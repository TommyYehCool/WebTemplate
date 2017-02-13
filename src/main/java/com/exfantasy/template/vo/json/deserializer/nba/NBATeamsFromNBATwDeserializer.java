package com.exfantasy.template.vo.json.deserializer.nba;

import java.io.IOException;
import java.util.Iterator;

import com.exfantasy.template.cnst.nba.NBAConference;
import com.exfantasy.template.cnst.nba.NBADivision;
import com.exfantasy.template.mybatis.model.NBATeam;
import com.exfantasy.template.vo.json.nba.NBATeamsFromNBATw;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class NBATeamsFromNBATwDeserializer extends JsonDeserializer<NBATeamsFromNBATw> {

	@Override
	public NBATeamsFromNBATw deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// 暫存整包 json 回應
		NBATeamsFromNBATw resp = new NBATeamsFromNBATw();
		
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
				Integer teamId = profileNode.get("id").asInt();

				// Data
				String abbr = profileNode.get("abbr").asText();
				
				// Data
				String cityCh = profileNode.get("city").asText();
				
				// Data
				String cityEn = profileNode.get("cityEn").asText();
				
				// Data
				String code = profileNode.get("code").asText();
				
				// Data
				String nameCh = profileNode.get("name").asText();
				
				// Data
				String nameEn = profileNode.get("nameEn").asText();
				
				// ----- 儲存每隊資料 -----
				NBATeam team = new NBATeam();

				// ----- 將資料塞進物件 -----
				team.setTeamId(teamId);
				team.setAbbr(abbr);
				team.setCityCh(cityCh);
				team.setCityEn(cityEn);
				team.setCode(code);
				team.setConferenceCh(NBAConference.getChinese(conferenceEn));
				team.setConferenceEn(conferenceEn);
				team.setDivisionCh(NBADivision.getChinese(divisionEn));
				team.setDivisionEn(divisionEn);
				team.setNameCh(nameCh);
				team.setNameEn(nameEn);
				
				resp.addNBATeam(team);
			}
		}
		return resp;
	}

}
