package com.exfantasy.template.mybatis.mapper;

import com.exfantasy.template.mybatis.model.NBATeam;
import com.exfantasy.template.mybatis.model.NBATeamExample.Criteria;
import com.exfantasy.template.mybatis.model.NBATeamExample.Criterion;
import com.exfantasy.template.mybatis.model.NBATeamExample;
import java.util.List;
import org.apache.ibatis.jdbc.SQL;

public class NBATeamSqlProvider {

    public String insertSelective(NBATeam record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("nba_team");
        
        if (record.getTeamId() != null) {
            sql.VALUES("team_id", "#{teamId,jdbcType=INTEGER}");
        }
        
        if (record.getAbbr() != null) {
            sql.VALUES("abbr", "#{abbr,jdbcType=VARCHAR}");
        }
        
        if (record.getCityCh() != null) {
            sql.VALUES("city_ch", "#{cityCh,jdbcType=VARCHAR}");
        }
        
        if (record.getCityEn() != null) {
            sql.VALUES("city_en", "#{cityEn,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getConferenceCh() != null) {
            sql.VALUES("conference_ch", "#{conferenceCh,jdbcType=VARCHAR}");
        }
        
        if (record.getConferenceEn() != null) {
            sql.VALUES("conference_en", "#{conferenceEn,jdbcType=VARCHAR}");
        }
        
        if (record.getDivisionCh() != null) {
            sql.VALUES("division_ch", "#{divisionCh,jdbcType=VARCHAR}");
        }
        
        if (record.getDivisionEn() != null) {
            sql.VALUES("division_en", "#{divisionEn,jdbcType=VARCHAR}");
        }
        
        if (record.getNameCh() != null) {
            sql.VALUES("name_ch", "#{nameCh,jdbcType=VARCHAR}");
        }
        
        if (record.getNameEn() != null) {
            sql.VALUES("name_en", "#{nameEn,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(NBATeamExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("team_id");
        } else {
            sql.SELECT("team_id");
        }
        sql.SELECT("abbr");
        sql.SELECT("city_ch");
        sql.SELECT("city_en");
        sql.SELECT("code");
        sql.SELECT("conference_ch");
        sql.SELECT("conference_en");
        sql.SELECT("division_ch");
        sql.SELECT("division_en");
        sql.SELECT("name_ch");
        sql.SELECT("name_en");
        sql.FROM("nba_team");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(NBATeam record) {
        SQL sql = new SQL();
        sql.UPDATE("nba_team");
        
        if (record.getAbbr() != null) {
            sql.SET("abbr = #{abbr,jdbcType=VARCHAR}");
        }
        
        if (record.getCityCh() != null) {
            sql.SET("city_ch = #{cityCh,jdbcType=VARCHAR}");
        }
        
        if (record.getCityEn() != null) {
            sql.SET("city_en = #{cityEn,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getConferenceCh() != null) {
            sql.SET("conference_ch = #{conferenceCh,jdbcType=VARCHAR}");
        }
        
        if (record.getConferenceEn() != null) {
            sql.SET("conference_en = #{conferenceEn,jdbcType=VARCHAR}");
        }
        
        if (record.getDivisionCh() != null) {
            sql.SET("division_ch = #{divisionCh,jdbcType=VARCHAR}");
        }
        
        if (record.getDivisionEn() != null) {
            sql.SET("division_en = #{divisionEn,jdbcType=VARCHAR}");
        }
        
        if (record.getNameCh() != null) {
            sql.SET("name_ch = #{nameCh,jdbcType=VARCHAR}");
        }
        
        if (record.getNameEn() != null) {
            sql.SET("name_en = #{nameEn,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("team_id = #{teamId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, NBATeamExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}