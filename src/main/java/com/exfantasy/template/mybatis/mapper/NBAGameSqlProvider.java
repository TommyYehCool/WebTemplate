package com.exfantasy.template.mybatis.mapper;

import com.exfantasy.template.mybatis.model.NBAGame;
import com.exfantasy.template.mybatis.model.NBAGameExample.Criteria;
import com.exfantasy.template.mybatis.model.NBAGameExample.Criterion;
import com.exfantasy.template.mybatis.model.NBAGameExample;
import java.util.List;
import org.apache.ibatis.jdbc.SQL;

public class NBAGameSqlProvider {

    public String countByExample(NBAGameExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("nba_game");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(NBAGame record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("nba_game");
        
        if (record.getGameId() != null) {
            sql.VALUES("game_id", "#{gameId,jdbcType=INTEGER}");
        }
        
        if (record.getHomeTeam1stScores() != null) {
            sql.VALUES("home_team_1st_scores", "#{homeTeam1stScores,jdbcType=INTEGER}");
        }
        
        if (record.getHomeTeam2ndScores() != null) {
            sql.VALUES("home_team_2nd_scores", "#{homeTeam2ndScores,jdbcType=INTEGER}");
        }
        
        if (record.getHomeTeam3rdScores() != null) {
            sql.VALUES("home_team_3rd_scores", "#{homeTeam3rdScores,jdbcType=INTEGER}");
        }
        
        if (record.getHomeTeam4thScores() != null) {
            sql.VALUES("home_team_4th_scores", "#{homeTeam4thScores,jdbcType=INTEGER}");
        }
        
        if (record.getHomeTeamScoresSum() != null) {
            sql.VALUES("home_team_scores_sum", "#{homeTeamScoresSum,jdbcType=INTEGER}");
        }
        
        if (record.getAwayTeam1stScores() != null) {
            sql.VALUES("away_team_1st_scores", "#{awayTeam1stScores,jdbcType=INTEGER}");
        }
        
        if (record.getAwayTeam2ndScores() != null) {
            sql.VALUES("away_team_2nd_scores", "#{awayTeam2ndScores,jdbcType=INTEGER}");
        }
        
        if (record.getAwayTeam3rdScores() != null) {
            sql.VALUES("away_team_3rd_scores", "#{awayTeam3rdScores,jdbcType=INTEGER}");
        }
        
        if (record.getAwayTeam4thScores() != null) {
            sql.VALUES("away_team_4th_scores", "#{awayTeam4thScores,jdbcType=INTEGER}");
        }
        
        if (record.getAwayTeamScoresSum() != null) {
            sql.VALUES("away_team_scores_sum", "#{awayTeamScoresSum,jdbcType=INTEGER}");
        }
        
        if (record.getTotalScoresSum() != null) {
            sql.VALUES("total_scores_sum", "#{totalScoresSum,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(NBAGameExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("game_id");
        } else {
            sql.SELECT("game_id");
        }
        sql.SELECT("home_team_1st_scores");
        sql.SELECT("home_team_2nd_scores");
        sql.SELECT("home_team_3rd_scores");
        sql.SELECT("home_team_4th_scores");
        sql.SELECT("home_team_scores_sum");
        sql.SELECT("away_team_1st_scores");
        sql.SELECT("away_team_2nd_scores");
        sql.SELECT("away_team_3rd_scores");
        sql.SELECT("away_team_4th_scores");
        sql.SELECT("away_team_scores_sum");
        sql.SELECT("total_scores_sum");
        sql.FROM("nba_game");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(NBAGame record) {
        SQL sql = new SQL();
        sql.UPDATE("nba_game");
        
        if (record.getHomeTeam1stScores() != null) {
            sql.SET("home_team_1st_scores = #{homeTeam1stScores,jdbcType=INTEGER}");
        }
        
        if (record.getHomeTeam2ndScores() != null) {
            sql.SET("home_team_2nd_scores = #{homeTeam2ndScores,jdbcType=INTEGER}");
        }
        
        if (record.getHomeTeam3rdScores() != null) {
            sql.SET("home_team_3rd_scores = #{homeTeam3rdScores,jdbcType=INTEGER}");
        }
        
        if (record.getHomeTeam4thScores() != null) {
            sql.SET("home_team_4th_scores = #{homeTeam4thScores,jdbcType=INTEGER}");
        }
        
        if (record.getHomeTeamScoresSum() != null) {
            sql.SET("home_team_scores_sum = #{homeTeamScoresSum,jdbcType=INTEGER}");
        }
        
        if (record.getAwayTeam1stScores() != null) {
            sql.SET("away_team_1st_scores = #{awayTeam1stScores,jdbcType=INTEGER}");
        }
        
        if (record.getAwayTeam2ndScores() != null) {
            sql.SET("away_team_2nd_scores = #{awayTeam2ndScores,jdbcType=INTEGER}");
        }
        
        if (record.getAwayTeam3rdScores() != null) {
            sql.SET("away_team_3rd_scores = #{awayTeam3rdScores,jdbcType=INTEGER}");
        }
        
        if (record.getAwayTeam4thScores() != null) {
            sql.SET("away_team_4th_scores = #{awayTeam4thScores,jdbcType=INTEGER}");
        }
        
        if (record.getAwayTeamScoresSum() != null) {
            sql.SET("away_team_scores_sum = #{awayTeamScoresSum,jdbcType=INTEGER}");
        }
        
        if (record.getTotalScoresSum() != null) {
            sql.SET("total_scores_sum = #{totalScoresSum,jdbcType=INTEGER}");
        }
        
        sql.WHERE("game_id = #{gameId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, NBAGameExample example, boolean includeExamplePhrase) {
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