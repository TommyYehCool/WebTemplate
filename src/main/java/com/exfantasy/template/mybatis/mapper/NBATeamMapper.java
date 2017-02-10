package com.exfantasy.template.mybatis.mapper;

import com.exfantasy.template.mybatis.model.NBATeam;
import com.exfantasy.template.mybatis.model.NBATeamExample;
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
public interface NBATeamMapper {
    @SelectProvider(type=NBATeamSqlProvider.class, method="countByExample")
    int countByExample(NBATeamExample example);

    @Delete({
        "delete from nba_team",
        "where team_id = #{teamId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer teamId);

    @Insert({
        "insert into nba_team (team_id, abbr, ",
        "city_ch, city_en, ",
        "code, conference_ch, ",
        "conference_en, division_ch, ",
        "division_en, name_ch, ",
        "name_en)",
        "values (#{teamId,jdbcType=INTEGER}, #{abbr,jdbcType=VARCHAR}, ",
        "#{cityCh,jdbcType=VARCHAR}, #{cityEn,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{conferenceCh,jdbcType=VARCHAR}, ",
        "#{conferenceEn,jdbcType=VARCHAR}, #{divisionCh,jdbcType=VARCHAR}, ",
        "#{divisionEn,jdbcType=VARCHAR}, #{nameCh,jdbcType=VARCHAR}, ",
        "#{nameEn,jdbcType=VARCHAR})"
    })
    int insert(NBATeam record);

    @InsertProvider(type=NBATeamSqlProvider.class, method="insertSelective")
    int insertSelective(NBATeam record);

    @SelectProvider(type=NBATeamSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="team_id", property="teamId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="abbr", property="abbr", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_ch", property="cityCh", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_en", property="cityEn", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="conference_ch", property="conferenceCh", jdbcType=JdbcType.VARCHAR),
        @Result(column="conference_en", property="conferenceEn", jdbcType=JdbcType.VARCHAR),
        @Result(column="division_ch", property="divisionCh", jdbcType=JdbcType.VARCHAR),
        @Result(column="division_en", property="divisionEn", jdbcType=JdbcType.VARCHAR),
        @Result(column="name_ch", property="nameCh", jdbcType=JdbcType.VARCHAR),
        @Result(column="name_en", property="nameEn", jdbcType=JdbcType.VARCHAR)
    })
    List<NBATeam> selectByExample(NBATeamExample example);

    @Select({
        "select",
        "team_id, abbr, city_ch, city_en, code, conference_ch, conference_en, division_ch, ",
        "division_en, name_ch, name_en",
        "from nba_team",
        "where team_id = #{teamId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="team_id", property="teamId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="abbr", property="abbr", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_ch", property="cityCh", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_en", property="cityEn", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="conference_ch", property="conferenceCh", jdbcType=JdbcType.VARCHAR),
        @Result(column="conference_en", property="conferenceEn", jdbcType=JdbcType.VARCHAR),
        @Result(column="division_ch", property="divisionCh", jdbcType=JdbcType.VARCHAR),
        @Result(column="division_en", property="divisionEn", jdbcType=JdbcType.VARCHAR),
        @Result(column="name_ch", property="nameCh", jdbcType=JdbcType.VARCHAR),
        @Result(column="name_en", property="nameEn", jdbcType=JdbcType.VARCHAR)
    })
    NBATeam selectByPrimaryKey(Integer teamId);

    @UpdateProvider(type=NBATeamSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NBATeam record);

    @Update({
        "update nba_team",
        "set abbr = #{abbr,jdbcType=VARCHAR},",
          "city_ch = #{cityCh,jdbcType=VARCHAR},",
          "city_en = #{cityEn,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "conference_ch = #{conferenceCh,jdbcType=VARCHAR},",
          "conference_en = #{conferenceEn,jdbcType=VARCHAR},",
          "division_ch = #{divisionCh,jdbcType=VARCHAR},",
          "division_en = #{divisionEn,jdbcType=VARCHAR},",
          "name_ch = #{nameCh,jdbcType=VARCHAR},",
          "name_en = #{nameEn,jdbcType=VARCHAR}",
        "where team_id = #{teamId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(NBATeam record);
}