package com.chk.pdms.fpd.domain;

import java.util.ArrayList;
import java.util.List;

public class FpdSeriesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FpdSeriesExample() {
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
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFFactorysIsNull() {
            addCriterion("F_factorys is null");
            return (Criteria) this;
        }

        public Criteria andFFactorysIsNotNull() {
            addCriterion("F_factorys is not null");
            return (Criteria) this;
        }

        public Criteria andFFactorysEqualTo(String value) {
            addCriterion("F_factorys =", value, "fFactorys");
            return (Criteria) this;
        }

        public Criteria andFFactorysNotEqualTo(String value) {
            addCriterion("F_factorys <>", value, "fFactorys");
            return (Criteria) this;
        }

        public Criteria andFFactorysGreaterThan(String value) {
            addCriterion("F_factorys >", value, "fFactorys");
            return (Criteria) this;
        }

        public Criteria andFFactorysGreaterThanOrEqualTo(String value) {
            addCriterion("F_factorys >=", value, "fFactorys");
            return (Criteria) this;
        }

        public Criteria andFFactorysLessThan(String value) {
            addCriterion("F_factorys <", value, "fFactorys");
            return (Criteria) this;
        }

        public Criteria andFFactorysLessThanOrEqualTo(String value) {
            addCriterion("F_factorys <=", value, "fFactorys");
            return (Criteria) this;
        }

        public Criteria andFFactorysLike(String value) {
            addCriterion("F_factorys like", value, "fFactorys");
            return (Criteria) this;
        }

        public Criteria andFFactorysNotLike(String value) {
            addCriterion("F_factorys not like", value, "fFactorys");
            return (Criteria) this;
        }

        public Criteria andFFactorysIn(List<String> values) {
            addCriterion("F_factorys in", values, "fFactorys");
            return (Criteria) this;
        }

        public Criteria andFFactorysNotIn(List<String> values) {
            addCriterion("F_factorys not in", values, "fFactorys");
            return (Criteria) this;
        }

        public Criteria andFFactorysBetween(String value1, String value2) {
            addCriterion("F_factorys between", value1, value2, "fFactorys");
            return (Criteria) this;
        }

        public Criteria andFFactorysNotBetween(String value1, String value2) {
            addCriterion("F_factorys not between", value1, value2, "fFactorys");
            return (Criteria) this;
        }

        public Criteria andFSeriesIsNull() {
            addCriterion("F_series is null");
            return (Criteria) this;
        }

        public Criteria andFSeriesIsNotNull() {
            addCriterion("F_series is not null");
            return (Criteria) this;
        }

        public Criteria andFSeriesEqualTo(String value) {
            addCriterion("F_series =", value, "fSeries");
            return (Criteria) this;
        }

        public Criteria andFSeriesNotEqualTo(String value) {
            addCriterion("F_series <>", value, "fSeries");
            return (Criteria) this;
        }

        public Criteria andFSeriesGreaterThan(String value) {
            addCriterion("F_series >", value, "fSeries");
            return (Criteria) this;
        }

        public Criteria andFSeriesGreaterThanOrEqualTo(String value) {
            addCriterion("F_series >=", value, "fSeries");
            return (Criteria) this;
        }

        public Criteria andFSeriesLessThan(String value) {
            addCriterion("F_series <", value, "fSeries");
            return (Criteria) this;
        }

        public Criteria andFSeriesLessThanOrEqualTo(String value) {
            addCriterion("F_series <=", value, "fSeries");
            return (Criteria) this;
        }

        public Criteria andFSeriesLike(String value) {
            addCriterion("F_series like", value, "fSeries");
            return (Criteria) this;
        }

        public Criteria andFSeriesNotLike(String value) {
            addCriterion("F_series not like", value, "fSeries");
            return (Criteria) this;
        }

        public Criteria andFSeriesIn(List<String> values) {
            addCriterion("F_series in", values, "fSeries");
            return (Criteria) this;
        }

