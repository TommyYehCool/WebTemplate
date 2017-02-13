package com.exfantasy.template.vo.json.deserializer.nba;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.exfantasy.template.mybatis.model.NBAGame;
import com.exfantasy.template.vo.json.nba.NBATodayGamesFromNBAData;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class NBATodayGamesFromNBADataDeserializer extends JsonDeserializer<NBATodayGamesFromNBAData> {
	
	private final Logger logger = LoggerFactory.getLogger(NBATodayGamesFromNBADataDeserializer.class);
	
	private final SimpleDateFormat srcDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private final SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy/MM/dd");

	@Override
	public NBATodayGamesFromNBAData deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		NBATodayGamesFromNBAData resp = new NBATodayGamesFromNBAData();
		
		ObjectCodec oc = jp.getCodec();
		JsonNode rootNode = oc.readTree(jp);
		
		JsonNode gsNode = rootNode.get("gs");
		
		// Data: 比賽日期
		@SuppressWarnings("unused")
		String taiwanGameDate = getTaiwanCompetitionDate(gsNode.get("gdte").asText());
		
		JsonNode gameNodes = gsNode.get("g");
		
		Iterator<JsonNode> itGameNodes = gameNodes.iterator();
		
		while (itGameNodes.hasNext()) {
			JsonNode gameNode = itGameNodes.next();

			// Data: 場次編號
			Integer gameId = gameNode.get("gid").asInt();
			
			// Data: 主隊資訊
			JsonNode homeTeamNode = gameNode.get("h");

			int homeTeam1stScores = homeTeamNode.get("q1").asInt(0);
			int homeTeam2ndScores = homeTeamNode.get("q2").asInt(0);
			int homeTeam3rdScores = homeTeamNode.get("q3").asInt(0);
			int homeTeam4thScores = homeTeamNode.get("q4").asInt(0);
			int homeTeamScoreSum = homeTeamNode.get("s").asInt(0);

			// Data: 客隊資訊
			JsonNode awayTeamNode = gameNode.get("v");

			int awayTeam1stScores = awayTeamNode.get("q1").asInt(0);
			int awayTeam2ndScores = awayTeamNode.get("q2").asInt(0);
			int awayTeam3rdScores = awayTeamNode.get("q3").asInt(0);
			int awayTeam4thScores = awayTeamNode.get("q4").asInt(0);
			int awayTeamScoreSum = awayTeamNode.get("s").asInt(0);
			
			// 兩隊總分加總
			Integer totalScoresSum = homeTeamScoreSum + awayTeamScoreSum;
			
			// ----- 儲存每場比賽資訊 -----
			NBAGame nbaGame = new NBAGame();

			// ----- 將資料塞進物件 -----
			nbaGame.setGameId(gameId);

			nbaGame.setHomeTeam1stScores(homeTeam1stScores);
			nbaGame.setHomeTeam2ndScores(homeTeam2ndScores);
			nbaGame.setHomeTeam3rdScores(homeTeam3rdScores);
			nbaGame.setHomeTeam4thScores(homeTeam4thScores);
			nbaGame.setHomeTeamScoresSum(homeTeamScoreSum);
			
			nbaGame.setAwayTeam1stScores(awayTeam1stScores);
			nbaGame.setAwayTeam2ndScores(awayTeam2ndScores);
			nbaGame.setAwayTeam3rdScores(awayTeam3rdScores);
			nbaGame.setAwayTeam4thScores(awayTeam4thScores);
			nbaGame.setAwayTeamScoresSum(awayTeamScoreSum);
			
			nbaGame.setTotalScoresSum(totalScoresSum);

			resp.addNBAGame(nbaGame);
		}
		return resp;
	}

	private String getTaiwanCompetitionDate(String competitionDate) {
		try {
			Date americanTime = srcDateFormat.parse(competitionDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(americanTime);
			cal.add(Calendar.DATE, 1);
			return outputDateFormat.format(cal.getTime());
		} catch (ParseException e) {
			logger.error("ParseException raised while parsing source field \"gdte\": {}" + competitionDate);
			return null;
		}
	}

}