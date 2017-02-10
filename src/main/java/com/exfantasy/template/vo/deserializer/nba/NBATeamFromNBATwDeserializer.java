package com.exfantasy.template.vo.deserializer.nba;

import java.io.IOException;
import java.util.Iterator;

import com.exfantasy.template.mybatis.model.NBATeam;
import com.exfantasy.template.vo.json.nba.NBATeamFromNBATw;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class NBATeamFromNBATwDeserializer extends JsonDeserializer<NBATeamFromNBATw> {

	@Override
	public NBATeamFromNBATw deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// 暫存整包 json 回應
		NBATeamFromNBATw resp = new NBATeamFromNBATw();
		
		// 取出 root node
		ObjectCodec oc = jp.getCodec();
		JsonNode rootNode = oc.readTree(jp);
		
		JsonNode groupsNode = rootNode.get("payload").get("listGroups");
		
		Iterator<JsonNode> itGroupNodes = groupsNode.iterator();
		
		while (itGroupNodes.hasNext()) {
			JsonNode groupNode = itGroupNodes.next();
			
			// Data
			String conferenceEn = groupNode.get("conference").asText();
			
			// Data
			String divisionEn = groupNode.get("division").asText();
			
			JsonNode teamsNode = groupNode.get("teams");

			Iterator<JsonNode> itTeamNodes = teamsNode.iterator();
			
			while (itTeamNodes.hasNext()) {
				JsonNode teamNode = itTeamNodes.next();
				
				JsonNode profileNode = teamNode.get("profile");
				
				// Data
				String abbr = profileNode.get("abbr").asText();
				
				// Data
				String cityCh = profileNode.get("city").asText();
				
				// Data
				String cityEn = profileNode.get("cityEn").asText();
				
				// Data
				String code = profileNode.get("code").asText();
				
				// Data
				Integer teamId = profileNode.get("id").asInt();
				
				// Data
				String nameCh = profileNode.get("name").asText();
				
				// Data
				String nameEn = profileNode.get("nameEn").asText();
				
				// 儲存每隊資料
				NBATeam team = new NBATeam();
				team.setAbbr(abbr);
				team.setCityCh(cityCh);
				team.setCityEn(cityEn);
				team.setCode(code);
				team.setConferenceCh(getConferenceCh(conferenceEn));
				team.setConferenceEn(conferenceEn);
				team.setDivisionCh(getDivisionCh(divisionEn));
				team.setDivisionEn(divisionEn);
				team.setNameCh(nameCh);
				team.setNameEn(nameEn);
				team.setTeamId(teamId);
				
				resp.addNBATeam(team);
			}
		}
		return resp;
	}
	
	private String getConferenceCh(String conferenceEn) {
		switch (conferenceEn) {
			case "Eastern":
				return "東區聯盟";
			
			case "Western":
				return "西區聯盟";
		}
		return "";
	}
	
	private String getDivisionCh(String divisionEn) {
		switch (divisionEn) {
			case "Atlantic":
				return "大西洋組";
			
			case "Central":
				return "中央組";
				
			case "Southeast":
				return "東南組";
				
			case "Northwest":
				return "西北組";
				
			case "Pacific":
				return "太平洋組";
				
			case "Southwest":
				return "西南組";
		}
		return "";
	}

}
