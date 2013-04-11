package com.ami.ifs.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IfsDbLogExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Ifs_Db_Log
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Ifs_Db_Log
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Ifs_Db_Log
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Db_Log
     *
     * @mbggenerated
     */
    public IfsDbLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Db_Log
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Db_Log
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Db_Log
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Db_Log
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Db_Log
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Db_Log
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Db_Log
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
     * This method corresponds to the database table Ifs_Db_Log
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
     * This method corresponds to the database table Ifs_Db_Log
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Db_Log
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
     * This class corresponds to the database table Ifs_Db_Log
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

        public Criteria andIfsDbLogIdIsNull() {
            addCriterion("Ifs_Db_Log_Id is null");
            return (Criteria) this;
        }

        public Criteria andIfsDbLogIdIsNotNull() {
            addCriterion("Ifs_Db_Log_Id is not null");
            return (Criteria) this;
        }

        public Criteria andIfsDbLogIdEqualTo(Integer value) {
            addCriterion("Ifs_Db_Log_Id =", value, "ifsDbLogId");
            return (Criteria) this;
        }

        public Criteria andIfsDbLogIdNotEqualTo(Integer value) {
            addCriterion("Ifs_Db_Log_Id <>", value, "ifsDbLogId");
            return (Criteria) this;
        }

        public Criteria andIfsDbLogIdGreaterThan(Integer value) {
            addCriterion("Ifs_Db_Log_Id >", value, "ifsDbLogId");
            return (Criteria) this;
        }

        public Criteria andIfsDbLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Ifs_Db_Log_Id >=", value, "ifsDbLogId");
            return (Criteria) this;
        }

        public Criteria andIfsDbLogIdLessThan(Integer value) {
            addCriterion("Ifs_Db_Log_Id <", value, "ifsDbLogId");
            return (Criteria) this;
        }

        public Criteria andIfsDbLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("Ifs_Db_Log_Id <=", value, "ifsDbLogId");
            return (Criteria) this;
        }

        public Criteria andIfsDbLogIdIn(List<Integer> values) {
            addCriterion("Ifs_Db_Log_Id in", values, "ifsDbLogId");
            return (Criteria) this;
        }

        public Criteria andIfsDbLogIdNotIn(List<Integer> values) {
            addCriterion("Ifs_Db_Log_Id not in", values, "ifsDbLogId");
            return (Criteria) this;
        }

        public Criteria andIfsDbLogIdBetween(Integer value1, Integer value2) {
            addCriterion("Ifs_Db_Log_Id between", value1, value2, "ifsDbLogId");
            return (Criteria) this;
        }

        public Criteria andIfsDbLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Ifs_Db_Log_Id not between", value1, value2, "ifsDbLogId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNull() {
            addCriterion("Store_Id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("Store_Id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(String value) {
            addCriterion("Store_Id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(String value) {
            addCriterion("Store_Id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(String value) {
            addCriterion("Store_Id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(String value) {
            addCriterion("Store_Id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(String value) {
            addCriterion("Store_Id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(String value) {
            addCriterion("Store_Id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLike(String value) {
            addCriterion("Store_Id like", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotLike(String value) {
            addCriterion("Store_Id not like", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<String> values) {
            addCriterion("Store_Id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<String> values) {
            addCriterion("Store_Id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(String value1, String value2) {
            addCriterion("Store_Id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(String value1, String value2) {
            addCriterion("Store_Id not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIsNull() {
            addCriterion("Operate_Type is null");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIsNotNull() {
            addCriterion("Operate_Type is not null");
            return (Criteria) this;
        }

        public Criteria andOperateTypeEqualTo(String value) {
            addCriterion("Operate_Type =", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotEqualTo(String value) {
            addCriterion("Operate_Type <>", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeGreaterThan(String value) {
            addCriterion("Operate_Type >", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("Operate_Type >=", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLessThan(String value) {
            addCriterion("Operate_Type <", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLessThanOrEqualTo(String value) {
            addCriterion("Operate_Type <=", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLike(String value) {
            addCriterion("Operate_Type like", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotLike(String value) {
            addCriterion("Operate_Type not like", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIn(List<String> values) {
            addCriterion("Operate_Type in", values, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotIn(List<String> values) {
            addCriterion("Operate_Type not in", values, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeBetween(String value1, String value2) {
            addCriterion("Operate_Type between", value1, value2, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotBetween(String value1, String value2) {
            addCriterion("Operate_Type not between", value1, value2, "operateType");
            return (Criteria) this;
        }

        public Criteria andIfsACdIsNull() {
            addCriterion("Ifs_A_Cd is null");
            return (Criteria) this;
        }

        public Criteria andIfsACdIsNotNull() {
            addCriterion("Ifs_A_Cd is not null");
            return (Criteria) this;
        }

        public Criteria andIfsACdEqualTo(String value) {
            addCriterion("Ifs_A_Cd =", value, "ifsACd");
            return (Criteria) this;
        }

        public Criteria andIfsACdNotEqualTo(String value) {
            addCriterion("Ifs_A_Cd <>", value, "ifsACd");
            return (Criteria) this;
        }

        public Criteria andIfsACdGreaterThan(String value) {
            addCriterion("Ifs_A_Cd >", value, "ifsACd");
            return (Criteria) this;
        }

        public Criteria andIfsACdGreaterThanOrEqualTo(String value) {
            addCriterion("Ifs_A_Cd >=", value, "ifsACd");
            return (Criteria) this;
        }

        public Criteria andIfsACdLessThan(String value) {
            addCriterion("Ifs_A_Cd <", value, "ifsACd");
            return (Criteria) this;
        }

        public Criteria andIfsACdLessThanOrEqualTo(String value) {
            addCriterion("Ifs_A_Cd <=", value, "ifsACd");
            return (Criteria) this;
        }

        public Criteria andIfsACdLike(String value) {
            addCriterion("Ifs_A_Cd like", value, "ifsACd");
            return (Criteria) this;
        }

        public Criteria andIfsACdNotLike(String value) {
            addCriterion("Ifs_A_Cd not like", value, "ifsACd");
            return (Criteria) this;
        }

        public Criteria andIfsACdIn(List<String> values) {
            addCriterion("Ifs_A_Cd in", values, "ifsACd");
            return (Criteria) this;
        }

        public Criteria andIfsACdNotIn(List<String> values) {
            addCriterion("Ifs_A_Cd not in", values, "ifsACd");
            return (Criteria) this;
        }

        public Criteria andIfsACdBetween(String value1, String value2) {
            addCriterion("Ifs_A_Cd between", value1, value2, "ifsACd");
            return (Criteria) this;
        }

        public Criteria andIfsACdNotBetween(String value1, String value2) {
            addCriterion("Ifs_A_Cd not between", value1, value2, "ifsACd");
            return (Criteria) this;
        }

        public Criteria andIfsCCdIsNull() {
            addCriterion("Ifs_C_Cd is null");
            return (Criteria) this;
        }

        public Criteria andIfsCCdIsNotNull() {
            addCriterion("Ifs_C_Cd is not null");
            return (Criteria) this;
        }

        public Criteria andIfsCCdEqualTo(String value) {
            addCriterion("Ifs_C_Cd =", value, "ifsCCd");
            return (Criteria) this;
        }

        public Criteria andIfsCCdNotEqualTo(String value) {
            addCriterion("Ifs_C_Cd <>", value, "ifsCCd");
            return (Criteria) this;
        }

        public Criteria andIfsCCdGreaterThan(String value) {
            addCriterion("Ifs_C_Cd >", value, "ifsCCd");
            return (Criteria) this;
        }

        public Criteria andIfsCCdGreaterThanOrEqualTo(String value) {
            addCriterion("Ifs_C_Cd >=", value, "ifsCCd");
            return (Criteria) this;
        }

        public Criteria andIfsCCdLessThan(String value) {
            addCriterion("Ifs_C_Cd <", value, "ifsCCd");
            return (Criteria) this;
        }

        public Criteria andIfsCCdLessThanOrEqualTo(String value) {
            addCriterion("Ifs_C_Cd <=", value, "ifsCCd");
            return (Criteria) this;
        }

        public Criteria andIfsCCdLike(String value) {
            addCriterion("Ifs_C_Cd like", value, "ifsCCd");
            return (Criteria) this;
        }

        public Criteria andIfsCCdNotLike(String value) {
            addCriterion("Ifs_C_Cd not like", value, "ifsCCd");
            return (Criteria) this;
        }

        public Criteria andIfsCCdIn(List<String> values) {
            addCriterion("Ifs_C_Cd in", values, "ifsCCd");
            return (Criteria) this;
        }

        public Criteria andIfsCCdNotIn(List<String> values) {
            addCriterion("Ifs_C_Cd not in", values, "ifsCCd");
            return (Criteria) this;
        }

        public Criteria andIfsCCdBetween(String value1, String value2) {
            addCriterion("Ifs_C_Cd between", value1, value2, "ifsCCd");
            return (Criteria) this;
        }

        public Criteria andIfsCCdNotBetween(String value1, String value2) {
            addCriterion("Ifs_C_Cd not between", value1, value2, "ifsCCd");
            return (Criteria) this;
        }

        public Criteria andStartOperateTimeIsNull() {
            addCriterion("Start_Operate_Time is null");
            return (Criteria) this;
        }

        public Criteria andStartOperateTimeIsNotNull() {
            addCriterion("Start_Operate_Time is not null");
            return (Criteria) this;
        }

        public Criteria andStartOperateTimeEqualTo(Date value) {
            addCriterion("Start_Operate_Time =", value, "startOperateTime");
            return (Criteria) this;
        }

        public Criteria andStartOperateTimeNotEqualTo(Date value) {
            addCriterion("Start_Operate_Time <>", value, "startOperateTime");
            return (Criteria) this;
        }

        public Criteria andStartOperateTimeGreaterThan(Date value) {
            addCriterion("Start_Operate_Time >", value, "startOperateTime");
            return (Criteria) this;
        }

        public Criteria andStartOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Start_Operate_Time >=", value, "startOperateTime");
            return (Criteria) this;
        }

        public Criteria andStartOperateTimeLessThan(Date value) {
            addCriterion("Start_Operate_Time <", value, "startOperateTime");
            return (Criteria) this;
        }

        public Criteria andStartOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("Start_Operate_Time <=", value, "startOperateTime");
            return (Criteria) this;
        }

        public Criteria andStartOperateTimeIn(List<Date> values) {
            addCriterion("Start_Operate_Time in", values, "startOperateTime");
            return (Criteria) this;
        }

        public Criteria andStartOperateTimeNotIn(List<Date> values) {
            addCriterion("Start_Operate_Time not in", values, "startOperateTime");
            return (Criteria) this;
        }

        public Criteria andStartOperateTimeBetween(Date value1, Date value2) {
            addCriterion("Start_Operate_Time between", value1, value2, "startOperateTime");
            return (Criteria) this;
        }

        public Criteria andStartOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("Start_Operate_Time not between", value1, value2, "startOperateTime");
            return (Criteria) this;
        }

        public Criteria andEndOperateTimeIsNull() {
            addCriterion("End_Operate_Time is null");
            return (Criteria) this;
        }

        public Criteria andEndOperateTimeIsNotNull() {
            addCriterion("End_Operate_Time is not null");
            return (Criteria) this;
        }

        public Criteria andEndOperateTimeEqualTo(Date value) {
            addCriterion("End_Operate_Time =", value, "endOperateTime");
            return (Criteria) this;
        }

        public Criteria andEndOperateTimeNotEqualTo(Date value) {
            addCriterion("End_Operate_Time <>", value, "endOperateTime");
            return (Criteria) this;
        }

        public Criteria andEndOperateTimeGreaterThan(Date value) {
            addCriterion("End_Operate_Time >", value, "endOperateTime");
            return (Criteria) this;
        }

        public Criteria andEndOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("End_Operate_Time >=", value, "endOperateTime");
            return (Criteria) this;
        }

        public Criteria andEndOperateTimeLessThan(Date value) {
            addCriterion("End_Operate_Time <", value, "endOperateTime");
            return (Criteria) this;
        }

        public Criteria andEndOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("End_Operate_Time <=", value, "endOperateTime");
            return (Criteria) this;
        }

        public Criteria andEndOperateTimeIn(List<Date> values) {
            addCriterion("End_Operate_Time in", values, "endOperateTime");
            return (Criteria) this;
        }

        public Criteria andEndOperateTimeNotIn(List<Date> values) {
            addCriterion("End_Operate_Time not in", values, "endOperateTime");
            return (Criteria) this;
        }

        public Criteria andEndOperateTimeBetween(Date value1, Date value2) {
            addCriterion("End_Operate_Time between", value1, value2, "endOperateTime");
            return (Criteria) this;
        }

        public Criteria andEndOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("End_Operate_Time not between", value1, value2, "endOperateTime");
            return (Criteria) this;
        }

        public Criteria andOperateCountIsNull() {
            addCriterion("Operate_Count is null");
            return (Criteria) this;
        }

        public Criteria andOperateCountIsNotNull() {
            addCriterion("Operate_Count is not null");
            return (Criteria) this;
        }

        public Criteria andOperateCountEqualTo(Integer value) {
            addCriterion("Operate_Count =", value, "operateCount");
            return (Criteria) this;
        }

        public Criteria andOperateCountNotEqualTo(Integer value) {
            addCriterion("Operate_Count <>", value, "operateCount");
            return (Criteria) this;
        }

        public Criteria andOperateCountGreaterThan(Integer value) {
            addCriterion("Operate_Count >", value, "operateCount");
            return (Criteria) this;
        }

        public Criteria andOperateCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("Operate_Count >=", value, "operateCount");
            return (Criteria) this;
        }

        public Criteria andOperateCountLessThan(Integer value) {
            addCriterion("Operate_Count <", value, "operateCount");
            return (Criteria) this;
        }

        public Criteria andOperateCountLessThanOrEqualTo(Integer value) {
            addCriterion("Operate_Count <=", value, "operateCount");
            return (Criteria) this;
        }

        public Criteria andOperateCountIn(List<Integer> values) {
            addCriterion("Operate_Count in", values, "operateCount");
            return (Criteria) this;
        }

        public Criteria andOperateCountNotIn(List<Integer> values) {
            addCriterion("Operate_Count not in", values, "operateCount");
            return (Criteria) this;
        }

        public Criteria andOperateCountBetween(Integer value1, Integer value2) {
            addCriterion("Operate_Count between", value1, value2, "operateCount");
            return (Criteria) this;
        }

        public Criteria andOperateCountNotBetween(Integer value1, Integer value2) {
            addCriterion("Operate_Count not between", value1, value2, "operateCount");
            return (Criteria) this;
        }

        public Criteria andSuccessIsNull() {
            addCriterion("Success is null");
            return (Criteria) this;
        }

        public Criteria andSuccessIsNotNull() {
            addCriterion("Success is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessEqualTo(String value) {
            addCriterion("Success =", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessNotEqualTo(String value) {
            addCriterion("Success <>", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessGreaterThan(String value) {
            addCriterion("Success >", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessGreaterThanOrEqualTo(String value) {
            addCriterion("Success >=", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessLessThan(String value) {
            addCriterion("Success <", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessLessThanOrEqualTo(String value) {
            addCriterion("Success <=", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessLike(String value) {
            addCriterion("Success like", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessNotLike(String value) {
            addCriterion("Success not like", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessIn(List<String> values) {
            addCriterion("Success in", values, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessNotIn(List<String> values) {
            addCriterion("Success not in", values, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessBetween(String value1, String value2) {
            addCriterion("Success between", value1, value2, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessNotBetween(String value1, String value2) {
            addCriterion("Success not between", value1, value2, "success");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Ifs_Db_Log
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
     * This class corresponds to the database table Ifs_Db_Log
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