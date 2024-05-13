package com.zoe.starfish_server.domain;

import java.util.ArrayList;
import java.util.List;

public class HouseResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HouseResourceExample() {
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

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andHouseImageIdIsNull() {
            addCriterion("house_image_id is null");
            return (Criteria) this;
        }

        public Criteria andHouseImageIdIsNotNull() {
            addCriterion("house_image_id is not null");
            return (Criteria) this;
        }

        public Criteria andHouseImageIdEqualTo(Long value) {
            addCriterion("house_image_id =", value, "houseImageId");
            return (Criteria) this;
        }

        public Criteria andHouseImageIdNotEqualTo(Long value) {
            addCriterion("house_image_id <>", value, "houseImageId");
            return (Criteria) this;
        }

        public Criteria andHouseImageIdGreaterThan(Long value) {
            addCriterion("house_image_id >", value, "houseImageId");
            return (Criteria) this;
        }

        public Criteria andHouseImageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("house_image_id >=", value, "houseImageId");
            return (Criteria) this;
        }

        public Criteria andHouseImageIdLessThan(Long value) {
            addCriterion("house_image_id <", value, "houseImageId");
            return (Criteria) this;
        }

        public Criteria andHouseImageIdLessThanOrEqualTo(Long value) {
            addCriterion("house_image_id <=", value, "houseImageId");
            return (Criteria) this;
        }

        public Criteria andHouseImageIdIn(List<Long> values) {
            addCriterion("house_image_id in", values, "houseImageId");
            return (Criteria) this;
        }

        public Criteria andHouseImageIdNotIn(List<Long> values) {
            addCriterion("house_image_id not in", values, "houseImageId");
            return (Criteria) this;
        }

        public Criteria andHouseImageIdBetween(Long value1, Long value2) {
            addCriterion("house_image_id between", value1, value2, "houseImageId");
            return (Criteria) this;
        }

        public Criteria andHouseImageIdNotBetween(Long value1, Long value2) {
            addCriterion("house_image_id not between", value1, value2, "houseImageId");
            return (Criteria) this;
        }

        public Criteria andHouseDescIsNull() {
            addCriterion("house_desc is null");
            return (Criteria) this;
        }

        public Criteria andHouseDescIsNotNull() {
            addCriterion("house_desc is not null");
            return (Criteria) this;
        }

        public Criteria andHouseDescEqualTo(String value) {
            addCriterion("house_desc =", value, "houseDesc");
            return (Criteria) this;
        }

        public Criteria andHouseDescNotEqualTo(String value) {
            addCriterion("house_desc <>", value, "houseDesc");
            return (Criteria) this;
        }

        public Criteria andHouseDescGreaterThan(String value) {
            addCriterion("house_desc >", value, "houseDesc");
            return (Criteria) this;
        }

        public Criteria andHouseDescGreaterThanOrEqualTo(String value) {
            addCriterion("house_desc >=", value, "houseDesc");
            return (Criteria) this;
        }

        public Criteria andHouseDescLessThan(String value) {
            addCriterion("house_desc <", value, "houseDesc");
            return (Criteria) this;
        }

        public Criteria andHouseDescLessThanOrEqualTo(String value) {
            addCriterion("house_desc <=", value, "houseDesc");
            return (Criteria) this;
        }

        public Criteria andHouseDescLike(String value) {
            addCriterion("house_desc like", value, "houseDesc");
            return (Criteria) this;
        }

        public Criteria andHouseDescNotLike(String value) {
            addCriterion("house_desc not like", value, "houseDesc");
            return (Criteria) this;
        }

        public Criteria andHouseDescIn(List<String> values) {
            addCriterion("house_desc in", values, "houseDesc");
            return (Criteria) this;
        }

        public Criteria andHouseDescNotIn(List<String> values) {
            addCriterion("house_desc not in", values, "houseDesc");
            return (Criteria) this;
        }

        public Criteria andHouseDescBetween(String value1, String value2) {
            addCriterion("house_desc between", value1, value2, "houseDesc");
            return (Criteria) this;
        }

        public Criteria andHouseDescNotBetween(String value1, String value2) {
            addCriterion("house_desc not between", value1, value2, "houseDesc");
            return (Criteria) this;
        }

        public Criteria andLeaseTypeIsNull() {
            addCriterion("lease_type is null");
            return (Criteria) this;
        }

        public Criteria andLeaseTypeIsNotNull() {
            addCriterion("lease_type is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseTypeEqualTo(Integer value) {
            addCriterion("lease_type =", value, "leaseType");
            return (Criteria) this;
        }

        public Criteria andLeaseTypeNotEqualTo(Integer value) {
            addCriterion("lease_type <>", value, "leaseType");
            return (Criteria) this;
        }

        public Criteria andLeaseTypeGreaterThan(Integer value) {
            addCriterion("lease_type >", value, "leaseType");
            return (Criteria) this;
        }

        public Criteria andLeaseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("lease_type >=", value, "leaseType");
            return (Criteria) this;
        }

        public Criteria andLeaseTypeLessThan(Integer value) {
            addCriterion("lease_type <", value, "leaseType");
            return (Criteria) this;
        }

        public Criteria andLeaseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("lease_type <=", value, "leaseType");
            return (Criteria) this;
        }

        public Criteria andLeaseTypeIn(List<Integer> values) {
            addCriterion("lease_type in", values, "leaseType");
            return (Criteria) this;
        }

        public Criteria andLeaseTypeNotIn(List<Integer> values) {
            addCriterion("lease_type not in", values, "leaseType");
            return (Criteria) this;
        }

        public Criteria andLeaseTypeBetween(Integer value1, Integer value2) {
            addCriterion("lease_type between", value1, value2, "leaseType");
            return (Criteria) this;
        }

        public Criteria andLeaseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("lease_type not between", value1, value2, "leaseType");
            return (Criteria) this;
        }

        public Criteria andRentIsNull() {
            addCriterion("rent is null");
            return (Criteria) this;
        }

        public Criteria andRentIsNotNull() {
            addCriterion("rent is not null");
            return (Criteria) this;
        }

        public Criteria andRentEqualTo(Long value) {
            addCriterion("rent =", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentNotEqualTo(Long value) {
            addCriterion("rent <>", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentGreaterThan(Long value) {
            addCriterion("rent >", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentGreaterThanOrEqualTo(Long value) {
            addCriterion("rent >=", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentLessThan(Long value) {
            addCriterion("rent <", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentLessThanOrEqualTo(Long value) {
            addCriterion("rent <=", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentIn(List<Long> values) {
            addCriterion("rent in", values, "rent");
            return (Criteria) this;
        }

        public Criteria andRentNotIn(List<Long> values) {
            addCriterion("rent not in", values, "rent");
            return (Criteria) this;
        }

        public Criteria andRentBetween(Long value1, Long value2) {
            addCriterion("rent between", value1, value2, "rent");
            return (Criteria) this;
        }

        public Criteria andRentNotBetween(Long value1, Long value2) {
            addCriterion("rent not between", value1, value2, "rent");
            return (Criteria) this;
        }

        public Criteria andServiceChargeIsNull() {
            addCriterion("service_charge is null");
            return (Criteria) this;
        }

        public Criteria andServiceChargeIsNotNull() {
            addCriterion("service_charge is not null");
            return (Criteria) this;
        }

        public Criteria andServiceChargeEqualTo(Long value) {
            addCriterion("service_charge =", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeNotEqualTo(Long value) {
            addCriterion("service_charge <>", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeGreaterThan(Long value) {
            addCriterion("service_charge >", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeGreaterThanOrEqualTo(Long value) {
            addCriterion("service_charge >=", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeLessThan(Long value) {
            addCriterion("service_charge <", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeLessThanOrEqualTo(Long value) {
            addCriterion("service_charge <=", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeIn(List<Long> values) {
            addCriterion("service_charge in", values, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeNotIn(List<Long> values) {
            addCriterion("service_charge not in", values, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeBetween(Long value1, Long value2) {
            addCriterion("service_charge between", value1, value2, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeNotBetween(Long value1, Long value2) {
            addCriterion("service_charge not between", value1, value2, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdIsNull() {
            addCriterion("house_type_id is null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdIsNotNull() {
            addCriterion("house_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdEqualTo(Long value) {
            addCriterion("house_type_id =", value, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdNotEqualTo(Long value) {
            addCriterion("house_type_id <>", value, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdGreaterThan(Long value) {
            addCriterion("house_type_id >", value, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("house_type_id >=", value, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdLessThan(Long value) {
            addCriterion("house_type_id <", value, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("house_type_id <=", value, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdIn(List<Long> values) {
            addCriterion("house_type_id in", values, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdNotIn(List<Long> values) {
            addCriterion("house_type_id not in", values, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdBetween(Long value1, Long value2) {
            addCriterion("house_type_id between", value1, value2, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("house_type_id not between", value1, value2, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNull() {
            addCriterion("house_type is null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNotNull() {
            addCriterion("house_type is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeEqualTo(Integer value) {
            addCriterion("house_type =", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotEqualTo(Integer value) {
            addCriterion("house_type <>", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThan(Integer value) {
            addCriterion("house_type >", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("house_type >=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThan(Integer value) {
            addCriterion("house_type <", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("house_type <=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIn(List<Integer> values) {
            addCriterion("house_type in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotIn(List<Integer> values) {
            addCriterion("house_type not in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeBetween(Integer value1, Integer value2) {
            addCriterion("house_type between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("house_type not between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNull() {
            addCriterion("direction is null");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNotNull() {
            addCriterion("direction is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionEqualTo(String value) {
            addCriterion("direction =", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotEqualTo(String value) {
            addCriterion("direction <>", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThan(String value) {
            addCriterion("direction >", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThanOrEqualTo(String value) {
            addCriterion("direction >=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThan(String value) {
            addCriterion("direction <", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThanOrEqualTo(String value) {
            addCriterion("direction <=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLike(String value) {
            addCriterion("direction like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotLike(String value) {
            addCriterion("direction not like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionIn(List<String> values) {
            addCriterion("direction in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotIn(List<String> values) {
            addCriterion("direction not in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionBetween(String value1, String value2) {
            addCriterion("direction between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotBetween(String value1, String value2) {
            addCriterion("direction not between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andCheckInDateIsNull() {
            addCriterion("check_in_date is null");
            return (Criteria) this;
        }

        public Criteria andCheckInDateIsNotNull() {
            addCriterion("check_in_date is not null");
            return (Criteria) this;
        }

        public Criteria andCheckInDateEqualTo(String value) {
            addCriterion("check_in_date =", value, "checkInDate");
            return (Criteria) this;
        }

        public Criteria andCheckInDateNotEqualTo(String value) {
            addCriterion("check_in_date <>", value, "checkInDate");
            return (Criteria) this;
        }

        public Criteria andCheckInDateGreaterThan(String value) {
            addCriterion("check_in_date >", value, "checkInDate");
            return (Criteria) this;
        }

        public Criteria andCheckInDateGreaterThanOrEqualTo(String value) {
            addCriterion("check_in_date >=", value, "checkInDate");
            return (Criteria) this;
        }

        public Criteria andCheckInDateLessThan(String value) {
            addCriterion("check_in_date <", value, "checkInDate");
            return (Criteria) this;
        }

        public Criteria andCheckInDateLessThanOrEqualTo(String value) {
            addCriterion("check_in_date <=", value, "checkInDate");
            return (Criteria) this;
        }

        public Criteria andCheckInDateLike(String value) {
            addCriterion("check_in_date like", value, "checkInDate");
            return (Criteria) this;
        }

        public Criteria andCheckInDateNotLike(String value) {
            addCriterion("check_in_date not like", value, "checkInDate");
            return (Criteria) this;
        }

        public Criteria andCheckInDateIn(List<String> values) {
            addCriterion("check_in_date in", values, "checkInDate");
            return (Criteria) this;
        }

        public Criteria andCheckInDateNotIn(List<String> values) {
            addCriterion("check_in_date not in", values, "checkInDate");
            return (Criteria) this;
        }

        public Criteria andCheckInDateBetween(String value1, String value2) {
            addCriterion("check_in_date between", value1, value2, "checkInDate");
            return (Criteria) this;
        }

        public Criteria andCheckInDateNotBetween(String value1, String value2) {
            addCriterion("check_in_date not between", value1, value2, "checkInDate");
            return (Criteria) this;
        }

        public Criteria andTotalFloorIsNull() {
            addCriterion("total_floor is null");
            return (Criteria) this;
        }

        public Criteria andTotalFloorIsNotNull() {
            addCriterion("total_floor is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFloorEqualTo(Integer value) {
            addCriterion("total_floor =", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorNotEqualTo(Integer value) {
            addCriterion("total_floor <>", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorGreaterThan(Integer value) {
            addCriterion("total_floor >", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_floor >=", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorLessThan(Integer value) {
            addCriterion("total_floor <", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorLessThanOrEqualTo(Integer value) {
            addCriterion("total_floor <=", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorIn(List<Integer> values) {
            addCriterion("total_floor in", values, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorNotIn(List<Integer> values) {
            addCriterion("total_floor not in", values, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorBetween(Integer value1, Integer value2) {
            addCriterion("total_floor between", value1, value2, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorNotBetween(Integer value1, Integer value2) {
            addCriterion("total_floor not between", value1, value2, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorIsNull() {
            addCriterion("current_floor is null");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorIsNotNull() {
            addCriterion("current_floor is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorEqualTo(Integer value) {
            addCriterion("current_floor =", value, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorNotEqualTo(Integer value) {
            addCriterion("current_floor <>", value, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorGreaterThan(Integer value) {
            addCriterion("current_floor >", value, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_floor >=", value, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorLessThan(Integer value) {
            addCriterion("current_floor <", value, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorLessThanOrEqualTo(Integer value) {
            addCriterion("current_floor <=", value, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorIn(List<Integer> values) {
            addCriterion("current_floor in", values, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorNotIn(List<Integer> values) {
            addCriterion("current_floor not in", values, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorBetween(Integer value1, Integer value2) {
            addCriterion("current_floor between", value1, value2, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andCurrentFloorNotBetween(Integer value1, Integer value2) {
            addCriterion("current_floor not between", value1, value2, "currentFloor");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIdIsNull() {
            addCriterion("house_area_id is null");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIdIsNotNull() {
            addCriterion("house_area_id is not null");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIdEqualTo(Long value) {
            addCriterion("house_area_id =", value, "houseAreaId");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIdNotEqualTo(Long value) {
            addCriterion("house_area_id <>", value, "houseAreaId");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIdGreaterThan(Long value) {
            addCriterion("house_area_id >", value, "houseAreaId");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("house_area_id >=", value, "houseAreaId");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIdLessThan(Long value) {
            addCriterion("house_area_id <", value, "houseAreaId");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIdLessThanOrEqualTo(Long value) {
            addCriterion("house_area_id <=", value, "houseAreaId");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIdIn(List<Long> values) {
            addCriterion("house_area_id in", values, "houseAreaId");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIdNotIn(List<Long> values) {
            addCriterion("house_area_id not in", values, "houseAreaId");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIdBetween(Long value1, Long value2) {
            addCriterion("house_area_id between", value1, value2, "houseAreaId");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIdNotBetween(Long value1, Long value2) {
            addCriterion("house_area_id not between", value1, value2, "houseAreaId");
            return (Criteria) this;
        }

        public Criteria andAcreageIsNull() {
            addCriterion("acreage is null");
            return (Criteria) this;
        }

        public Criteria andAcreageIsNotNull() {
            addCriterion("acreage is not null");
            return (Criteria) this;
        }

        public Criteria andAcreageEqualTo(Integer value) {
            addCriterion("acreage =", value, "acreage");
            return (Criteria) this;
        }

        public Criteria andAcreageNotEqualTo(Integer value) {
            addCriterion("acreage <>", value, "acreage");
            return (Criteria) this;
        }

        public Criteria andAcreageGreaterThan(Integer value) {
            addCriterion("acreage >", value, "acreage");
            return (Criteria) this;
        }

        public Criteria andAcreageGreaterThanOrEqualTo(Integer value) {
            addCriterion("acreage >=", value, "acreage");
            return (Criteria) this;
        }

        public Criteria andAcreageLessThan(Integer value) {
            addCriterion("acreage <", value, "acreage");
            return (Criteria) this;
        }

        public Criteria andAcreageLessThanOrEqualTo(Integer value) {
            addCriterion("acreage <=", value, "acreage");
            return (Criteria) this;
        }

        public Criteria andAcreageIn(List<Integer> values) {
            addCriterion("acreage in", values, "acreage");
            return (Criteria) this;
        }

        public Criteria andAcreageNotIn(List<Integer> values) {
            addCriterion("acreage not in", values, "acreage");
            return (Criteria) this;
        }

        public Criteria andAcreageBetween(Integer value1, Integer value2) {
            addCriterion("acreage between", value1, value2, "acreage");
            return (Criteria) this;
        }

        public Criteria andAcreageNotBetween(Integer value1, Integer value2) {
            addCriterion("acreage not between", value1, value2, "acreage");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNull() {
            addCriterion("publish_date is null");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNotNull() {
            addCriterion("publish_date is not null");
            return (Criteria) this;
        }

        public Criteria andPublishDateEqualTo(String value) {
            addCriterion("publish_date =", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotEqualTo(String value) {
            addCriterion("publish_date <>", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThan(String value) {
            addCriterion("publish_date >", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThanOrEqualTo(String value) {
            addCriterion("publish_date >=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThan(String value) {
            addCriterion("publish_date <", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThanOrEqualTo(String value) {
            addCriterion("publish_date <=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLike(String value) {
            addCriterion("publish_date like", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotLike(String value) {
            addCriterion("publish_date not like", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateIn(List<String> values) {
            addCriterion("publish_date in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotIn(List<String> values) {
            addCriterion("publish_date not in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateBetween(String value1, String value2) {
            addCriterion("publish_date between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotBetween(String value1, String value2) {
            addCriterion("publish_date not between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andFitmentIsNull() {
            addCriterion("fitment is null");
            return (Criteria) this;
        }

        public Criteria andFitmentIsNotNull() {
            addCriterion("fitment is not null");
            return (Criteria) this;
        }

        public Criteria andFitmentEqualTo(String value) {
            addCriterion("fitment =", value, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentNotEqualTo(String value) {
            addCriterion("fitment <>", value, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentGreaterThan(String value) {
            addCriterion("fitment >", value, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentGreaterThanOrEqualTo(String value) {
            addCriterion("fitment >=", value, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentLessThan(String value) {
            addCriterion("fitment <", value, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentLessThanOrEqualTo(String value) {
            addCriterion("fitment <=", value, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentLike(String value) {
            addCriterion("fitment like", value, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentNotLike(String value) {
            addCriterion("fitment not like", value, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentIn(List<String> values) {
            addCriterion("fitment in", values, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentNotIn(List<String> values) {
            addCriterion("fitment not in", values, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentBetween(String value1, String value2) {
            addCriterion("fitment between", value1, value2, "fitment");
            return (Criteria) this;
        }

        public Criteria andFitmentNotBetween(String value1, String value2) {
            addCriterion("fitment not between", value1, value2, "fitment");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNull() {
            addCriterion("payment_type is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNotNull() {
            addCriterion("payment_type is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeEqualTo(Integer value) {
            addCriterion("payment_type =", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotEqualTo(Integer value) {
            addCriterion("payment_type <>", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThan(Integer value) {
            addCriterion("payment_type >", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_type >=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThan(Integer value) {
            addCriterion("payment_type <", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("payment_type <=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIn(List<Integer> values) {
            addCriterion("payment_type in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotIn(List<Integer> values) {
            addCriterion("payment_type not in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeBetween(Integer value1, Integer value2) {
            addCriterion("payment_type between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_type not between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andBedIsNull() {
            addCriterion("bed is null");
            return (Criteria) this;
        }

        public Criteria andBedIsNotNull() {
            addCriterion("bed is not null");
            return (Criteria) this;
        }

        public Criteria andBedEqualTo(Integer value) {
            addCriterion("bed =", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedNotEqualTo(Integer value) {
            addCriterion("bed <>", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedGreaterThan(Integer value) {
            addCriterion("bed >", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedGreaterThanOrEqualTo(Integer value) {
            addCriterion("bed >=", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedLessThan(Integer value) {
            addCriterion("bed <", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedLessThanOrEqualTo(Integer value) {
            addCriterion("bed <=", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedIn(List<Integer> values) {
            addCriterion("bed in", values, "bed");
            return (Criteria) this;
        }

        public Criteria andBedNotIn(List<Integer> values) {
            addCriterion("bed not in", values, "bed");
            return (Criteria) this;
        }

        public Criteria andBedBetween(Integer value1, Integer value2) {
            addCriterion("bed between", value1, value2, "bed");
            return (Criteria) this;
        }

        public Criteria andBedNotBetween(Integer value1, Integer value2) {
            addCriterion("bed not between", value1, value2, "bed");
            return (Criteria) this;
        }

        public Criteria andWashingMachineIsNull() {
            addCriterion("washing_machine is null");
            return (Criteria) this;
        }

        public Criteria andWashingMachineIsNotNull() {
            addCriterion("washing_machine is not null");
            return (Criteria) this;
        }

        public Criteria andWashingMachineEqualTo(Integer value) {
            addCriterion("washing_machine =", value, "washingMachine");
            return (Criteria) this;
        }

        public Criteria andWashingMachineNotEqualTo(Integer value) {
            addCriterion("washing_machine <>", value, "washingMachine");
            return (Criteria) this;
        }

        public Criteria andWashingMachineGreaterThan(Integer value) {
            addCriterion("washing_machine >", value, "washingMachine");
            return (Criteria) this;
        }

        public Criteria andWashingMachineGreaterThanOrEqualTo(Integer value) {
            addCriterion("washing_machine >=", value, "washingMachine");
            return (Criteria) this;
        }

        public Criteria andWashingMachineLessThan(Integer value) {
            addCriterion("washing_machine <", value, "washingMachine");
            return (Criteria) this;
        }

        public Criteria andWashingMachineLessThanOrEqualTo(Integer value) {
            addCriterion("washing_machine <=", value, "washingMachine");
            return (Criteria) this;
        }

        public Criteria andWashingMachineIn(List<Integer> values) {
            addCriterion("washing_machine in", values, "washingMachine");
            return (Criteria) this;
        }

        public Criteria andWashingMachineNotIn(List<Integer> values) {
            addCriterion("washing_machine not in", values, "washingMachine");
            return (Criteria) this;
        }

        public Criteria andWashingMachineBetween(Integer value1, Integer value2) {
            addCriterion("washing_machine between", value1, value2, "washingMachine");
            return (Criteria) this;
        }

        public Criteria andWashingMachineNotBetween(Integer value1, Integer value2) {
            addCriterion("washing_machine not between", value1, value2, "washingMachine");
            return (Criteria) this;
        }

        public Criteria andRefrigeratorIsNull() {
            addCriterion("refrigerator is null");
            return (Criteria) this;
        }

        public Criteria andRefrigeratorIsNotNull() {
            addCriterion("refrigerator is not null");
            return (Criteria) this;
        }

        public Criteria andRefrigeratorEqualTo(Integer value) {
            addCriterion("refrigerator =", value, "refrigerator");
            return (Criteria) this;
        }

        public Criteria andRefrigeratorNotEqualTo(Integer value) {
            addCriterion("refrigerator <>", value, "refrigerator");
            return (Criteria) this;
        }

        public Criteria andRefrigeratorGreaterThan(Integer value) {
            addCriterion("refrigerator >", value, "refrigerator");
            return (Criteria) this;
        }

        public Criteria andRefrigeratorGreaterThanOrEqualTo(Integer value) {
            addCriterion("refrigerator >=", value, "refrigerator");
            return (Criteria) this;
        }

        public Criteria andRefrigeratorLessThan(Integer value) {
            addCriterion("refrigerator <", value, "refrigerator");
            return (Criteria) this;
        }

        public Criteria andRefrigeratorLessThanOrEqualTo(Integer value) {
            addCriterion("refrigerator <=", value, "refrigerator");
            return (Criteria) this;
        }

        public Criteria andRefrigeratorIn(List<Integer> values) {
            addCriterion("refrigerator in", values, "refrigerator");
            return (Criteria) this;
        }

        public Criteria andRefrigeratorNotIn(List<Integer> values) {
            addCriterion("refrigerator not in", values, "refrigerator");
            return (Criteria) this;
        }

        public Criteria andRefrigeratorBetween(Integer value1, Integer value2) {
            addCriterion("refrigerator between", value1, value2, "refrigerator");
            return (Criteria) this;
        }

        public Criteria andRefrigeratorNotBetween(Integer value1, Integer value2) {
            addCriterion("refrigerator not between", value1, value2, "refrigerator");
            return (Criteria) this;
        }

        public Criteria andAirConditionerIsNull() {
            addCriterion("air_conditioner is null");
            return (Criteria) this;
        }

        public Criteria andAirConditionerIsNotNull() {
            addCriterion("air_conditioner is not null");
            return (Criteria) this;
        }

        public Criteria andAirConditionerEqualTo(Integer value) {
            addCriterion("air_conditioner =", value, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNotEqualTo(Integer value) {
            addCriterion("air_conditioner <>", value, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerGreaterThan(Integer value) {
            addCriterion("air_conditioner >", value, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerGreaterThanOrEqualTo(Integer value) {
            addCriterion("air_conditioner >=", value, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerLessThan(Integer value) {
            addCriterion("air_conditioner <", value, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerLessThanOrEqualTo(Integer value) {
            addCriterion("air_conditioner <=", value, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerIn(List<Integer> values) {
            addCriterion("air_conditioner in", values, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNotIn(List<Integer> values) {
            addCriterion("air_conditioner not in", values, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerBetween(Integer value1, Integer value2) {
            addCriterion("air_conditioner between", value1, value2, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNotBetween(Integer value1, Integer value2) {
            addCriterion("air_conditioner not between", value1, value2, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andWifiIsNull() {
            addCriterion("wifi is null");
            return (Criteria) this;
        }

        public Criteria andWifiIsNotNull() {
            addCriterion("wifi is not null");
            return (Criteria) this;
        }

        public Criteria andWifiEqualTo(Integer value) {
            addCriterion("wifi =", value, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiNotEqualTo(Integer value) {
            addCriterion("wifi <>", value, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiGreaterThan(Integer value) {
            addCriterion("wifi >", value, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiGreaterThanOrEqualTo(Integer value) {
            addCriterion("wifi >=", value, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiLessThan(Integer value) {
            addCriterion("wifi <", value, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiLessThanOrEqualTo(Integer value) {
            addCriterion("wifi <=", value, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiIn(List<Integer> values) {
            addCriterion("wifi in", values, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiNotIn(List<Integer> values) {
            addCriterion("wifi not in", values, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiBetween(Integer value1, Integer value2) {
            addCriterion("wifi between", value1, value2, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiNotBetween(Integer value1, Integer value2) {
            addCriterion("wifi not between", value1, value2, "wifi");
            return (Criteria) this;
        }

        public Criteria andSofaIsNull() {
            addCriterion("sofa is null");
            return (Criteria) this;
        }

        public Criteria andSofaIsNotNull() {
            addCriterion("sofa is not null");
            return (Criteria) this;
        }

        public Criteria andSofaEqualTo(Integer value) {
            addCriterion("sofa =", value, "sofa");
            return (Criteria) this;
        }

        public Criteria andSofaNotEqualTo(Integer value) {
            addCriterion("sofa <>", value, "sofa");
            return (Criteria) this;
        }

        public Criteria andSofaGreaterThan(Integer value) {
            addCriterion("sofa >", value, "sofa");
            return (Criteria) this;
        }

        public Criteria andSofaGreaterThanOrEqualTo(Integer value) {
            addCriterion("sofa >=", value, "sofa");
            return (Criteria) this;
        }

        public Criteria andSofaLessThan(Integer value) {
            addCriterion("sofa <", value, "sofa");
            return (Criteria) this;
        }

        public Criteria andSofaLessThanOrEqualTo(Integer value) {
            addCriterion("sofa <=", value, "sofa");
            return (Criteria) this;
        }

        public Criteria andSofaIn(List<Integer> values) {
            addCriterion("sofa in", values, "sofa");
            return (Criteria) this;
        }

        public Criteria andSofaNotIn(List<Integer> values) {
            addCriterion("sofa not in", values, "sofa");
            return (Criteria) this;
        }

        public Criteria andSofaBetween(Integer value1, Integer value2) {
            addCriterion("sofa between", value1, value2, "sofa");
            return (Criteria) this;
        }

        public Criteria andSofaNotBetween(Integer value1, Integer value2) {
            addCriterion("sofa not between", value1, value2, "sofa");
            return (Criteria) this;
        }

        public Criteria andTableChairIsNull() {
            addCriterion("table_chair is null");
            return (Criteria) this;
        }

        public Criteria andTableChairIsNotNull() {
            addCriterion("table_chair is not null");
            return (Criteria) this;
        }

        public Criteria andTableChairEqualTo(Integer value) {
            addCriterion("table_chair =", value, "tableChair");
            return (Criteria) this;
        }

        public Criteria andTableChairNotEqualTo(Integer value) {
            addCriterion("table_chair <>", value, "tableChair");
            return (Criteria) this;
        }

        public Criteria andTableChairGreaterThan(Integer value) {
            addCriterion("table_chair >", value, "tableChair");
            return (Criteria) this;
        }

        public Criteria andTableChairGreaterThanOrEqualTo(Integer value) {
            addCriterion("table_chair >=", value, "tableChair");
            return (Criteria) this;
        }

        public Criteria andTableChairLessThan(Integer value) {
            addCriterion("table_chair <", value, "tableChair");
            return (Criteria) this;
        }

        public Criteria andTableChairLessThanOrEqualTo(Integer value) {
            addCriterion("table_chair <=", value, "tableChair");
            return (Criteria) this;
        }

        public Criteria andTableChairIn(List<Integer> values) {
            addCriterion("table_chair in", values, "tableChair");
            return (Criteria) this;
        }

        public Criteria andTableChairNotIn(List<Integer> values) {
            addCriterion("table_chair not in", values, "tableChair");
            return (Criteria) this;
        }

        public Criteria andTableChairBetween(Integer value1, Integer value2) {
            addCriterion("table_chair between", value1, value2, "tableChair");
            return (Criteria) this;
        }

        public Criteria andTableChairNotBetween(Integer value1, Integer value2) {
            addCriterion("table_chair not between", value1, value2, "tableChair");
            return (Criteria) this;
        }

        public Criteria andTvIsNull() {
            addCriterion("tv is null");
            return (Criteria) this;
        }

        public Criteria andTvIsNotNull() {
            addCriterion("tv is not null");
            return (Criteria) this;
        }

        public Criteria andTvEqualTo(Integer value) {
            addCriterion("tv =", value, "tv");
            return (Criteria) this;
        }

        public Criteria andTvNotEqualTo(Integer value) {
            addCriterion("tv <>", value, "tv");
            return (Criteria) this;
        }

        public Criteria andTvGreaterThan(Integer value) {
            addCriterion("tv >", value, "tv");
            return (Criteria) this;
        }

        public Criteria andTvGreaterThanOrEqualTo(Integer value) {
            addCriterion("tv >=", value, "tv");
            return (Criteria) this;
        }

        public Criteria andTvLessThan(Integer value) {
            addCriterion("tv <", value, "tv");
            return (Criteria) this;
        }

        public Criteria andTvLessThanOrEqualTo(Integer value) {
            addCriterion("tv <=", value, "tv");
            return (Criteria) this;
        }

        public Criteria andTvIn(List<Integer> values) {
            addCriterion("tv in", values, "tv");
            return (Criteria) this;
        }

        public Criteria andTvNotIn(List<Integer> values) {
            addCriterion("tv not in", values, "tv");
            return (Criteria) this;
        }

        public Criteria andTvBetween(Integer value1, Integer value2) {
            addCriterion("tv between", value1, value2, "tv");
            return (Criteria) this;
        }

        public Criteria andTvNotBetween(Integer value1, Integer value2) {
            addCriterion("tv not between", value1, value2, "tv");
            return (Criteria) this;
        }

        public Criteria andWaterHeaterIsNull() {
            addCriterion("water_heater is null");
            return (Criteria) this;
        }

        public Criteria andWaterHeaterIsNotNull() {
            addCriterion("water_heater is not null");
            return (Criteria) this;
        }

        public Criteria andWaterHeaterEqualTo(Integer value) {
            addCriterion("water_heater =", value, "waterHeater");
            return (Criteria) this;
        }

        public Criteria andWaterHeaterNotEqualTo(Integer value) {
            addCriterion("water_heater <>", value, "waterHeater");
            return (Criteria) this;
        }

        public Criteria andWaterHeaterGreaterThan(Integer value) {
            addCriterion("water_heater >", value, "waterHeater");
            return (Criteria) this;
        }

        public Criteria andWaterHeaterGreaterThanOrEqualTo(Integer value) {
            addCriterion("water_heater >=", value, "waterHeater");
            return (Criteria) this;
        }

        public Criteria andWaterHeaterLessThan(Integer value) {
            addCriterion("water_heater <", value, "waterHeater");
            return (Criteria) this;
        }

        public Criteria andWaterHeaterLessThanOrEqualTo(Integer value) {
            addCriterion("water_heater <=", value, "waterHeater");
            return (Criteria) this;
        }

        public Criteria andWaterHeaterIn(List<Integer> values) {
            addCriterion("water_heater in", values, "waterHeater");
            return (Criteria) this;
        }

        public Criteria andWaterHeaterNotIn(List<Integer> values) {
            addCriterion("water_heater not in", values, "waterHeater");
            return (Criteria) this;
        }

        public Criteria andWaterHeaterBetween(Integer value1, Integer value2) {
            addCriterion("water_heater between", value1, value2, "waterHeater");
            return (Criteria) this;
        }

        public Criteria andWaterHeaterNotBetween(Integer value1, Integer value2) {
            addCriterion("water_heater not between", value1, value2, "waterHeater");
            return (Criteria) this;
        }

        public Criteria andCookIsNull() {
            addCriterion("cook is null");
            return (Criteria) this;
        }

        public Criteria andCookIsNotNull() {
            addCriterion("cook is not null");
            return (Criteria) this;
        }

        public Criteria andCookEqualTo(Integer value) {
            addCriterion("cook =", value, "cook");
            return (Criteria) this;
        }

        public Criteria andCookNotEqualTo(Integer value) {
            addCriterion("cook <>", value, "cook");
            return (Criteria) this;
        }

        public Criteria andCookGreaterThan(Integer value) {
            addCriterion("cook >", value, "cook");
            return (Criteria) this;
        }

        public Criteria andCookGreaterThanOrEqualTo(Integer value) {
            addCriterion("cook >=", value, "cook");
            return (Criteria) this;
        }

        public Criteria andCookLessThan(Integer value) {
            addCriterion("cook <", value, "cook");
            return (Criteria) this;
        }

        public Criteria andCookLessThanOrEqualTo(Integer value) {
            addCriterion("cook <=", value, "cook");
            return (Criteria) this;
        }

        public Criteria andCookIn(List<Integer> values) {
            addCriterion("cook in", values, "cook");
            return (Criteria) this;
        }

        public Criteria andCookNotIn(List<Integer> values) {
            addCriterion("cook not in", values, "cook");
            return (Criteria) this;
        }

        public Criteria andCookBetween(Integer value1, Integer value2) {
            addCriterion("cook between", value1, value2, "cook");
            return (Criteria) this;
        }

        public Criteria andCookNotBetween(Integer value1, Integer value2) {
            addCriterion("cook not between", value1, value2, "cook");
            return (Criteria) this;
        }

        public Criteria andHeatingIsNull() {
            addCriterion("heating is null");
            return (Criteria) this;
        }

        public Criteria andHeatingIsNotNull() {
            addCriterion("heating is not null");
            return (Criteria) this;
        }

        public Criteria andHeatingEqualTo(Integer value) {
            addCriterion("heating =", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingNotEqualTo(Integer value) {
            addCriterion("heating <>", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingGreaterThan(Integer value) {
            addCriterion("heating >", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingGreaterThanOrEqualTo(Integer value) {
            addCriterion("heating >=", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingLessThan(Integer value) {
            addCriterion("heating <", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingLessThanOrEqualTo(Integer value) {
            addCriterion("heating <=", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingIn(List<Integer> values) {
            addCriterion("heating in", values, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingNotIn(List<Integer> values) {
            addCriterion("heating not in", values, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingBetween(Integer value1, Integer value2) {
            addCriterion("heating between", value1, value2, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingNotBetween(Integer value1, Integer value2) {
            addCriterion("heating not between", value1, value2, "heating");
            return (Criteria) this;
        }

        public Criteria andBalconyIsNull() {
            addCriterion("balcony is null");
            return (Criteria) this;
        }

        public Criteria andBalconyIsNotNull() {
            addCriterion("balcony is not null");
            return (Criteria) this;
        }

        public Criteria andBalconyEqualTo(Integer value) {
            addCriterion("balcony =", value, "balcony");
            return (Criteria) this;
        }

        public Criteria andBalconyNotEqualTo(Integer value) {
            addCriterion("balcony <>", value, "balcony");
            return (Criteria) this;
        }

        public Criteria andBalconyGreaterThan(Integer value) {
            addCriterion("balcony >", value, "balcony");
            return (Criteria) this;
        }

        public Criteria andBalconyGreaterThanOrEqualTo(Integer value) {
            addCriterion("balcony >=", value, "balcony");
            return (Criteria) this;
        }

        public Criteria andBalconyLessThan(Integer value) {
            addCriterion("balcony <", value, "balcony");
            return (Criteria) this;
        }

        public Criteria andBalconyLessThanOrEqualTo(Integer value) {
            addCriterion("balcony <=", value, "balcony");
            return (Criteria) this;
        }

        public Criteria andBalconyIn(List<Integer> values) {
            addCriterion("balcony in", values, "balcony");
            return (Criteria) this;
        }

        public Criteria andBalconyNotIn(List<Integer> values) {
            addCriterion("balcony not in", values, "balcony");
            return (Criteria) this;
        }

        public Criteria andBalconyBetween(Integer value1, Integer value2) {
            addCriterion("balcony between", value1, value2, "balcony");
            return (Criteria) this;
        }

        public Criteria andBalconyNotBetween(Integer value1, Integer value2) {
            addCriterion("balcony not between", value1, value2, "balcony");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andPublisherIsNull() {
            addCriterion("publisher is null");
            return (Criteria) this;
        }

        public Criteria andPublisherIsNotNull() {
            addCriterion("publisher is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherEqualTo(String value) {
            addCriterion("publisher =", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotEqualTo(String value) {
            addCriterion("publisher <>", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherGreaterThan(String value) {
            addCriterion("publisher >", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherGreaterThanOrEqualTo(String value) {
            addCriterion("publisher >=", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLessThan(String value) {
            addCriterion("publisher <", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLessThanOrEqualTo(String value) {
            addCriterion("publisher <=", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLike(String value) {
            addCriterion("publisher like", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotLike(String value) {
            addCriterion("publisher not like", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherIn(List<String> values) {
            addCriterion("publisher in", values, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotIn(List<String> values) {
            addCriterion("publisher not in", values, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherBetween(String value1, String value2) {
            addCriterion("publisher between", value1, value2, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotBetween(String value1, String value2) {
            addCriterion("publisher not between", value1, value2, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNumberIsNull() {
            addCriterion("publisher_number is null");
            return (Criteria) this;
        }

        public Criteria andPublisherNumberIsNotNull() {
            addCriterion("publisher_number is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherNumberEqualTo(String value) {
            addCriterion("publisher_number =", value, "publisherNumber");
            return (Criteria) this;
        }

        public Criteria andPublisherNumberNotEqualTo(String value) {
            addCriterion("publisher_number <>", value, "publisherNumber");
            return (Criteria) this;
        }

        public Criteria andPublisherNumberGreaterThan(String value) {
            addCriterion("publisher_number >", value, "publisherNumber");
            return (Criteria) this;
        }

        public Criteria andPublisherNumberGreaterThanOrEqualTo(String value) {
            addCriterion("publisher_number >=", value, "publisherNumber");
            return (Criteria) this;
        }

        public Criteria andPublisherNumberLessThan(String value) {
            addCriterion("publisher_number <", value, "publisherNumber");
            return (Criteria) this;
        }

        public Criteria andPublisherNumberLessThanOrEqualTo(String value) {
            addCriterion("publisher_number <=", value, "publisherNumber");
            return (Criteria) this;
        }

        public Criteria andPublisherNumberLike(String value) {
            addCriterion("publisher_number like", value, "publisherNumber");
            return (Criteria) this;
        }

        public Criteria andPublisherNumberNotLike(String value) {
            addCriterion("publisher_number not like", value, "publisherNumber");
            return (Criteria) this;
        }

        public Criteria andPublisherNumberIn(List<String> values) {
            addCriterion("publisher_number in", values, "publisherNumber");
            return (Criteria) this;
        }

        public Criteria andPublisherNumberNotIn(List<String> values) {
            addCriterion("publisher_number not in", values, "publisherNumber");
            return (Criteria) this;
        }

        public Criteria andPublisherNumberBetween(String value1, String value2) {
            addCriterion("publisher_number between", value1, value2, "publisherNumber");
            return (Criteria) this;
        }

        public Criteria andPublisherNumberNotBetween(String value1, String value2) {
            addCriterion("publisher_number not between", value1, value2, "publisherNumber");
            return (Criteria) this;
        }

        public Criteria andTagIdIsNull() {
            addCriterion("tag_id is null");
            return (Criteria) this;
        }

        public Criteria andTagIdIsNotNull() {
            addCriterion("tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andTagIdEqualTo(Long value) {
            addCriterion("tag_id =", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotEqualTo(Long value) {
            addCriterion("tag_id <>", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdGreaterThan(Long value) {
            addCriterion("tag_id >", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tag_id >=", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLessThan(Long value) {
            addCriterion("tag_id <", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLessThanOrEqualTo(Long value) {
            addCriterion("tag_id <=", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdIn(List<Long> values) {
            addCriterion("tag_id in", values, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotIn(List<Long> values) {
            addCriterion("tag_id not in", values, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdBetween(Long value1, Long value2) {
            addCriterion("tag_id between", value1, value2, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotBetween(Long value1, Long value2) {
            addCriterion("tag_id not between", value1, value2, "tagId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdIsNull() {
            addCriterion("publisher_id is null");
            return (Criteria) this;
        }

        public Criteria andPublisherIdIsNotNull() {
            addCriterion("publisher_id is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherIdEqualTo(Long value) {
            addCriterion("publisher_id =", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotEqualTo(Long value) {
            addCriterion("publisher_id <>", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdGreaterThan(Long value) {
            addCriterion("publisher_id >", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdGreaterThanOrEqualTo(Long value) {
            addCriterion("publisher_id >=", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdLessThan(Long value) {
            addCriterion("publisher_id <", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdLessThanOrEqualTo(Long value) {
            addCriterion("publisher_id <=", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdIn(List<Long> values) {
            addCriterion("publisher_id in", values, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotIn(List<Long> values) {
            addCriterion("publisher_id not in", values, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdBetween(Long value1, Long value2) {
            addCriterion("publisher_id between", value1, value2, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotBetween(Long value1, Long value2) {
            addCriterion("publisher_id not between", value1, value2, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherTypeIsNull() {
            addCriterion("publisher_type is null");
            return (Criteria) this;
        }

        public Criteria andPublisherTypeIsNotNull() {
            addCriterion("publisher_type is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherTypeEqualTo(String value) {
            addCriterion("publisher_type =", value, "publisherType");
            return (Criteria) this;
        }

        public Criteria andPublisherTypeNotEqualTo(String value) {
            addCriterion("publisher_type <>", value, "publisherType");
            return (Criteria) this;
        }

        public Criteria andPublisherTypeGreaterThan(String value) {
            addCriterion("publisher_type >", value, "publisherType");
            return (Criteria) this;
        }

        public Criteria andPublisherTypeGreaterThanOrEqualTo(String value) {
            addCriterion("publisher_type >=", value, "publisherType");
            return (Criteria) this;
        }

        public Criteria andPublisherTypeLessThan(String value) {
            addCriterion("publisher_type <", value, "publisherType");
            return (Criteria) this;
        }

        public Criteria andPublisherTypeLessThanOrEqualTo(String value) {
            addCriterion("publisher_type <=", value, "publisherType");
            return (Criteria) this;
        }

        public Criteria andPublisherTypeLike(String value) {
            addCriterion("publisher_type like", value, "publisherType");
            return (Criteria) this;
        }

        public Criteria andPublisherTypeNotLike(String value) {
            addCriterion("publisher_type not like", value, "publisherType");
            return (Criteria) this;
        }

        public Criteria andPublisherTypeIn(List<String> values) {
            addCriterion("publisher_type in", values, "publisherType");
            return (Criteria) this;
        }

        public Criteria andPublisherTypeNotIn(List<String> values) {
            addCriterion("publisher_type not in", values, "publisherType");
            return (Criteria) this;
        }

        public Criteria andPublisherTypeBetween(String value1, String value2) {
            addCriterion("publisher_type between", value1, value2, "publisherType");
            return (Criteria) this;
        }

        public Criteria andPublisherTypeNotBetween(String value1, String value2) {
            addCriterion("publisher_type not between", value1, value2, "publisherType");
            return (Criteria) this;
        }

        public Criteria andPublisherHeadIsNull() {
            addCriterion("publisher_head is null");
            return (Criteria) this;
        }

        public Criteria andPublisherHeadIsNotNull() {
            addCriterion("publisher_head is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherHeadEqualTo(String value) {
            addCriterion("publisher_head =", value, "publisherHead");
            return (Criteria) this;
        }

        public Criteria andPublisherHeadNotEqualTo(String value) {
            addCriterion("publisher_head <>", value, "publisherHead");
            return (Criteria) this;
        }

        public Criteria andPublisherHeadGreaterThan(String value) {
            addCriterion("publisher_head >", value, "publisherHead");
            return (Criteria) this;
        }

        public Criteria andPublisherHeadGreaterThanOrEqualTo(String value) {
            addCriterion("publisher_head >=", value, "publisherHead");
            return (Criteria) this;
        }

        public Criteria andPublisherHeadLessThan(String value) {
            addCriterion("publisher_head <", value, "publisherHead");
            return (Criteria) this;
        }

        public Criteria andPublisherHeadLessThanOrEqualTo(String value) {
            addCriterion("publisher_head <=", value, "publisherHead");
            return (Criteria) this;
        }

        public Criteria andPublisherHeadLike(String value) {
            addCriterion("publisher_head like", value, "publisherHead");
            return (Criteria) this;
        }

        public Criteria andPublisherHeadNotLike(String value) {
            addCriterion("publisher_head not like", value, "publisherHead");
            return (Criteria) this;
        }

        public Criteria andPublisherHeadIn(List<String> values) {
            addCriterion("publisher_head in", values, "publisherHead");
            return (Criteria) this;
        }

        public Criteria andPublisherHeadNotIn(List<String> values) {
            addCriterion("publisher_head not in", values, "publisherHead");
            return (Criteria) this;
        }

        public Criteria andPublisherHeadBetween(String value1, String value2) {
            addCriterion("publisher_head between", value1, value2, "publisherHead");
            return (Criteria) this;
        }

        public Criteria andPublisherHeadNotBetween(String value1, String value2) {
            addCriterion("publisher_head not between", value1, value2, "publisherHead");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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