        public Criteria andFSeriesNotIn(List<String> values) {
            addCriterion("F_series not in", values, "fSeries");
            return (Criteria) this;
        }

        public Criteria andFSeriesBetween(String value1, String value2) {
            addCriterion("F_series between", value1, value2, "fSeries");
            return (Criteria) this;
        }

        public Criteria andFSeriesNotBetween(String value1, String value2) {
            addCriterion("F_series not between", value1, value2, "fSeries");
            return (Criteria) this;
        }

        public Criteria andHkSeriesIsNull() {
            addCriterion("HK_series is null");
            return (Criteria) this;
        }

        public Criteria andHkSeriesIsNotNull() {
            addCriterion("HK_series is not null");
            return (Criteria) this;
        }

        public Criteria andHkSeriesEqualTo(String value) {
            addCriterion("HK_series =", value, "hkSeries");
            return (Criteria) this;
        }

        public Criteria andHkSeriesNotEqualTo(String value) {
            addCriterion("HK_series <>", value, "hkSeries");
            return (Criteria) this;
        }

        public Criteria andHkSeriesGreaterThan(String value) {
            addCriterion("HK_series >", value, "hkSeries");
            return (Criteria) this;
        }

        public Criteria andHkSeriesGreaterThanOrEqualTo(String value) {
            addCriterion("HK_series >=", value, "hkSeries");
            return (Criteria) this;
        }

        public Criteria andHkSeriesLessThan(String value) {
            addCriterion("HK_series <", value, "hkSeries");
            return (Criteria) this;
        }

        public Criteria andHkSeriesLessThanOrEqualTo(String value) {
            addCriterion("HK_series <=", value, "hkSeries");
            return (Criteria) this;
        }

        public Criteria andHkSeriesLike(String value) {
            addCriterion("HK_series like", value, "hkSeries");
            return (Criteria) this;
        }

        public Criteria andHkSeriesNotLike(String value) {
            addCriterion("HK_series not like", value, "hkSeries");
            return (Criteria) this;
        }

        public Criteria andHkSeriesIn(List<String> values) {
            addCriterion("HK_series in", values, "hkSeries");
            return (Criteria) this;
        }

        public Criteria andHkSeriesNotIn(List<String> values) {
            addCriterion("HK_series not in", values, "hkSeries");
            return (Criteria) this;
        }

        public Criteria andHkSeriesBetween(String value1, String value2) {
            addCriterion("HK_series between", value1, value2, "hkSeries");
            return (Criteria) this;
        }

        public Criteria andHkSeriesNotBetween(String value1, String value2) {
            addCriterion("HK_series not between", value1, value2, "hkSeries");
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

        public Criteria andFFactorysLikeInsensitive(String value) {
            addCriterion("upper(F_factorys) like", value.toUpperCase(), "fFactorys");
            return (Criteria) this;
        }

        public Criteria andFSeriesLikeInsensitive(String value) {
            addCriterion("upper(F_series) like", value.toUpperCase(), "fSeries");
            return (Criteria) this;
        }

        public Criteria andHkSeriesLikeInsensitive(String value) {
            addCriterion("upper(HK_series) like", value.toUpperCase(), "hkSeries");
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

        public Criteria andOutletLikeInsensitive(String value) {
            addCriterion("upper(outlet) like", value.toUpperCase(), "outlet");
            return (Criteria) this;
        }

        public Criteria andToleranceLikeInsensitive(String value) {
            addCriterion("upper(tolerance) like", value.toUpperCase(), "tolerance");
            return (Criteria) this;
        }

        public Criteria andSocStrLikeInsensitive(String value) {
            addCriterion("upper(soc_str) like", value.toUpperCase(), "socStr");
            return (Criteria) this;
        }

        public Criteria andElecCodeLikeInsensitive(String value) {
            addCriterion("upper(elec_code) like", value.toUpperCase(), "elecCode");
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