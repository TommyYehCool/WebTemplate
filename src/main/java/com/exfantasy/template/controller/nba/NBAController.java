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

/**
 * <pre>
 * NBA 相關 APIs
 * </pre>
 * 
 * @author tommy.feng
 *
 */
@Controller
@RequestMapping(value = "/nba")
@Api("NBAController - NBA 相關 API")
public class NBAController {
	
	@Autowired
	private NBAService nbaService;
	
	@RequestMapping(value = "/get_nba_team/{abbr}", method = RequestMethod.GET)
	@ApiOperation(value = "使用簡稱查詢 NBA 隊伍", notes = "使用簡稱查詢 NBA 隊伍", response = NBATeam.class)
	public @ResponseBody NBATeam getNBATeam(
			@ApiParam("欲查詢的簡稱") @PathVariable(value = "abbr", required = true) String abbr) {
		return nbaService.queryNBATeamByAbbr(abbr);
	}
	
	@RequestMapping(value = "/fetch_latest_informations", method = RequestMethod.GET)
	@ApiOperation(value = "抓取新的 NBA 隊伍及賽程資訊", notes = "抓取新的 NBA 隊伍及賽程資訊", response = RespCommon.class)
	public @ResponseBody RespCommon fetchLatestInformations() {
		nbaService.fetchNewestNBATeamsInformation();
		nbaService.fetchNewestNBASchedules();
		nbaService.fetchTodayNBAGameResults();
		return new RespCommon(ResultCode.SUCCESS);
	}
	
	@RequestMapping(value = "/fetch_date_game_results", method = RequestMethod.GET)
	@ApiOperation(value = "抓取某一天 NBA 賽程資訊", notes = "抓取某一天 NBA 賽程資訊", response = RespCommon.class)
	public @ResponseBody RespCommon fetchDateGameResults(
			@ApiParam("欲抓取的日期") @RequestParam(value = "date", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		nbaService.fetchDateGameResults(date);
		return new RespCommon(ResultCode.SUCCESS);
	}
	
	@RequestMapping(value = "/get_schedules", method = RequestMethod.GET)
	@ApiOperation(value = "抓取當天 NBA 賽程資料", notes = "抓取當天 NBA 賽程資料", responseContainer = "List", response = NBAScheduleResp.class)
	public @ResponseBody List<NBAScheduleResp> getSchedules(
			@ApiParam("欲查詢的日期") @RequestParam(value = "date", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		return nbaService.queryNBASchedulesByDate(date);
	}
	
	@RequestMapping(value = "/get_game_results", method = RequestMethod.GET)
	@ApiOperation(value = "查詢目前所有比賽結果", notes = "查詢目前所有比賽結果", responseContainer = "List", response = NBAGameResp.class)
	public @ResponseBody List<NBAGameResp> getNBAGameResults() {
		return nbaService.queryNBAGamess();
	}
	
	@RequestMapping(value = "/get_game_result/{gameId}", method = RequestMethod.GET)
	@ApiOperation(value = "使用場次編號查詢比賽結果", notes = "使用場次編號查詢比賽結果", response = NBAGameResp.class)
	public @ResponseBody NBAGameResp getNBAGameResult(
			@ApiParam("欲查詢的場次編號") @PathVariable(value = "gameId", required = true) Integer gameId) {
		return nbaService.queryNBAGameByGameId(gameId);
	}
	
}
