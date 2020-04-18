package com.gtmdtest.platform.model.entity;

import java.util.ArrayList;
import java.util.List;

public class TestInterfaceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestInterfaceExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andItfNameIsNull() {
            addCriterion("itf_name is null");
            return (Criteria) this;
        }

        public Criteria andItfNameIsNotNull() {
            addCriterion("itf_name is not null");
            return (Criteria) this;
        }

        public Criteria andItfNameEqualTo(String value) {
            addCriterion("itf_name =", value, "itfName");
            return (Criteria) this;
        }

        public Criteria andItfNameNotEqualTo(String value) {
            addCriterion("itf_name <>", value, "itfName");
            return (Criteria) this;
        }

        public Criteria andItfNameGreaterThan(String value) {
            addCriterion("itf_name >", value, "itfName");
            return (Criteria) this;
        }

        public Criteria andItfNameGreaterThanOrEqualTo(String value) {
            addCriterion("itf_name >=", value, "itfName");
            return (Criteria) this;
        }

        public Criteria andItfNameLessThan(String value) {
            addCriterion("itf_name <", value, "itfName");
            return (Criteria) this;
        }

        public Criteria andItfNameLessThanOrEqualTo(String value) {
            addCriterion("itf_name <=", value, "itfName");
            return (Criteria) this;
        }

        public Criteria andItfNameLike(String value) {
            addCriterion("itf_name like", value, "itfName");
            return (Criteria) this;
        }

        public Criteria andItfNameNotLike(String value) {
            addCriterion("itf_name not like", value, "itfName");
            return (Criteria) this;
        }

        public Criteria andItfNameIn(List<String> values) {
            addCriterion("itf_name in", values, "itfName");
            return (Criteria) this;
        }

        public Criteria andItfNameNotIn(List<String> values) {
            addCriterion("itf_name not in", values, "itfName");
            return (Criteria) this;
        }

        public Criteria andItfNameBetween(String value1, String value2) {
            addCriterion("itf_name between", value1, value2, "itfName");
            return (Criteria) this;
        }

        public Criteria andItfNameNotBetween(String value1, String value2) {
            addCriterion("itf_name not between", value1, value2, "itfName");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("method not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andParamsIsNull() {
            addCriterion("params is null");
            return (Criteria) this;
        }

        public Criteria andParamsIsNotNull() {
            addCriterion("params is not null");
            return (Criteria) this;
        }

        public Criteria andParamsEqualTo(String value) {
            addCriterion("params =", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotEqualTo(String value) {
            addCriterion("params <>", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThan(String value) {
            addCriterion("params >", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThanOrEqualTo(String value) {
            addCriterion("params >=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThan(String value) {
            addCriterion("params <", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThanOrEqualTo(String value) {
            addCriterion("params <=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLike(String value) {
            addCriterion("params like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotLike(String value) {
            addCriterion("params not like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsIn(List<String> values) {
            addCriterion("params in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotIn(List<String> values) {
            addCriterion("params not in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsBetween(String value1, String value2) {
            addCriterion("params between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotBetween(String value1, String value2) {
            addCriterion("params not between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andOutputIsNull() {
            addCriterion("output is null");
            return (Criteria) this;
        }

        public Criteria andOutputIsNotNull() {
            addCriterion("output is not null");
            return (Criteria) this;
        }

        public Criteria andOutputEqualTo(String value) {
            addCriterion("output =", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotEqualTo(String value) {
            addCriterion("output <>", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputGreaterThan(String value) {
            addCriterion("output >", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputGreaterThanOrEqualTo(String value) {
            addCriterion("output >=", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputLessThan(String value) {
            addCriterion("output <", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputLessThanOrEqualTo(String value) {
            addCriterion("output <=", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputLike(String value) {
            addCriterion("output like", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotLike(String value) {
            addCriterion("output not like", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputIn(List<String> values) {
            addCriterion("output in", values, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotIn(List<String> values) {
            addCriterion("output not in", values, "output");
            return (Criteria) this;
        }

        public Criteria andOutputBetween(String value1, String value2) {
            addCriterion("output between", value1, value2, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotBetween(String value1, String value2) {
            addCriterion("output not between", value1, value2, "output");
            return (Criteria) this;
        }

        public Criteria andItfHeadersIsNull() {
            addCriterion("itf_headers is null");
            return (Criteria) this;
        }

        public Criteria andItfHeadersIsNotNull() {
            addCriterion("itf_headers is not null");
            return (Criteria) this;
        }

        public Criteria andItfHeadersEqualTo(String value) {
            addCriterion("itf_headers =", value, "itfHeaders");
            return (Criteria) this;
        }

        public Criteria andItfHeadersNotEqualTo(String value) {
            addCriterion("itf_headers <>", value, "itfHeaders");
            return (Criteria) this;
        }

        public Criteria andItfHeadersGreaterThan(String value) {
            addCriterion("itf_headers >", value, "itfHeaders");
            return (Criteria) this;
        }

        public Criteria andItfHeadersGreaterThanOrEqualTo(String value) {
            addCriterion("itf_headers >=", value, "itfHeaders");
            return (Criteria) this;
        }

        public Criteria andItfHeadersLessThan(String value) {
            addCriterion("itf_headers <", value, "itfHeaders");
            return (Criteria) this;
        }

        public Criteria andItfHeadersLessThanOrEqualTo(String value) {
            addCriterion("itf_headers <=", value, "itfHeaders");
            return (Criteria) this;
        }

        public Criteria andItfHeadersLike(String value) {
            addCriterion("itf_headers like", value, "itfHeaders");
            return (Criteria) this;
        }

        public Criteria andItfHeadersNotLike(String value) {
            addCriterion("itf_headers not like", value, "itfHeaders");
            return (Criteria) this;
        }

        public Criteria andItfHeadersIn(List<String> values) {
            addCriterion("itf_headers in", values, "itfHeaders");
            return (Criteria) this;
        }

        public Criteria andItfHeadersNotIn(List<String> values) {
            addCriterion("itf_headers not in", values, "itfHeaders");
            return (Criteria) this;
        }

        public Criteria andItfHeadersBetween(String value1, String value2) {
            addCriterion("itf_headers between", value1, value2, "itfHeaders");
            return (Criteria) this;
        }

        public Criteria andItfHeadersNotBetween(String value1, String value2) {
            addCriterion("itf_headers not between", value1, value2, "itfHeaders");
            return (Criteria) this;
        }

        public Criteria andItfCookiesIsNull() {
            addCriterion("itf_cookies is null");
            return (Criteria) this;
        }

        public Criteria andItfCookiesIsNotNull() {
            addCriterion("itf_cookies is not null");
            return (Criteria) this;
        }

        public Criteria andItfCookiesEqualTo(String value) {
            addCriterion("itf_cookies =", value, "itfCookies");
            return (Criteria) this;
        }

        public Criteria andItfCookiesNotEqualTo(String value) {
            addCriterion("itf_cookies <>", value, "itfCookies");
            return (Criteria) this;
        }

        public Criteria andItfCookiesGreaterThan(String value) {
            addCriterion("itf_cookies >", value, "itfCookies");
            return (Criteria) this;
        }

        public Criteria andItfCookiesGreaterThanOrEqualTo(String value) {
            addCriterion("itf_cookies >=", value, "itfCookies");
            return (Criteria) this;
        }

        public Criteria andItfCookiesLessThan(String value) {
            addCriterion("itf_cookies <", value, "itfCookies");
            return (Criteria) this;
        }

        public Criteria andItfCookiesLessThanOrEqualTo(String value) {
            addCriterion("itf_cookies <=", value, "itfCookies");
            return (Criteria) this;
        }

        public Criteria andItfCookiesLike(String value) {
            addCriterion("itf_cookies like", value, "itfCookies");
            return (Criteria) this;
        }

        public Criteria andItfCookiesNotLike(String value) {
            addCriterion("itf_cookies not like", value, "itfCookies");
            return (Criteria) this;
        }

        public Criteria andItfCookiesIn(List<String> values) {
            addCriterion("itf_cookies in", values, "itfCookies");
            return (Criteria) this;
        }

        public Criteria andItfCookiesNotIn(List<String> values) {
            addCriterion("itf_cookies not in", values, "itfCookies");
            return (Criteria) this;
        }

        public Criteria andItfCookiesBetween(String value1, String value2) {
            addCriterion("itf_cookies between", value1, value2, "itfCookies");
            return (Criteria) this;
        }

        public Criteria andItfCookiesNotBetween(String value1, String value2) {
            addCriterion("itf_cookies not between", value1, value2, "itfCookies");
            return (Criteria) this;
        }

        public Criteria andItfAssertIsNull() {
            addCriterion("itf_assert is null");
            return (Criteria) this;
        }

        public Criteria andItfAssertIsNotNull() {
            addCriterion("itf_assert is not null");
            return (Criteria) this;
        }

        public Criteria andItfAssertEqualTo(String value) {
            addCriterion("itf_assert =", value, "itfAssert");
            return (Criteria) this;
        }

        public Criteria andItfAssertNotEqualTo(String value) {
            addCriterion("itf_assert <>", value, "itfAssert");
            return (Criteria) this;
        }

        public Criteria andItfAssertGreaterThan(String value) {
            addCriterion("itf_assert >", value, "itfAssert");
            return (Criteria) this;
        }

        public Criteria andItfAssertGreaterThanOrEqualTo(String value) {
            addCriterion("itf_assert >=", value, "itfAssert");
            return (Criteria) this;
        }

        public Criteria andItfAssertLessThan(String value) {
            addCriterion("itf_assert <", value, "itfAssert");
            return (Criteria) this;
        }

        public Criteria andItfAssertLessThanOrEqualTo(String value) {
            addCriterion("itf_assert <=", value, "itfAssert");
            return (Criteria) this;
        }

        public Criteria andItfAssertLike(String value) {
            addCriterion("itf_assert like", value, "itfAssert");
            return (Criteria) this;
        }

        public Criteria andItfAssertNotLike(String value) {
            addCriterion("itf_assert not like", value, "itfAssert");
            return (Criteria) this;
        }

        public Criteria andItfAssertIn(List<String> values) {
            addCriterion("itf_assert in", values, "itfAssert");
            return (Criteria) this;
        }

        public Criteria andItfAssertNotIn(List<String> values) {
            addCriterion("itf_assert not in", values, "itfAssert");
            return (Criteria) this;
        }

        public Criteria andItfAssertBetween(String value1, String value2) {
            addCriterion("itf_assert between", value1, value2, "itfAssert");
            return (Criteria) this;
        }

        public Criteria andItfAssertNotBetween(String value1, String value2) {
            addCriterion("itf_assert not between", value1, value2, "itfAssert");
            return (Criteria) this;
        }

        public Criteria andItfTempvalueIsNull() {
            addCriterion("itf_tempvalue is null");
            return (Criteria) this;
        }

        public Criteria andItfTempvalueIsNotNull() {
            addCriterion("itf_tempvalue is not null");
            return (Criteria) this;
        }

        public Criteria andItfTempvalueEqualTo(String value) {
            addCriterion("itf_tempvalue =", value, "itfTempvalue");
            return (Criteria) this;
        }

        public Criteria andItfTempvalueNotEqualTo(String value) {
            addCriterion("itf_tempvalue <>", value, "itfTempvalue");
            return (Criteria) this;
        }

        public Criteria andItfTempvalueGreaterThan(String value) {
            addCriterion("itf_tempvalue >", value, "itfTempvalue");
            return (Criteria) this;
        }

        public Criteria andItfTempvalueGreaterThanOrEqualTo(String value) {
            addCriterion("itf_tempvalue >=", value, "itfTempvalue");
            return (Criteria) this;
        }

        public Criteria andItfTempvalueLessThan(String value) {
            addCriterion("itf_tempvalue <", value, "itfTempvalue");
            return (Criteria) this;
        }

        public Criteria andItfTempvalueLessThanOrEqualTo(String value) {
            addCriterion("itf_tempvalue <=", value, "itfTempvalue");
            return (Criteria) this;
        }

        public Criteria andItfTempvalueLike(String value) {
            addCriterion("itf_tempvalue like", value, "itfTempvalue");
            return (Criteria) this;
        }

        public Criteria andItfTempvalueNotLike(String value) {
            addCriterion("itf_tempvalue not like", value, "itfTempvalue");
            return (Criteria) this;
        }

        public Criteria andItfTempvalueIn(List<String> values) {
            addCriterion("itf_tempvalue in", values, "itfTempvalue");
            return (Criteria) this;
        }

        public Criteria andItfTempvalueNotIn(List<String> values) {
            addCriterion("itf_tempvalue not in", values, "itfTempvalue");
            return (Criteria) this;
        }

        public Criteria andItfTempvalueBetween(String value1, String value2) {
            addCriterion("itf_tempvalue between", value1, value2, "itfTempvalue");
            return (Criteria) this;
        }

        public Criteria andItfTempvalueNotBetween(String value1, String value2) {
            addCriterion("itf_tempvalue not between", value1, value2, "itfTempvalue");
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