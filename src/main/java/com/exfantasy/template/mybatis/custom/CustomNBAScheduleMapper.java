package com.exfantasy.template.mybatis.custom;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.exfantasy.template.mybatis.mapper.NBAScheduleMapper;
import com.exfantasy.template.mybatis.model.NBASchedule;
import com.exfantasy.template.vo.response.nba.NBAScheduleResp;

@Mapper
public interface CustomNBAScheduleMapper extends NBAScheduleMapper {

	/**
	 * <pre>
	 * Upsert NBA 賽程資料
	 * </pre>
	 * 
	 * @param record
	 * @return
	 */
	@Insert({
		"insert into nba_schedule",
		"(",
			"game_id,",
			"game_time_in_millis,",
			"game_time,",
			"home_team_id,", 
			"away_team_id",
        ")",
        "values",
        "(",
        	"#{gameId,jdbcType=INTEGER},",
        	"#{gameTimeInMillis,jdbcType=BIGINT},",
        	"#{gameTime,jdbcType=TIMESTAMP},",
        	"#{homeTeamId,jdbcType=INTEGER},",
        	"#{awayTeamId,jdbcType=INTEGER}",
        ")",
        "on duplicate key update",
        	"game_time_in_millis = #{gameTimeInMillis,jdbcType=BIGINT},",
        	"game_time = #{gameTime,jdbcType=TIMESTAMP},",
        	"home_team_id = #{homeTeamId,jdbcType=INTEGER},",
        	"away_team_id = #{awayTeamId,jdbcType=INTEGER}"
	})
	int upsert(NBASchedule record);
	
	/**
	 * <pre>
	 * 根據日期查詢 NBA 賽程
	 * </pre>
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@Select({
		"select",
			"ns.game_id as gameId,",
			"ns.game_time as gameTimeDate,",
			"ht.name_ch as homeTeamNameCh,",
			"ht.name_en as homeTeamNameEn,",
			"at.name_ch as awayTeamNameCh,",
			"at.name_en as awayTeamNameEn",
		"from nba_schedule as ns",
		"left join nba_team as ht on ns.home_team_id = ht.team_id",
		"left join nba_team as at on ns.away_team_id = at.team_id",
		"where ns.game_time between #{startTime,jdbcType=TIMESTAMP} and #{endTime,jdbcType=TIMESTAMP}"
	})
	@Results(
		id = "NBAScheduleResp",
		value = {
			@Result(column="gameId", property="gameId", jdbcType=JdbcType.INTEGER, id=true),
			@Result(column="gameTimeDate", property="gameTimeDate", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="homeTeamNameCh", property="homeTeamNameCh", jdbcType=JdbcType.VARCHAR),
			@Result(column="homeTeamNameEn", property="homeTeamNameEn", jdbcType=JdbcType.VARCHAR),
			@Result(column="awayTeamNameCh", property="awayTeamNameCh", jdbcType=JdbcType.VARCHAR),
			@Result(column="awayTeamNameEn", property="awayTeamNameEn", jdbcType=JdbcType.VARCHAR)
		}
	)
	List<NBAScheduleResp> selectNBASchedulesGameTimeBetween(@Param("startTime") Date startTime, @Param("endTime") Date endTime);
}
