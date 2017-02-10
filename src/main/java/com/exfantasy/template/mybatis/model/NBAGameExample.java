package com.exfantasy.template.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class NBAGameExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NBAGameExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andGameIdIsNull() {
            addCriterion("game_id is null");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNotNull() {
            addCriterion("game_id is not null");
            return (Criteria) this;
        }

        public Criteria andGameIdEqualTo(Integer value) {
            addCriterion("game_id =", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotEqualTo(Integer value) {
            addCriterion("game_id <>", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThan(Integer value) {
            addCriterion("game_id >", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("game_id >=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThan(Integer value) {
            addCriterion("game_id <", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThanOrEqualTo(Integer value) {
            addCriterion("game_id <=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdIn(List<Integer> values) {
            addCriterion("game_id in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotIn(List<Integer> values) {
            addCriterion("game_id not in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdBetween(Integer value1, Integer value2) {
            addCriterion("game_id between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotBetween(Integer value1, Integer value2) {
            addCriterion("game_id not between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1stScoresIsNull() {
            addCriterion("home_team_1st_scores is null");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1stScoresIsNotNull() {
            addCriterion("home_team_1st_scores is not null");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1stScoresEqualTo(Integer value) {
            addCriterion("home_team_1st_scores =", value, "homeTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1stScoresNotEqualTo(Integer value) {
            addCriterion("home_team_1st_scores <>", value, "homeTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1stScoresGreaterThan(Integer value) {
            addCriterion("home_team_1st_scores >", value, "homeTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1stScoresGreaterThanOrEqualTo(Integer value) {
            addCriterion("home_team_1st_scores >=", value, "homeTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1stScoresLessThan(Integer value) {
            addCriterion("home_team_1st_scores <", value, "homeTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1stScoresLessThanOrEqualTo(Integer value) {
            addCriterion("home_team_1st_scores <=", value, "homeTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1stScoresIn(List<Integer> values) {
            addCriterion("home_team_1st_scores in", values, "homeTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1stScoresNotIn(List<Integer> values) {
            addCriterion("home_team_1st_scores not in", values, "homeTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1stScoresBetween(Integer value1, Integer value2) {
            addCriterion("home_team_1st_scores between", value1, value2, "homeTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1stScoresNotBetween(Integer value1, Integer value2) {
            addCriterion("home_team_1st_scores not between", value1, value2, "homeTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2ndScoresIsNull() {
            addCriterion("home_team_2nd_scores is null");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2ndScoresIsNotNull() {
            addCriterion("home_team_2nd_scores is not null");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2ndScoresEqualTo(Integer value) {
            addCriterion("home_team_2nd_scores =", value, "homeTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2ndScoresNotEqualTo(Integer value) {
            addCriterion("home_team_2nd_scores <>", value, "homeTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2ndScoresGreaterThan(Integer value) {
            addCriterion("home_team_2nd_scores >", value, "homeTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2ndScoresGreaterThanOrEqualTo(Integer value) {
            addCriterion("home_team_2nd_scores >=", value, "homeTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2ndScoresLessThan(Integer value) {
            addCriterion("home_team_2nd_scores <", value, "homeTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2ndScoresLessThanOrEqualTo(Integer value) {
            addCriterion("home_team_2nd_scores <=", value, "homeTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2ndScoresIn(List<Integer> values) {
            addCriterion("home_team_2nd_scores in", values, "homeTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2ndScoresNotIn(List<Integer> values) {
            addCriterion("home_team_2nd_scores not in", values, "homeTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2ndScoresBetween(Integer value1, Integer value2) {
            addCriterion("home_team_2nd_scores between", value1, value2, "homeTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2ndScoresNotBetween(Integer value1, Integer value2) {
            addCriterion("home_team_2nd_scores not between", value1, value2, "homeTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam3rdScoresIsNull() {
            addCriterion("home_team_3rd_scores is null");
            return (Criteria) this;
        }

        public Criteria andHomeTeam3rdScoresIsNotNull() {
            addCriterion("home_team_3rd_scores is not null");
            return (Criteria) this;
        }

        public Criteria andHomeTeam3rdScoresEqualTo(Integer value) {
            addCriterion("home_team_3rd_scores =", value, "homeTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam3rdScoresNotEqualTo(Integer value) {
            addCriterion("home_team_3rd_scores <>", value, "homeTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam3rdScoresGreaterThan(Integer value) {
            addCriterion("home_team_3rd_scores >", value, "homeTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam3rdScoresGreaterThanOrEqualTo(Integer value) {
            addCriterion("home_team_3rd_scores >=", value, "homeTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam3rdScoresLessThan(Integer value) {
            addCriterion("home_team_3rd_scores <", value, "homeTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam3rdScoresLessThanOrEqualTo(Integer value) {
            addCriterion("home_team_3rd_scores <=", value, "homeTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam3rdScoresIn(List<Integer> values) {
            addCriterion("home_team_3rd_scores in", values, "homeTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam3rdScoresNotIn(List<Integer> values) {
            addCriterion("home_team_3rd_scores not in", values, "homeTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam3rdScoresBetween(Integer value1, Integer value2) {
            addCriterion("home_team_3rd_scores between", value1, value2, "homeTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam3rdScoresNotBetween(Integer value1, Integer value2) {
            addCriterion("home_team_3rd_scores not between", value1, value2, "homeTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam4thScoresIsNull() {
            addCriterion("home_team_4th_scores is null");
            return (Criteria) this;
        }

        public Criteria andHomeTeam4thScoresIsNotNull() {
            addCriterion("home_team_4th_scores is not null");
            return (Criteria) this;
        }

        public Criteria andHomeTeam4thScoresEqualTo(Integer value) {
            addCriterion("home_team_4th_scores =", value, "homeTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam4thScoresNotEqualTo(Integer value) {
            addCriterion("home_team_4th_scores <>", value, "homeTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam4thScoresGreaterThan(Integer value) {
            addCriterion("home_team_4th_scores >", value, "homeTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam4thScoresGreaterThanOrEqualTo(Integer value) {
            addCriterion("home_team_4th_scores >=", value, "homeTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam4thScoresLessThan(Integer value) {
            addCriterion("home_team_4th_scores <", value, "homeTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam4thScoresLessThanOrEqualTo(Integer value) {
            addCriterion("home_team_4th_scores <=", value, "homeTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam4thScoresIn(List<Integer> values) {
            addCriterion("home_team_4th_scores in", values, "homeTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam4thScoresNotIn(List<Integer> values) {
            addCriterion("home_team_4th_scores not in", values, "homeTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam4thScoresBetween(Integer value1, Integer value2) {
            addCriterion("home_team_4th_scores between", value1, value2, "homeTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeam4thScoresNotBetween(Integer value1, Integer value2) {
            addCriterion("home_team_4th_scores not between", value1, value2, "homeTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andHomeTeamScoresSumIsNull() {
            addCriterion("home_team_scores_sum is null");
            return (Criteria) this;
        }

        public Criteria andHomeTeamScoresSumIsNotNull() {
            addCriterion("home_team_scores_sum is not null");
            return (Criteria) this;
        }

        public Criteria andHomeTeamScoresSumEqualTo(Integer value) {
            addCriterion("home_team_scores_sum =", value, "homeTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andHomeTeamScoresSumNotEqualTo(Integer value) {
            addCriterion("home_team_scores_sum <>", value, "homeTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andHomeTeamScoresSumGreaterThan(Integer value) {
            addCriterion("home_team_scores_sum >", value, "homeTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andHomeTeamScoresSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("home_team_scores_sum >=", value, "homeTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andHomeTeamScoresSumLessThan(Integer value) {
            addCriterion("home_team_scores_sum <", value, "homeTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andHomeTeamScoresSumLessThanOrEqualTo(Integer value) {
            addCriterion("home_team_scores_sum <=", value, "homeTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andHomeTeamScoresSumIn(List<Integer> values) {
            addCriterion("home_team_scores_sum in", values, "homeTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andHomeTeamScoresSumNotIn(List<Integer> values) {
            addCriterion("home_team_scores_sum not in", values, "homeTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andHomeTeamScoresSumBetween(Integer value1, Integer value2) {
            addCriterion("home_team_scores_sum between", value1, value2, "homeTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andHomeTeamScoresSumNotBetween(Integer value1, Integer value2) {
            addCriterion("home_team_scores_sum not between", value1, value2, "homeTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andAwayTeam1stScoresIsNull() {
            addCriterion("away_team_1st_scores is null");
            return (Criteria) this;
        }

        public Criteria andAwayTeam1stScoresIsNotNull() {
            addCriterion("away_team_1st_scores is not null");
            return (Criteria) this;
        }

        public Criteria andAwayTeam1stScoresEqualTo(Integer value) {
            addCriterion("away_team_1st_scores =", value, "awayTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam1stScoresNotEqualTo(Integer value) {
            addCriterion("away_team_1st_scores <>", value, "awayTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam1stScoresGreaterThan(Integer value) {
            addCriterion("away_team_1st_scores >", value, "awayTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam1stScoresGreaterThanOrEqualTo(Integer value) {
            addCriterion("away_team_1st_scores >=", value, "awayTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam1stScoresLessThan(Integer value) {
            addCriterion("away_team_1st_scores <", value, "awayTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam1stScoresLessThanOrEqualTo(Integer value) {
            addCriterion("away_team_1st_scores <=", value, "awayTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam1stScoresIn(List<Integer> values) {
            addCriterion("away_team_1st_scores in", values, "awayTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam1stScoresNotIn(List<Integer> values) {
            addCriterion("away_team_1st_scores not in", values, "awayTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam1stScoresBetween(Integer value1, Integer value2) {
            addCriterion("away_team_1st_scores between", value1, value2, "awayTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam1stScoresNotBetween(Integer value1, Integer value2) {
            addCriterion("away_team_1st_scores not between", value1, value2, "awayTeam1stScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam2ndScoresIsNull() {
            addCriterion("away_team_2nd_scores is null");
            return (Criteria) this;
        }

        public Criteria andAwayTeam2ndScoresIsNotNull() {
            addCriterion("away_team_2nd_scores is not null");
            return (Criteria) this;
        }

        public Criteria andAwayTeam2ndScoresEqualTo(Integer value) {
            addCriterion("away_team_2nd_scores =", value, "awayTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam2ndScoresNotEqualTo(Integer value) {
            addCriterion("away_team_2nd_scores <>", value, "awayTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam2ndScoresGreaterThan(Integer value) {
            addCriterion("away_team_2nd_scores >", value, "awayTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam2ndScoresGreaterThanOrEqualTo(Integer value) {
            addCriterion("away_team_2nd_scores >=", value, "awayTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam2ndScoresLessThan(Integer value) {
            addCriterion("away_team_2nd_scores <", value, "awayTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam2ndScoresLessThanOrEqualTo(Integer value) {
            addCriterion("away_team_2nd_scores <=", value, "awayTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam2ndScoresIn(List<Integer> values) {
            addCriterion("away_team_2nd_scores in", values, "awayTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam2ndScoresNotIn(List<Integer> values) {
            addCriterion("away_team_2nd_scores not in", values, "awayTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam2ndScoresBetween(Integer value1, Integer value2) {
            addCriterion("away_team_2nd_scores between", value1, value2, "awayTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam2ndScoresNotBetween(Integer value1, Integer value2) {
            addCriterion("away_team_2nd_scores not between", value1, value2, "awayTeam2ndScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam3rdScoresIsNull() {
            addCriterion("away_team_3rd_scores is null");
            return (Criteria) this;
        }

        public Criteria andAwayTeam3rdScoresIsNotNull() {
            addCriterion("away_team_3rd_scores is not null");
            return (Criteria) this;
        }

        public Criteria andAwayTeam3rdScoresEqualTo(Integer value) {
            addCriterion("away_team_3rd_scores =", value, "awayTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam3rdScoresNotEqualTo(Integer value) {
            addCriterion("away_team_3rd_scores <>", value, "awayTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam3rdScoresGreaterThan(Integer value) {
            addCriterion("away_team_3rd_scores >", value, "awayTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam3rdScoresGreaterThanOrEqualTo(Integer value) {
            addCriterion("away_team_3rd_scores >=", value, "awayTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam3rdScoresLessThan(Integer value) {
            addCriterion("away_team_3rd_scores <", value, "awayTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam3rdScoresLessThanOrEqualTo(Integer value) {
            addCriterion("away_team_3rd_scores <=", value, "awayTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam3rdScoresIn(List<Integer> values) {
            addCriterion("away_team_3rd_scores in", values, "awayTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam3rdScoresNotIn(List<Integer> values) {
            addCriterion("away_team_3rd_scores not in", values, "awayTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam3rdScoresBetween(Integer value1, Integer value2) {
            addCriterion("away_team_3rd_scores between", value1, value2, "awayTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam3rdScoresNotBetween(Integer value1, Integer value2) {
            addCriterion("away_team_3rd_scores not between", value1, value2, "awayTeam3rdScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam4thScoresIsNull() {
            addCriterion("away_team_4th_scores is null");
            return (Criteria) this;
        }

        public Criteria andAwayTeam4thScoresIsNotNull() {
            addCriterion("away_team_4th_scores is not null");
            return (Criteria) this;
        }

        public Criteria andAwayTeam4thScoresEqualTo(Integer value) {
            addCriterion("away_team_4th_scores =", value, "awayTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam4thScoresNotEqualTo(Integer value) {
            addCriterion("away_team_4th_scores <>", value, "awayTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam4thScoresGreaterThan(Integer value) {
            addCriterion("away_team_4th_scores >", value, "awayTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam4thScoresGreaterThanOrEqualTo(Integer value) {
            addCriterion("away_team_4th_scores >=", value, "awayTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam4thScoresLessThan(Integer value) {
            addCriterion("away_team_4th_scores <", value, "awayTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam4thScoresLessThanOrEqualTo(Integer value) {
            addCriterion("away_team_4th_scores <=", value, "awayTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam4thScoresIn(List<Integer> values) {
            addCriterion("away_team_4th_scores in", values, "awayTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam4thScoresNotIn(List<Integer> values) {
            addCriterion("away_team_4th_scores not in", values, "awayTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam4thScoresBetween(Integer value1, Integer value2) {
            addCriterion("away_team_4th_scores between", value1, value2, "awayTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeam4thScoresNotBetween(Integer value1, Integer value2) {
            addCriterion("away_team_4th_scores not between", value1, value2, "awayTeam4thScores");
            return (Criteria) this;
        }

        public Criteria andAwayTeamScoresSumIsNull() {
            addCriterion("away_team_scores_sum is null");
            return (Criteria) this;
        }

        public Criteria andAwayTeamScoresSumIsNotNull() {
            addCriterion("away_team_scores_sum is not null");
            return (Criteria) this;
        }

        public Criteria andAwayTeamScoresSumEqualTo(Integer value) {
            addCriterion("away_team_scores_sum =", value, "awayTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andAwayTeamScoresSumNotEqualTo(Integer value) {
            addCriterion("away_team_scores_sum <>", value, "awayTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andAwayTeamScoresSumGreaterThan(Integer value) {
            addCriterion("away_team_scores_sum >", value, "awayTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andAwayTeamScoresSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("away_team_scores_sum >=", value, "awayTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andAwayTeamScoresSumLessThan(Integer value) {
            addCriterion("away_team_scores_sum <", value, "awayTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andAwayTeamScoresSumLessThanOrEqualTo(Integer value) {
            addCriterion("away_team_scores_sum <=", value, "awayTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andAwayTeamScoresSumIn(List<Integer> values) {
            addCriterion("away_team_scores_sum in", values, "awayTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andAwayTeamScoresSumNotIn(List<Integer> values) {
            addCriterion("away_team_scores_sum not in", values, "awayTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andAwayTeamScoresSumBetween(Integer value1, Integer value2) {
            addCriterion("away_team_scores_sum between", value1, value2, "awayTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andAwayTeamScoresSumNotBetween(Integer value1, Integer value2) {
            addCriterion("away_team_scores_sum not between", value1, value2, "awayTeamScoresSum");
            return (Criteria) this;
        }

        public Criteria andTotalScoresSumIsNull() {
            addCriterion("total_scores_sum is null");
            return (Criteria) this;
        }

        public Criteria andTotalScoresSumIsNotNull() {
            addCriterion("total_scores_sum is not null");
            return (Criteria) this;
        }

        public Criteria andTotalScoresSumEqualTo(Integer value) {
            addCriterion("total_scores_sum =", value, "totalScoresSum");
            return (Criteria) this;
        }

        public Criteria andTotalScoresSumNotEqualTo(Integer value) {
            addCriterion("total_scores_sum <>", value, "totalScoresSum");
            return (Criteria) this;
        }

        public Criteria andTotalScoresSumGreaterThan(Integer value) {
            addCriterion("total_scores_sum >", value, "totalScoresSum");
            return (Criteria) this;
        }

        public Criteria andTotalScoresSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_scores_sum >=", value, "totalScoresSum");
            return (Criteria) this;
        }

        public Criteria andTotalScoresSumLessThan(Integer value) {
            addCriterion("total_scores_sum <", value, "totalScoresSum");
            return (Criteria) this;
        }

        public Criteria andTotalScoresSumLessThanOrEqualTo(Integer value) {
            addCriterion("total_scores_sum <=", value, "totalScoresSum");
            return (Criteria) this;
        }

        public Criteria andTotalScoresSumIn(List<Integer> values) {
            addCriterion("total_scores_sum in", values, "totalScoresSum");
            return (Criteria) this;
        }

        public Criteria andTotalScoresSumNotIn(List<Integer> values) {
            addCriterion("total_scores_sum not in", values, "totalScoresSum");
            return (Criteria) this;
        }

        public Criteria andTotalScoresSumBetween(Integer value1, Integer value2) {
            addCriterion("total_scores_sum between", value1, value2, "totalScoresSum");
            return (Criteria) this;
        }

        public Criteria andTotalScoresSumNotBetween(Integer value1, Integer value2) {
            addCriterion("total_scores_sum not between", value1, value2, "totalScoresSum");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}