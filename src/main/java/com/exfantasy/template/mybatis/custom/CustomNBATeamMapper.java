package com.exfantasy.template.mybatis.custom;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.exfantasy.template.mybatis.mapper.NBATeamMapper;
import com.exfantasy.template.mybatis.model.NBATeam;

@Mapper
public interface CustomNBATeamMapper extends NBATeamMapper {
	
	@Delete({
        "delete from nba_team"
    })
    int deleteAll();

	/**
	 * <pre>
	 * 批次新增 NBA 隊伍資料
	 * </pre>
	 */
	@Insert({
		"<script>",
		"insert into nba_team values",
		"<foreach collection='list' item='team' separator=','>",
		"(",
			"#{team.teamId,jdbcType=INTEGER}, #{team.abbr,jdbcType=VARCHAR}, ",
			"#{team.cityCh,jdbcType=VARCHAR}, #{team.cityEn,jdbcType=VARCHAR}, ",
        	"#{team.code,jdbcType=VARCHAR}, #{team.conferenceCh,jdbcType=VARCHAR}, ",
        	"#{team.conferenceEn,jdbcType=VARCHAR}, #{team.divisionCh,jdbcType=VARCHAR}, ",
        	"#{team.divisionEn,jdbcType=VARCHAR}, #{team.nameCh,jdbcType=VARCHAR}, ",
        	"#{team.nameEn,jdbcType=VARCHAR}",
		")",
		"</foreach>",
		"</script>"
	})
	int batchInsertNBATeams(List<NBATeam> teams);
}
