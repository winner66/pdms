package com.chk.pdms.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DataCollectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataCollectExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andPageIsNull() {
            addCriterion("page is null");
            return (Criteria) this;
        }

        public Criteria andPageIsNotNull() {
            addCriterion("page is not null");
            return (Criteria) this;
        }

        public Criteria andPageEqualTo(String value) {
            addCriterion("page =", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotEqualTo(String value) {
            addCriterion("page <>", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageGreaterThan(String value) {
            addCriterion("page >", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageGreaterThanOrEqualTo(String value) {
            addCriterion("page >=", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageLessThan(String value) {
            addCriterion("page <", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageLessThanOrEqualTo(String value) {
            addCriterion("page <=", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageLike(String value) {
            addCriterion("page like", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotLike(String value) {
            addCriterion("page not like", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageIn(List<String> values) {
            addCriterion("page in", values, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotIn(List<String> values) {
            addCriterion("page not in", values, "page");
            return (Criteria) this;
        }

        public Criteria andPageBetween(String value1, String value2) {
            addCriterion("page between", value1, value2, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotBetween(String value1, String value2) {
            addCriterion("page not between", value1, value2, "page");
            return (Criteria) this;
        }

        public Criteria andEventIsNull() {
            addCriterion("event is null");
            return (Criteria) this;
        }

        public Criteria andEventIsNotNull() {
            addCriterion("event is not null");
            return (Criteria) this;
        }

        public Criteria andEventEqualTo(String value) {
            addCriterion("event =", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventNotEqualTo(String value) {
            addCriterion("event <>", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventGreaterThan(String value) {
            addCriterion("event >", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventGreaterThanOrEqualTo(String value) {
            addCriterion("event >=", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventLessThan(String value) {
            addCriterion("event <", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventLessThanOrEqualTo(String value) {
            addCriterion("event <=", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventLike(String value) {
            addCriterion("event like", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventNotLike(String value) {
            addCriterion("event not like", value, "event");
            return (Criteria) this;
        }

        public Criteria andEventIn(List<String> values) {
            addCriterion("event in", values, "event");
            return (Criteria) this;
        }

        public Criteria andEventNotIn(List<String> values) {
            addCriterion("event not in", values, "event");
            return (Criteria) this;
        }

        public Criteria andEventBetween(String value1, String value2) {
            addCriterion("event between", value1, value2, "event");
            return (Criteria) this;
        }

        public Criteria andEventNotBetween(String value1, String value2) {
            addCriterion("event not between", value1, value2, "event");
            return (Criteria) this;
        }

        public Criteria andDataIsNull() {
            addCriterion("data is null");
            return (Criteria) this;
        }

        public Criteria andDataIsNotNull() {
            addCriterion("data is not null");
            return (Criteria) this;
        }

        public Criteria andDataEqualTo(String value) {
            addCriterion("data =", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotEqualTo(String value) {
            addCriterion("data <>", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataGreaterThan(String value) {
            addCriterion("data >", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataGreaterThanOrEqualTo(String value) {
            addCriterion("data >=", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLessThan(String value) {
            addCriterion("data <", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLessThanOrEqualTo(String value) {
            addCriterion("data <=", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLike(String value) {
            addCriterion("data like", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotLike(String value) {
            addCriterion("data not like", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataIn(List<String> values) {
            addCriterion("data in", values, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotIn(List<String> values) {
            addCriterion("data not in", values, "data");
            return (Criteria) this;
        }

        public Criteria andDataBetween(String value1, String value2) {
            addCriterion("data between", value1, value2, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotBetween(String value1, String value2) {
            addCriterion("data not between", value1, value2, "data");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andPageLikeInsensitive(String value) {
            addCriterion("upper(page) like", value.toUpperCase(), "page");
            return (Criteria) this;
        }

        public Criteria andEventLikeInsensitive(String value) {
            addCriterion("upper(event) like", value.toUpperCase(), "event");
            return (Criteria) this;
        }

        public Criteria andDataLikeInsensitive(String value) {
            addCriterion("upper(data) like", value.toUpperCase(), "data");
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