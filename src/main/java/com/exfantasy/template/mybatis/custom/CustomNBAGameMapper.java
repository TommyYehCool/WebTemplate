package com.exfantasy.template.mybatis.custom;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.exfantasy.template.mybatis.mapper.NBAGameMapper;
import com.exfantasy.template.mybatis.model.NBAGame;
import com.exfantasy.template.vo.response.nba.NBAGameResp;

@Mapper
public interface CustomNBAGameMapper extends NBAGameMapper {

	/**
	 * <pre>
	 * Upsert NBA 比賽結果
	 * </pre>
	 * 
	 * @param game
	 * @return
	 */
	@Insert({
		"insert into nba_game ",
		"(",
			"game_id, ",
			"home_team_1st_scores, ",
			"home_team_2nd_scores, ",
			"home_team_3rd_scores, ",
			"home_team_4th_scores, ",
			"home_team_scores_sum, ",
			"away_team_1st_scores, ",
			"away_team_2nd_scores, ",
			"away_team_3rd_scores, ",
			"away_team_4th_scores, ",
			"away_team_scores_sum, ",
			"total_scores_sum",
		") ",
        "values ",
        "(",
        	"#{gameId,jdbcType=INTEGER}, ", 
        	"#{homeTeam1stScores,jdbcType=INTEGER}, ",
        	"#{homeTeam2ndScores,jdbcType=INTEGER}, ",
        	"#{homeTeam3rdScores,jdbcType=INTEGER}, ",
        	"#{homeTeam4thScores,jdbcType=INTEGER}, ", 
        	"#{homeTeamScoresSum,jdbcType=INTEGER}, ",
        	"#{awayTeam1stScores,jdbcType=INTEGER}, ", 
        	"#{awayTeam2ndScores,jdbcType=INTEGER}, ",
        	"#{awayTeam3rdScores,jdbcType=INTEGER}, ", 
        	"#{awayTeam4thScores,jdbcType=INTEGER}, ",
        	"#{awayTeamScoresSum,jdbcType=INTEGER}, ", 
        	"#{totalScoresSum,jdbcType=INTEGER}",
        ")",
        "on duplicate key update ",
        	"home_team_1st_scores = #{homeTeam1stScores,jdbcType=INTEGER}, ",
        	"home_team_2nd_scores = #{homeTeam2ndScores,jdbcType=INTEGER}, ",
        	"home_team_3rd_scores = #{homeTeam3rdScores,jdbcType=INTEGER}, ",
        	"home_team_4th_scores = #{homeTeam4thScores,jdbcType=INTEGER}, ",
        	"home_team_scores_sum = #{homeTeamScoresSum,jdbcType=INTEGER}, ",
        	"away_team_1st_scores = #{awayTeam1stScores,jdbcType=INTEGER}, ",
        	"away_team_2nd_scores = #{awayTeam2ndScores,jdbcType=INTEGER}, ",
        	"away_team_3rd_scores = #{awayTeam3rdScores,jdbcType=INTEGER}, ",
        	"away_team_4th_scores = #{awayTeam4thScores,jdbcType=INTEGER}, ",
        	"away_team_scores_sum = #{awayTeamScoresSum,jdbcType=INTEGER}, ",
        	"total_scores_sum = #{totalScoresSum,jdbcType=INTEGER}",
	})
	int upsert(NBAGame game);

	// TODO select 語法
	NBAGameResp selectNBAGameByGameId(Integer gameId);

}
