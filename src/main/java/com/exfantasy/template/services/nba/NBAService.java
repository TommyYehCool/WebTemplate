package com.exfantasy.template.services.nba;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exfantasy.template.mybatis.custom.CustomNBATeamMapper;
import com.exfantasy.template.mybatis.model.NBATeam;
import com.exfantasy.template.vo.json.NBATeamFromNBATw;
import com.exfantasy.utils.http.HttpUtil;
import com.exfantasy.utils.http.HttpUtilException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NBAService {
	
	private Logger logger = LoggerFactory.getLogger(NBAService.class);

	private final String URL_NBA_TEAM_NBA_TAIWAN = "http://tw.global.nba.com/stats2/league/divisionteamlist.json?locale=zh_TW";
	
	@Autowired
	private CustomNBATeamMapper nbaTeamMapper;
	
	public void fetchNewestNBATeamsInformation() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonResp = HttpUtil.sendGetRequest(URL_NBA_TEAM_NBA_TAIWAN);
			
			NBATeamFromNBATw resp = mapper.readValue(jsonResp, NBATeamFromNBATw.class);
			
			List<NBATeam> teams = resp.getTeams();
			
			int deleteCounts = nbaTeamMapper.deleteAll();
			
			logger.info(">>>>> Delete exist NBA Teams information done, delete-cnts: {} <<<<<", deleteCounts);
			
			int insertCounts = nbaTeamMapper.batchInsertNBATeams(teams);
			
			logger.info(">>>>> Insert newest NBA Teams information done, insert-cnts: {} <<<<<", insertCounts);
			
		} catch (HttpUtilException e) {
			logger.error("HttpUtilException raised while trying to get newest NBA Team information from url: <{}>", URL_NBA_TEAM_NBA_TAIWAN, e);
		} catch (IOException e) {
			logger.error("IOException raised while converting json data to NBATeamFromNBATw", e);
		}
	}
}
