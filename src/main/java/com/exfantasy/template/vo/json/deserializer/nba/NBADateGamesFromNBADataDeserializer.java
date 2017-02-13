package com.exfantasy.template.vo.json.deserializer.nba;

import java.io.IOException;
import java.util.Iterator;

import com.exfantasy.template.mybatis.model.NBAGame;
import com.exfantasy.template.vo.json.nba.NBADateGamesFromNBAData;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class NBADateGamesFromNBADataDeserializer extends JsonDeserializer<NBADateGamesFromNBAData> {
	
	@Override
	public NBADateGamesFromNBAData deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		NBADateGamesFromNBAData resp = new NBADateGamesFromNBAData();
		
		ObjectCodec oc = jp.getCodec();
		JsonNode rootNode = oc.readTree(jp);
		
		JsonNode gameNodes = rootNode.get("payload").get("date").get("games");
		
		Iterator<JsonNode> itGameNodes = gameNodes.iterator();
		
		while (itGameNodes.hasNext()) {
			JsonNode gameNode = itGameNodes.next();
			
			NBAGame nbaGame = new NBAGame();
			
			// Data: 場次編號
			Integer gameId = gameNode.get("profile").get("gameId").asInt();
			
			// Data: 得分資訊
			JsonNode boxScoreNode = gameNode.get("boxscore");
			int homeTeamScoresSum = boxScoreNode.get("homeScore").asInt();
			int awayTeamScoresSum = boxScoreNode.get("awayScore").asInt();
			int totalScoresSum = homeTeamScoresSum + awayTeamScoresSum;

			// Data: 主隊資訊
			JsonNode homeTeamScoreNode = gameNode.get("homeTeam").get("score");
			int homeTeam1stScores = homeTeamScoreNode.get("q1Score").asInt();
			int homeTeam2ndScores = homeTeamScoreNode.get("q2Score").asInt();
			int homeTeam3rdScores = homeTeamScoreNode.get("q3Score").asInt();
			int homeTeam4thScores = homeTeamScoreNode.get("q4Score").asInt();
			
			// Data: 客隊資訊
			JsonNode awayTeamScoreNode = gameNode.get("awayTeam").get("score");
			int awayTeam1stScores = awayTeamScoreNode.get("q1Score").asInt();
			int awayTeam2ndScores = awayTeamScoreNode.get("q2Score").asInt();
			int awayTeam3rdScores = awayTeamScoreNode.get("q3Score").asInt();
			int awayTeam4thScores = awayTeamScoreNode.get("q4Score").asInt();

			// 將資料塞入物件
			nbaGame.setGameId(gameId);
			
			nbaGame.setHomeTeam1stScores(homeTeam1stScores);
			nbaGame.setHomeTeam2ndScores(homeTeam2ndScores);
			nbaGame.setHomeTeam3rdScores(homeTeam3rdScores);
			nbaGame.setHomeTeam4thScores(homeTeam4thScores);
			nbaGame.setHomeTeamScoresSum(homeTeamScoresSum);
			
			nbaGame.setAwayTeam1stScores(awayTeam1stScores);
			nbaGame.setAwayTeam2ndScores(awayTeam2ndScores);
			nbaGame.setAwayTeam3rdScores(awayTeam3rdScores);
			nbaGame.setAwayTeam4thScores(awayTeam4thScores);
			nbaGame.setAwayTeamScoresSum(awayTeamScoresSum);
			
			nbaGame.setTotalScoresSum(totalScoresSum);
			
			resp.addNBAGame(nbaGame);
		}
		return resp;
	}

}
