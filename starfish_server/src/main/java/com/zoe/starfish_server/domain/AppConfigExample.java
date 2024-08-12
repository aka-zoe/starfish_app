package com.zoe.starfish_server.domain;

import java.util.ArrayList;
import java.util.List;

public class AppConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppConfigExample() {
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

        public Criteria andUmHostIsNull() {
            addCriterion("um_host is null");
            return (Criteria) this;
        }

        public Criteria andUmHostIsNotNull() {
            addCriterion("um_host is not null");
            return (Criteria) this;
        }

        public Criteria andUmHostEqualTo(String value) {
            addCriterion("um_host =", value, "umHost");
            return (Criteria) this;
        }

        public Criteria andUmHostNotEqualTo(String value) {
            addCriterion("um_host <>", value, "umHost");
            return (Criteria) this;
        }

        public Criteria andUmHostGreaterThan(String value) {
            addCriterion("um_host >", value, "umHost");
            return (Criteria) this;
        }

        public Criteria andUmHostGreaterThanOrEqualTo(String value) {
            addCriterion("um_host >=", value, "umHost");
            return (Criteria) this;
        }

        public Criteria andUmHostLessThan(String value) {
            addCriterion("um_host <", value, "umHost");
            return (Criteria) this;
        }

        public Criteria andUmHostLessThanOrEqualTo(String value) {
            addCriterion("um_host <=", value, "umHost");
            return (Criteria) this;
        }

        public Criteria andUmHostLike(String value) {
            addCriterion("um_host like", value, "umHost");
            return (Criteria) this;
        }

        public Criteria andUmHostNotLike(String value) {
            addCriterion("um_host not like", value, "umHost");
            return (Criteria) this;
        }

        public Criteria andUmHostIn(List<String> values) {
            addCriterion("um_host in", values, "umHost");
            return (Criteria) this;
        }

        public Criteria andUmHostNotIn(List<String> values) {
            addCriterion("um_host not in", values, "umHost");
            return (Criteria) this;
        }

        public Criteria andUmHostBetween(String value1, String value2) {
            addCriterion("um_host between", value1, value2, "umHost");
            return (Criteria) this;
        }

        public Criteria andUmHostNotBetween(String value1, String value2) {
            addCriterion("um_host not between", value1, value2, "umHost");
            return (Criteria) this;
        }

        public Criteria andUmAppMasterSecretIsNull() {
            addCriterion("um_app_master_secret is null");
            return (Criteria) this;
        }

        public Criteria andUmAppMasterSecretIsNotNull() {
            addCriterion("um_app_master_secret is not null");
            return (Criteria) this;
        }

        public Criteria andUmAppMasterSecretEqualTo(String value) {
            addCriterion("um_app_master_secret =", value, "umAppMasterSecret");
            return (Criteria) this;
        }

        public Criteria andUmAppMasterSecretNotEqualTo(String value) {
            addCriterion("um_app_master_secret <>", value, "umAppMasterSecret");
            return (Criteria) this;
        }

        public Criteria andUmAppMasterSecretGreaterThan(String value) {
            addCriterion("um_app_master_secret >", value, "umAppMasterSecret");
            return (Criteria) this;
        }

        public Criteria andUmAppMasterSecretGreaterThanOrEqualTo(String value) {
            addCriterion("um_app_master_secret >=", value, "umAppMasterSecret");
            return (Criteria) this;
        }

        public Criteria andUmAppMasterSecretLessThan(String value) {
            addCriterion("um_app_master_secret <", value, "umAppMasterSecret");
            return (Criteria) this;
        }

        public Criteria andUmAppMasterSecretLessThanOrEqualTo(String value) {
            addCriterion("um_app_master_secret <=", value, "umAppMasterSecret");
            return (Criteria) this;
        }

        public Criteria andUmAppMasterSecretLike(String value) {
            addCriterion("um_app_master_secret like", value, "umAppMasterSecret");
            return (Criteria) this;
        }

        public Criteria andUmAppMasterSecretNotLike(String value) {
            addCriterion("um_app_master_secret not like", value, "umAppMasterSecret");
            return (Criteria) this;
        }

        public Criteria andUmAppMasterSecretIn(List<String> values) {
            addCriterion("um_app_master_secret in", values, "umAppMasterSecret");
            return (Criteria) this;
        }

        public Criteria andUmAppMasterSecretNotIn(List<String> values) {
            addCriterion("um_app_master_secret not in", values, "umAppMasterSecret");
            return (Criteria) this;
        }

        public Criteria andUmAppMasterSecretBetween(String value1, String value2) {
            addCriterion("um_app_master_secret between", value1, value2, "umAppMasterSecret");
            return (Criteria) this;
        }

