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
import com.exfantasy.template.vo.json.nba.NBAGameFromNBAData;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class NBAGameFromNBADataDeserializer extends JsonDeserializer<NBAGameFromNBAData> {
	
	private final Logger logger = LoggerFactory.getLogger(NBAGameFromNBADataDeserializer.class);
	
	private final SimpleDateFormat srcDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private final SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy/MM/dd");

	@Override
	public NBAGameFromNBAData deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		NBAGameFromNBAData resp = new NBAGameFromNBAData();
		
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

			NBAGame nbaGame = new NBAGame();
			
			// Data: 場次編號
			Integer gameId = gameNode.get("gid").asInt();
			nbaGame.setGameId(gameId);
			
			JsonNode homeTeamNode = gameNode.get("h");
			JsonNode awayTeamNode = gameNode.get("v");
			
			// Data: 主隊資訊
			nbaGame.setHomeTeam1stScores(homeTeamNode.get("q1").asInt(0));
			nbaGame.setHomeTeam2ndScores(homeTeamNode.get("q2").asInt(0));
			nbaGame.setHomeTeam3rdScores(homeTeamNode.get("q3").asInt(0));
			nbaGame.setHomeTeam4thScores(homeTeamNode.get("q4").asInt(0));
			int homeTeamScoreSum = homeTeamNode.get("s").asInt(0);
			nbaGame.setHomeTeamScoresSum(homeTeamScoreSum);

			// Data: 客隊資訊
			nbaGame.setAwayTeam1stScores(awayTeamNode.get("q1").asInt(0));
			nbaGame.setAwayTeam2ndScores(awayTeamNode.get("q2").asInt(0));
			nbaGame.setAwayTeam3rdScores(awayTeamNode.get("q3").asInt(0));
			nbaGame.setAwayTeam4thScores(awayTeamNode.get("q4").asInt(0));
			int awayTeamScoreSum = awayTeamNode.get("s").asInt(0);
			nbaGame.setAwayTeamScoresSum(awayTeamScoreSum);
			
			// 兩隊總分加總
			Integer totalScoresSum = homeTeamScoreSum + awayTeamScoreSum;
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