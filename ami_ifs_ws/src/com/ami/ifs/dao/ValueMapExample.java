package com.ami.ifs.dao;

import java.util.ArrayList;
import java.util.List;

public class ValueMapExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Value_map
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Value_map
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Value_map
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Value_map
     *
     * @mbggenerated
     */
    public ValueMapExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Value_map
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Value_map
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Value_map
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Value_map
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Value_map
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Value_map
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Value_map
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Value_map
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Value_map
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Value_map
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Value_map
     *
     * @mbggenerated
     */
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

        public Criteria andValueMapIdIsNull() {
            addCriterion("Value_map_id is null");
            return (Criteria) this;
        }

        public Criteria andValueMapIdIsNotNull() {
            addCriterion("Value_map_id is not null");
            return (Criteria) this;
        }

        public Criteria andValueMapIdEqualTo(Long value) {
            addCriterion("Value_map_id =", value, "valueMapId");
            return (Criteria) this;
        }

        public Criteria andValueMapIdNotEqualTo(Long value) {
            addCriterion("Value_map_id <>", value, "valueMapId");
            return (Criteria) this;
        }

        public Criteria andValueMapIdGreaterThan(Long value) {
            addCriterion("Value_map_id >", value, "valueMapId");
            return (Criteria) this;
        }

        public Criteria andValueMapIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Value_map_id >=", value, "valueMapId");
            return (Criteria) this;
        }

        public Criteria andValueMapIdLessThan(Long value) {
            addCriterion("Value_map_id <", value, "valueMapId");
            return (Criteria) this;
        }

        public Criteria andValueMapIdLessThanOrEqualTo(Long value) {
            addCriterion("Value_map_id <=", value, "valueMapId");
            return (Criteria) this;
        }

        public Criteria andValueMapIdIn(List<Long> values) {
            addCriterion("Value_map_id in", values, "valueMapId");
            return (Criteria) this;
        }

        public Criteria andValueMapIdNotIn(List<Long> values) {
            addCriterion("Value_map_id not in", values, "valueMapId");
            return (Criteria) this;
        }

        public Criteria andValueMapIdBetween(Long value1, Long value2) {
            addCriterion("Value_map_id between", value1, value2, "valueMapId");
            return (Criteria) this;
        }

        public Criteria andValueMapIdNotBetween(Long value1, Long value2) {
            addCriterion("Value_map_id not between", value1, value2, "valueMapId");
            return (Criteria) this;
        }

        public Criteria andCd1IsNull() {
            addCriterion("Cd1 is null");
            return (Criteria) this;
        }

        public Criteria andCd1IsNotNull() {
            addCriterion("Cd1 is not null");
            return (Criteria) this;
        }

        public Criteria andCd1EqualTo(String value) {
            addCriterion("Cd1 =", value, "cd1");
            return (Criteria) this;
        }

        public Criteria andCd1NotEqualTo(String value) {
            addCriterion("Cd1 <>", value, "cd1");
            return (Criteria) this;
        }

        public Criteria andCd1GreaterThan(String value) {
            addCriterion("Cd1 >", value, "cd1");
            return (Criteria) this;
        }

        public Criteria andCd1GreaterThanOrEqualTo(String value) {
            addCriterion("Cd1 >=", value, "cd1");
            return (Criteria) this;
        }

        public Criteria andCd1LessThan(String value) {
            addCriterion("Cd1 <", value, "cd1");
            return (Criteria) this;
        }

        public Criteria andCd1LessThanOrEqualTo(String value) {
            addCriterion("Cd1 <=", value, "cd1");
            return (Criteria) this;
        }

        public Criteria andCd1In(List<String> values) {
            addCriterion("Cd1 in", values, "cd1");
            return (Criteria) this;
        }

        public Criteria andCd1NotIn(List<String> values) {
            addCriterion("Cd1 not in", values, "cd1");
            return (Criteria) this;
        }

        public Criteria andCd1Between(String value1, String value2) {
            addCriterion("Cd1 between", value1, value2, "cd1");
            return (Criteria) this;
        }

        public Criteria andCd1NotBetween(String value1, String value2) {
            addCriterion("Cd1 not between", value1, value2, "cd1");
            return (Criteria) this;
        }

        public Criteria andCd2IsNull() {
            addCriterion("Cd2 is null");
            return (Criteria) this;
        }

        public Criteria andCd2IsNotNull() {
            addCriterion("Cd2 is not null");
            return (Criteria) this;
        }

        public Criteria andCd2EqualTo(String value) {
            addCriterion("Cd2 =", value, "cd2");
            return (Criteria) this;
        }

        public Criteria andCd2NotEqualTo(String value) {
            addCriterion("Cd2 <>", value, "cd2");
            return (Criteria) this;
        }

        public Criteria andCd2GreaterThan(String value) {
            addCriterion("Cd2 >", value, "cd2");
            return (Criteria) this;
        }

        public Criteria andCd2GreaterThanOrEqualTo(String value) {
            addCriterion("Cd2 >=", value, "cd2");
            return (Criteria) this;
        }

        public Criteria andCd2LessThan(String value) {
            addCriterion("Cd2 <", value, "cd2");
            return (Criteria) this;
        }

        public Criteria andCd2LessThanOrEqualTo(String value) {
            addCriterion("Cd2 <=", value, "cd2");
            return (Criteria) this;
        }

        public Criteria andCd2In(List<String> values) {
            addCriterion("Cd2 in", values, "cd2");
            return (Criteria) this;
        }

        public Criteria andCd2NotIn(List<String> values) {
            addCriterion("Cd2 not in", values, "cd2");
            return (Criteria) this;
        }

        public Criteria andCd2Between(String value1, String value2) {
            addCriterion("Cd2 between", value1, value2, "cd2");
            return (Criteria) this;
        }

        public Criteria andCd2NotBetween(String value1, String value2) {
            addCriterion("Cd2 not between", value1, value2, "cd2");
            return (Criteria) this;
        }

        public Criteria andCd3IsNull() {
            addCriterion("Cd3 is null");
            return (Criteria) this;
        }

        public Criteria andCd3IsNotNull() {
            addCriterion("Cd3 is not null");
            return (Criteria) this;
        }

        public Criteria andCd3EqualTo(String value) {
            addCriterion("Cd3 =", value, "cd3");
            return (Criteria) this;
        }

        public Criteria andCd3NotEqualTo(String value) {
            addCriterion("Cd3 <>", value, "cd3");
            return (Criteria) this;
        }

        public Criteria andCd3GreaterThan(String value) {
            addCriterion("Cd3 >", value, "cd3");
            return (Criteria) this;
        }

        public Criteria andCd3GreaterThanOrEqualTo(String value) {
            addCriterion("Cd3 >=", value, "cd3");
            return (Criteria) this;
        }

        public Criteria andCd3LessThan(String value) {
            addCriterion("Cd3 <", value, "cd3");
            return (Criteria) this;
        }

        public Criteria andCd3LessThanOrEqualTo(String value) {
            addCriterion("Cd3 <=", value, "cd3");
            return (Criteria) this;
        }

        public Criteria andCd3In(List<String> values) {
            addCriterion("Cd3 in", values, "cd3");
            return (Criteria) this;
        }

        public Criteria andCd3NotIn(List<String> values) {
            addCriterion("Cd3 not in", values, "cd3");
            return (Criteria) this;
        }

        public Criteria andCd3Between(String value1, String value2) {
            addCriterion("Cd3 between", value1, value2, "cd3");
            return (Criteria) this;
        }

        public Criteria andCd3NotBetween(String value1, String value2) {
            addCriterion("Cd3 not between", value1, value2, "cd3");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Value_map
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Value_map
     *
     * @mbggenerated
     */
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