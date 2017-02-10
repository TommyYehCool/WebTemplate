package com.exfantasy.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exfantasy.template.cnst.ResultCode;
import com.exfantasy.template.mybatis.model.NBATeam;
import com.exfantasy.template.services.nba.NBAService;
import com.exfantasy.template.vo.response.RespCommon;

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
		return new RespCommon(ResultCode.SUCCESS);
	}
}
