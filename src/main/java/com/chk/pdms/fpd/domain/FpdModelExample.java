package com.chk.pdms.fpd.domain;

import java.util.ArrayList;
import java.util.List;

public class FpdModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FpdModelExample() {
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

        public Criteria andIdxIsNull() {
            addCriterion("idx is null");
            return (Criteria) this;
        }

        public Criteria andIdxIsNotNull() {
            addCriterion("idx is not null");
            return (Criteria) this;
        }

        public Criteria andIdxEqualTo(Integer value) {
            addCriterion("idx =", value, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxNotEqualTo(Integer value) {
            addCriterion("idx <>", value, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxGreaterThan(Integer value) {
            addCriterion("idx >", value, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxGreaterThanOrEqualTo(Integer value) {
            addCriterion("idx >=", value, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxLessThan(Integer value) {
            addCriterion("idx <", value, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxLessThanOrEqualTo(Integer value) {
            addCriterion("idx <=", value, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxIn(List<Integer> values) {
            addCriterion("idx in", values, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxNotIn(List<Integer> values) {
            addCriterion("idx not in", values, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxBetween(Integer value1, Integer value2) {
            addCriterion("idx between", value1, value2, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxNotBetween(Integer value1, Integer value2) {
            addCriterion("idx not between", value1, value2, "idx");
            return (Criteria) this;
        }

        public Criteria andOrderRulePosIsNull() {
            addCriterion("order_rule_pos is null");
            return (Criteria) this;
        }

        public Criteria andOrderRulePosIsNotNull() {
            addCriterion("order_rule_pos is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRulePosEqualTo(String value) {
            addCriterion("order_rule_pos =", value, "orderRulePos");
            return (Criteria) this;
        }

        public Criteria andOrderRulePosNotEqualTo(String value) {
            addCriterion("order_rule_pos <>", value, "orderRulePos");
            return (Criteria) this;
        }

        public Criteria andOrderRulePosGreaterThan(String value) {
            addCriterion("order_rule_pos >", value, "orderRulePos");
            return (Criteria) this;
        }

        public Criteria andOrderRulePosGreaterThanOrEqualTo(String value) {
            addCriterion("order_rule_pos >=", value, "orderRulePos");
            return (Criteria) this;
        }

        public Criteria andOrderRulePosLessThan(String value) {
            addCriterion("order_rule_pos <", value, "orderRulePos");
            return (Criteria) this;
        }

        public Criteria andOrderRulePosLessThanOrEqualTo(String value) {
            addCriterion("order_rule_pos <=", value, "orderRulePos");
            return (Criteria) this;
        }

        public Criteria andOrderRulePosLike(String value) {
            addCriterion("order_rule_pos like", value, "orderRulePos");
            return (Criteria) this;
        }

        public Criteria andOrderRulePosNotLike(String value) {
            addCriterion("order_rule_pos not like", value, "orderRulePos");
            return (Criteria) this;
        }

        public Criteria andOrderRulePosIn(List<String> values) {
            addCriterion("order_rule_pos in", values, "orderRulePos");
            return (Criteria) this;
        }

        public Criteria andOrderRulePosNotIn(List<String> values) {
            addCriterion("order_rule_pos not in", values, "orderRulePos");
            return (Criteria) this;
        }

        public Criteria andOrderRulePosBetween(String value1, String value2) {
            addCriterion("order_rule_pos between", value1, value2, "orderRulePos");
            return (Criteria) this;
        }

        public Criteria andOrderRulePosNotBetween(String value1, String value2) {
            addCriterion("order_rule_pos not between", value1, value2, "orderRulePos");
            return (Criteria) this;
        }

        public Criteria andOrderRuleBitIsNull() {
            addCriterion("order_rule_bit is null");
            return (Criteria) this;
        }

        public Criteria andOrderRuleBitIsNotNull() {
            addCriterion("order_rule_bit is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRuleBitEqualTo(String value) {
            addCriterion("order_rule_bit =", value, "orderRuleBit");
            return (Criteria) this;
        }

        public Criteria andOrderRuleBitNotEqualTo(String value) {
            addCriterion("order_rule_bit <>", value, "orderRuleBit");
            return (Criteria) this;
        }

        public Criteria andOrderRuleBitGreaterThan(String value) {
            addCriterion("order_rule_bit >", value, "orderRuleBit");
            return (Criteria) this;
        }

        public Criteria andOrderRuleBitGreaterThanOrEqualTo(String value) {
            addCriterion("order_rule_bit >=", value, "orderRuleBit");
            return (Criteria) this;
        }

        public Criteria andOrderRuleBitLessThan(String value) {
            addCriterion("order_rule_bit <", value, "orderRuleBit");
            return (Criteria) this;
        }

        public Criteria andOrderRuleBitLessThanOrEqualTo(String value) {
            addCriterion("order_rule_bit <=", value, "orderRuleBit");
            return (Criteria) this;
        }

        public Criteria andOrderRuleBitLike(String value) {
            addCriterion("order_rule_bit like", value, "orderRuleBit");
            return (Criteria) this;
        }

        public Criteria andOrderRuleBitNotLike(String value) {
            addCriterion("order_rule_bit not like", value, "orderRuleBit");
            return (Criteria) this;
        }

        public Criteria andOrderRuleBitIn(List<String> values) {
            addCriterion("order_rule_bit in", values, "orderRuleBit");
            return (Criteria) this;
        }

        public Criteria andOrderRuleBitNotIn(List<String> values) {
            addCriterion("order_rule_bit not in", values, "orderRuleBit");
            return (Criteria) this;
        }

        public Criteria andOrderRuleBitBetween(String value1, String value2) {
            addCriterion("order_rule_bit between", value1, value2, "orderRuleBit");
            return (Criteria) this;
        }

        public Criteria andOrderRuleBitNotBetween(String value1, String value2) {
            addCriterion("order_rule_bit not between", value1, value2, "orderRuleBit");
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

        public Criteria andOrderRuleLikeInsensitive(String value) {
            addCriterion("upper(order_rule) like", value.toUpperCase(), "orderRule");
            return (Criteria) this;
        }

        public Criteria andOrderRulePosLikeInsensitive(String value) {
            addCriterion("upper(order_rule_pos) like", value.toUpperCase(), "orderRulePos");
            return (Criteria) this;
        }

        public Criteria andOrderRuleBitLikeInsensitive(String value) {
            addCriterion("upper(order_rule_bit) like", value.toUpperCase(), "orderRuleBit");
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