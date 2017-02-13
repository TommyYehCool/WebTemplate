package com.exfantasy.template.vo.json.nba;

import java.util.ArrayList;
import java.util.List;

import com.exfantasy.template.mybatis.model.NBAGame;
import com.exfantasy.template.vo.json.deserializer.nba.NBATodayGamesFromNBADataDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

@Data
@JsonDeserialize(using = NBATodayGamesFromNBADataDeserializer.class)
public class NBATodayGamesFromNBAData {
	
	private List<NBAGame> games = new ArrayList<>();
	
	public void addNBAGame(NBAGame game) {
		games.add(game);
	}
}
