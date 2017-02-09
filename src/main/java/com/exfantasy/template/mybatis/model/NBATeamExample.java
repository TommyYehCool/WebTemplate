package com.exfantasy.template.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class NBATeamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NBATeamExample() {
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

        public Criteria andTeamIdIsNull() {
            addCriterion("team_id is null");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNotNull() {
            addCriterion("team_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeamIdEqualTo(Integer value) {
            addCriterion("team_id =", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotEqualTo(Integer value) {
            addCriterion("team_id <>", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThan(Integer value) {
            addCriterion("team_id >", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("team_id >=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThan(Integer value) {
            addCriterion("team_id <", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThanOrEqualTo(Integer value) {
            addCriterion("team_id <=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIn(List<Integer> values) {
            addCriterion("team_id in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotIn(List<Integer> values) {
            addCriterion("team_id not in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdBetween(Integer value1, Integer value2) {
            addCriterion("team_id between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("team_id not between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andAbbrIsNull() {
            addCriterion("abbr is null");
            return (Criteria) this;
        }

        public Criteria andAbbrIsNotNull() {
            addCriterion("abbr is not null");
            return (Criteria) this;
        }

        public Criteria andAbbrEqualTo(String value) {
            addCriterion("abbr =", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrNotEqualTo(String value) {
            addCriterion("abbr <>", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrGreaterThan(String value) {
            addCriterion("abbr >", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrGreaterThanOrEqualTo(String value) {
            addCriterion("abbr >=", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrLessThan(String value) {
            addCriterion("abbr <", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrLessThanOrEqualTo(String value) {
            addCriterion("abbr <=", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrLike(String value) {
            addCriterion("abbr like", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrNotLike(String value) {
            addCriterion("abbr not like", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrIn(List<String> values) {
            addCriterion("abbr in", values, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrNotIn(List<String> values) {
            addCriterion("abbr not in", values, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrBetween(String value1, String value2) {
            addCriterion("abbr between", value1, value2, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrNotBetween(String value1, String value2) {
            addCriterion("abbr not between", value1, value2, "abbr");
            return (Criteria) this;
        }

        public Criteria andCityChIsNull() {
            addCriterion("city_ch is null");
            return (Criteria) this;
        }

        public Criteria andCityChIsNotNull() {
            addCriterion("city_ch is not null");
            return (Criteria) this;
        }

        public Criteria andCityChEqualTo(String value) {
            addCriterion("city_ch =", value, "cityCh");
            return (Criteria) this;
        }

        public Criteria andCityChNotEqualTo(String value) {
            addCriterion("city_ch <>", value, "cityCh");
            return (Criteria) this;
        }

        public Criteria andCityChGreaterThan(String value) {
            addCriterion("city_ch >", value, "cityCh");
            return (Criteria) this;
        }

        public Criteria andCityChGreaterThanOrEqualTo(String value) {
            addCriterion("city_ch >=", value, "cityCh");
            return (Criteria) this;
        }

        public Criteria andCityChLessThan(String value) {
            addCriterion("city_ch <", value, "cityCh");
            return (Criteria) this;
        }

        public Criteria andCityChLessThanOrEqualTo(String value) {
            addCriterion("city_ch <=", value, "cityCh");
            return (Criteria) this;
        }

        public Criteria andCityChLike(String value) {
            addCriterion("city_ch like", value, "cityCh");
            return (Criteria) this;
        }

        public Criteria andCityChNotLike(String value) {
            addCriterion("city_ch not like", value, "cityCh");
            return (Criteria) this;
        }

        public Criteria andCityChIn(List<String> values) {
            addCriterion("city_ch in", values, "cityCh");
            return (Criteria) this;
        }

        public Criteria andCityChNotIn(List<String> values) {
            addCriterion("city_ch not in", values, "cityCh");
            return (Criteria) this;
        }

        public Criteria andCityChBetween(String value1, String value2) {
            addCriterion("city_ch between", value1, value2, "cityCh");
            return (Criteria) this;
        }

        public Criteria andCityChNotBetween(String value1, String value2) {
            addCriterion("city_ch not between", value1, value2, "cityCh");
            return (Criteria) this;
        }

        public Criteria andCityEnIsNull() {
            addCriterion("city_en is null");
            return (Criteria) this;
        }

        public Criteria andCityEnIsNotNull() {
            addCriterion("city_en is not null");
            return (Criteria) this;
        }

        public Criteria andCityEnEqualTo(String value) {
            addCriterion("city_en =", value, "cityEn");
            return (Criteria) this;
        }

        public Criteria andCityEnNotEqualTo(String value) {
            addCriterion("city_en <>", value, "cityEn");
            return (Criteria) this;
        }

        public Criteria andCityEnGreaterThan(String value) {
            addCriterion("city_en >", value, "cityEn");
            return (Criteria) this;
        }

        public Criteria andCityEnGreaterThanOrEqualTo(String value) {
            addCriterion("city_en >=", value, "cityEn");
            return (Criteria) this;
        }

        public Criteria andCityEnLessThan(String value) {
            addCriterion("city_en <", value, "cityEn");
            return (Criteria) this;
        }

        public Criteria andCityEnLessThanOrEqualTo(String value) {
            addCriterion("city_en <=", value, "cityEn");
            return (Criteria) this;
        }

        public Criteria andCityEnLike(String value) {
            addCriterion("city_en like", value, "cityEn");
            return (Criteria) this;
        }

        public Criteria andCityEnNotLike(String value) {
            addCriterion("city_en not like", value, "cityEn");
            return (Criteria) this;
        }

        public Criteria andCityEnIn(List<String> values) {
            addCriterion("city_en in", values, "cityEn");
            return (Criteria) this;
        }

        public Criteria andCityEnNotIn(List<String> values) {
            addCriterion("city_en not in", values, "cityEn");
            return (Criteria) this;
        }

        public Criteria andCityEnBetween(String value1, String value2) {
            addCriterion("city_en between", value1, value2, "cityEn");
            return (Criteria) this;
        }

        public Criteria andCityEnNotBetween(String value1, String value2) {
            addCriterion("city_en not between", value1, value2, "cityEn");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andConferenceChIsNull() {
            addCriterion("conference_ch is null");
            return (Criteria) this;
        }

        public Criteria andConferenceChIsNotNull() {
            addCriterion("conference_ch is not null");
            return (Criteria) this;
        }

        public Criteria andConferenceChEqualTo(String value) {
            addCriterion("conference_ch =", value, "conferenceCh");
            return (Criteria) this;
        }

        public Criteria andConferenceChNotEqualTo(String value) {
            addCriterion("conference_ch <>", value, "conferenceCh");
            return (Criteria) this;
        }

        public Criteria andConferenceChGreaterThan(String value) {
            addCriterion("conference_ch >", value, "conferenceCh");
            return (Criteria) this;
        }

        public Criteria andConferenceChGreaterThanOrEqualTo(String value) {
            addCriterion("conference_ch >=", value, "conferenceCh");
            return (Criteria) this;
        }

        public Criteria andConferenceChLessThan(String value) {
            addCriterion("conference_ch <", value, "conferenceCh");
            return (Criteria) this;
        }

        public Criteria andConferenceChLessThanOrEqualTo(String value) {
            addCriterion("conference_ch <=", value, "conferenceCh");
            return (Criteria) this;
        }

        public Criteria andConferenceChLike(String value) {
            addCriterion("conference_ch like", value, "conferenceCh");
            return (Criteria) this;
        }

        public Criteria andConferenceChNotLike(String value) {
            addCriterion("conference_ch not like", value, "conferenceCh");
            return (Criteria) this;
        }

        public Criteria andConferenceChIn(List<String> values) {
            addCriterion("conference_ch in", values, "conferenceCh");
            return (Criteria) this;
        }

        public Criteria andConferenceChNotIn(List<String> values) {
            addCriterion("conference_ch not in", values, "conferenceCh");
            return (Criteria) this;
        }

        public Criteria andConferenceChBetween(String value1, String value2) {
            addCriterion("conference_ch between", value1, value2, "conferenceCh");
            return (Criteria) this;
        }

        public Criteria andConferenceChNotBetween(String value1, String value2) {
            addCriterion("conference_ch not between", value1, value2, "conferenceCh");
            return (Criteria) this;
        }

        public Criteria andConferenceEnIsNull() {
            addCriterion("conference_en is null");
            return (Criteria) this;
        }

        public Criteria andConferenceEnIsNotNull() {
            addCriterion("conference_en is not null");
            return (Criteria) this;
        }

        public Criteria andConferenceEnEqualTo(String value) {
            addCriterion("conference_en =", value, "conferenceEn");
            return (Criteria) this;
        }

        public Criteria andConferenceEnNotEqualTo(String value) {
            addCriterion("conference_en <>", value, "conferenceEn");
            return (Criteria) this;
        }

        public Criteria andConferenceEnGreaterThan(String value) {
            addCriterion("conference_en >", value, "conferenceEn");
            return (Criteria) this;
        }

        public Criteria andConferenceEnGreaterThanOrEqualTo(String value) {
            addCriterion("conference_en >=", value, "conferenceEn");
            return (Criteria) this;
        }

        public Criteria andConferenceEnLessThan(String value) {
            addCriterion("conference_en <", value, "conferenceEn");
            return (Criteria) this;
        }

        public Criteria andConferenceEnLessThanOrEqualTo(String value) {
            addCriterion("conference_en <=", value, "conferenceEn");
            return (Criteria) this;
        }

        public Criteria andConferenceEnLike(String value) {
            addCriterion("conference_en like", value, "conferenceEn");
            return (Criteria) this;
        }

        public Criteria andConferenceEnNotLike(String value) {
            addCriterion("conference_en not like", value, "conferenceEn");
            return (Criteria) this;
        }

        public Criteria andConferenceEnIn(List<String> values) {
            addCriterion("conference_en in", values, "conferenceEn");
            return (Criteria) this;
        }

        public Criteria andConferenceEnNotIn(List<String> values) {
            addCriterion("conference_en not in", values, "conferenceEn");
            return (Criteria) this;
        }

        public Criteria andConferenceEnBetween(String value1, String value2) {
            addCriterion("conference_en between", value1, value2, "conferenceEn");
            return (Criteria) this;
        }

        public Criteria andConferenceEnNotBetween(String value1, String value2) {
            addCriterion("conference_en not between", value1, value2, "conferenceEn");
            return (Criteria) this;
        }

        public Criteria andDivisionChIsNull() {
            addCriterion("division_ch is null");
            return (Criteria) this;
        }

        public Criteria andDivisionChIsNotNull() {
            addCriterion("division_ch is not null");
            return (Criteria) this;
        }

        public Criteria andDivisionChEqualTo(String value) {
            addCriterion("division_ch =", value, "divisionCh");
            return (Criteria) this;
        }

        public Criteria andDivisionChNotEqualTo(String value) {
            addCriterion("division_ch <>", value, "divisionCh");
            return (Criteria) this;
        }

        public Criteria andDivisionChGreaterThan(String value) {
            addCriterion("division_ch >", value, "divisionCh");
            return (Criteria) this;
        }

        public Criteria andDivisionChGreaterThanOrEqualTo(String value) {
            addCriterion("division_ch >=", value, "divisionCh");
            return (Criteria) this;
        }

        public Criteria andDivisionChLessThan(String value) {
            addCriterion("division_ch <", value, "divisionCh");
            return (Criteria) this;
        }

        public Criteria andDivisionChLessThanOrEqualTo(String value) {
            addCriterion("division_ch <=", value, "divisionCh");
            return (Criteria) this;
        }

        public Criteria andDivisionChLike(String value) {
            addCriterion("division_ch like", value, "divisionCh");
            return (Criteria) this;
        }

        public Criteria andDivisionChNotLike(String value) {
            addCriterion("division_ch not like", value, "divisionCh");
            return (Criteria) this;
        }

        public Criteria andDivisionChIn(List<String> values) {
            addCriterion("division_ch in", values, "divisionCh");
            return (Criteria) this;
        }

        public Criteria andDivisionChNotIn(List<String> values) {
            addCriterion("division_ch not in", values, "divisionCh");
            return (Criteria) this;
        }

        public Criteria andDivisionChBetween(String value1, String value2) {
            addCriterion("division_ch between", value1, value2, "divisionCh");
            return (Criteria) this;
        }

        public Criteria andDivisionChNotBetween(String value1, String value2) {
            addCriterion("division_ch not between", value1, value2, "divisionCh");
            return (Criteria) this;
        }

        public Criteria andDivisionEnIsNull() {
            addCriterion("division_en is null");
            return (Criteria) this;
        }

        public Criteria andDivisionEnIsNotNull() {
            addCriterion("division_en is not null");
            return (Criteria) this;
        }

        public Criteria andDivisionEnEqualTo(String value) {
            addCriterion("division_en =", value, "divisionEn");
            return (Criteria) this;
        }

        public Criteria andDivisionEnNotEqualTo(String value) {
            addCriterion("division_en <>", value, "divisionEn");
            return (Criteria) this;
        }

        public Criteria andDivisionEnGreaterThan(String value) {
            addCriterion("division_en >", value, "divisionEn");
            return (Criteria) this;
        }

        public Criteria andDivisionEnGreaterThanOrEqualTo(String value) {
            addCriterion("division_en >=", value, "divisionEn");
            return (Criteria) this;
        }

        public Criteria andDivisionEnLessThan(String value) {
            addCriterion("division_en <", value, "divisionEn");
            return (Criteria) this;
        }

        public Criteria andDivisionEnLessThanOrEqualTo(String value) {
            addCriterion("division_en <=", value, "divisionEn");
            return (Criteria) this;
        }

        public Criteria andDivisionEnLike(String value) {
            addCriterion("division_en like", value, "divisionEn");
            return (Criteria) this;
        }

        public Criteria andDivisionEnNotLike(String value) {
            addCriterion("division_en not like", value, "divisionEn");
            return (Criteria) this;
        }

        public Criteria andDivisionEnIn(List<String> values) {
            addCriterion("division_en in", values, "divisionEn");
            return (Criteria) this;
        }

        public Criteria andDivisionEnNotIn(List<String> values) {
            addCriterion("division_en not in", values, "divisionEn");
            return (Criteria) this;
        }

        public Criteria andDivisionEnBetween(String value1, String value2) {
            addCriterion("division_en between", value1, value2, "divisionEn");
            return (Criteria) this;
        }

        public Criteria andDivisionEnNotBetween(String value1, String value2) {
            addCriterion("division_en not between", value1, value2, "divisionEn");
            return (Criteria) this;
        }

        public Criteria andNameChIsNull() {
            addCriterion("name_ch is null");
            return (Criteria) this;
        }

        public Criteria andNameChIsNotNull() {
            addCriterion("name_ch is not null");
            return (Criteria) this;
        }

        public Criteria andNameChEqualTo(String value) {
            addCriterion("name_ch =", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChNotEqualTo(String value) {
            addCriterion("name_ch <>", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChGreaterThan(String value) {
            addCriterion("name_ch >", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChGreaterThanOrEqualTo(String value) {
            addCriterion("name_ch >=", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChLessThan(String value) {
            addCriterion("name_ch <", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChLessThanOrEqualTo(String value) {
            addCriterion("name_ch <=", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChLike(String value) {
            addCriterion("name_ch like", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChNotLike(String value) {
            addCriterion("name_ch not like", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChIn(List<String> values) {
            addCriterion("name_ch in", values, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChNotIn(List<String> values) {
            addCriterion("name_ch not in", values, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChBetween(String value1, String value2) {
            addCriterion("name_ch between", value1, value2, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChNotBetween(String value1, String value2) {
            addCriterion("name_ch not between", value1, value2, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNull() {
            addCriterion("name_en is null");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNotNull() {
            addCriterion("name_en is not null");
            return (Criteria) this;
        }

        public Criteria andNameEnEqualTo(String value) {
            addCriterion("name_en =", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotEqualTo(String value) {
            addCriterion("name_en <>", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThan(String value) {
            addCriterion("name_en >", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("name_en >=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThan(String value) {
            addCriterion("name_en <", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThanOrEqualTo(String value) {
            addCriterion("name_en <=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLike(String value) {
            addCriterion("name_en like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotLike(String value) {
            addCriterion("name_en not like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnIn(List<String> values) {
            addCriterion("name_en in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotIn(List<String> values) {
            addCriterion("name_en not in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnBetween(String value1, String value2) {
            addCriterion("name_en between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotBetween(String value1, String value2) {
            addCriterion("name_en not between", value1, value2, "nameEn");
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