package com.zoe.starfish_server.domain;

import java.util.ArrayList;
import java.util.List;

public class BookedHouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookedHouseExample() {
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

        public Criteria andBookedtimeIsNull() {
            addCriterion("bookedTime is null");
            return (Criteria) this;
        }

        public Criteria andBookedtimeIsNotNull() {
            addCriterion("bookedTime is not null");
            return (Criteria) this;
        }

        public Criteria andBookedtimeEqualTo(Long value) {
            addCriterion("bookedTime =", value, "bookedtime");
            return (Criteria) this;
        }

        public Criteria andBookedtimeNotEqualTo(Long value) {
            addCriterion("bookedTime <>", value, "bookedtime");
            return (Criteria) this;
        }

        public Criteria andBookedtimeGreaterThan(Long value) {
            addCriterion("bookedTime >", value, "bookedtime");
            return (Criteria) this;
        }

        public Criteria andBookedtimeGreaterThanOrEqualTo(Long value) {
            addCriterion("bookedTime >=", value, "bookedtime");
            return (Criteria) this;
        }

        public Criteria andBookedtimeLessThan(Long value) {
            addCriterion("bookedTime <", value, "bookedtime");
            return (Criteria) this;
        }

        public Criteria andBookedtimeLessThanOrEqualTo(Long value) {
            addCriterion("bookedTime <=", value, "bookedtime");
            return (Criteria) this;
        }

        public Criteria andBookedtimeIn(List<Long> values) {
            addCriterion("bookedTime in", values, "bookedtime");
            return (Criteria) this;
        }

        public Criteria andBookedtimeNotIn(List<Long> values) {
            addCriterion("bookedTime not in", values, "bookedtime");
            return (Criteria) this;
        }

        public Criteria andBookedtimeBetween(Long value1, Long value2) {
            addCriterion("bookedTime between", value1, value2, "bookedtime");
            return (Criteria) this;
        }

        public Criteria andBookedtimeNotBetween(Long value1, Long value2) {
            addCriterion("bookedTime not between", value1, value2, "bookedtime");
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

        public Criteria andBookeduseridIsNull() {
            addCriterion("bookedUserId is null");
            return (Criteria) this;
        }

        public Criteria andBookeduseridIsNotNull() {
            addCriterion("bookedUserId is not null");
            return (Criteria) this;
        }

        public Criteria andBookeduseridEqualTo(Long value) {
            addCriterion("bookedUserId =", value, "bookeduserid");
            return (Criteria) this;
        }

        public Criteria andBookeduseridNotEqualTo(Long value) {
            addCriterion("bookedUserId <>", value, "bookeduserid");
            return (Criteria) this;
        }

        public Criteria andBookeduseridGreaterThan(Long value) {
            addCriterion("bookedUserId >", value, "bookeduserid");
            return (Criteria) this;
        }

        public Criteria andBookeduseridGreaterThanOrEqualTo(Long value) {
            addCriterion("bookedUserId >=", value, "bookeduserid");
            return (Criteria) this;
        }

        public Criteria andBookeduseridLessThan(Long value) {
            addCriterion("bookedUserId <", value, "bookeduserid");
            return (Criteria) this;
        }

        public Criteria andBookeduseridLessThanOrEqualTo(Long value) {
            addCriterion("bookedUserId <=", value, "bookeduserid");
            return (Criteria) this;
        }

        public Criteria andBookeduseridIn(List<Long> values) {
            addCriterion("bookedUserId in", values, "bookeduserid");
            return (Criteria) this;
        }

        public Criteria andBookeduseridNotIn(List<Long> values) {
            addCriterion("bookedUserId not in", values, "bookeduserid");
            return (Criteria) this;
        }

        public Criteria andBookeduseridBetween(Long value1, Long value2) {
            addCriterion("bookedUserId between", value1, value2, "bookeduserid");
            return (Criteria) this;
        }

        public Criteria andBookeduseridNotBetween(Long value1, Long value2) {
            addCriterion("bookedUserId not between", value1, value2, "bookeduserid");
            return (Criteria) this;
        }

        public Criteria andUserphoneIsNull() {
            addCriterion("userPhone is null");
            return (Criteria) this;
        }

        public Criteria andUserphoneIsNotNull() {
            addCriterion("userPhone is not null");
            return (Criteria) this;
        }

        public Criteria andUserphoneEqualTo(String value) {
            addCriterion("userPhone =", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotEqualTo(String value) {
            addCriterion("userPhone <>", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneGreaterThan(String value) {
            addCriterion("userPhone >", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneGreaterThanOrEqualTo(String value) {
            addCriterion("userPhone >=", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneLessThan(String value) {
            addCriterion("userPhone <", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneLessThanOrEqualTo(String value) {
            addCriterion("userPhone <=", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneLike(String value) {
            addCriterion("userPhone like", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotLike(String value) {
            addCriterion("userPhone not like", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneIn(List<String> values) {
            addCriterion("userPhone in", values, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotIn(List<String> values) {
            addCriterion("userPhone not in", values, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneBetween(String value1, String value2) {
            addCriterion("userPhone between", value1, value2, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotBetween(String value1, String value2) {
            addCriterion("userPhone not between", value1, value2, "userphone");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` not between", value1, value2, "status");
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