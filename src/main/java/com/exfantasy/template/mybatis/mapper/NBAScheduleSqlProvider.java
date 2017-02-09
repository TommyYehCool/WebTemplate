package com.exfantasy.template.mybatis.mapper;

import com.exfantasy.template.mybatis.model.NBASchedule;
import com.exfantasy.template.mybatis.model.NBAScheduleExample.Criteria;
import com.exfantasy.template.mybatis.model.NBAScheduleExample.Criterion;
import com.exfantasy.template.mybatis.model.NBAScheduleExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class NBAScheduleSqlProvider {

    public String countByExample(NBAScheduleExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("nba_schedule");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(NBASchedule record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("nba_schedule");
        
        if (record.getGameId() != null) {
            sql.VALUES("game_id", "#{gameId,jdbcType=INTEGER}");
        }
        
        if (record.getGameTimeInMillis() != null) {
            sql.VALUES("game_time_in_millis", "#{gameTimeInMillis,jdbcType=BIGINT}");
        }
        
        if (record.getGameTime() != null) {
            sql.VALUES("game_time", "#{gameTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getHomeTeamId() != null) {
            sql.VALUES("home_team_id", "#{homeTeamId,jdbcType=INTEGER}");
        }
        
        if (record.getAwayTeamId() != null) {
            sql.VALUES("away_team_id", "#{awayTeamId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(NBAScheduleExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("game_id");
        } else {
            sql.SELECT("game_id");
        }
        sql.SELECT("game_time_in_millis");
        sql.SELECT("game_time");
        sql.SELECT("home_team_id");
        sql.SELECT("away_team_id");
        sql.FROM("nba_schedule");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        NBASchedule record = (NBASchedule) parameter.get("record");
        NBAScheduleExample example = (NBAScheduleExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("nba_schedule");
        
        if (record.getGameId() != null) {
            sql.SET("game_id = #{record.gameId,jdbcType=INTEGER}");
        }
        
        if (record.getGameTimeInMillis() != null) {
            sql.SET("game_time_in_millis = #{record.gameTimeInMillis,jdbcType=BIGINT}");
        }
        
        if (record.getGameTime() != null) {
            sql.SET("game_time = #{record.gameTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getHomeTeamId() != null) {
            sql.SET("home_team_id = #{record.homeTeamId,jdbcType=INTEGER}");
        }
        
        if (record.getAwayTeamId() != null) {
            sql.SET("away_team_id = #{record.awayTeamId,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("nba_schedule");
        
        sql.SET("game_id = #{record.gameId,jdbcType=INTEGER}");
        sql.SET("game_time_in_millis = #{record.gameTimeInMillis,jdbcType=BIGINT}");
        sql.SET("game_time = #{record.gameTime,jdbcType=TIMESTAMP}");
        sql.SET("home_team_id = #{record.homeTeamId,jdbcType=INTEGER}");
        sql.SET("away_team_id = #{record.awayTeamId,jdbcType=INTEGER}");
        
        NBAScheduleExample example = (NBAScheduleExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(NBASchedule record) {
        SQL sql = new SQL();
        sql.UPDATE("nba_schedule");
        
        if (record.getGameTimeInMillis() != null) {
            sql.SET("game_time_in_millis = #{gameTimeInMillis,jdbcType=BIGINT}");
        }
        
        if (record.getGameTime() != null) {
            sql.SET("game_time = #{gameTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getHomeTeamId() != null) {
            sql.SET("home_team_id = #{homeTeamId,jdbcType=INTEGER}");
        }
        
        if (record.getAwayTeamId() != null) {
            sql.SET("away_team_id = #{awayTeamId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("game_id = #{gameId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, NBAScheduleExample example, boolean includeExamplePhrase) {
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