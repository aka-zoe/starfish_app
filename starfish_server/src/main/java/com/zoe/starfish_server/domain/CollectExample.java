package com.zoe.starfish_server.domain;

import java.util.ArrayList;
import java.util.List;

public class CollectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollectExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCollecttypeIsNull() {
            addCriterion("collectType is null");
            return (Criteria) this;
        }

        public Criteria andCollecttypeIsNotNull() {
            addCriterion("collectType is not null");
            return (Criteria) this;
        }

        public Criteria andCollecttypeEqualTo(Integer value) {
            addCriterion("collectType =", value, "collecttype");
            return (Criteria) this;
        }

        public Criteria andCollecttypeNotEqualTo(Integer value) {
            addCriterion("collectType <>", value, "collecttype");
            return (Criteria) this;
        }

        public Criteria andCollecttypeGreaterThan(Integer value) {
            addCriterion("collectType >", value, "collecttype");
            return (Criteria) this;
        }

        public Criteria andCollecttypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("collectType >=", value, "collecttype");
            return (Criteria) this;
        }

        public Criteria andCollecttypeLessThan(Integer value) {
            addCriterion("collectType <", value, "collecttype");
            return (Criteria) this;
        }

        public Criteria andCollecttypeLessThanOrEqualTo(Integer value) {
            addCriterion("collectType <=", value, "collecttype");
            return (Criteria) this;
        }

        public Criteria andCollecttypeIn(List<Integer> values) {
            addCriterion("collectType in", values, "collecttype");
            return (Criteria) this;
        }

        public Criteria andCollecttypeNotIn(List<Integer> values) {
            addCriterion("collectType not in", values, "collecttype");
            return (Criteria) this;
        }

        public Criteria andCollecttypeBetween(Integer value1, Integer value2) {
            addCriterion("collectType between", value1, value2, "collecttype");
            return (Criteria) this;
        }

        public Criteria andCollecttypeNotBetween(Integer value1, Integer value2) {
            addCriterion("collectType not between", value1, value2, "collecttype");
            return (Criteria) this;
        }

        public Criteria andCollecttimeIsNull() {
            addCriterion("collectTime is null");
            return (Criteria) this;
        }

        public Criteria andCollecttimeIsNotNull() {
            addCriterion("collectTime is not null");
            return (Criteria) this;
        }

        public Criteria andCollecttimeEqualTo(Long value) {
            addCriterion("collectTime =", value, "collecttime");
            return (Criteria) this;
        }

        public Criteria andCollecttimeNotEqualTo(Long value) {
            addCriterion("collectTime <>", value, "collecttime");
            return (Criteria) this;
        }

        public Criteria andCollecttimeGreaterThan(Long value) {
            addCriterion("collectTime >", value, "collecttime");
            return (Criteria) this;
        }

        public Criteria andCollecttimeGreaterThanOrEqualTo(Long value) {
            addCriterion("collectTime >=", value, "collecttime");
            return (Criteria) this;
        }

        public Criteria andCollecttimeLessThan(Long value) {
            addCriterion("collectTime <", value, "collecttime");
            return (Criteria) this;
        }

        public Criteria andCollecttimeLessThanOrEqualTo(Long value) {
            addCriterion("collectTime <=", value, "collecttime");
            return (Criteria) this;
        }

        public Criteria andCollecttimeIn(List<Long> values) {
            addCriterion("collectTime in", values, "collecttime");
            return (Criteria) this;
        }

        public Criteria andCollecttimeNotIn(List<Long> values) {
            addCriterion("collectTime not in", values, "collecttime");
            return (Criteria) this;
        }

        public Criteria andCollecttimeBetween(Long value1, Long value2) {
            addCriterion("collectTime between", value1, value2, "collecttime");
            return (Criteria) this;
        }

        public Criteria andCollecttimeNotBetween(Long value1, Long value2) {
            addCriterion("collectTime not between", value1, value2, "collecttime");
            return (Criteria) this;
        }

        public Criteria andHouseresidIsNull() {
            addCriterion("houseResId is null");
            return (Criteria) this;
        }

        public Criteria andHouseresidIsNotNull() {
            addCriterion("houseResId is not null");
            return (Criteria) this;
        }

        public Criteria andHouseresidEqualTo(Long value) {
            addCriterion("houseResId =", value, "houseresid");
            return (Criteria) this;
        }

        public Criteria andHouseresidNotEqualTo(Long value) {
            addCriterion("houseResId <>", value, "houseresid");
            return (Criteria) this;
        }

        public Criteria andHouseresidGreaterThan(Long value) {
            addCriterion("houseResId >", value, "houseresid");
            return (Criteria) this;
        }

        public Criteria andHouseresidGreaterThanOrEqualTo(Long value) {
            addCriterion("houseResId >=", value, "houseresid");
            return (Criteria) this;
        }

        public Criteria andHouseresidLessThan(Long value) {
            addCriterion("houseResId <", value, "houseresid");
            return (Criteria) this;
        }

        public Criteria andHouseresidLessThanOrEqualTo(Long value) {
            addCriterion("houseResId <=", value, "houseresid");
            return (Criteria) this;
        }

        public Criteria andHouseresidIn(List<Long> values) {
            addCriterion("houseResId in", values, "houseresid");
            return (Criteria) this;
        }

        public Criteria andHouseresidNotIn(List<Long> values) {
            addCriterion("houseResId not in", values, "houseresid");
            return (Criteria) this;
        }

        public Criteria andHouseresidBetween(Long value1, Long value2) {
            addCriterion("houseResId between", value1, value2, "houseresid");
            return (Criteria) this;
        }

        public Criteria andHouseresidNotBetween(Long value1, Long value2) {
            addCriterion("houseResId not between", value1, value2, "houseresid");
            return (Criteria) this;
        }

        public Criteria andNewsidIsNull() {
            addCriterion("newsId is null");
            return (Criteria) this;
        }

        public Criteria andNewsidIsNotNull() {
            addCriterion("newsId is not null");
            return (Criteria) this;
        }

        public Criteria andNewsidEqualTo(Long value) {
            addCriterion("newsId =", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotEqualTo(Long value) {
            addCriterion("newsId <>", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidGreaterThan(Long value) {
            addCriterion("newsId >", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidGreaterThanOrEqualTo(Long value) {
            addCriterion("newsId >=", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidLessThan(Long value) {
            addCriterion("newsId <", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidLessThanOrEqualTo(Long value) {
            addCriterion("newsId <=", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidIn(List<Long> values) {
            addCriterion("newsId in", values, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotIn(List<Long> values) {
            addCriterion("newsId not in", values, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidBetween(Long value1, Long value2) {
            addCriterion("newsId between", value1, value2, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotBetween(Long value1, Long value2) {
            addCriterion("newsId not between", value1, value2, "newsid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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