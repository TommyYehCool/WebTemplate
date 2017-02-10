package com.exfantasy.template.vo.json.nba;

import java.util.ArrayList;
import java.util.List;

import com.exfantasy.template.mybatis.model.NBATeam;
import com.exfantasy.template.vo.json.deserializer.nba.NBATeamFromNBATwDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

@Data
@JsonDeserialize(using = NBATeamFromNBATwDeserializer.class)
public class NBATeamFromNBATw {

	private List<NBATeam> teams = new ArrayList<>();
	
	public void addNBATeam(NBATeam team) {
		teams.add(team);
	}
}
