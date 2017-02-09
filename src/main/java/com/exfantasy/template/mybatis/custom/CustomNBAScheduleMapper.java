package com.exfantasy.template.mybatis.custom;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.exfantasy.template.mybatis.mapper.NBAScheduleMapper;
import com.exfantasy.template.mybatis.model.NBASchedule;

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
		"insert into nba_schedule ",
		"(",
			"game_id, ",
			"game_time_in_millis, ",
			"game_time, ",
			"home_team_id, ", 
			"away_team_id",
        ") ",
        "values ",
        "(",
        	"#{gameId,jdbcType=INTEGER}, ",
        	"#{gameTimeInMillis,jdbcType=BIGINT}, ",
        	"#{gameTime,jdbcType=TIMESTAMP}, ",
        	"#{homeTeamId,jdbcType=INTEGER}, ",
        	"#{awayTeamId,jdbcType=INTEGER}",
        ")",
        "on duplicate key update ",
        	"game_time_in_millis = #{gameTimeInMillis,jdbcType=BIGINT}, ",
        	"game_time = #{gameTime,jdbcType=TIMESTAMP}, ",
        	"home_team_id = #{homeTeamId,jdbcType=INTEGER}, ",
        	"away_team_id = #{awayTeamId,jdbcType=INTEGER}"
	})
	int upsert(NBASchedule record);
}
