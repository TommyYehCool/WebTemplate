package com.exfantasy.template.mybatis.mapper;

import com.exfantasy.template.mybatis.model.NBAGame;
import com.exfantasy.template.mybatis.model.NBAGameExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface NBAGameMapper {
    @SelectProvider(type=NBAGameSqlProvider.class, method="countByExample")
    int countByExample(NBAGameExample example);

    @Delete({
        "delete from nba_game",
        "where game_id = #{gameId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer gameId);

    @Insert({
        "insert into nba_game (game_id, home_team_1st_scores, ",
        "home_team_2nd_scores, home_team_3rd_scores, ",
        "home_team_4th_scores, home_team_scores_sum, ",
        "away_team_1st_scores, away_team_2nd_scores, ",
        "away_team_3rd_scores, away_team_4th_scores, ",
        "away_team_scores_sum, total_scores_sum)",
        "values (#{gameId,jdbcType=INTEGER}, #{homeTeam1stScores,jdbcType=INTEGER}, ",
        "#{homeTeam2ndScores,jdbcType=INTEGER}, #{homeTeam3rdScores,jdbcType=INTEGER}, ",
        "#{homeTeam4thScores,jdbcType=INTEGER}, #{homeTeamScoresSum,jdbcType=INTEGER}, ",
        "#{awayTeam1stScores,jdbcType=INTEGER}, #{awayTeam2ndScores,jdbcType=INTEGER}, ",
        "#{awayTeam3rdScores,jdbcType=INTEGER}, #{awayTeam4thScores,jdbcType=INTEGER}, ",
        "#{awayTeamScoresSum,jdbcType=INTEGER}, #{totalScoresSum,jdbcType=INTEGER})"
    })
    int insert(NBAGame record);

    @InsertProvider(type=NBAGameSqlProvider.class, method="insertSelective")
    int insertSelective(NBAGame record);

    @SelectProvider(type=NBAGameSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="game_id", property="gameId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="home_team_1st_scores", property="homeTeam1stScores", jdbcType=JdbcType.INTEGER),
        @Result(column="home_team_2nd_scores", property="homeTeam2ndScores", jdbcType=JdbcType.INTEGER),
        @Result(column="home_team_3rd_scores", property="homeTeam3rdScores", jdbcType=JdbcType.INTEGER),
        @Result(column="home_team_4th_scores", property="homeTeam4thScores", jdbcType=JdbcType.INTEGER),
        @Result(column="home_team_scores_sum", property="homeTeamScoresSum", jdbcType=JdbcType.INTEGER),
        @Result(column="away_team_1st_scores", property="awayTeam1stScores", jdbcType=JdbcType.INTEGER),
        @Result(column="away_team_2nd_scores", property="awayTeam2ndScores", jdbcType=JdbcType.INTEGER),
        @Result(column="away_team_3rd_scores", property="awayTeam3rdScores", jdbcType=JdbcType.INTEGER),
        @Result(column="away_team_4th_scores", property="awayTeam4thScores", jdbcType=JdbcType.INTEGER),
        @Result(column="away_team_scores_sum", property="awayTeamScoresSum", jdbcType=JdbcType.INTEGER),
        @Result(column="total_scores_sum", property="totalScoresSum", jdbcType=JdbcType.INTEGER)
    })
    List<NBAGame> selectByExample(NBAGameExample example);

    @Select({
        "select",
        "game_id, home_team_1st_scores, home_team_2nd_scores, home_team_3rd_scores, home_team_4th_scores, ",
        "home_team_scores_sum, away_team_1st_scores, away_team_2nd_scores, away_team_3rd_scores, ",
        "away_team_4th_scores, away_team_scores_sum, total_scores_sum",
        "from nba_game",
        "where game_id = #{gameId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="game_id", property="gameId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="home_team_1st_scores", property="homeTeam1stScores", jdbcType=JdbcType.INTEGER),
        @Result(column="home_team_2nd_scores", property="homeTeam2ndScores", jdbcType=JdbcType.INTEGER),
        @Result(column="home_team_3rd_scores", property="homeTeam3rdScores", jdbcType=JdbcType.INTEGER),
        @Result(column="home_team_4th_scores", property="homeTeam4thScores", jdbcType=JdbcType.INTEGER),
        @Result(column="home_team_scores_sum", property="homeTeamScoresSum", jdbcType=JdbcType.INTEGER),
        @Result(column="away_team_1st_scores", property="awayTeam1stScores", jdbcType=JdbcType.INTEGER),
        @Result(column="away_team_2nd_scores", property="awayTeam2ndScores", jdbcType=JdbcType.INTEGER),
        @Result(column="away_team_3rd_scores", property="awayTeam3rdScores", jdbcType=JdbcType.INTEGER),
        @Result(column="away_team_4th_scores", property="awayTeam4thScores", jdbcType=JdbcType.INTEGER),
        @Result(column="away_team_scores_sum", property="awayTeamScoresSum", jdbcType=JdbcType.INTEGER),
        @Result(column="total_scores_sum", property="totalScoresSum", jdbcType=JdbcType.INTEGER)
    })
    NBAGame selectByPrimaryKey(Integer gameId);

    @UpdateProvider(type=NBAGameSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NBAGame record);

    @Update({
        "update nba_game",
        "set home_team_1st_scores = #{homeTeam1stScores,jdbcType=INTEGER},",
          "home_team_2nd_scores = #{homeTeam2ndScores,jdbcType=INTEGER},",
          "home_team_3rd_scores = #{homeTeam3rdScores,jdbcType=INTEGER},",
          "home_team_4th_scores = #{homeTeam4thScores,jdbcType=INTEGER},",
          "home_team_scores_sum = #{homeTeamScoresSum,jdbcType=INTEGER},",
          "away_team_1st_scores = #{awayTeam1stScores,jdbcType=INTEGER},",
          "away_team_2nd_scores = #{awayTeam2ndScores,jdbcType=INTEGER},",
          "away_team_3rd_scores = #{awayTeam3rdScores,jdbcType=INTEGER},",
          "away_team_4th_scores = #{awayTeam4thScores,jdbcType=INTEGER},",
          "away_team_scores_sum = #{awayTeamScoresSum,jdbcType=INTEGER},",
          "total_scores_sum = #{totalScoresSum,jdbcType=INTEGER}",
        "where game_id = #{gameId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(NBAGame record);
}