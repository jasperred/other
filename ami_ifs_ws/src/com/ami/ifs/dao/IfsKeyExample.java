package com.ami.ifs.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IfsKeyExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Ifs_Key
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Ifs_Key
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Ifs_Key
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Key
     *
     * @mbggenerated
     */
    public IfsKeyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Key
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Key
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Key
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Key
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Key
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Key
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Key
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
     * This method corresponds to the database table Ifs_Key
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
     * This method corresponds to the database table Ifs_Key
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Key
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
     * This class corresponds to the database table Ifs_Key
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

        public Criteria andIfsKeyIdIsNull() {
            addCriterion("Ifs_Key_Id is null");
            return (Criteria) this;
        }

        public Criteria andIfsKeyIdIsNotNull() {
            addCriterion("Ifs_Key_Id is not null");
            return (Criteria) this;
        }

        public Criteria andIfsKeyIdEqualTo(Integer value) {
            addCriterion("Ifs_Key_Id =", value, "ifsKeyId");
            return (Criteria) this;
        }

        public Criteria andIfsKeyIdNotEqualTo(Integer value) {
            addCriterion("Ifs_Key_Id <>", value, "ifsKeyId");
            return (Criteria) this;
        }

        public Criteria andIfsKeyIdGreaterThan(Integer value) {
            addCriterion("Ifs_Key_Id >", value, "ifsKeyId");
            return (Criteria) this;
        }

        public Criteria andIfsKeyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Ifs_Key_Id >=", value, "ifsKeyId");
            return (Criteria) this;
        }

        public Criteria andIfsKeyIdLessThan(Integer value) {
            addCriterion("Ifs_Key_Id <", value, "ifsKeyId");
            return (Criteria) this;
        }

        public Criteria andIfsKeyIdLessThanOrEqualTo(Integer value) {
            addCriterion("Ifs_Key_Id <=", value, "ifsKeyId");
            return (Criteria) this;
        }

        public Criteria andIfsKeyIdIn(List<Integer> values) {
            addCriterion("Ifs_Key_Id in", values, "ifsKeyId");
            return (Criteria) this;
        }

        public Criteria andIfsKeyIdNotIn(List<Integer> values) {
            addCriterion("Ifs_Key_Id not in", values, "ifsKeyId");
            return (Criteria) this;
        }

        public Criteria andIfsKeyIdBetween(Integer value1, Integer value2) {
            addCriterion("Ifs_Key_Id between", value1, value2, "ifsKeyId");
            return (Criteria) this;
        }

        public Criteria andIfsKeyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Ifs_Key_Id not between", value1, value2, "ifsKeyId");
            return (Criteria) this;
        }

        public Criteria andWsKeyIsNull() {
            addCriterion("Ws_Key is null");
            return (Criteria) this;
        }

        public Criteria andWsKeyIsNotNull() {
            addCriterion("Ws_Key is not null");
            return (Criteria) this;
        }

        public Criteria andWsKeyEqualTo(String value) {
            addCriterion("Ws_Key =", value, "wsKey");
            return (Criteria) this;
        }

        public Criteria andWsKeyNotEqualTo(String value) {
            addCriterion("Ws_Key <>", value, "wsKey");
            return (Criteria) this;
        }

        public Criteria andWsKeyGreaterThan(String value) {
            addCriterion("Ws_Key >", value, "wsKey");
            return (Criteria) this;
        }

        public Criteria andWsKeyGreaterThanOrEqualTo(String value) {
            addCriterion("Ws_Key >=", value, "wsKey");
            return (Criteria) this;
        }

        public Criteria andWsKeyLessThan(String value) {
            addCriterion("Ws_Key <", value, "wsKey");
            return (Criteria) this;
        }

        public Criteria andWsKeyLessThanOrEqualTo(String value) {
            addCriterion("Ws_Key <=", value, "wsKey");
            return (Criteria) this;
        }

        public Criteria andWsKeyLike(String value) {
            addCriterion("Ws_Key like", value, "wsKey");
            return (Criteria) this;
        }

        public Criteria andWsKeyNotLike(String value) {
            addCriterion("Ws_Key not like", value, "wsKey");
            return (Criteria) this;
        }

        public Criteria andWsKeyIn(List<String> values) {
            addCriterion("Ws_Key in", values, "wsKey");
            return (Criteria) this;
        }

        public Criteria andWsKeyNotIn(List<String> values) {
            addCriterion("Ws_Key not in", values, "wsKey");
            return (Criteria) this;
        }

        public Criteria andWsKeyBetween(String value1, String value2) {
            addCriterion("Ws_Key between", value1, value2, "wsKey");
            return (Criteria) this;
        }

        public Criteria andWsKeyNotBetween(String value1, String value2) {
            addCriterion("Ws_Key not between", value1, value2, "wsKey");
            return (Criteria) this;
        }

        public Criteria andIfsCdIsNull() {
            addCriterion("Ifs_Cd is null");
            return (Criteria) this;
        }

        public Criteria andIfsCdIsNotNull() {
            addCriterion("Ifs_Cd is not null");
            return (Criteria) this;
        }

        public Criteria andIfsCdEqualTo(String value) {
            addCriterion("Ifs_Cd =", value, "ifsCd");
            return (Criteria) this;
        }

        public Criteria andIfsCdNotEqualTo(String value) {
            addCriterion("Ifs_Cd <>", value, "ifsCd");
            return (Criteria) this;
        }

        public Criteria andIfsCdGreaterThan(String value) {
            addCriterion("Ifs_Cd >", value, "ifsCd");
            return (Criteria) this;
        }

        public Criteria andIfsCdGreaterThanOrEqualTo(String value) {
            addCriterion("Ifs_Cd >=", value, "ifsCd");
            return (Criteria) this;
        }

        public Criteria andIfsCdLessThan(String value) {
            addCriterion("Ifs_Cd <", value, "ifsCd");
            return (Criteria) this;
        }

        public Criteria andIfsCdLessThanOrEqualTo(String value) {
            addCriterion("Ifs_Cd <=", value, "ifsCd");
            return (Criteria) this;
        }

        public Criteria andIfsCdLike(String value) {
            addCriterion("Ifs_Cd like", value, "ifsCd");
            return (Criteria) this;
        }

        public Criteria andIfsCdNotLike(String value) {
            addCriterion("Ifs_Cd not like", value, "ifsCd");
            return (Criteria) this;
        }

        public Criteria andIfsCdIn(List<String> values) {
            addCriterion("Ifs_Cd in", values, "ifsCd");
            return (Criteria) this;
        }

        public Criteria andIfsCdNotIn(List<String> values) {
            addCriterion("Ifs_Cd not in", values, "ifsCd");
            return (Criteria) this;
        }

        public Criteria andIfsCdBetween(String value1, String value2) {
            addCriterion("Ifs_Cd between", value1, value2, "ifsCd");
            return (Criteria) this;
        }

        public Criteria andIfsCdNotBetween(String value1, String value2) {
            addCriterion("Ifs_Cd not between", value1, value2, "ifsCd");
            return (Criteria) this;
        }

        public Criteria andWsTypeIsNull() {
            addCriterion("Ws_Type is null");
            return (Criteria) this;
        }

        public Criteria andWsTypeIsNotNull() {
            addCriterion("Ws_Type is not null");
            return (Criteria) this;
        }

        public Criteria andWsTypeEqualTo(String value) {
            addCriterion("Ws_Type =", value, "wsType");
            return (Criteria) this;
        }

        public Criteria andWsTypeNotEqualTo(String value) {
            addCriterion("Ws_Type <>", value, "wsType");
            return (Criteria) this;
        }

        public Criteria andWsTypeGreaterThan(String value) {
            addCriterion("Ws_Type >", value, "wsType");
            return (Criteria) this;
        }

        public Criteria andWsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("Ws_Type >=", value, "wsType");
            return (Criteria) this;
        }

        public Criteria andWsTypeLessThan(String value) {
            addCriterion("Ws_Type <", value, "wsType");
            return (Criteria) this;
        }

        public Criteria andWsTypeLessThanOrEqualTo(String value) {
            addCriterion("Ws_Type <=", value, "wsType");
            return (Criteria) this;
        }

        public Criteria andWsTypeLike(String value) {
            addCriterion("Ws_Type like", value, "wsType");
            return (Criteria) this;
        }

        public Criteria andWsTypeNotLike(String value) {
            addCriterion("Ws_Type not like", value, "wsType");
            return (Criteria) this;
        }

        public Criteria andWsTypeIn(List<String> values) {
            addCriterion("Ws_Type in", values, "wsType");
            return (Criteria) this;
        }

        public Criteria andWsTypeNotIn(List<String> values) {
            addCriterion("Ws_Type not in", values, "wsType");
            return (Criteria) this;
        }

        public Criteria andWsTypeBetween(String value1, String value2) {
            addCriterion("Ws_Type between", value1, value2, "wsType");
            return (Criteria) this;
        }

        public Criteria andWsTypeNotBetween(String value1, String value2) {
            addCriterion("Ws_Type not between", value1, value2, "wsType");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("Create_Time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("Create_Time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("Create_Time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("Create_Time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("Create_Time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Create_Time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("Create_Time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("Create_Time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("Create_Time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("Create_Time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("Create_Time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("Create_Time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeIsNull() {
            addCriterion("Invalid_Time is null");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeIsNotNull() {
            addCriterion("Invalid_Time is not null");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeEqualTo(Date value) {
            addCriterion("Invalid_Time =", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeNotEqualTo(Date value) {
            addCriterion("Invalid_Time <>", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeGreaterThan(Date value) {
            addCriterion("Invalid_Time >", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Invalid_Time >=", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeLessThan(Date value) {
            addCriterion("Invalid_Time <", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeLessThanOrEqualTo(Date value) {
            addCriterion("Invalid_Time <=", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeIn(List<Date> values) {
            addCriterion("Invalid_Time in", values, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeNotIn(List<Date> values) {
            addCriterion("Invalid_Time not in", values, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeBetween(Date value1, Date value2) {
            addCriterion("Invalid_Time between", value1, value2, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeNotBetween(Date value1, Date value2) {
            addCriterion("Invalid_Time not between", value1, value2, "invalidTime");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("Status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("Status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("Status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Ifs_Key
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
     * This class corresponds to the database table Ifs_Key
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