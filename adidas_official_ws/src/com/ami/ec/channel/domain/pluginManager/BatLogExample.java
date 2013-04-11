package com.ami.ec.channel.domain.pluginManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BatLogExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Bat_log
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Bat_log
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Bat_log
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_log
     *
     * @mbggenerated
     */
    public BatLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_log
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_log
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_log
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_log
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_log
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_log
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_log
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
     * This method corresponds to the database table Bat_log
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
     * This method corresponds to the database table Bat_log
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_log
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
     * This class corresponds to the database table Bat_log
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

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBatRecordIdIsNull() {
            addCriterion("Bat_record_id is null");
            return (Criteria) this;
        }

        public Criteria andBatRecordIdIsNotNull() {
            addCriterion("Bat_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andBatRecordIdEqualTo(Long value) {
            addCriterion("Bat_record_id =", value, "batRecordId");
            return (Criteria) this;
        }

        public Criteria andBatRecordIdNotEqualTo(Long value) {
            addCriterion("Bat_record_id <>", value, "batRecordId");
            return (Criteria) this;
        }

        public Criteria andBatRecordIdGreaterThan(Long value) {
            addCriterion("Bat_record_id >", value, "batRecordId");
            return (Criteria) this;
        }

        public Criteria andBatRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Bat_record_id >=", value, "batRecordId");
            return (Criteria) this;
        }

        public Criteria andBatRecordIdLessThan(Long value) {
            addCriterion("Bat_record_id <", value, "batRecordId");
            return (Criteria) this;
        }

        public Criteria andBatRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("Bat_record_id <=", value, "batRecordId");
            return (Criteria) this;
        }

        public Criteria andBatRecordIdIn(List<Long> values) {
            addCriterion("Bat_record_id in", values, "batRecordId");
            return (Criteria) this;
        }

        public Criteria andBatRecordIdNotIn(List<Long> values) {
            addCriterion("Bat_record_id not in", values, "batRecordId");
            return (Criteria) this;
        }

        public Criteria andBatRecordIdBetween(Long value1, Long value2) {
            addCriterion("Bat_record_id between", value1, value2, "batRecordId");
            return (Criteria) this;
        }

        public Criteria andBatRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("Bat_record_id not between", value1, value2, "batRecordId");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNull() {
            addCriterion("Log_time is null");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNotNull() {
            addCriterion("Log_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogTimeEqualTo(Date value) {
            addCriterion("Log_time =", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotEqualTo(Date value) {
            addCriterion("Log_time <>", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThan(Date value) {
            addCriterion("Log_time >", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Log_time >=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThan(Date value) {
            addCriterion("Log_time <", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThanOrEqualTo(Date value) {
            addCriterion("Log_time <=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeIn(List<Date> values) {
            addCriterion("Log_time in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotIn(List<Date> values) {
            addCriterion("Log_time not in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeBetween(Date value1, Date value2) {
            addCriterion("Log_time between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotBetween(Date value1, Date value2) {
            addCriterion("Log_time not between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogContentIsNull() {
            addCriterion("Log_content is null");
            return (Criteria) this;
        }

        public Criteria andLogContentIsNotNull() {
            addCriterion("Log_content is not null");
            return (Criteria) this;
        }

        public Criteria andLogContentEqualTo(String value) {
            addCriterion("Log_content =", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentNotEqualTo(String value) {
            addCriterion("Log_content <>", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentGreaterThan(String value) {
            addCriterion("Log_content >", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentGreaterThanOrEqualTo(String value) {
            addCriterion("Log_content >=", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentLessThan(String value) {
            addCriterion("Log_content <", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentLessThanOrEqualTo(String value) {
            addCriterion("Log_content <=", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentIn(List<String> values) {
            addCriterion("Log_content in", values, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentNotIn(List<String> values) {
            addCriterion("Log_content not in", values, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentBetween(String value1, String value2) {
            addCriterion("Log_content between", value1, value2, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentNotBetween(String value1, String value2) {
            addCriterion("Log_content not between", value1, value2, "logContent");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalIsNull() {
            addCriterion("Is_abnormal is null");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalIsNotNull() {
            addCriterion("Is_abnormal is not null");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalEqualTo(Boolean value) {
            addCriterion("Is_abnormal =", value, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalNotEqualTo(Boolean value) {
            addCriterion("Is_abnormal <>", value, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalGreaterThan(Boolean value) {
            addCriterion("Is_abnormal >", value, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalGreaterThanOrEqualTo(Boolean value) {
            addCriterion("Is_abnormal >=", value, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalLessThan(Boolean value) {
            addCriterion("Is_abnormal <", value, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalLessThanOrEqualTo(Boolean value) {
            addCriterion("Is_abnormal <=", value, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalIn(List<Boolean> values) {
            addCriterion("Is_abnormal in", values, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalNotIn(List<Boolean> values) {
            addCriterion("Is_abnormal not in", values, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalBetween(Boolean value1, Boolean value2) {
            addCriterion("Is_abnormal between", value1, value2, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalNotBetween(Boolean value1, Boolean value2) {
            addCriterion("Is_abnormal not between", value1, value2, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andRefIdIsNull() {
            addCriterion("ref_id is null");
            return (Criteria) this;
        }

        public Criteria andRefIdIsNotNull() {
            addCriterion("ref_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefIdEqualTo(String value) {
            addCriterion("ref_id =", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdNotEqualTo(String value) {
            addCriterion("ref_id <>", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdGreaterThan(String value) {
            addCriterion("ref_id >", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdGreaterThanOrEqualTo(String value) {
            addCriterion("ref_id >=", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdLessThan(String value) {
            addCriterion("ref_id <", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdLessThanOrEqualTo(String value) {
            addCriterion("ref_id <=", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdLike(String value) {
            addCriterion("ref_id like", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdNotLike(String value) {
            addCriterion("ref_id not like", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdIn(List<String> values) {
            addCriterion("ref_id in", values, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdNotIn(List<String> values) {
            addCriterion("ref_id not in", values, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdBetween(String value1, String value2) {
            addCriterion("ref_id between", value1, value2, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdNotBetween(String value1, String value2) {
            addCriterion("ref_id not between", value1, value2, "refId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Bat_log
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
     * This class corresponds to the database table Bat_log
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