package com.chk.pdms.pd.domain;

import java.util.ArrayList;
import java.util.List;

public class PdInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PdInfoExample() {
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

        public Criteria andPdModelIdIsNull() {
            addCriterion("pd_model_id is null");
            return (Criteria) this;
        }

        public Criteria andPdModelIdIsNotNull() {
            addCriterion("pd_model_id is not null");
            return (Criteria) this;
        }

        public Criteria andPdModelIdEqualTo(Long value) {
            addCriterion("pd_model_id =", value, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andPdModelIdNotEqualTo(Long value) {
            addCriterion("pd_model_id <>", value, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andPdModelIdGreaterThan(Long value) {
            addCriterion("pd_model_id >", value, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andPdModelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pd_model_id >=", value, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andPdModelIdLessThan(Long value) {
            addCriterion("pd_model_id <", value, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andPdModelIdLessThanOrEqualTo(Long value) {
            addCriterion("pd_model_id <=", value, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andPdModelIdIn(List<Long> values) {
            addCriterion("pd_model_id in", values, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andPdModelIdNotIn(List<Long> values) {
            addCriterion("pd_model_id not in", values, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andPdModelIdBetween(Long value1, Long value2) {
            addCriterion("pd_model_id between", value1, value2, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andPdModelIdNotBetween(Long value1, Long value2) {
            addCriterion("pd_model_id not between", value1, value2, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andStdIsNull() {
            addCriterion("std is null");
            return (Criteria) this;
        }

        public Criteria andStdIsNotNull() {
            addCriterion("std is not null");
            return (Criteria) this;
        }

        public Criteria andStdEqualTo(String value) {
            addCriterion("std =", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdNotEqualTo(String value) {
            addCriterion("std <>", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdGreaterThan(String value) {
            addCriterion("std >", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdGreaterThanOrEqualTo(String value) {
            addCriterion("std >=", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdLessThan(String value) {
            addCriterion("std <", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdLessThanOrEqualTo(String value) {
            addCriterion("std <=", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdLike(String value) {
            addCriterion("std like", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdNotLike(String value) {
            addCriterion("std not like", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdIn(List<String> values) {
            addCriterion("std in", values, "std");
            return (Criteria) this;
        }

        public Criteria andStdNotIn(List<String> values) {
            addCriterion("std not in", values, "std");
            return (Criteria) this;
        }

        public Criteria andStdBetween(String value1, String value2) {
            addCriterion("std between", value1, value2, "std");
            return (Criteria) this;
        }

        public Criteria andStdNotBetween(String value1, String value2) {
            addCriterion("std not between", value1, value2, "std");
            return (Criteria) this;
        }

        public Criteria andQualityIsNull() {
            addCriterion("quality is null");
            return (Criteria) this;
        }

        public Criteria andQualityIsNotNull() {
            addCriterion("quality is not null");
            return (Criteria) this;
        }

        public Criteria andQualityEqualTo(String value) {
            addCriterion("quality =", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotEqualTo(String value) {
            addCriterion("quality <>", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThan(String value) {
            addCriterion("quality >", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThanOrEqualTo(String value) {
            addCriterion("quality >=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThan(String value) {
            addCriterion("quality <", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThanOrEqualTo(String value) {
            addCriterion("quality <=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLike(String value) {
            addCriterion("quality like", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotLike(String value) {
            addCriterion("quality not like", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityIn(List<String> values) {
            addCriterion("quality in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotIn(List<String> values) {
            addCriterion("quality not in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityBetween(String value1, String value2) {
            addCriterion("quality between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotBetween(String value1, String value2) {
            addCriterion("quality not between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(String value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(String value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(String value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(String value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(String value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(String value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLike(String value) {
            addCriterion("size like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotLike(String value) {
            addCriterion("size not like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<String> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<String> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(String value1, String value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(String value1, String value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNull() {
            addCriterion("temperature is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNotNull() {
            addCriterion("temperature is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureEqualTo(String value) {
            addCriterion("temperature =", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotEqualTo(String value) {
            addCriterion("temperature <>", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThan(String value) {
            addCriterion("temperature >", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThanOrEqualTo(String value) {
            addCriterion("temperature >=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThan(String value) {
            addCriterion("temperature <", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThanOrEqualTo(String value) {
            addCriterion("temperature <=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLike(String value) {
            addCriterion("temperature like", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotLike(String value) {
            addCriterion("temperature not like", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureIn(List<String> values) {
            addCriterion("temperature in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotIn(List<String> values) {
            addCriterion("temperature not in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureBetween(String value1, String value2) {
            addCriterion("temperature between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotBetween(String value1, String value2) {
            addCriterion("temperature not between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andVoltageIsNull() {
            addCriterion("voltage is null");
            return (Criteria) this;
        }

        public Criteria andVoltageIsNotNull() {
            addCriterion("voltage is not null");
            return (Criteria) this;
        }

        public Criteria andVoltageEqualTo(String value) {
            addCriterion("voltage =", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotEqualTo(String value) {
            addCriterion("voltage <>", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageGreaterThan(String value) {
            addCriterion("voltage >", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageGreaterThanOrEqualTo(String value) {
            addCriterion("voltage >=", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageLessThan(String value) {
            addCriterion("voltage <", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageLessThanOrEqualTo(String value) {
            addCriterion("voltage <=", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageLike(String value) {
            addCriterion("voltage like", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotLike(String value) {
            addCriterion("voltage not like", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageIn(List<String> values) {
            addCriterion("voltage in", values, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotIn(List<String> values) {
            addCriterion("voltage not in", values, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageBetween(String value1, String value2) {
            addCriterion("voltage between", value1, value2, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotBetween(String value1, String value2) {
            addCriterion("voltage not between", value1, value2, "voltage");
            return (Criteria) this;
        }

        public Criteria andCapacityMinIsNull() {
            addCriterion("capacity_min is null");
            return (Criteria) this;
        }

        public Criteria andCapacityMinIsNotNull() {
            addCriterion("capacity_min is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityMinEqualTo(String value) {
            addCriterion("capacity_min =", value, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinNotEqualTo(String value) {
            addCriterion("capacity_min <>", value, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinGreaterThan(String value) {
            addCriterion("capacity_min >", value, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinGreaterThanOrEqualTo(String value) {
            addCriterion("capacity_min >=", value, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinLessThan(String value) {
            addCriterion("capacity_min <", value, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinLessThanOrEqualTo(String value) {
            addCriterion("capacity_min <=", value, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinLike(String value) {
            addCriterion("capacity_min like", value, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinNotLike(String value) {
            addCriterion("capacity_min not like", value, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinIn(List<String> values) {
            addCriterion("capacity_min in", values, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinNotIn(List<String> values) {
            addCriterion("capacity_min not in", values, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinBetween(String value1, String value2) {
            addCriterion("capacity_min between", value1, value2, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinNotBetween(String value1, String value2) {
            addCriterion("capacity_min not between", value1, value2, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxIsNull() {
            addCriterion("capacity_max is null");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxIsNotNull() {
            addCriterion("capacity_max is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxEqualTo(String value) {
            addCriterion("capacity_max =", value, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxNotEqualTo(String value) {
            addCriterion("capacity_max <>", value, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxGreaterThan(String value) {
            addCriterion("capacity_max >", value, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxGreaterThanOrEqualTo(String value) {
            addCriterion("capacity_max >=", value, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxLessThan(String value) {
            addCriterion("capacity_max <", value, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxLessThanOrEqualTo(String value) {
            addCriterion("capacity_max <=", value, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxLike(String value) {
            addCriterion("capacity_max like", value, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxNotLike(String value) {
            addCriterion("capacity_max not like", value, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxIn(List<String> values) {
            addCriterion("capacity_max in", values, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxNotIn(List<String> values) {
            addCriterion("capacity_max not in", values, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxBetween(String value1, String value2) {
            addCriterion("capacity_max between", value1, value2, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxNotBetween(String value1, String value2) {
            addCriterion("capacity_max not between", value1, value2, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMinIdxIsNull() {
            addCriterion("capacity_min_idx is null");
            return (Criteria) this;
        }

        public Criteria andCapacityMinIdxIsNotNull() {
            addCriterion("capacity_min_idx is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityMinIdxEqualTo(Integer value) {
            addCriterion("capacity_min_idx =", value, "capacityMinIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMinIdxNotEqualTo(Integer value) {
            addCriterion("capacity_min_idx <>", value, "capacityMinIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMinIdxGreaterThan(Integer value) {
            addCriterion("capacity_min_idx >", value, "capacityMinIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMinIdxGreaterThanOrEqualTo(Integer value) {
            addCriterion("capacity_min_idx >=", value, "capacityMinIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMinIdxLessThan(Integer value) {
            addCriterion("capacity_min_idx <", value, "capacityMinIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMinIdxLessThanOrEqualTo(Integer value) {
            addCriterion("capacity_min_idx <=", value, "capacityMinIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMinIdxIn(List<Integer> values) {
            addCriterion("capacity_min_idx in", values, "capacityMinIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMinIdxNotIn(List<Integer> values) {
            addCriterion("capacity_min_idx not in", values, "capacityMinIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMinIdxBetween(Integer value1, Integer value2) {
            addCriterion("capacity_min_idx between", value1, value2, "capacityMinIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMinIdxNotBetween(Integer value1, Integer value2) {
            addCriterion("capacity_min_idx not between", value1, value2, "capacityMinIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxIdxIsNull() {
            addCriterion("capacity_max_idx is null");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxIdxIsNotNull() {
            addCriterion("capacity_max_idx is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxIdxEqualTo(Integer value) {
            addCriterion("capacity_max_idx =", value, "capacityMaxIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxIdxNotEqualTo(Integer value) {
            addCriterion("capacity_max_idx <>", value, "capacityMaxIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxIdxGreaterThan(Integer value) {
            addCriterion("capacity_max_idx >", value, "capacityMaxIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxIdxGreaterThanOrEqualTo(Integer value) {
            addCriterion("capacity_max_idx >=", value, "capacityMaxIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxIdxLessThan(Integer value) {
            addCriterion("capacity_max_idx <", value, "capacityMaxIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxIdxLessThanOrEqualTo(Integer value) {
            addCriterion("capacity_max_idx <=", value, "capacityMaxIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxIdxIn(List<Integer> values) {
            addCriterion("capacity_max_idx in", values, "capacityMaxIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxIdxNotIn(List<Integer> values) {
            addCriterion("capacity_max_idx not in", values, "capacityMaxIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxIdxBetween(Integer value1, Integer value2) {
            addCriterion("capacity_max_idx between", value1, value2, "capacityMaxIdx");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxIdxNotBetween(Integer value1, Integer value2) {
            addCriterion("capacity_max_idx not between", value1, value2, "capacityMaxIdx");
            return (Criteria) this;
        }

        public Criteria andToleranceIsNull() {
            addCriterion("tolerance is null");
            return (Criteria) this;
        }

        public Criteria andToleranceIsNotNull() {
            addCriterion("tolerance is not null");
            return (Criteria) this;
        }

        public Criteria andToleranceEqualTo(String value) {
            addCriterion("tolerance =", value, "tolerance");
            return (Criteria) this;
        }

        public Criteria andToleranceNotEqualTo(String value) {
            addCriterion("tolerance <>", value, "tolerance");
            return (Criteria) this;
        }

        public Criteria andToleranceGreaterThan(String value) {
            addCriterion("tolerance >", value, "tolerance");
            return (Criteria) this;
        }

        public Criteria andToleranceGreaterThanOrEqualTo(String value) {
            addCriterion("tolerance >=", value, "tolerance");
            return (Criteria) this;
        }

        public Criteria andToleranceLessThan(String value) {
            addCriterion("tolerance <", value, "tolerance");
            return (Criteria) this;
        }

        public Criteria andToleranceLessThanOrEqualTo(String value) {
            addCriterion("tolerance <=", value, "tolerance");
            return (Criteria) this;
        }

        public Criteria andToleranceLike(String value) {
            addCriterion("tolerance like", value, "tolerance");
            return (Criteria) this;
        }

        public Criteria andToleranceNotLike(String value) {
            addCriterion("tolerance not like", value, "tolerance");
            return (Criteria) this;
        }

        public Criteria andToleranceIn(List<String> values) {
            addCriterion("tolerance in", values, "tolerance");
            return (Criteria) this;
        }

        public Criteria andToleranceNotIn(List<String> values) {
            addCriterion("tolerance not in", values, "tolerance");
            return (Criteria) this;
        }

        public Criteria andToleranceBetween(String value1, String value2) {
            addCriterion("tolerance between", value1, value2, "tolerance");
            return (Criteria) this;
        }

        public Criteria andToleranceNotBetween(String value1, String value2) {
            addCriterion("tolerance not between", value1, value2, "tolerance");
            return (Criteria) this;
        }

        public Criteria andOutletIsNull() {
            addCriterion("outlet is null");
            return (Criteria) this;
        }

        public Criteria andOutletIsNotNull() {
            addCriterion("outlet is not null");
            return (Criteria) this;
        }

        public Criteria andOutletEqualTo(String value) {
            addCriterion("outlet =", value, "outlet");
            return (Criteria) this;
        }

        public Criteria andOutletNotEqualTo(String value) {
            addCriterion("outlet <>", value, "outlet");
            return (Criteria) this;
        }

        public Criteria andOutletGreaterThan(String value) {
            addCriterion("outlet >", value, "outlet");
            return (Criteria) this;
        }

        public Criteria andOutletGreaterThanOrEqualTo(String value) {
            addCriterion("outlet >=", value, "outlet");
            return (Criteria) this;
        }

        public Criteria andOutletLessThan(String value) {
            addCriterion("outlet <", value, "outlet");
            return (Criteria) this;
        }

        public Criteria andOutletLessThanOrEqualTo(String value) {
            addCriterion("outlet <=", value, "outlet");
            return (Criteria) this;
        }

        public Criteria andOutletLike(String value) {
            addCriterion("outlet like", value, "outlet");
            return (Criteria) this;
        }

        public Criteria andOutletNotLike(String value) {
            addCriterion("outlet not like", value, "outlet");
            return (Criteria) this;
        }

        public Criteria andOutletIn(List<String> values) {
            addCriterion("outlet in", values, "outlet");
            return (Criteria) this;
        }

        public Criteria andOutletNotIn(List<String> values) {
            addCriterion("outlet not in", values, "outlet");
            return (Criteria) this;
        }

        public Criteria andOutletBetween(String value1, String value2) {
            addCriterion("outlet between", value1, value2, "outlet");
            return (Criteria) this;
        }

        public Criteria andOutletNotBetween(String value1, String value2) {
            addCriterion("outlet not between", value1, value2, "outlet");
            return (Criteria) this;
        }

        public Criteria andElecCodeIsNull() {
            addCriterion("elec_code is null");
            return (Criteria) this;
        }

        public Criteria andElecCodeIsNotNull() {
            addCriterion("elec_code is not null");
            return (Criteria) this;
        }

        public Criteria andElecCodeEqualTo(String value) {
            addCriterion("elec_code =", value, "elecCode");
            return (Criteria) this;
        }

        public Criteria andElecCodeNotEqualTo(String value) {
            addCriterion("elec_code <>", value, "elecCode");
            return (Criteria) this;
        }

        public Criteria andElecCodeGreaterThan(String value) {
            addCriterion("elec_code >", value, "elecCode");
            return (Criteria) this;
        }

        public Criteria andElecCodeGreaterThanOrEqualTo(String value) {
            addCriterion("elec_code >=", value, "elecCode");
            return (Criteria) this;
        }

        public Criteria andElecCodeLessThan(String value) {
            addCriterion("elec_code <", value, "elecCode");
            return (Criteria) this;
        }

        public Criteria andElecCodeLessThanOrEqualTo(String value) {
            addCriterion("elec_code <=", value, "elecCode");
            return (Criteria) this;
        }

        public Criteria andElecCodeLike(String value) {
            addCriterion("elec_code like", value, "elecCode");
            return (Criteria) this;
        }

        public Criteria andElecCodeNotLike(String value) {
            addCriterion("elec_code not like", value, "elecCode");
            return (Criteria) this;
        }

        public Criteria andElecCodeIn(List<String> values) {
            addCriterion("elec_code in", values, "elecCode");
            return (Criteria) this;
        }

        public Criteria andElecCodeNotIn(List<String> values) {
            addCriterion("elec_code not in", values, "elecCode");
            return (Criteria) this;
        }

        public Criteria andElecCodeBetween(String value1, String value2) {
            addCriterion("elec_code between", value1, value2, "elecCode");
            return (Criteria) this;
        }

        public Criteria andElecCodeNotBetween(String value1, String value2) {
            addCriterion("elec_code not between", value1, value2, "elecCode");
            return (Criteria) this;
        }

        public Criteria andCapNumIsNull() {
            addCriterion("cap_num is null");
            return (Criteria) this;
        }

        public Criteria andCapNumIsNotNull() {
            addCriterion("cap_num is not null");
            return (Criteria) this;
        }

        public Criteria andCapNumEqualTo(String value) {
            addCriterion("cap_num =", value, "capNum");
            return (Criteria) this;
        }

        public Criteria andCapNumNotEqualTo(String value) {
            addCriterion("cap_num <>", value, "capNum");
            return (Criteria) this;
        }

        public Criteria andCapNumGreaterThan(String value) {
            addCriterion("cap_num >", value, "capNum");
            return (Criteria) this;
        }

        public Criteria andCapNumGreaterThanOrEqualTo(String value) {
            addCriterion("cap_num >=", value, "capNum");
            return (Criteria) this;
        }

        public Criteria andCapNumLessThan(String value) {
            addCriterion("cap_num <", value, "capNum");
            return (Criteria) this;
        }

        public Criteria andCapNumLessThanOrEqualTo(String value) {
            addCriterion("cap_num <=", value, "capNum");
            return (Criteria) this;
        }

        public Criteria andCapNumLike(String value) {
            addCriterion("cap_num like", value, "capNum");
            return (Criteria) this;
        }

        public Criteria andCapNumNotLike(String value) {
            addCriterion("cap_num not like", value, "capNum");
            return (Criteria) this;
        }

        public Criteria andCapNumIn(List<String> values) {
            addCriterion("cap_num in", values, "capNum");
            return (Criteria) this;
        }

        public Criteria andCapNumNotIn(List<String> values) {
            addCriterion("cap_num not in", values, "capNum");
            return (Criteria) this;
        }

        public Criteria andCapNumBetween(String value1, String value2) {
            addCriterion("cap_num between", value1, value2, "capNum");
            return (Criteria) this;
        }

        public Criteria andCapNumNotBetween(String value1, String value2) {
            addCriterion("cap_num not between", value1, value2, "capNum");
            return (Criteria) this;
        }

        public Criteria andElecTypeIsNull() {
            addCriterion("elec_type is null");
            return (Criteria) this;
        }

        public Criteria andElecTypeIsNotNull() {
            addCriterion("elec_type is not null");
            return (Criteria) this;
        }

        public Criteria andElecTypeEqualTo(String value) {
            addCriterion("elec_type =", value, "elecType");
            return (Criteria) this;
        }

        public Criteria andElecTypeNotEqualTo(String value) {
            addCriterion("elec_type <>", value, "elecType");
            return (Criteria) this;
        }

        public Criteria andElecTypeGreaterThan(String value) {
            addCriterion("elec_type >", value, "elecType");
            return (Criteria) this;
        }

        public Criteria andElecTypeGreaterThanOrEqualTo(String value) {
            addCriterion("elec_type >=", value, "elecType");
            return (Criteria) this;
        }

        public Criteria andElecTypeLessThan(String value) {
            addCriterion("elec_type <", value, "elecType");
            return (Criteria) this;
        }

        public Criteria andElecTypeLessThanOrEqualTo(String value) {
            addCriterion("elec_type <=", value, "elecType");
            return (Criteria) this;
        }

        public Criteria andElecTypeLike(String value) {
            addCriterion("elec_type like", value, "elecType");
            return (Criteria) this;
        }

        public Criteria andElecTypeNotLike(String value) {
            addCriterion("elec_type not like", value, "elecType");
            return (Criteria) this;
        }

        public Criteria andElecTypeIn(List<String> values) {
            addCriterion("elec_type in", values, "elecType");
            return (Criteria) this;
        }

        public Criteria andElecTypeNotIn(List<String> values) {
            addCriterion("elec_type not in", values, "elecType");
            return (Criteria) this;
        }

        public Criteria andElecTypeBetween(String value1, String value2) {
            addCriterion("elec_type between", value1, value2, "elecType");
            return (Criteria) this;
        }

        public Criteria andElecTypeNotBetween(String value1, String value2) {
            addCriterion("elec_type not between", value1, value2, "elecType");
            return (Criteria) this;
        }

        public Criteria andTemperRangeIsNull() {
            addCriterion("temper_range is null");
            return (Criteria) this;
        }

        public Criteria andTemperRangeIsNotNull() {
            addCriterion("temper_range is not null");
            return (Criteria) this;
        }

        public Criteria andTemperRangeEqualTo(String value) {
            addCriterion("temper_range =", value, "temperRange");
            return (Criteria) this;
        }

        public Criteria andTemperRangeNotEqualTo(String value) {
            addCriterion("temper_range <>", value, "temperRange");
            return (Criteria) this;
        }

        public Criteria andTemperRangeGreaterThan(String value) {
            addCriterion("temper_range >", value, "temperRange");
            return (Criteria) this;
        }

        public Criteria andTemperRangeGreaterThanOrEqualTo(String value) {
            addCriterion("temper_range >=", value, "temperRange");
            return (Criteria) this;
        }

        public Criteria andTemperRangeLessThan(String value) {
            addCriterion("temper_range <", value, "temperRange");
            return (Criteria) this;
        }

        public Criteria andTemperRangeLessThanOrEqualTo(String value) {
            addCriterion("temper_range <=", value, "temperRange");
            return (Criteria) this;
        }

        public Criteria andTemperRangeLike(String value) {
            addCriterion("temper_range like", value, "temperRange");
            return (Criteria) this;
        }

        public Criteria andTemperRangeNotLike(String value) {
            addCriterion("temper_range not like", value, "temperRange");
            return (Criteria) this;
        }

        public Criteria andTemperRangeIn(List<String> values) {
            addCriterion("temper_range in", values, "temperRange");
            return (Criteria) this;
        }

        public Criteria andTemperRangeNotIn(List<String> values) {
            addCriterion("temper_range not in", values, "temperRange");
            return (Criteria) this;
        }

        public Criteria andTemperRangeBetween(String value1, String value2) {
            addCriterion("temper_range between", value1, value2, "temperRange");
            return (Criteria) this;
        }

        public Criteria andTemperRangeNotBetween(String value1, String value2) {
            addCriterion("temper_range not between", value1, value2, "temperRange");
            return (Criteria) this;
        }

        public Criteria andWireMaIsNull() {
            addCriterion("wire_ma is null");
            return (Criteria) this;
        }

        public Criteria andWireMaIsNotNull() {
            addCriterion("wire_ma is not null");
            return (Criteria) this;
        }

        public Criteria andWireMaEqualTo(String value) {
            addCriterion("wire_ma =", value, "wireMa");
            return (Criteria) this;
        }

        public Criteria andWireMaNotEqualTo(String value) {
            addCriterion("wire_ma <>", value, "wireMa");
            return (Criteria) this;
        }

        public Criteria andWireMaGreaterThan(String value) {
            addCriterion("wire_ma >", value, "wireMa");
            return (Criteria) this;
        }

        public Criteria andWireMaGreaterThanOrEqualTo(String value) {
            addCriterion("wire_ma >=", value, "wireMa");
            return (Criteria) this;
        }

        public Criteria andWireMaLessThan(String value) {
            addCriterion("wire_ma <", value, "wireMa");
            return (Criteria) this;
        }

        public Criteria andWireMaLessThanOrEqualTo(String value) {
            addCriterion("wire_ma <=", value, "wireMa");
            return (Criteria) this;
        }

        public Criteria andWireMaLike(String value) {
            addCriterion("wire_ma like", value, "wireMa");
            return (Criteria) this;
        }

        public Criteria andWireMaNotLike(String value) {
            addCriterion("wire_ma not like", value, "wireMa");
            return (Criteria) this;
        }

        public Criteria andWireMaIn(List<String> values) {
            addCriterion("wire_ma in", values, "wireMa");
            return (Criteria) this;
        }

        public Criteria andWireMaNotIn(List<String> values) {
            addCriterion("wire_ma not in", values, "wireMa");
            return (Criteria) this;
        }

        public Criteria andWireMaBetween(String value1, String value2) {
            addCriterion("wire_ma between", value1, value2, "wireMa");
            return (Criteria) this;
        }

        public Criteria andWireMaNotBetween(String value1, String value2) {
            addCriterion("wire_ma not between", value1, value2, "wireMa");
            return (Criteria) this;
        }

        public Criteria andWireSizeIsNull() {
            addCriterion("wire_size is null");
            return (Criteria) this;
        }

        public Criteria andWireSizeIsNotNull() {
            addCriterion("wire_size is not null");
            return (Criteria) this;
        }

        public Criteria andWireSizeEqualTo(String value) {
            addCriterion("wire_size =", value, "wireSize");
            return (Criteria) this;
        }

        public Criteria andWireSizeNotEqualTo(String value) {
            addCriterion("wire_size <>", value, "wireSize");
            return (Criteria) this;
        }

        public Criteria andWireSizeGreaterThan(String value) {
            addCriterion("wire_size >", value, "wireSize");
            return (Criteria) this;
        }

        public Criteria andWireSizeGreaterThanOrEqualTo(String value) {
            addCriterion("wire_size >=", value, "wireSize");
            return (Criteria) this;
        }

        public Criteria andWireSizeLessThan(String value) {
            addCriterion("wire_size <", value, "wireSize");
            return (Criteria) this;
        }

        public Criteria andWireSizeLessThanOrEqualTo(String value) {
            addCriterion("wire_size <=", value, "wireSize");
            return (Criteria) this;
        }

        public Criteria andWireSizeLike(String value) {
            addCriterion("wire_size like", value, "wireSize");
            return (Criteria) this;
        }

        public Criteria andWireSizeNotLike(String value) {
            addCriterion("wire_size not like", value, "wireSize");
            return (Criteria) this;
        }

        public Criteria andWireSizeIn(List<String> values) {
            addCriterion("wire_size in", values, "wireSize");
            return (Criteria) this;
        }

        public Criteria andWireSizeNotIn(List<String> values) {
            addCriterion("wire_size not in", values, "wireSize");
            return (Criteria) this;
        }

        public Criteria andWireSizeBetween(String value1, String value2) {
            addCriterion("wire_size between", value1, value2, "wireSize");
            return (Criteria) this;
        }

        public Criteria andWireSizeNotBetween(String value1, String value2) {
            addCriterion("wire_size not between", value1, value2, "wireSize");
            return (Criteria) this;
        }

        public Criteria andElecSerIsNull() {
            addCriterion("elec_ser is null");
            return (Criteria) this;
        }

        public Criteria andElecSerIsNotNull() {
            addCriterion("elec_ser is not null");
            return (Criteria) this;
        }

        public Criteria andElecSerEqualTo(String value) {
            addCriterion("elec_ser =", value, "elecSer");
            return (Criteria) this;
        }

        public Criteria andElecSerNotEqualTo(String value) {
            addCriterion("elec_ser <>", value, "elecSer");
            return (Criteria) this;
        }

        public Criteria andElecSerGreaterThan(String value) {
            addCriterion("elec_ser >", value, "elecSer");
            return (Criteria) this;
        }

        public Criteria andElecSerGreaterThanOrEqualTo(String value) {
            addCriterion("elec_ser >=", value, "elecSer");
            return (Criteria) this;
        }

        public Criteria andElecSerLessThan(String value) {
            addCriterion("elec_ser <", value, "elecSer");
            return (Criteria) this;
        }

        public Criteria andElecSerLessThanOrEqualTo(String value) {
            addCriterion("elec_ser <=", value, "elecSer");
            return (Criteria) this;
        }

        public Criteria andElecSerLike(String value) {
            addCriterion("elec_ser like", value, "elecSer");
            return (Criteria) this;
        }

        public Criteria andElecSerNotLike(String value) {
            addCriterion("elec_ser not like", value, "elecSer");
            return (Criteria) this;
        }

        public Criteria andElecSerIn(List<String> values) {
            addCriterion("elec_ser in", values, "elecSer");
            return (Criteria) this;
        }

        public Criteria andElecSerNotIn(List<String> values) {
            addCriterion("elec_ser not in", values, "elecSer");
            return (Criteria) this;
        }

        public Criteria andElecSerBetween(String value1, String value2) {
            addCriterion("elec_ser between", value1, value2, "elecSer");
            return (Criteria) this;
        }

        public Criteria andElecSerNotBetween(String value1, String value2) {
            addCriterion("elec_ser not between", value1, value2, "elecSer");
            return (Criteria) this;
        }

        public Criteria andSocStrIsNull() {
            addCriterion("soc_str is null");
            return (Criteria) this;
        }

        public Criteria andSocStrIsNotNull() {
            addCriterion("soc_str is not null");
            return (Criteria) this;
        }

        public Criteria andSocStrEqualTo(String value) {
            addCriterion("soc_str =", value, "socStr");
            return (Criteria) this;
        }

        public Criteria andSocStrNotEqualTo(String value) {
            addCriterion("soc_str <>", value, "socStr");
            return (Criteria) this;
        }

        public Criteria andSocStrGreaterThan(String value) {
            addCriterion("soc_str >", value, "socStr");
            return (Criteria) this;
        }

        public Criteria andSocStrGreaterThanOrEqualTo(String value) {
            addCriterion("soc_str >=", value, "socStr");
            return (Criteria) this;
        }

        public Criteria andSocStrLessThan(String value) {
            addCriterion("soc_str <", value, "socStr");
            return (Criteria) this;
        }

        public Criteria andSocStrLessThanOrEqualTo(String value) {
            addCriterion("soc_str <=", value, "socStr");
            return (Criteria) this;
        }

        public Criteria andSocStrLike(String value) {
            addCriterion("soc_str like", value, "socStr");
            return (Criteria) this;
        }

        public Criteria andSocStrNotLike(String value) {
            addCriterion("soc_str not like", value, "socStr");
            return (Criteria) this;
        }

        public Criteria andSocStrIn(List<String> values) {
            addCriterion("soc_str in", values, "socStr");
            return (Criteria) this;
        }

        public Criteria andSocStrNotIn(List<String> values) {
            addCriterion("soc_str not in", values, "socStr");
            return (Criteria) this;
        }

        public Criteria andSocStrBetween(String value1, String value2) {
            addCriterion("soc_str between", value1, value2, "socStr");
            return (Criteria) this;
        }

        public Criteria andSocStrNotBetween(String value1, String value2) {
            addCriterion("soc_str not between", value1, value2, "socStr");
            return (Criteria) this;
        }

        public Criteria andPackTypeIsNull() {
            addCriterion("pack_type is null");
            return (Criteria) this;
        }

        public Criteria andPackTypeIsNotNull() {
            addCriterion("pack_type is not null");
            return (Criteria) this;
        }

        public Criteria andPackTypeEqualTo(String value) {
            addCriterion("pack_type =", value, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeNotEqualTo(String value) {
            addCriterion("pack_type <>", value, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeGreaterThan(String value) {
            addCriterion("pack_type >", value, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pack_type >=", value, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeLessThan(String value) {
            addCriterion("pack_type <", value, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeLessThanOrEqualTo(String value) {
            addCriterion("pack_type <=", value, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeLike(String value) {
            addCriterion("pack_type like", value, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeNotLike(String value) {
            addCriterion("pack_type not like", value, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeIn(List<String> values) {
            addCriterion("pack_type in", values, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeNotIn(List<String> values) {
            addCriterion("pack_type not in", values, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeBetween(String value1, String value2) {
            addCriterion("pack_type between", value1, value2, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeNotBetween(String value1, String value2) {
            addCriterion("pack_type not between", value1, value2, "packType");
            return (Criteria) this;
        }

        public Criteria andPinIsNull() {
            addCriterion("pin is null");
            return (Criteria) this;
        }

        public Criteria andPinIsNotNull() {
            addCriterion("pin is not null");
            return (Criteria) this;
        }

        public Criteria andPinEqualTo(String value) {
            addCriterion("pin =", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotEqualTo(String value) {
            addCriterion("pin <>", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinGreaterThan(String value) {
            addCriterion("pin >", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinGreaterThanOrEqualTo(String value) {
            addCriterion("pin >=", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinLessThan(String value) {
            addCriterion("pin <", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinLessThanOrEqualTo(String value) {
            addCriterion("pin <=", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinLike(String value) {
            addCriterion("pin like", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotLike(String value) {
            addCriterion("pin not like", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinIn(List<String> values) {
            addCriterion("pin in", values, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotIn(List<String> values) {
            addCriterion("pin not in", values, "pin");
            return (Criteria) this;
        }

        public Criteria andPinBetween(String value1, String value2) {
            addCriterion("pin between", value1, value2, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotBetween(String value1, String value2) {
            addCriterion("pin not between", value1, value2, "pin");
            return (Criteria) this;
        }

        public Criteria andSearchKeyIsNull() {
            addCriterion("search_key is null");
            return (Criteria) this;
        }

        public Criteria andSearchKeyIsNotNull() {
            addCriterion("search_key is not null");
            return (Criteria) this;
        }

        public Criteria andSearchKeyEqualTo(String value) {
            addCriterion("search_key =", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyNotEqualTo(String value) {
            addCriterion("search_key <>", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyGreaterThan(String value) {
            addCriterion("search_key >", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyGreaterThanOrEqualTo(String value) {
            addCriterion("search_key >=", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyLessThan(String value) {
            addCriterion("search_key <", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyLessThanOrEqualTo(String value) {
            addCriterion("search_key <=", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyLike(String value) {
            addCriterion("search_key like", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyNotLike(String value) {
            addCriterion("search_key not like", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyIn(List<String> values) {
            addCriterion("search_key in", values, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyNotIn(List<String> values) {
            addCriterion("search_key not in", values, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyBetween(String value1, String value2) {
            addCriterion("search_key between", value1, value2, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyNotBetween(String value1, String value2) {
            addCriterion("search_key not between", value1, value2, "searchKey");
            return (Criteria) this;
        }

        public Criteria andStdLikeInsensitive(String value) {
            addCriterion("upper(std) like", value.toUpperCase(), "std");
            return (Criteria) this;
        }

        public Criteria andQualityLikeInsensitive(String value) {
            addCriterion("upper(quality) like", value.toUpperCase(), "quality");
            return (Criteria) this;
        }

        public Criteria andModelLikeInsensitive(String value) {
            addCriterion("upper(model) like", value.toUpperCase(), "model");
            return (Criteria) this;
        }

        public Criteria andSizeLikeInsensitive(String value) {
            addCriterion("upper(size) like", value.toUpperCase(), "size");
            return (Criteria) this;
        }

        public Criteria andTemperatureLikeInsensitive(String value) {
            addCriterion("upper(temperature) like", value.toUpperCase(), "temperature");
            return (Criteria) this;
        }

        public Criteria andVoltageLikeInsensitive(String value) {
            addCriterion("upper(voltage) like", value.toUpperCase(), "voltage");
            return (Criteria) this;
        }

        public Criteria andCapacityMinLikeInsensitive(String value) {
            addCriterion("upper(capacity_min) like", value.toUpperCase(), "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxLikeInsensitive(String value) {
            addCriterion("upper(capacity_max) like", value.toUpperCase(), "capacityMax");
            return (Criteria) this;
        }

        public Criteria andToleranceLikeInsensitive(String value) {
            addCriterion("upper(tolerance) like", value.toUpperCase(), "tolerance");
            return (Criteria) this;
        }

        public Criteria andOutletLikeInsensitive(String value) {
            addCriterion("upper(outlet) like", value.toUpperCase(), "outlet");
            return (Criteria) this;
        }

        public Criteria andElecCodeLikeInsensitive(String value) {
            addCriterion("upper(elec_code) like", value.toUpperCase(), "elecCode");
            return (Criteria) this;
        }

        public Criteria andCapNumLikeInsensitive(String value) {
            addCriterion("upper(cap_num) like", value.toUpperCase(), "capNum");
            return (Criteria) this;
        }

        public Criteria andElecTypeLikeInsensitive(String value) {
            addCriterion("upper(elec_type) like", value.toUpperCase(), "elecType");
            return (Criteria) this;
        }

        public Criteria andTemperRangeLikeInsensitive(String value) {
            addCriterion("upper(temper_range) like", value.toUpperCase(), "temperRange");
            return (Criteria) this;
        }

        public Criteria andWireMaLikeInsensitive(String value) {
            addCriterion("upper(wire_ma) like", value.toUpperCase(), "wireMa");
            return (Criteria) this;
        }

        public Criteria andWireSizeLikeInsensitive(String value) {
            addCriterion("upper(wire_size) like", value.toUpperCase(), "wireSize");
            return (Criteria) this;
        }

        public Criteria andElecSerLikeInsensitive(String value) {
            addCriterion("upper(elec_ser) like", value.toUpperCase(), "elecSer");
            return (Criteria) this;
        }

        public Criteria andSocStrLikeInsensitive(String value) {
            addCriterion("upper(soc_str) like", value.toUpperCase(), "socStr");
            return (Criteria) this;
        }

        public Criteria andPackTypeLikeInsensitive(String value) {
            addCriterion("upper(pack_type) like", value.toUpperCase(), "packType");
            return (Criteria) this;
        }

        public Criteria andPinLikeInsensitive(String value) {
            addCriterion("upper(pin) like", value.toUpperCase(), "pin");
            return (Criteria) this;
        }

        public Criteria andSearchKeyLikeInsensitive(String value) {
            addCriterion("upper(search_key) like", value.toUpperCase(), "searchKey");
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