        public Criteria andUmAppMasterSecretNotBetween(String value1, String value2) {
            addCriterion("um_app_master_secret not between", value1, value2, "umAppMasterSecret");
            return (Criteria) this;
        }

        public Criteria andUmAppKeyIsNull() {
            addCriterion("um_app_key is null");
            return (Criteria) this;
        }

        public Criteria andUmAppKeyIsNotNull() {
            addCriterion("um_app_key is not null");
            return (Criteria) this;
        }

        public Criteria andUmAppKeyEqualTo(String value) {
            addCriterion("um_app_key =", value, "umAppKey");
            return (Criteria) this;
        }

        public Criteria andUmAppKeyNotEqualTo(String value) {
            addCriterion("um_app_key <>", value, "umAppKey");
            return (Criteria) this;
        }

        public Criteria andUmAppKeyGreaterThan(String value) {
            addCriterion("um_app_key >", value, "umAppKey");
            return (Criteria) this;
        }

        public Criteria andUmAppKeyGreaterThanOrEqualTo(String value) {
            addCriterion("um_app_key >=", value, "umAppKey");
            return (Criteria) this;
        }

        public Criteria andUmAppKeyLessThan(String value) {
            addCriterion("um_app_key <", value, "umAppKey");
            return (Criteria) this;
        }

        public Criteria andUmAppKeyLessThanOrEqualTo(String value) {
            addCriterion("um_app_key <=", value, "umAppKey");
            return (Criteria) this;
        }

        public Criteria andUmAppKeyLike(String value) {
            addCriterion("um_app_key like", value, "umAppKey");
            return (Criteria) this;
        }

        public Criteria andUmAppKeyNotLike(String value) {
            addCriterion("um_app_key not like", value, "umAppKey");
            return (Criteria) this;
        }

        public Criteria andUmAppKeyIn(List<String> values) {
            addCriterion("um_app_key in", values, "umAppKey");
            return (Criteria) this;
        }

        public Criteria andUmAppKeyNotIn(List<String> values) {
            addCriterion("um_app_key not in", values, "umAppKey");
            return (Criteria) this;
        }

        public Criteria andUmAppKeyBetween(String value1, String value2) {
            addCriterion("um_app_key between", value1, value2, "umAppKey");
            return (Criteria) this;
        }

        public Criteria andUmAppKeyNotBetween(String value1, String value2) {
            addCriterion("um_app_key not between", value1, value2, "umAppKey");
            return (Criteria) this;
        }

        public Criteria andUploadFilePathIsNull() {
            addCriterion("upload_file_path is null");
            return (Criteria) this;
        }

        public Criteria andUploadFilePathIsNotNull() {
            addCriterion("upload_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andUploadFilePathEqualTo(String value) {
            addCriterion("upload_file_path =", value, "uploadFilePath");
            return (Criteria) this;
        }

        public Criteria andUploadFilePathNotEqualTo(String value) {
            addCriterion("upload_file_path <>", value, "uploadFilePath");
            return (Criteria) this;
        }

        public Criteria andUploadFilePathGreaterThan(String value) {
            addCriterion("upload_file_path >", value, "uploadFilePath");
            return (Criteria) this;
        }

        public Criteria andUploadFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("upload_file_path >=", value, "uploadFilePath");
            return (Criteria) this;
        }

        public Criteria andUploadFilePathLessThan(String value) {
            addCriterion("upload_file_path <", value, "uploadFilePath");
            return (Criteria) this;
        }

        public Criteria andUploadFilePathLessThanOrEqualTo(String value) {
            addCriterion("upload_file_path <=", value, "uploadFilePath");
            return (Criteria) this;
        }

        public Criteria andUploadFilePathLike(String value) {
            addCriterion("upload_file_path like", value, "uploadFilePath");
            return (Criteria) this;
        }

        public Criteria andUploadFilePathNotLike(String value) {
            addCriterion("upload_file_path not like", value, "uploadFilePath");
            return (Criteria) this;
        }

        public Criteria andUploadFilePathIn(List<String> values) {
            addCriterion("upload_file_path in", values, "uploadFilePath");
            return (Criteria) this;
        }

        public Criteria andUploadFilePathNotIn(List<String> values) {
            addCriterion("upload_file_path not in", values, "uploadFilePath");
            return (Criteria) this;
        }

        public Criteria andUploadFilePathBetween(String value1, String value2) {
            addCriterion("upload_file_path between", value1, value2, "uploadFilePath");
            return (Criteria) this;
        }

        public Criteria andUploadFilePathNotBetween(String value1, String value2) {
            addCriterion("upload_file_path not between", value1, value2, "uploadFilePath");
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