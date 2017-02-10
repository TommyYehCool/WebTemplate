package com.exfantasy.template.services.nba;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exfantasy.template.mybatis.custom.CustomNBAGameMapper;
import com.exfantasy.template.mybatis.custom.CustomNBAScheduleMapper;
import com.exfantasy.template.mybatis.custom.CustomNBATeamMapper;
import com.exfantasy.template.mybatis.model.NBAGame;
import com.exfantasy.template.mybatis.model.NBASchedule;
import com.exfantasy.template.mybatis.model.NBATeam;
import com.exfantasy.template.mybatis.model.NBATeamExample;
import com.exfantasy.template.vo.json.nba.NBAGameFromNBAData;
import com.exfantasy.template.vo.json.nba.NBAScheduleFromNBATw;
import com.exfantasy.template.vo.json.nba.NBATeamFromNBATw;
import com.exfantasy.template.vo.response.nba.NBAGameResp;
import com.exfantasy.template.vo.response.nba.NBAScheduleResp;
import com.exfantasy.utils.http.HttpUtil;
import com.exfantasy.utils.http.HttpUtilException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class NBAService {
	
	private Logger logger = LoggerFactory.getLogger(NBAService.class);

	private final String URL_NBA_TEAM_NBA_TAIWAN = "http://tw.global.nba.com/stats2/league/divisionteamlist.json?locale=zh_TW";
	
	private final String URL_NBA_SCHEDULE_NBA_TAIWAN = "https://tw.global.nba.com/stats2/season/schedule.json?countryCode=TW&days=7&dst=0&locale=zh_TW&tz=%2B8";
	
	private final String URL_NBA_GAME_NBA_DATA = "http://data.nba.com/data/5s/v2015/json/mobile_teams/nba/2016/scores/00_todays_scores.json";
	
	@Autowired
	private CustomNBATeamMapper nbaTeamMapper;
	
	@Autowired
	private CustomNBAScheduleMapper nbaScheduleMapper;
	
	@Autowired
	private CustomNBAGameMapper nbaGameMapper;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public void fetchNewestNBATeamsInformation() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonResp = HttpUtil.sendGetRequest(URL_NBA_TEAM_NBA_TAIWAN);
			
			NBATeamFromNBATw resp = mapper.readValue(jsonResp, NBATeamFromNBATw.class);
			
			List<NBATeam> teams = resp.getTeams();
			
			int upsertCnts = 0;
			
			for (NBATeam team : teams) {
				upsertCnts += nbaTeamMapper.upsert(team);
			}
			
			logger.info(">>>>> Upsert newest NBA Teams information done, counts: {} <<<<<", upsertCnts);
			
		} catch (HttpUtilException e) {
			logger.error("HttpUtilException raised while trying to get newest NBA Team information from url: <{}>", URL_NBA_TEAM_NBA_TAIWAN, e);
		} catch (IOException e) {
			logger.error("IOException raised while converting json data to NBATeamFromNBATw", e);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public void fetchNewestNBASchedules() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonResp = HttpUtil.sendGetRequest(URL_NBA_SCHEDULE_NBA_TAIWAN);
			
			NBAScheduleFromNBATw resp = mapper.readValue(jsonResp, NBAScheduleFromNBATw.class);
			
			List<NBASchedule> schedules = resp.getSchedules();
			
			int upsertCnts = 0;
			
			for (NBASchedule schedule : schedules) { 
				upsertCnts += nbaScheduleMapper.upsert(schedule);
			}
			
			logger.info(">>>>> Upsert newest NBA Schedules done, counts: {} <<<<<", upsertCnts);
			
		} catch (HttpUtilException e) {
			logger.error("HttpUtilException raised while trying to get newest NBA Schedules from url: <{}>", URL_NBA_SCHEDULE_NBA_TAIWAN, e);
		} catch (IOException e) {
			logger.error("IOException raised while converting json data to NBAScheduleFromNBATw", e);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public void fetchNewestNBAGames() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonResp = HttpUtil.sendGetRequest(URL_NBA_GAME_NBA_DATA);
			
			NBAGameFromNBAData resp = mapper.readValue(jsonResp, NBAGameFromNBAData.class);
			
			List<NBAGame> games = resp.getGames();
			
			int upsertCnts = 0;
			
			for (NBAGame game : games) {
				upsertCnts += nbaGameMapper.upsert(game);
			}
			
			logger.info(">>>>> Upsert newest NBA Games done, counts: {} <<<<<", upsertCnts);
			
		} catch (HttpUtilException e) {
			logger.error("HttpUtilException raised while trying to get newest NBA Games from url: <{}>", URL_NBA_GAME_NBA_DATA, e);
		} catch (IOException e) {
			logger.error("IOException raised while converting json data to NBAGamesFromNBAData", e);
		}
	}

	public NBATeam queryNBATeamByAbbr(String abbr) {
		NBATeamExample example = new NBATeamExample();
		example.createCriteria().andAbbrEqualTo(abbr);
		List<NBATeam> teams = nbaTeamMapper.selectByExample(example);
		return teams.size() == 1 ? teams.get(0) : null;
	}
	
	public List<NBAScheduleResp> queryNBASchedulesByDate(Date date) {
		Date startTime = date;
		Date endTime = getEndTime(date);
		return nbaScheduleMapper.selectNBASchedulesGameTimeBetween(startTime, endTime);
	}

	private Date getEndTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	public NBAGameResp queryNBAGameByGameId(Integer gameId) {
		return nbaGameMapper.selectNBAGameByGameId(gameId);
	}

	public List<NBAGameResp> queryNBAGamess() {
		return nbaGameMapper.selectNBAGameResps();
	}
	
}