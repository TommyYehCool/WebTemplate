package com.exfantasy.template.vo.json.deserializer.nba;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.exfantasy.template.mybatis.model.NBASchedule;
import com.exfantasy.template.vo.json.nba.NBASchedulesFromNBATw;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class NBASchedulesFromNBATwDeserializer extends JsonDeserializer<NBASchedulesFromNBATw> {
	
	private final Logger logger = LoggerFactory.getLogger(NBASchedulesFromNBATwDeserializer.class);
	
	// 處理每一天的日期
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
	@Override
	public NBASchedulesFromNBATw deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// 暫存整包 json 回應
		NBASchedulesFromNBATw resp = new NBASchedulesFromNBATw();

		// use to process time
		Calendar cal = Calendar.getInstance();

		// 取出 root node
		ObjectCodec oc = jp.getCodec();
		JsonNode rootNode = oc.readTree(jp);
		
		// 取出每個日期資訊
		JsonNode datesNode = rootNode.get("payload").get("dates");

		Iterator<JsonNode> itDateNodes = datesNode.iterator();
		
		while (itDateNodes.hasNext()) {
			// 每天的資訊
			JsonNode dateNode = itDateNodes.next();
			
			// Data: 當天有幾場比賽
			String gameCount = dateNode.get("gameCount").asText();

			// Data: 哪一天
			long dateUtcMillis = dateNode.get("utcMillis").asLong();
			cal.setTimeInMillis(dateUtcMillis);
			String date = dateFormat.format(cal.getTime());
			
			logger.info(">>>>> Date: {}, Game Count: {} <<<<<", date, gameCount);
			
			// 取出當天所有比賽資訊
			JsonNode gameNodes = dateNode.get("games");
			
			Iterator<JsonNode> itGameNodes = gameNodes.iterator();
			
			while (itGameNodes.hasNext()) {
				// 當天各場比賽資訊
				JsonNode gameNode = itGameNodes.next();
				
				// ----- Node: profile -----
				JsonNode profileNode = gameNode.get("profile");
				
				// Data: 場次 ID
				Integer gameId = profileNode.get("gameId").asInt();
				
				// Data: 場次時間
				Long gameTimeInMillis = profileNode.get("utcMillis").asLong();
				cal.setTimeInMillis(gameTimeInMillis);
				Date gameTime = cal.getTime();

				// Data: 主場隊伍 ID
				Integer homeTeamId = profileNode.get("homeTeamId").asInt();

				// Data: 客場隊伍 ID 
				Integer awayTeamId = profileNode.get("awayTeamId").asInt();
				
				// ----- 儲存每場比賽資訊 -----
				NBASchedule schedule = new NBASchedule();

				// ----- 將資料塞進物件 -----
				schedule.setGameId(gameId);
				schedule.setGameTimeInMillis(gameTimeInMillis);
				schedule.setGameTime(gameTime);
				schedule.setHomeTeamId(homeTeamId);
				schedule.setAwayTeamId(awayTeamId);
				
				resp.addNBASchedule(schedule);
			}
		}
		return resp;
	}

}
