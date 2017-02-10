package com.exfantasy.template.controller.nba;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exfantasy.template.cnst.ResultCode;
import com.exfantasy.template.mybatis.model.NBATeam;
import com.exfantasy.template.services.nba.NBAService;
import com.exfantasy.template.vo.response.RespCommon;
import com.exfantasy.template.vo.response.nba.NBAGameResp;
import com.exfantasy.template.vo.response.nba.NBAScheduleResp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/nba")
@Api("NBAController - NBA 相關 API")
public class NBAController {
	
	@Autowired
	private NBAService nbaService;
	
	@RequestMapping(value = "/get_nba_team/{abbr}", method = RequestMethod.GET)
	@ApiOperation(value = "使用簡稱查詢 NBA 隊伍", notes = "使用簡稱查詢 NBA 隊伍", response = NBATeam.class)
	public @ResponseBody NBATeam getNBATeam(@ApiParam("欲查詢的簡稱") @PathVariable("abbr") String abbr) {
		return nbaService.queryNBATeamByAbbr(abbr);
	}
	
	@RequestMapping(value = "/get_latest_informations", method = RequestMethod.GET)
	@ApiOperation(value = "抓取新的 NBA 隊伍及賽程資訊", notes = "抓取新的 NBA 隊伍及賽程資訊", response = RespCommon.class)
	public @ResponseBody RespCommon getLatestInformations() {
		nbaService.fetchNewestNBATeamsInformation();
		nbaService.fetchNewestNBASchedules();
		nbaService.fetchNewestNBAGames();
		return new RespCommon(ResultCode.SUCCESS);
	}
	
	@RequestMapping(value = "/get_schedules", method = RequestMethod.GET)
	@ApiOperation(value = "抓取當天 NBA 賽程資料", notes = "抓取當天 NBA 賽程資料", responseContainer = "List", response = NBAScheduleResp.class)
	public @ResponseBody List<NBAScheduleResp> getSchedules(
			@RequestParam(value = "日期", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		return nbaService.queryNBASchedulesByDate(date);
	}
	
	@RequestMapping(value = "/get_game_result/{gameId}", method = RequestMethod.GET)
	@ApiOperation(value = "使用場次編號查詢比賽結果", notes = "使用場次編號查詢比賽結果", response = NBAGameResp.class)
	public @ResponseBody NBAGameResp getNBAGameResult(@ApiParam("欲查詢的場次編號") @PathVariable("gameId") Integer gameId) {
		return nbaService.queryNBAGameByGameId(gameId);
	}
}
