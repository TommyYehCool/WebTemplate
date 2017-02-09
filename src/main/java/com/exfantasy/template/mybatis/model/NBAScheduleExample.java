package com.exfantasy.template.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NBAScheduleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NBAScheduleExample() {
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

        public Criteria andGameTimeInMillisIsNull() {
            addCriterion("game_time_in_millis is null");
            return (Criteria) this;
        }

        public Criteria andGameTimeInMillisIsNotNull() {
            addCriterion("game_time_in_millis is not null");
            return (Criteria) this;
        }

        public Criteria andGameTimeInMillisEqualTo(Long value) {
            addCriterion("game_time_in_millis =", value, "gameTimeInMillis");
            return (Criteria) this;
        }

        public Criteria andGameTimeInMillisNotEqualTo(Long value) {
            addCriterion("game_time_in_millis <>", value, "gameTimeInMillis");
            return (Criteria) this;
        }

        public Criteria andGameTimeInMillisGreaterThan(Long value) {
            addCriterion("game_time_in_millis >", value, "gameTimeInMillis");
            return (Criteria) this;
        }

        public Criteria andGameTimeInMillisGreaterThanOrEqualTo(Long value) {
            addCriterion("game_time_in_millis >=", value, "gameTimeInMillis");
            return (Criteria) this;
        }

        public Criteria andGameTimeInMillisLessThan(Long value) {
            addCriterion("game_time_in_millis <", value, "gameTimeInMillis");
            return (Criteria) this;
        }

        public Criteria andGameTimeInMillisLessThanOrEqualTo(Long value) {
            addCriterion("game_time_in_millis <=", value, "gameTimeInMillis");
            return (Criteria) this;
        }

        public Criteria andGameTimeInMillisIn(List<Long> values) {
            addCriterion("game_time_in_millis in", values, "gameTimeInMillis");
            return (Criteria) this;
        }

        public Criteria andGameTimeInMillisNotIn(List<Long> values) {
            addCriterion("game_time_in_millis not in", values, "gameTimeInMillis");
            return (Criteria) this;
        }

        public Criteria andGameTimeInMillisBetween(Long value1, Long value2) {
            addCriterion("game_time_in_millis between", value1, value2, "gameTimeInMillis");
            return (Criteria) this;
        }

        public Criteria andGameTimeInMillisNotBetween(Long value1, Long value2) {
            addCriterion("game_time_in_millis not between", value1, value2, "gameTimeInMillis");
            return (Criteria) this;
        }

        public Criteria andGameTimeIsNull() {
            addCriterion("game_time is null");
            return (Criteria) this;
        }

        public Criteria andGameTimeIsNotNull() {
            addCriterion("game_time is not null");
            return (Criteria) this;
        }

        public Criteria andGameTimeEqualTo(Date value) {
            addCriterion("game_time =", value, "gameTime");
            return (Criteria) this;
        }

        public Criteria andGameTimeNotEqualTo(Date value) {
            addCriterion("game_time <>", value, "gameTime");
            return (Criteria) this;
        }

        public Criteria andGameTimeGreaterThan(Date value) {
            addCriterion("game_time >", value, "gameTime");
            return (Criteria) this;
        }

        public Criteria andGameTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("game_time >=", value, "gameTime");
            return (Criteria) this;
        }

        public Criteria andGameTimeLessThan(Date value) {
            addCriterion("game_time <", value, "gameTime");
            return (Criteria) this;
        }

        public Criteria andGameTimeLessThanOrEqualTo(Date value) {
            addCriterion("game_time <=", value, "gameTime");
            return (Criteria) this;
        }

        public Criteria andGameTimeIn(List<Date> values) {
            addCriterion("game_time in", values, "gameTime");
            return (Criteria) this;
        }

        public Criteria andGameTimeNotIn(List<Date> values) {
            addCriterion("game_time not in", values, "gameTime");
            return (Criteria) this;
        }

        public Criteria andGameTimeBetween(Date value1, Date value2) {
            addCriterion("game_time between", value1, value2, "gameTime");
            return (Criteria) this;
        }

        public Criteria andGameTimeNotBetween(Date value1, Date value2) {
            addCriterion("game_time not between", value1, value2, "gameTime");
            return (Criteria) this;
        }

        public Criteria andHomeTeamIdIsNull() {
            addCriterion("home_team_id is null");
            return (Criteria) this;
        }

        public Criteria andHomeTeamIdIsNotNull() {
            addCriterion("home_team_id is not null");
            return (Criteria) this;
        }

        public Criteria andHomeTeamIdEqualTo(Integer value) {
            addCriterion("home_team_id =", value, "homeTeamId");
            return (Criteria) this;
        }

        public Criteria andHomeTeamIdNotEqualTo(Integer value) {
            addCriterion("home_team_id <>", value, "homeTeamId");
            return (Criteria) this;
        }

        public Criteria andHomeTeamIdGreaterThan(Integer value) {
            addCriterion("home_team_id >", value, "homeTeamId");
            return (Criteria) this;
        }

        public Criteria andHomeTeamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("home_team_id >=", value, "homeTeamId");
            return (Criteria) this;
        }

        public Criteria andHomeTeamIdLessThan(Integer value) {
            addCriterion("home_team_id <", value, "homeTeamId");
            return (Criteria) this;
        }

        public Criteria andHomeTeamIdLessThanOrEqualTo(Integer value) {
            addCriterion("home_team_id <=", value, "homeTeamId");
            return (Criteria) this;
        }

        public Criteria andHomeTeamIdIn(List<Integer> values) {
            addCriterion("home_team_id in", values, "homeTeamId");
            return (Criteria) this;
        }

        public Criteria andHomeTeamIdNotIn(List<Integer> values) {
            addCriterion("home_team_id not in", values, "homeTeamId");
            return (Criteria) this;
        }

        public Criteria andHomeTeamIdBetween(Integer value1, Integer value2) {
            addCriterion("home_team_id between", value1, value2, "homeTeamId");
            return (Criteria) this;
        }

        public Criteria andHomeTeamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("home_team_id not between", value1, value2, "homeTeamId");
            return (Criteria) this;
        }

        public Criteria andAwayTeamIdIsNull() {
            addCriterion("away_team_id is null");
            return (Criteria) this;
        }

        public Criteria andAwayTeamIdIsNotNull() {
            addCriterion("away_team_id is not null");
            return (Criteria) this;
        }

        public Criteria andAwayTeamIdEqualTo(Integer value) {
            addCriterion("away_team_id =", value, "awayTeamId");
            return (Criteria) this;
        }

        public Criteria andAwayTeamIdNotEqualTo(Integer value) {
            addCriterion("away_team_id <>", value, "awayTeamId");
            return (Criteria) this;
        }

        public Criteria andAwayTeamIdGreaterThan(Integer value) {
            addCriterion("away_team_id >", value, "awayTeamId");
            return (Criteria) this;
        }

        public Criteria andAwayTeamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("away_team_id >=", value, "awayTeamId");
            return (Criteria) this;
        }

        public Criteria andAwayTeamIdLessThan(Integer value) {
            addCriterion("away_team_id <", value, "awayTeamId");
            return (Criteria) this;
        }

        public Criteria andAwayTeamIdLessThanOrEqualTo(Integer value) {
            addCriterion("away_team_id <=", value, "awayTeamId");
            return (Criteria) this;
        }

        public Criteria andAwayTeamIdIn(List<Integer> values) {
            addCriterion("away_team_id in", values, "awayTeamId");
            return (Criteria) this;
        }

        public Criteria andAwayTeamIdNotIn(List<Integer> values) {
            addCriterion("away_team_id not in", values, "awayTeamId");
            return (Criteria) this;
        }

        public Criteria andAwayTeamIdBetween(Integer value1, Integer value2) {
            addCriterion("away_team_id between", value1, value2, "awayTeamId");
            return (Criteria) this;
        }

        public Criteria andAwayTeamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("away_team_id not between", value1, value2, "awayTeamId");
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