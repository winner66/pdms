package com.chk.pdms.pd.domain;

import java.util.ArrayList;
import java.util.List;

public class PdModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PdModelExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andQaCodeIsNull() {
            addCriterion("qa_code is null");
            return (Criteria) this;
        }

        public Criteria andQaCodeIsNotNull() {
            addCriterion("qa_code is not null");
            return (Criteria) this;
        }

        public Criteria andQaCodeEqualTo(String value) {
            addCriterion("qa_code =", value, "qaCode");
            return (Criteria) this;
        }

        public Criteria andQaCodeNotEqualTo(String value) {
            addCriterion("qa_code <>", value, "qaCode");
            return (Criteria) this;
        }

        public Criteria andQaCodeGreaterThan(String value) {
            addCriterion("qa_code >", value, "qaCode");
            return (Criteria) this;
        }

        public Criteria andQaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("qa_code >=", value, "qaCode");
            return (Criteria) this;
        }

        public Criteria andQaCodeLessThan(String value) {
            addCriterion("qa_code <", value, "qaCode");
            return (Criteria) this;
        }

        public Criteria andQaCodeLessThanOrEqualTo(String value) {
            addCriterion("qa_code <=", value, "qaCode");
            return (Criteria) this;
        }

        public Criteria andQaCodeLike(String value) {
            addCriterion("qa_code like", value, "qaCode");
            return (Criteria) this;
        }

        public Criteria andQaCodeNotLike(String value) {
            addCriterion("qa_code not like", value, "qaCode");
            return (Criteria) this;
        }

        public Criteria andQaCodeIn(List<String> values) {
            addCriterion("qa_code in", values, "qaCode");
            return (Criteria) this;
        }

        public Criteria andQaCodeNotIn(List<String> values) {
            addCriterion("qa_code not in", values, "qaCode");
            return (Criteria) this;
        }

        public Criteria andQaCodeBetween(String value1, String value2) {
            addCriterion("qa_code between", value1, value2, "qaCode");
            return (Criteria) this;
        }

        public Criteria andQaCodeNotBetween(String value1, String value2) {
            addCriterion("qa_code not between", value1, value2, "qaCode");
            return (Criteria) this;
        }

        public Criteria andPdClassIdIsNull() {
            addCriterion("pd_class_id is null");
            return (Criteria) this;
        }

        public Criteria andPdClassIdIsNotNull() {
            addCriterion("pd_class_id is not null");
            return (Criteria) this;
        }

        public Criteria andPdClassIdEqualTo(Long value) {
            addCriterion("pd_class_id =", value, "pdClassId");
            return (Criteria) this;
        }

        public Criteria andPdClassIdNotEqualTo(Long value) {
            addCriterion("pd_class_id <>", value, "pdClassId");
            return (Criteria) this;
        }

        public Criteria andPdClassIdGreaterThan(Long value) {
            addCriterion("pd_class_id >", value, "pdClassId");
            return (Criteria) this;
        }

        public Criteria andPdClassIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pd_class_id >=", value, "pdClassId");
            return (Criteria) this;
        }

        public Criteria andPdClassIdLessThan(Long value) {
            addCriterion("pd_class_id <", value, "pdClassId");
            return (Criteria) this;
        }

        public Criteria andPdClassIdLessThanOrEqualTo(Long value) {
            addCriterion("pd_class_id <=", value, "pdClassId");
            return (Criteria) this;
        }

        public Criteria andPdClassIdIn(List<Long> values) {
            addCriterion("pd_class_id in", values, "pdClassId");
            return (Criteria) this;
        }

        public Criteria andPdClassIdNotIn(List<Long> values) {
            addCriterion("pd_class_id not in", values, "pdClassId");
            return (Criteria) this;
        }

        public Criteria andPdClassIdBetween(Long value1, Long value2) {
            addCriterion("pd_class_id between", value1, value2, "pdClassId");
            return (Criteria) this;
        }

        public Criteria andPdClassIdNotBetween(Long value1, Long value2) {
            addCriterion("pd_class_id not between", value1, value2, "pdClassId");
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

        public Criteria andOhmIsNull() {
            addCriterion("ohm is null");
            return (Criteria) this;
        }

        public Criteria andOhmIsNotNull() {
            addCriterion("ohm is not null");
            return (Criteria) this;
        }

        public Criteria andOhmEqualTo(String value) {
            addCriterion("ohm =", value, "ohm");
            return (Criteria) this;
        }

        public Criteria andOhmNotEqualTo(String value) {
            addCriterion("ohm <>", value, "ohm");
            return (Criteria) this;
        }

        public Criteria andOhmGreaterThan(String value) {
            addCriterion("ohm >", value, "ohm");
            return (Criteria) this;
        }

        public Criteria andOhmGreaterThanOrEqualTo(String value) {
            addCriterion("ohm >=", value, "ohm");
            return (Criteria) this;
        }

        public Criteria andOhmLessThan(String value) {
            addCriterion("ohm <", value, "ohm");
            return (Criteria) this;
        }

        public Criteria andOhmLessThanOrEqualTo(String value) {
            addCriterion("ohm <=", value, "ohm");
            return (Criteria) this;
        }

        public Criteria andOhmLike(String value) {
            addCriterion("ohm like", value, "ohm");
            return (Criteria) this;
        }

        public Criteria andOhmNotLike(String value) {
            addCriterion("ohm not like", value, "ohm");
            return (Criteria) this;
        }

        public Criteria andOhmIn(List<String> values) {
            addCriterion("ohm in", values, "ohm");
            return (Criteria) this;
        }

        public Criteria andOhmNotIn(List<String> values) {
            addCriterion("ohm not in", values, "ohm");
            return (Criteria) this;
        }

        public Criteria andOhmBetween(String value1, String value2) {
            addCriterion("ohm between", value1, value2, "ohm");
            return (Criteria) this;
        }

        public Criteria andOhmNotBetween(String value1, String value2) {
            addCriterion("ohm not between", value1, value2, "ohm");
            return (Criteria) this;
        }

        public Criteria andTanIsNull() {
            addCriterion("tan is null");
            return (Criteria) this;
        }

        public Criteria andTanIsNotNull() {
            addCriterion("tan is not null");
            return (Criteria) this;
        }

        public Criteria andTanEqualTo(String value) {
            addCriterion("tan =", value, "tan");
            return (Criteria) this;
        }

        public Criteria andTanNotEqualTo(String value) {
            addCriterion("tan <>", value, "tan");
            return (Criteria) this;
        }

        public Criteria andTanGreaterThan(String value) {
            addCriterion("tan >", value, "tan");
            return (Criteria) this;
        }

        public Criteria andTanGreaterThanOrEqualTo(String value) {
            addCriterion("tan >=", value, "tan");
            return (Criteria) this;
        }

        public Criteria andTanLessThan(String value) {
            addCriterion("tan <", value, "tan");
            return (Criteria) this;
        }

        public Criteria andTanLessThanOrEqualTo(String value) {
            addCriterion("tan <=", value, "tan");
            return (Criteria) this;
        }

        public Criteria andTanLike(String value) {
            addCriterion("tan like", value, "tan");
            return (Criteria) this;
        }

        public Criteria andTanNotLike(String value) {
            addCriterion("tan not like", value, "tan");
            return (Criteria) this;
        }

        public Criteria andTanIn(List<String> values) {
            addCriterion("tan in", values, "tan");
            return (Criteria) this;
        }

        public Criteria andTanNotIn(List<String> values) {
            addCriterion("tan not in", values, "tan");
            return (Criteria) this;
        }

        public Criteria andTanBetween(String value1, String value2) {
            addCriterion("tan between", value1, value2, "tan");
            return (Criteria) this;
        }

        public Criteria andTanNotBetween(String value1, String value2) {
            addCriterion("tan not between", value1, value2, "tan");
            return (Criteria) this;
        }

        public Criteria andOtherParamIsNull() {
            addCriterion("other_param is null");
            return (Criteria) this;
        }

        public Criteria andOtherParamIsNotNull() {
            addCriterion("other_param is not null");
            return (Criteria) this;
        }

        public Criteria andOtherParamEqualTo(String value) {
            addCriterion("other_param =", value, "otherParam");
            return (Criteria) this;
        }

        public Criteria andOtherParamNotEqualTo(String value) {
            addCriterion("other_param <>", value, "otherParam");
            return (Criteria) this;
        }

        public Criteria andOtherParamGreaterThan(String value) {
            addCriterion("other_param >", value, "otherParam");
            return (Criteria) this;
        }

        public Criteria andOtherParamGreaterThanOrEqualTo(String value) {
            addCriterion("other_param >=", value, "otherParam");
            return (Criteria) this;
        }

        public Criteria andOtherParamLessThan(String value) {
            addCriterion("other_param <", value, "otherParam");
            return (Criteria) this;
        }

        public Criteria andOtherParamLessThanOrEqualTo(String value) {
            addCriterion("other_param <=", value, "otherParam");
            return (Criteria) this;
        }

        public Criteria andOtherParamLike(String value) {
            addCriterion("other_param like", value, "otherParam");
            return (Criteria) this;
        }

        public Criteria andOtherParamNotLike(String value) {
            addCriterion("other_param not like", value, "otherParam");
            return (Criteria) this;
        }

        public Criteria andOtherParamIn(List<String> values) {
            addCriterion("other_param in", values, "otherParam");
            return (Criteria) this;
        }

        public Criteria andOtherParamNotIn(List<String> values) {
            addCriterion("other_param not in", values, "otherParam");
            return (Criteria) this;
        }

        public Criteria andOtherParamBetween(String value1, String value2) {
            addCriterion("other_param between", value1, value2, "otherParam");
            return (Criteria) this;
        }

        public Criteria andOtherParamNotBetween(String value1, String value2) {
            addCriterion("other_param not between", value1, value2, "otherParam");
            return (Criteria) this;
        }

        public Criteria andPurposeIsNull() {
            addCriterion("purpose is null");
            return (Criteria) this;
        }

        public Criteria andPurposeIsNotNull() {
            addCriterion("purpose is not null");
            return (Criteria) this;
        }

        public Criteria andPurposeEqualTo(String value) {
            addCriterion("purpose =", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotEqualTo(String value) {
            addCriterion("purpose <>", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeGreaterThan(String value) {
            addCriterion("purpose >", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeGreaterThanOrEqualTo(String value) {
            addCriterion("purpose >=", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLessThan(String value) {
            addCriterion("purpose <", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLessThanOrEqualTo(String value) {
            addCriterion("purpose <=", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLike(String value) {
            addCriterion("purpose like", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotLike(String value) {
            addCriterion("purpose not like", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeIn(List<String> values) {
            addCriterion("purpose in", values, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotIn(List<String> values) {
            addCriterion("purpose not in", values, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeBetween(String value1, String value2) {
            addCriterion("purpose between", value1, value2, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotBetween(String value1, String value2) {
            addCriterion("purpose not between", value1, value2, "purpose");
            return (Criteria) this;
        }

        public Criteria andFeatureIsNull() {
            addCriterion("feature is null");
            return (Criteria) this;
        }

        public Criteria andFeatureIsNotNull() {
            addCriterion("feature is not null");
            return (Criteria) this;
        }

        public Criteria andFeatureEqualTo(String value) {
            addCriterion("feature =", value, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureNotEqualTo(String value) {
            addCriterion("feature <>", value, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureGreaterThan(String value) {
            addCriterion("feature >", value, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureGreaterThanOrEqualTo(String value) {
            addCriterion("feature >=", value, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureLessThan(String value) {
            addCriterion("feature <", value, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureLessThanOrEqualTo(String value) {
            addCriterion("feature <=", value, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureLike(String value) {
            addCriterion("feature like", value, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureNotLike(String value) {
            addCriterion("feature not like", value, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureIn(List<String> values) {
            addCriterion("feature in", values, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureNotIn(List<String> values) {
            addCriterion("feature not in", values, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureBetween(String value1, String value2) {
            addCriterion("feature between", value1, value2, "feature");
            return (Criteria) this;
        }

        public Criteria andFeatureNotBetween(String value1, String value2) {
            addCriterion("feature not between", value1, value2, "feature");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andOrderRuleIsNull() {
            addCriterion("order_rule is null");
            return (Criteria) this;
        }

        public Criteria andOrderRuleIsNotNull() {
            addCriterion("order_rule is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRuleEqualTo(String value) {
            addCriterion("order_rule =", value, "orderRule");
            return (Criteria) this;
        }

        public Criteria andOrderRuleNotEqualTo(String value) {
            addCriterion("order_rule <>", value, "orderRule");
            return (Criteria) this;
        }

        public Criteria andOrderRuleGreaterThan(String value) {
            addCriterion("order_rule >", value, "orderRule");
            return (Criteria) this;
        }

        public Criteria andOrderRuleGreaterThanOrEqualTo(String value) {
            addCriterion("order_rule >=", value, "orderRule");
            return (Criteria) this;
        }

        public Criteria andOrderRuleLessThan(String value) {
            addCriterion("order_rule <", value, "orderRule");
            return (Criteria) this;
        }

        public Criteria andOrderRuleLessThanOrEqualTo(String value) {
            addCriterion("order_rule <=", value, "orderRule");
            return (Criteria) this;
        }

        public Criteria andOrderRuleLike(String value) {
            addCriterion("order_rule like", value, "orderRule");
            return (Criteria) this;
        }

        public Criteria andOrderRuleNotLike(String value) {
            addCriterion("order_rule not like", value, "orderRule");
            return (Criteria) this;
        }

        public Criteria andOrderRuleIn(List<String> values) {
            addCriterion("order_rule in", values, "orderRule");
            return (Criteria) this;
        }

        public Criteria andOrderRuleNotIn(List<String> values) {
            addCriterion("order_rule not in", values, "orderRule");
            return (Criteria) this;
        }

        public Criteria andOrderRuleBetween(String value1, String value2) {
            addCriterion("order_rule between", value1, value2, "orderRule");
            return (Criteria) this;
        }

        public Criteria andOrderRuleNotBetween(String value1, String value2) {
            addCriterion("order_rule not between", value1, value2, "orderRule");
            return (Criteria) this;
        }

        public Criteria andManualUrlIsNull() {
            addCriterion("manual_url is null");
            return (Criteria) this;
        }

        public Criteria andManualUrlIsNotNull() {
            addCriterion("manual_url is not null");
            return (Criteria) this;
        }

        public Criteria andManualUrlEqualTo(String value) {
            addCriterion("manual_url =", value, "manualUrl");
            return (Criteria) this;
        }

        public Criteria andManualUrlNotEqualTo(String value) {
            addCriterion("manual_url <>", value, "manualUrl");
            return (Criteria) this;
        }

        public Criteria andManualUrlGreaterThan(String value) {
            addCriterion("manual_url >", value, "manualUrl");
            return (Criteria) this;
        }

        public Criteria andManualUrlGreaterThanOrEqualTo(String value) {
            addCriterion("manual_url >=", value, "manualUrl");
            return (Criteria) this;
        }

        public Criteria andManualUrlLessThan(String value) {
            addCriterion("manual_url <", value, "manualUrl");
            return (Criteria) this;
        }

        public Criteria andManualUrlLessThanOrEqualTo(String value) {
            addCriterion("manual_url <=", value, "manualUrl");
            return (Criteria) this;
        }

        public Criteria andManualUrlLike(String value) {
            addCriterion("manual_url like", value, "manualUrl");
            return (Criteria) this;
        }

        public Criteria andManualUrlNotLike(String value) {
            addCriterion("manual_url not like", value, "manualUrl");
            return (Criteria) this;
        }

        public Criteria andManualUrlIn(List<String> values) {
            addCriterion("manual_url in", values, "manualUrl");
            return (Criteria) this;
        }

        public Criteria andManualUrlNotIn(List<String> values) {
            addCriterion("manual_url not in", values, "manualUrl");
            return (Criteria) this;
        }

        public Criteria andManualUrlBetween(String value1, String value2) {
            addCriterion("manual_url between", value1, value2, "manualUrl");
            return (Criteria) this;
        }

        public Criteria andManualUrlNotBetween(String value1, String value2) {
            addCriterion("manual_url not between", value1, value2, "manualUrl");
            return (Criteria) this;
        }

        public Criteria andSizeUrlIsNull() {
            addCriterion("size_url is null");
            return (Criteria) this;
        }

        public Criteria andSizeUrlIsNotNull() {
            addCriterion("size_url is not null");
            return (Criteria) this;
        }

        public Criteria andSizeUrlEqualTo(String value) {
            addCriterion("size_url =", value, "sizeUrl");
            return (Criteria) this;
        }

        public Criteria andSizeUrlNotEqualTo(String value) {
            addCriterion("size_url <>", value, "sizeUrl");
            return (Criteria) this;
        }

        public Criteria andSizeUrlGreaterThan(String value) {
            addCriterion("size_url >", value, "sizeUrl");
            return (Criteria) this;
        }

        public Criteria andSizeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("size_url >=", value, "sizeUrl");
            return (Criteria) this;
        }

        public Criteria andSizeUrlLessThan(String value) {
            addCriterion("size_url <", value, "sizeUrl");
            return (Criteria) this;
        }

        public Criteria andSizeUrlLessThanOrEqualTo(String value) {
            addCriterion("size_url <=", value, "sizeUrl");
            return (Criteria) this;
        }

        public Criteria andSizeUrlLike(String value) {
            addCriterion("size_url like", value, "sizeUrl");
            return (Criteria) this;
        }

        public Criteria andSizeUrlNotLike(String value) {
            addCriterion("size_url not like", value, "sizeUrl");
            return (Criteria) this;
        }

        public Criteria andSizeUrlIn(List<String> values) {
            addCriterion("size_url in", values, "sizeUrl");
            return (Criteria) this;
        }

        public Criteria andSizeUrlNotIn(List<String> values) {
            addCriterion("size_url not in", values, "sizeUrl");
            return (Criteria) this;
        }

        public Criteria andSizeUrlBetween(String value1, String value2) {
            addCriterion("size_url between", value1, value2, "sizeUrl");
            return (Criteria) this;
        }

        public Criteria andSizeUrlNotBetween(String value1, String value2) {
            addCriterion("size_url not between", value1, value2, "sizeUrl");
            return (Criteria) this;
        }

        public Criteria andOrderRuleUrlIsNull() {
            addCriterion("order_rule_url is null");
            return (Criteria) this;
        }

        public Criteria andOrderRuleUrlIsNotNull() {
            addCriterion("order_rule_url is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRuleUrlEqualTo(String value) {
            addCriterion("order_rule_url =", value, "orderRuleUrl");
            return (Criteria) this;
        }

        public Criteria andOrderRuleUrlNotEqualTo(String value) {
            addCriterion("order_rule_url <>", value, "orderRuleUrl");
            return (Criteria) this;
        }

        public Criteria andOrderRuleUrlGreaterThan(String value) {
            addCriterion("order_rule_url >", value, "orderRuleUrl");
            return (Criteria) this;
        }

        public Criteria andOrderRuleUrlGreaterThanOrEqualTo(String value) {
            addCriterion("order_rule_url >=", value, "orderRuleUrl");
            return (Criteria) this;
        }

        public Criteria andOrderRuleUrlLessThan(String value) {
            addCriterion("order_rule_url <", value, "orderRuleUrl");
            return (Criteria) this;
        }

        public Criteria andOrderRuleUrlLessThanOrEqualTo(String value) {
            addCriterion("order_rule_url <=", value, "orderRuleUrl");
            return (Criteria) this;
        }

        public Criteria andOrderRuleUrlLike(String value) {
            addCriterion("order_rule_url like", value, "orderRuleUrl");
            return (Criteria) this;
        }

        public Criteria andOrderRuleUrlNotLike(String value) {
            addCriterion("order_rule_url not like", value, "orderRuleUrl");
            return (Criteria) this;
        }

        public Criteria andOrderRuleUrlIn(List<String> values) {
            addCriterion("order_rule_url in", values, "orderRuleUrl");
            return (Criteria) this;
        }

        public Criteria andOrderRuleUrlNotIn(List<String> values) {
            addCriterion("order_rule_url not in", values, "orderRuleUrl");
            return (Criteria) this;
        }

        public Criteria andOrderRuleUrlBetween(String value1, String value2) {
            addCriterion("order_rule_url between", value1, value2, "orderRuleUrl");
            return (Criteria) this;
        }

        public Criteria andOrderRuleUrlNotBetween(String value1, String value2) {
            addCriterion("order_rule_url not between", value1, value2, "orderRuleUrl");
            return (Criteria) this;
        }

        public Criteria andObjectUrlIsNull() {
            addCriterion("object_url is null");
            return (Criteria) this;
        }

        public Criteria andObjectUrlIsNotNull() {
            addCriterion("object_url is not null");
            return (Criteria) this;
        }

        public Criteria andObjectUrlEqualTo(String value) {
            addCriterion("object_url =", value, "objectUrl");
            return (Criteria) this;
        }

        public Criteria andObjectUrlNotEqualTo(String value) {
            addCriterion("object_url <>", value, "objectUrl");
            return (Criteria) this;
        }

        public Criteria andObjectUrlGreaterThan(String value) {
            addCriterion("object_url >", value, "objectUrl");
            return (Criteria) this;
        }

        public Criteria andObjectUrlGreaterThanOrEqualTo(String value) {
            addCriterion("object_url >=", value, "objectUrl");
            return (Criteria) this;
        }

        public Criteria andObjectUrlLessThan(String value) {
            addCriterion("object_url <", value, "objectUrl");
            return (Criteria) this;
        }

        public Criteria andObjectUrlLessThanOrEqualTo(String value) {
            addCriterion("object_url <=", value, "objectUrl");
            return (Criteria) this;
        }

        public Criteria andObjectUrlLike(String value) {
            addCriterion("object_url like", value, "objectUrl");
            return (Criteria) this;
        }

        public Criteria andObjectUrlNotLike(String value) {
            addCriterion("object_url not like", value, "objectUrl");
            return (Criteria) this;
        }

        public Criteria andObjectUrlIn(List<String> values) {
            addCriterion("object_url in", values, "objectUrl");
            return (Criteria) this;
        }

        public Criteria andObjectUrlNotIn(List<String> values) {
            addCriterion("object_url not in", values, "objectUrl");
            return (Criteria) this;
        }

        public Criteria andObjectUrlBetween(String value1, String value2) {
            addCriterion("object_url between", value1, value2, "objectUrl");
            return (Criteria) this;
        }

        public Criteria andObjectUrlNotBetween(String value1, String value2) {
            addCriterion("object_url not between", value1, value2, "objectUrl");
            return (Criteria) this;
        }

        public Criteria andChartUrlIsNull() {
            addCriterion("chart_url is null");
            return (Criteria) this;
        }

        public Criteria andChartUrlIsNotNull() {
            addCriterion("chart_url is not null");
            return (Criteria) this;
        }

        public Criteria andChartUrlEqualTo(String value) {
            addCriterion("chart_url =", value, "chartUrl");
            return (Criteria) this;
        }

        public Criteria andChartUrlNotEqualTo(String value) {
            addCriterion("chart_url <>", value, "chartUrl");
            return (Criteria) this;
        }

        public Criteria andChartUrlGreaterThan(String value) {
            addCriterion("chart_url >", value, "chartUrl");
            return (Criteria) this;
        }

        public Criteria andChartUrlGreaterThanOrEqualTo(String value) {
            addCriterion("chart_url >=", value, "chartUrl");
            return (Criteria) this;
        }

        public Criteria andChartUrlLessThan(String value) {
            addCriterion("chart_url <", value, "chartUrl");
            return (Criteria) this;
        }

        public Criteria andChartUrlLessThanOrEqualTo(String value) {
            addCriterion("chart_url <=", value, "chartUrl");
            return (Criteria) this;
        }

        public Criteria andChartUrlLike(String value) {
            addCriterion("chart_url like", value, "chartUrl");
            return (Criteria) this;
        }

        public Criteria andChartUrlNotLike(String value) {
            addCriterion("chart_url not like", value, "chartUrl");
            return (Criteria) this;
        }

        public Criteria andChartUrlIn(List<String> values) {
            addCriterion("chart_url in", values, "chartUrl");
            return (Criteria) this;
        }

        public Criteria andChartUrlNotIn(List<String> values) {
            addCriterion("chart_url not in", values, "chartUrl");
            return (Criteria) this;
        }

        public Criteria andChartUrlBetween(String value1, String value2) {
            addCriterion("chart_url between", value1, value2, "chartUrl");
            return (Criteria) this;
        }

        public Criteria andChartUrlNotBetween(String value1, String value2) {
            addCriterion("chart_url not between", value1, value2, "chartUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andGeneralNormsIsNull() {
            addCriterion("general_norms is null");
            return (Criteria) this;
        }

        public Criteria andGeneralNormsIsNotNull() {
            addCriterion("general_norms is not null");
            return (Criteria) this;
        }

        public Criteria andGeneralNormsEqualTo(String value) {
            addCriterion("general_norms =", value, "generalNorms");
            return (Criteria) this;
        }

        public Criteria andGeneralNormsNotEqualTo(String value) {
            addCriterion("general_norms <>", value, "generalNorms");
            return (Criteria) this;
        }

        public Criteria andGeneralNormsGreaterThan(String value) {
            addCriterion("general_norms >", value, "generalNorms");
            return (Criteria) this;
        }

        public Criteria andGeneralNormsGreaterThanOrEqualTo(String value) {
            addCriterion("general_norms >=", value, "generalNorms");
            return (Criteria) this;
        }

        public Criteria andGeneralNormsLessThan(String value) {
            addCriterion("general_norms <", value, "generalNorms");
            return (Criteria) this;
        }

        public Criteria andGeneralNormsLessThanOrEqualTo(String value) {
            addCriterion("general_norms <=", value, "generalNorms");
            return (Criteria) this;
        }

        public Criteria andGeneralNormsLike(String value) {
            addCriterion("general_norms like", value, "generalNorms");
            return (Criteria) this;
        }

        public Criteria andGeneralNormsNotLike(String value) {
            addCriterion("general_norms not like", value, "generalNorms");
            return (Criteria) this;
        }

        public Criteria andGeneralNormsIn(List<String> values) {
            addCriterion("general_norms in", values, "generalNorms");
            return (Criteria) this;
        }

        public Criteria andGeneralNormsNotIn(List<String> values) {
            addCriterion("general_norms not in", values, "generalNorms");
            return (Criteria) this;
        }

        public Criteria andGeneralNormsBetween(String value1, String value2) {
            addCriterion("general_norms between", value1, value2, "generalNorms");
            return (Criteria) this;
        }

        public Criteria andGeneralNormsNotBetween(String value1, String value2) {
            addCriterion("general_norms not between", value1, value2, "generalNorms");
            return (Criteria) this;
        }

        public Criteria andDetailNormsIsNull() {
            addCriterion("detail_norms is null");
            return (Criteria) this;
        }

        public Criteria andDetailNormsIsNotNull() {
            addCriterion("detail_norms is not null");
            return (Criteria) this;
        }

        public Criteria andDetailNormsEqualTo(String value) {
            addCriterion("detail_norms =", value, "detailNorms");
            return (Criteria) this;
        }

        public Criteria andDetailNormsNotEqualTo(String value) {
            addCriterion("detail_norms <>", value, "detailNorms");
            return (Criteria) this;
        }

        public Criteria andDetailNormsGreaterThan(String value) {
            addCriterion("detail_norms >", value, "detailNorms");
            return (Criteria) this;
        }

        public Criteria andDetailNormsGreaterThanOrEqualTo(String value) {
            addCriterion("detail_norms >=", value, "detailNorms");
            return (Criteria) this;
        }

        public Criteria andDetailNormsLessThan(String value) {
            addCriterion("detail_norms <", value, "detailNorms");
            return (Criteria) this;
        }

        public Criteria andDetailNormsLessThanOrEqualTo(String value) {
            addCriterion("detail_norms <=", value, "detailNorms");
            return (Criteria) this;
        }

        public Criteria andDetailNormsLike(String value) {
            addCriterion("detail_norms like", value, "detailNorms");
            return (Criteria) this;
        }

        public Criteria andDetailNormsNotLike(String value) {
            addCriterion("detail_norms not like", value, "detailNorms");
            return (Criteria) this;
        }

        public Criteria andDetailNormsIn(List<String> values) {
            addCriterion("detail_norms in", values, "detailNorms");
            return (Criteria) this;
        }

        public Criteria andDetailNormsNotIn(List<String> values) {
            addCriterion("detail_norms not in", values, "detailNorms");
            return (Criteria) this;
        }

        public Criteria andDetailNormsBetween(String value1, String value2) {
            addCriterion("detail_norms between", value1, value2, "detailNorms");
            return (Criteria) this;
        }

        public Criteria andDetailNormsNotBetween(String value1, String value2) {
            addCriterion("detail_norms not between", value1, value2, "detailNorms");
            return (Criteria) this;
        }

        public Criteria andDelIsNull() {
            addCriterion("del is null");
            return (Criteria) this;
        }

        public Criteria andDelIsNotNull() {
            addCriterion("del is not null");
            return (Criteria) this;
        }

        public Criteria andDelEqualTo(Boolean value) {
            addCriterion("del =", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotEqualTo(Boolean value) {
            addCriterion("del <>", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThan(Boolean value) {
            addCriterion("del >", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("del >=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThan(Boolean value) {
            addCriterion("del <", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThanOrEqualTo(Boolean value) {
            addCriterion("del <=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelIn(List<Boolean> values) {
            addCriterion("del in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotIn(List<Boolean> values) {
            addCriterion("del not in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelBetween(Boolean value1, Boolean value2) {
            addCriterion("del between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("del not between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(name) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andCodeLikeInsensitive(String value) {
            addCriterion("upper(code) like", value.toUpperCase(), "code");
            return (Criteria) this;
        }

        public Criteria andQaCodeLikeInsensitive(String value) {
            addCriterion("upper(qa_code) like", value.toUpperCase(), "qaCode");
            return (Criteria) this;
        }

        public Criteria andVoltageLikeInsensitive(String value) {
            addCriterion("upper(voltage) like", value.toUpperCase(), "voltage");
            return (Criteria) this;
        }

        public Criteria andOhmLikeInsensitive(String value) {
            addCriterion("upper(ohm) like", value.toUpperCase(), "ohm");
            return (Criteria) this;
        }

        public Criteria andTanLikeInsensitive(String value) {
            addCriterion("upper(tan) like", value.toUpperCase(), "tan");
            return (Criteria) this;
        }

        public Criteria andOtherParamLikeInsensitive(String value) {
            addCriterion("upper(other_param) like", value.toUpperCase(), "otherParam");
            return (Criteria) this;
        }

        public Criteria andPurposeLikeInsensitive(String value) {
            addCriterion("upper(purpose) like", value.toUpperCase(), "purpose");
            return (Criteria) this;
        }

        public Criteria andFeatureLikeInsensitive(String value) {
            addCriterion("upper(feature) like", value.toUpperCase(), "feature");
            return (Criteria) this;
        }

        public Criteria andContactLikeInsensitive(String value) {
            addCriterion("upper(contact) like", value.toUpperCase(), "contact");
            return (Criteria) this;
        }

        public Criteria andPhoneLikeInsensitive(String value) {
            addCriterion("upper(phone) like", value.toUpperCase(), "phone");
            return (Criteria) this;
        }

        public Criteria andOrderRuleLikeInsensitive(String value) {
            addCriterion("upper(order_rule) like", value.toUpperCase(), "orderRule");
            return (Criteria) this;
        }

        public Criteria andManualUrlLikeInsensitive(String value) {
            addCriterion("upper(manual_url) like", value.toUpperCase(), "manualUrl");
            return (Criteria) this;
        }

        public Criteria andSizeUrlLikeInsensitive(String value) {
            addCriterion("upper(size_url) like", value.toUpperCase(), "sizeUrl");
            return (Criteria) this;
        }

        public Criteria andOrderRuleUrlLikeInsensitive(String value) {
            addCriterion("upper(order_rule_url) like", value.toUpperCase(), "orderRuleUrl");
            return (Criteria) this;
        }

        public Criteria andObjectUrlLikeInsensitive(String value) {
            addCriterion("upper(object_url) like", value.toUpperCase(), "objectUrl");
            return (Criteria) this;
        }

        public Criteria andChartUrlLikeInsensitive(String value) {
            addCriterion("upper(chart_url) like", value.toUpperCase(), "chartUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyLikeInsensitive(String value) {
            addCriterion("upper(company) like", value.toUpperCase(), "company");
            return (Criteria) this;
        }

        public Criteria andGeneralNormsLikeInsensitive(String value) {
            addCriterion("upper(general_norms) like", value.toUpperCase(), "generalNorms");
            return (Criteria) this;
        }

        public Criteria andDetailNormsLikeInsensitive(String value) {
            addCriterion("upper(detail_norms) like", value.toUpperCase(), "detailNorms");
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