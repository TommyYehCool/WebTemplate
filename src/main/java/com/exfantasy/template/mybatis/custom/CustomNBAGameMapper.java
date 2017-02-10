package com.exfantasy.template.mybatis.custom;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

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

//  ------ 原本寫法 ------
//	/**
//	 * <pre>
//	 * 根據場次編號查詢 NBA 比賽結果
//	 * </pre>
//	 * 
//	 * @param gameId
//	 * @return
//	 */
//	@Select({
//		"select",
//		"ng.game_id as gameId, ",
//		"ht.name_ch as homeTeamNameCh, ",
//		"ht.name_en as homeTeamNameEn, ",
//		"at.name_ch as awayTeamNameCh, ",
//		"at.name_en as awayTeamNameEn, ",
//		"ng.home_team_1st_scores as homeTeam1stScores, ",
//		"ng.home_team_2nd_scores as homeTeam2ndScores, ",
//		"ng.home_team_3rd_scores as homeTeam3rdScores, ",
//		"ng.home_team_4th_scores as homeTeam4thScores, ",
//		"ng.home_team_scores_sum as homeTeamScoresSum, ",
//		"ng.away_team_1st_scores as awayTeam1stScores, ",
//		"ng.away_team_2nd_scores as awayTeam2ndScores, ",
//		"ng.away_team_3rd_scores as awayTeam3rdScores, ",
//		"ng.away_team_4th_scores as awayTeam4thScores, ",
//		"ng.away_team_scores_sum as awayTeamScoresSum, ",
//		"ng.total_scores_sum as totalScoresSum ",
//		"from nba_game as ng ",
//		"left join nba_schedule as ns on ng.game_id = ns.game_id ",
//		"left join nba_team as ht on ns.home_team_id = ht.team_id ",
//		"left join nba_team as at on ns.away_team_id = at.team_id ",
//		"where ng.game_id = #{gameId,jdbcType=INTEGER}"
//	})
//	@Results({
//		@Result(column="gameId", property="gameId", jdbcType=JdbcType.INTEGER, id=true),
//		@Result(column="homeTeamNameCh", property="homeTeamNameCh", jdbcType=JdbcType.VARCHAR),
//		@Result(column="homeTeamNameEn", property="homeTeamNameEn", jdbcType=JdbcType.VARCHAR),
//		@Result(column="awayTeamNameCh", property="awayTeamNameCh", jdbcType=JdbcType.VARCHAR),
//		@Result(column="awayTeamNameEn", property="awayTeamNameEn", jdbcType=JdbcType.VARCHAR),
//		@Result(column="homeTeam1stScores", property="homeTeam1stScores", jdbcType=JdbcType.INTEGER),
//		@Result(column="homeTeam2ndScores", property="homeTeam2ndScores", jdbcType=JdbcType.INTEGER),
//		@Result(column="homeTeam3rdScores", property="homeTeam3rdScores", jdbcType=JdbcType.INTEGER),
//		@Result(column="homeTeam4thScores", property="homeTeam4thScores", jdbcType=JdbcType.INTEGER),
//		@Result(column="homeTeamScoresSum", property="homeTeamScoresSum", jdbcType=JdbcType.INTEGER),
//		@Result(column="awayTeam1stScores", property="awayTeam1stScores", jdbcType=JdbcType.INTEGER),
//		@Result(column="awayTeam2ndScores", property="awayTeam2ndScores", jdbcType=JdbcType.INTEGER),
//		@Result(column="awayTeam3rdScores", property="awayTeam3rdScores", jdbcType=JdbcType.INTEGER),
//		@Result(column="awayTeam4thScores", property="awayTeam4thScores", jdbcType=JdbcType.INTEGER),
//		@Result(column="awayTeamScoresSum", property="awayTeamScoresSum", jdbcType=JdbcType.INTEGER),
//		@Result(column="totalScoresSum", property="totalScoresSum", jdbcType=JdbcType.INTEGER)
//		
//	})
//	NBAGameResp selectNBAGameByGameId(@Param("gameId") Integer gameId);
	
	/**
	 * <pre>
	 * 查詢目前所有 NBA 比賽結果
	 * </pre>
	 * 
	 * @return
	 */
	@SelectProvider(type=CustomNBAGameSqlProvider.class, method="selectNBAGameResps")
	@Results(
		id = "NBAGameResp", 
		value = {
			@Result(column="gameId", property="gameId", jdbcType=JdbcType.INTEGER, id=true),
			@Result(column="homeTeamNameCh", property="homeTeamNameCh", jdbcType=JdbcType.VARCHAR),
			@Result(column="homeTeamNameEn", property="homeTeamNameEn", jdbcType=JdbcType.VARCHAR),
			@Result(column="awayTeamNameCh", property="awayTeamNameCh", jdbcType=JdbcType.VARCHAR),
			@Result(column="awayTeamNameEn", property="awayTeamNameEn", jdbcType=JdbcType.VARCHAR),
			@Result(column="homeTeam1stScores", property="homeTeam1stScores", jdbcType=JdbcType.INTEGER),
			@Result(column="homeTeam2ndScores", property="homeTeam2ndScores", jdbcType=JdbcType.INTEGER),
			@Result(column="homeTeam3rdScores", property="homeTeam3rdScores", jdbcType=JdbcType.INTEGER),
			@Result(column="homeTeam4thScores", property="homeTeam4thScores", jdbcType=JdbcType.INTEGER),
			@Result(column="homeTeamScoresSum", property="homeTeamScoresSum", jdbcType=JdbcType.INTEGER),
			@Result(column="awayTeam1stScores", property="awayTeam1stScores", jdbcType=JdbcType.INTEGER),
			@Result(column="awayTeam2ndScores", property="awayTeam2ndScores", jdbcType=JdbcType.INTEGER),
			@Result(column="awayTeam3rdScores", property="awayTeam3rdScores", jdbcType=JdbcType.INTEGER),
			@Result(column="awayTeam4thScores", property="awayTeam4thScores", jdbcType=JdbcType.INTEGER),
			@Result(column="awayTeamScoresSum", property="awayTeamScoresSum", jdbcType=JdbcType.INTEGER),
			@Result(column="totalScoresSum", property="totalScoresSum", jdbcType=JdbcType.INTEGER)
		}
	)
	List<NBAGameResp> selectNBAGameResps();
	
	/**
	 * <pre>
	 * 根據場次編號查詢 NBA 比賽結果
	 * 
	 * ref: <a href="https://github.com/mybatis/mybatis-3/issues/155">ResultMap</a>
	 * </pre>
	 * 
	 * @param gameId
	 * @return
	 */
	@SelectProvider(type=CustomNBAGameSqlProvider.class, method="selectNBAGameRespByGameId")
	@ResultMap("NBAGameResp")
	NBAGameResp selectNBAGameByGameId(@Param("gameId") Integer gameId);

}
