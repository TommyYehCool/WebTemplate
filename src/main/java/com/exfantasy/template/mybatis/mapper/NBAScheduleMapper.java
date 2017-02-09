package com.exfantasy.template.mybatis.mapper;

import com.exfantasy.template.mybatis.model.NBASchedule;
import com.exfantasy.template.mybatis.model.NBAScheduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface NBAScheduleMapper {
    @SelectProvider(type=NBAScheduleSqlProvider.class, method="countByExample")
    int countByExample(NBAScheduleExample example);

    @Delete({
        "delete from nba_schedule",
        "where game_id = #{gameId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer gameId);

    @Insert({
        "insert into nba_schedule (game_id, game_time_in_millis, ",
        "game_time, home_team_id, ",
        "away_team_id)",
        "values (#{gameId,jdbcType=INTEGER}, #{gameTimeInMillis,jdbcType=BIGINT}, ",
        "#{gameTime,jdbcType=TIMESTAMP}, #{homeTeamId,jdbcType=INTEGER}, ",
        "#{awayTeamId,jdbcType=INTEGER})"
    })
    int insert(NBASchedule record);

    @InsertProvider(type=NBAScheduleSqlProvider.class, method="insertSelective")
    int insertSelective(NBASchedule record);

    @SelectProvider(type=NBAScheduleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="game_id", property="gameId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="game_time_in_millis", property="gameTimeInMillis", jdbcType=JdbcType.BIGINT),
        @Result(column="game_time", property="gameTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="home_team_id", property="homeTeamId", jdbcType=JdbcType.INTEGER),
        @Result(column="away_team_id", property="awayTeamId", jdbcType=JdbcType.INTEGER)
    })
    List<NBASchedule> selectByExample(NBAScheduleExample example);

    @Select({
        "select",
        "game_id, game_time_in_millis, game_time, home_team_id, away_team_id",
        "from nba_schedule",
        "where game_id = #{gameId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="game_id", property="gameId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="game_time_in_millis", property="gameTimeInMillis", jdbcType=JdbcType.BIGINT),
        @Result(column="game_time", property="gameTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="home_team_id", property="homeTeamId", jdbcType=JdbcType.INTEGER),
        @Result(column="away_team_id", property="awayTeamId", jdbcType=JdbcType.INTEGER)
    })
    NBASchedule selectByPrimaryKey(Integer gameId);

    @UpdateProvider(type=NBAScheduleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") NBASchedule record, @Param("example") NBAScheduleExample example);

    @UpdateProvider(type=NBAScheduleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") NBASchedule record, @Param("example") NBAScheduleExample example);

    @UpdateProvider(type=NBAScheduleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NBASchedule record);

    @Update({
        "update nba_schedule",
        "set game_time_in_millis = #{gameTimeInMillis,jdbcType=BIGINT},",
          "game_time = #{gameTime,jdbcType=TIMESTAMP},",
          "home_team_id = #{homeTeamId,jdbcType=INTEGER},",
          "away_team_id = #{awayTeamId,jdbcType=INTEGER}",
        "where game_id = #{gameId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(NBASchedule record);
}