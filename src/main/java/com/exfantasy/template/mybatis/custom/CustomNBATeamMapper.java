package com.exfantasy.template.mybatis.custom;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.exfantasy.template.mybatis.mapper.NBATeamMapper;
import com.exfantasy.template.mybatis.model.NBATeam;

@Mapper
public interface CustomNBATeamMapper extends NBATeamMapper {
	
	/**
	 * <pre>
	 * 刪除全部 NBA 隊伍資料
	 * </pre>
	 * 
	 * @return
	 */
	@Delete({
        "delete from nba_team"
    })
	@Deprecated
    int deleteAll();

	/**
	 * <pre>
	 * 批次新增 NBA 隊伍資料
	 * </pre>
	 * 
	 * @param teams
	 * @return
	 */
	@Insert({
		"<script>",
			"insert into nba_team values",
			"<foreach collection='list' item='team' separator=','>",
				"(",
					"#{team.teamId,jdbcType=INTEGER},",
					"#{team.abbr,jdbcType=VARCHAR},",
					"#{team.cityCh,jdbcType=VARCHAR},",
					"#{team.cityEn,jdbcType=VARCHAR},",
					"#{team.code,jdbcType=VARCHAR},",
					"#{team.conferenceCh,jdbcType=VARCHAR},",
					"#{team.conferenceEn,jdbcType=VARCHAR},",
					"#{team.divisionCh,jdbcType=VARCHAR},",
					"#{team.divisionEn,jdbcType=VARCHAR},",
					"#{team.nameCh,jdbcType=VARCHAR},",
					"#{team.nameEn,jdbcType=VARCHAR}",
				")",
			"</foreach>",
		"</script>"
	})
	@Deprecated
	int batchInsertNBATeams(List<NBATeam> teams);

	/**
	 * <pre>
	 * Upsert NBA 隊伍資料
	 * </pre>
	 * 
	 * @param team
	 * @return
	 */
	@Insert({
		"insert into nba_team",
		"(",
			"team_id,",
			"abbr,",
			"city_ch,",
			"city_en,",
			"code,",
			"conference_ch,",
			"conference_en,",
			"division_ch,",
			"division_en,",
			"name_ch,",
			"name_en",
		")",
		"values",
        "(",
        	"#{teamId,jdbcType=INTEGER},",
        	"#{abbr,jdbcType=VARCHAR},",
        	"#{cityCh,jdbcType=VARCHAR},",
        	"#{cityEn,jdbcType=VARCHAR},",
        	"#{code,jdbcType=VARCHAR},",
        	"#{conferenceCh,jdbcType=VARCHAR},",
        	"#{conferenceEn,jdbcType=VARCHAR},",
        	"#{divisionCh,jdbcType=VARCHAR},",
        	"#{divisionEn,jdbcType=VARCHAR},",
        	"#{nameCh,jdbcType=VARCHAR},",
        	"#{nameEn,jdbcType=VARCHAR}",
        ")",
        "on duplicate key update",
        	"abbr = #{abbr,jdbcType=VARCHAR},",
        	"city_ch = #{cityCh,jdbcType=VARCHAR},",
        	"city_en = #{cityEn,jdbcType=VARCHAR},",
        	"code = #{code,jdbcType=VARCHAR},",
        	"conference_ch = #{conferenceCh,jdbcType=VARCHAR},",
        	"conference_en = #{conferenceEn,jdbcType=VARCHAR},",
        	"division_ch = #{divisionCh,jdbcType=VARCHAR},",
        	"division_en = #{divisionEn,jdbcType=VARCHAR},",
        	"name_ch = #{nameCh,jdbcType=VARCHAR},",
        	"name_en = #{nameEn,jdbcType=VARCHAR}"
	})
	int upsert(NBATeam team);
}
