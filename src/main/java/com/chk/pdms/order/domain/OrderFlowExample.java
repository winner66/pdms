package com.chk.pdms.order.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderFlowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderFlowExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdIsNull() {
            addCriterion("op_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOpUserIdIsNotNull() {
            addCriterion("op_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpUserIdEqualTo(Long value) {
            addCriterion("op_user_id =", value, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdNotEqualTo(Long value) {
            addCriterion("op_user_id <>", value, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdGreaterThan(Long value) {
            addCriterion("op_user_id >", value, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("op_user_id >=", value, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdLessThan(Long value) {
            addCriterion("op_user_id <", value, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdLessThanOrEqualTo(Long value) {
            addCriterion("op_user_id <=", value, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdIn(List<Long> values) {
            addCriterion("op_user_id in", values, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdNotIn(List<Long> values) {
            addCriterion("op_user_id not in", values, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdBetween(Long value1, Long value2) {
            addCriterion("op_user_id between", value1, value2, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdNotBetween(Long value1, Long value2) {
            addCriterion("op_user_id not between", value1, value2, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIsNull() {
            addCriterion("op_user is null");
            return (Criteria) this;
        }

        public Criteria andOpUserIsNotNull() {
            addCriterion("op_user is not null");
            return (Criteria) this;
        }

        public Criteria andOpUserEqualTo(String value) {
            addCriterion("op_user =", value, "opUser");
            return (Criteria) this;
        }

        public Criteria andOpUserNotEqualTo(String value) {
            addCriterion("op_user <>", value, "opUser");
            return (Criteria) this;
        }

        public Criteria andOpUserGreaterThan(String value) {
            addCriterion("op_user >", value, "opUser");
            return (Criteria) this;
        }

        public Criteria andOpUserGreaterThanOrEqualTo(String value) {
            addCriterion("op_user >=", value, "opUser");
            return (Criteria) this;
        }

        public Criteria andOpUserLessThan(String value) {
            addCriterion("op_user <", value, "opUser");
            return (Criteria) this;
        }

        public Criteria andOpUserLessThanOrEqualTo(String value) {
            addCriterion("op_user <=", value, "opUser");
            return (Criteria) this;
        }

        public Criteria andOpUserLike(String value) {
            addCriterion("op_user like", value, "opUser");
            return (Criteria) this;
        }

        public Criteria andOpUserNotLike(String value) {
            addCriterion("op_user not like", value, "opUser");
            return (Criteria) this;
        }

        public Criteria andOpUserIn(List<String> values) {
            addCriterion("op_user in", values, "opUser");
            return (Criteria) this;
        }

        public Criteria andOpUserNotIn(List<String> values) {
            addCriterion("op_user not in", values, "opUser");
            return (Criteria) this;
        }

        public Criteria andOpUserBetween(String value1, String value2) {
            addCriterion("op_user between", value1, value2, "opUser");
            return (Criteria) this;
        }

        public Criteria andOpUserNotBetween(String value1, String value2) {
            addCriterion("op_user not between", value1, value2, "opUser");
            return (Criteria) this;
        }

        public Criteria andOpDescIsNull() {
            addCriterion("op_desc is null");
            return (Criteria) this;
        }

        public Criteria andOpDescIsNotNull() {
            addCriterion("op_desc is not null");
            return (Criteria) this;
        }

        public Criteria andOpDescEqualTo(String value) {
            addCriterion("op_desc =", value, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescNotEqualTo(String value) {
            addCriterion("op_desc <>", value, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescGreaterThan(String value) {
            addCriterion("op_desc >", value, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescGreaterThanOrEqualTo(String value) {
            addCriterion("op_desc >=", value, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescLessThan(String value) {
            addCriterion("op_desc <", value, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescLessThanOrEqualTo(String value) {
            addCriterion("op_desc <=", value, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescLike(String value) {
            addCriterion("op_desc like", value, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescNotLike(String value) {
            addCriterion("op_desc not like", value, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescIn(List<String> values) {
            addCriterion("op_desc in", values, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescNotIn(List<String> values) {
            addCriterion("op_desc not in", values, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescBetween(String value1, String value2) {
            addCriterion("op_desc between", value1, value2, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescNotBetween(String value1, String value2) {
            addCriterion("op_desc not between", value1, value2, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDatetimeIsNull() {
            addCriterion("op_datetime is null");
            return (Criteria) this;
        }

        public Criteria andOpDatetimeIsNotNull() {
            addCriterion("op_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andOpDatetimeEqualTo(Date value) {
            addCriterion("op_datetime =", value, "opDatetime");
            return (Criteria) this;
        }

        public Criteria andOpDatetimeNotEqualTo(Date value) {
            addCriterion("op_datetime <>", value, "opDatetime");
            return (Criteria) this;
        }

        public Criteria andOpDatetimeGreaterThan(Date value) {
            addCriterion("op_datetime >", value, "opDatetime");
            return (Criteria) this;
        }

        public Criteria andOpDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("op_datetime >=", value, "opDatetime");
            return (Criteria) this;
        }

        public Criteria andOpDatetimeLessThan(Date value) {
            addCriterion("op_datetime <", value, "opDatetime");
            return (Criteria) this;
        }

        public Criteria andOpDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("op_datetime <=", value, "opDatetime");
            return (Criteria) this;
        }

        public Criteria andOpDatetimeIn(List<Date> values) {
            addCriterion("op_datetime in", values, "opDatetime");
            return (Criteria) this;
        }

        public Criteria andOpDatetimeNotIn(List<Date> values) {
            addCriterion("op_datetime not in", values, "opDatetime");
            return (Criteria) this;
        }

        public Criteria andOpDatetimeBetween(Date value1, Date value2) {
            addCriterion("op_datetime between", value1, value2, "opDatetime");
            return (Criteria) this;
        }

        public Criteria andOpDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("op_datetime not between", value1, value2, "opDatetime");
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

        public Criteria andOpUserLikeInsensitive(String value) {
            addCriterion("upper(op_user) like", value.toUpperCase(), "opUser");
            return (Criteria) this;
        }

        public Criteria andOpDescLikeInsensitive(String value) {
            addCriterion("upper(op_desc) like", value.toUpperCase(), "opDesc");
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