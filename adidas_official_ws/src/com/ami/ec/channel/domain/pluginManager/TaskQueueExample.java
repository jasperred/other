package com.ami.ec.channel.domain.pluginManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskQueueExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    public TaskQueueExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
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
     * This method corresponds to the database table Task_queue
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
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
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
     * This class corresponds to the database table Task_queue
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

        public Criteria andTaskQueueIdIsNull() {
            addCriterion("Task_queue_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskQueueIdIsNotNull() {
            addCriterion("Task_queue_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskQueueIdEqualTo(Long value) {
            addCriterion("Task_queue_id =", value, "taskQueueId");
            return (Criteria) this;
        }

        public Criteria andTaskQueueIdNotEqualTo(Long value) {
            addCriterion("Task_queue_id <>", value, "taskQueueId");
            return (Criteria) this;
        }

        public Criteria andTaskQueueIdGreaterThan(Long value) {
            addCriterion("Task_queue_id >", value, "taskQueueId");
            return (Criteria) this;
        }

        public Criteria andTaskQueueIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Task_queue_id >=", value, "taskQueueId");
            return (Criteria) this;
        }

        public Criteria andTaskQueueIdLessThan(Long value) {
            addCriterion("Task_queue_id <", value, "taskQueueId");
            return (Criteria) this;
        }

        public Criteria andTaskQueueIdLessThanOrEqualTo(Long value) {
            addCriterion("Task_queue_id <=", value, "taskQueueId");
            return (Criteria) this;
        }

        public Criteria andTaskQueueIdIn(List<Long> values) {
            addCriterion("Task_queue_id in", values, "taskQueueId");
            return (Criteria) this;
        }

        public Criteria andTaskQueueIdNotIn(List<Long> values) {
            addCriterion("Task_queue_id not in", values, "taskQueueId");
            return (Criteria) this;
        }

        public Criteria andTaskQueueIdBetween(Long value1, Long value2) {
            addCriterion("Task_queue_id between", value1, value2, "taskQueueId");
            return (Criteria) this;
        }

        public Criteria andTaskQueueIdNotBetween(Long value1, Long value2) {
            addCriterion("Task_queue_id not between", value1, value2, "taskQueueId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("Task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("Task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("Task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("Task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("Task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("Task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("Task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("Task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("Task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("Task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("Start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("Start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("Start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("Start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("Start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("Start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("Start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("Start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("Start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("Start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("Start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("End_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("End_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("End_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("End_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("End_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("End_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("End_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("End_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("End_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("End_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("End_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("End_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andIsDealedIsNull() {
            addCriterion("Is_dealed is null");
            return (Criteria) this;
        }

        public Criteria andIsDealedIsNotNull() {
            addCriterion("Is_dealed is not null");
            return (Criteria) this;
        }

        public Criteria andIsDealedEqualTo(Boolean value) {
            addCriterion("Is_dealed =", value, "isDealed");
            return (Criteria) this;
        }

        public Criteria andIsDealedNotEqualTo(Boolean value) {
            addCriterion("Is_dealed <>", value, "isDealed");
            return (Criteria) this;
        }

        public Criteria andIsDealedGreaterThan(Boolean value) {
            addCriterion("Is_dealed >", value, "isDealed");
            return (Criteria) this;
        }

        public Criteria andIsDealedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("Is_dealed >=", value, "isDealed");
            return (Criteria) this;
        }

        public Criteria andIsDealedLessThan(Boolean value) {
            addCriterion("Is_dealed <", value, "isDealed");
            return (Criteria) this;
        }

        public Criteria andIsDealedLessThanOrEqualTo(Boolean value) {
            addCriterion("Is_dealed <=", value, "isDealed");
            return (Criteria) this;
        }

        public Criteria andIsDealedIn(List<Boolean> values) {
            addCriterion("Is_dealed in", values, "isDealed");
            return (Criteria) this;
        }

        public Criteria andIsDealedNotIn(List<Boolean> values) {
            addCriterion("Is_dealed not in", values, "isDealed");
            return (Criteria) this;
        }

        public Criteria andIsDealedBetween(Boolean value1, Boolean value2) {
            addCriterion("Is_dealed between", value1, value2, "isDealed");
            return (Criteria) this;
        }

        public Criteria andIsDealedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("Is_dealed not between", value1, value2, "isDealed");
            return (Criteria) this;
        }

        public Criteria andDealedTimeIsNull() {
            addCriterion("Dealed_time is null");
            return (Criteria) this;
        }

        public Criteria andDealedTimeIsNotNull() {
            addCriterion("Dealed_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealedTimeEqualTo(Date value) {
            addCriterion("Dealed_time =", value, "dealedTime");
            return (Criteria) this;
        }

        public Criteria andDealedTimeNotEqualTo(Date value) {
            addCriterion("Dealed_time <>", value, "dealedTime");
            return (Criteria) this;
        }

        public Criteria andDealedTimeGreaterThan(Date value) {
            addCriterion("Dealed_time >", value, "dealedTime");
            return (Criteria) this;
        }

        public Criteria andDealedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Dealed_time >=", value, "dealedTime");
            return (Criteria) this;
        }

        public Criteria andDealedTimeLessThan(Date value) {
            addCriterion("Dealed_time <", value, "dealedTime");
            return (Criteria) this;
        }

        public Criteria andDealedTimeLessThanOrEqualTo(Date value) {
            addCriterion("Dealed_time <=", value, "dealedTime");
            return (Criteria) this;
        }

        public Criteria andDealedTimeIn(List<Date> values) {
            addCriterion("Dealed_time in", values, "dealedTime");
            return (Criteria) this;
        }

        public Criteria andDealedTimeNotIn(List<Date> values) {
            addCriterion("Dealed_time not in", values, "dealedTime");
            return (Criteria) this;
        }

        public Criteria andDealedTimeBetween(Date value1, Date value2) {
            addCriterion("Dealed_time between", value1, value2, "dealedTime");
            return (Criteria) this;
        }

        public Criteria andDealedTimeNotBetween(Date value1, Date value2) {
            addCriterion("Dealed_time not between", value1, value2, "dealedTime");
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

        public Criteria andIsRightNowIsNull() {
            addCriterion("Is_right_now is null");
            return (Criteria) this;
        }

        public Criteria andIsRightNowIsNotNull() {
            addCriterion("Is_right_now is not null");
            return (Criteria) this;
        }

        public Criteria andIsRightNowEqualTo(Boolean value) {
            addCriterion("Is_right_now =", value, "isRightNow");
            return (Criteria) this;
        }

        public Criteria andIsRightNowNotEqualTo(Boolean value) {
            addCriterion("Is_right_now <>", value, "isRightNow");
            return (Criteria) this;
        }

        public Criteria andIsRightNowGreaterThan(Boolean value) {
            addCriterion("Is_right_now >", value, "isRightNow");
            return (Criteria) this;
        }

        public Criteria andIsRightNowGreaterThanOrEqualTo(Boolean value) {
            addCriterion("Is_right_now >=", value, "isRightNow");
            return (Criteria) this;
        }

        public Criteria andIsRightNowLessThan(Boolean value) {
            addCriterion("Is_right_now <", value, "isRightNow");
            return (Criteria) this;
        }

        public Criteria andIsRightNowLessThanOrEqualTo(Boolean value) {
            addCriterion("Is_right_now <=", value, "isRightNow");
            return (Criteria) this;
        }

        public Criteria andIsRightNowIn(List<Boolean> values) {
            addCriterion("Is_right_now in", values, "isRightNow");
            return (Criteria) this;
        }

        public Criteria andIsRightNowNotIn(List<Boolean> values) {
            addCriterion("Is_right_now not in", values, "isRightNow");
            return (Criteria) this;
        }

        public Criteria andIsRightNowBetween(Boolean value1, Boolean value2) {
            addCriterion("Is_right_now between", value1, value2, "isRightNow");
            return (Criteria) this;
        }

        public Criteria andIsRightNowNotBetween(Boolean value1, Boolean value2) {
            addCriterion("Is_right_now not between", value1, value2, "isRightNow");
            return (Criteria) this;
        }

        public Criteria andThreadnumIsNull() {
            addCriterion("ThreadNum is null");
            return (Criteria) this;
        }

        public Criteria andThreadnumIsNotNull() {
            addCriterion("ThreadNum is not null");
            return (Criteria) this;
        }

        public Criteria andThreadnumEqualTo(Integer value) {
            addCriterion("ThreadNum =", value, "threadnum");
            return (Criteria) this;
        }

        public Criteria andThreadnumNotEqualTo(Integer value) {
            addCriterion("ThreadNum <>", value, "threadnum");
            return (Criteria) this;
        }

        public Criteria andThreadnumGreaterThan(Integer value) {
            addCriterion("ThreadNum >", value, "threadnum");
            return (Criteria) this;
        }

        public Criteria andThreadnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ThreadNum >=", value, "threadnum");
            return (Criteria) this;
        }

        public Criteria andThreadnumLessThan(Integer value) {
            addCriterion("ThreadNum <", value, "threadnum");
            return (Criteria) this;
        }

        public Criteria andThreadnumLessThanOrEqualTo(Integer value) {
            addCriterion("ThreadNum <=", value, "threadnum");
            return (Criteria) this;
        }

        public Criteria andThreadnumIn(List<Integer> values) {
            addCriterion("ThreadNum in", values, "threadnum");
            return (Criteria) this;
        }

        public Criteria andThreadnumNotIn(List<Integer> values) {
            addCriterion("ThreadNum not in", values, "threadnum");
            return (Criteria) this;
        }

        public Criteria andThreadnumBetween(Integer value1, Integer value2) {
            addCriterion("ThreadNum between", value1, value2, "threadnum");
            return (Criteria) this;
        }

        public Criteria andThreadnumNotBetween(Integer value1, Integer value2) {
            addCriterion("ThreadNum not between", value1, value2, "threadnum");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdIsNull() {
            addCriterion("Operate_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdIsNotNull() {
            addCriterion("Operate_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdEqualTo(Integer value) {
            addCriterion("Operate_user_id =", value, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdNotEqualTo(Integer value) {
            addCriterion("Operate_user_id <>", value, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdGreaterThan(Integer value) {
            addCriterion("Operate_user_id >", value, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Operate_user_id >=", value, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdLessThan(Integer value) {
            addCriterion("Operate_user_id <", value, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("Operate_user_id <=", value, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdIn(List<Integer> values) {
            addCriterion("Operate_user_id in", values, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdNotIn(List<Integer> values) {
            addCriterion("Operate_user_id not in", values, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("Operate_user_id between", value1, value2, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Operate_user_id not between", value1, value2, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("Create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("Create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("Create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("Create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("Create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("Create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("Create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("Create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("Create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("Create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("Create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIsNull() {
            addCriterion("Operate_time is null");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIsNotNull() {
            addCriterion("Operate_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperateTimeEqualTo(Date value) {
            addCriterion("Operate_time =", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotEqualTo(Date value) {
            addCriterion("Operate_time <>", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeGreaterThan(Date value) {
            addCriterion("Operate_time >", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Operate_time >=", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeLessThan(Date value) {
            addCriterion("Operate_time <", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("Operate_time <=", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIn(List<Date> values) {
            addCriterion("Operate_time in", values, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotIn(List<Date> values) {
            addCriterion("Operate_time not in", values, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeBetween(Date value1, Date value2) {
            addCriterion("Operate_time between", value1, value2, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("Operate_time not between", value1, value2, "operateTime");
            return (Criteria) this;
        }

        public Criteria andIsFinishedIsNull() {
            addCriterion("Is_finished is null");
            return (Criteria) this;
        }

        public Criteria andIsFinishedIsNotNull() {
            addCriterion("Is_finished is not null");
            return (Criteria) this;
        }

        public Criteria andIsFinishedEqualTo(Boolean value) {
            addCriterion("Is_finished =", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedNotEqualTo(Boolean value) {
            addCriterion("Is_finished <>", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedGreaterThan(Boolean value) {
            addCriterion("Is_finished >", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("Is_finished >=", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedLessThan(Boolean value) {
            addCriterion("Is_finished <", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedLessThanOrEqualTo(Boolean value) {
            addCriterion("Is_finished <=", value, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedIn(List<Boolean> values) {
            addCriterion("Is_finished in", values, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedNotIn(List<Boolean> values) {
            addCriterion("Is_finished not in", values, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedBetween(Boolean value1, Boolean value2) {
            addCriterion("Is_finished between", value1, value2, "isFinished");
            return (Criteria) this;
        }

        public Criteria andIsFinishedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("Is_finished not between", value1, value2, "isFinished");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("Message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("Message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("Message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("Message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("Message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("Message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("Message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("Message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("Message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("Message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("Message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("Message not between", value1, value2, "message");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Task_queue
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
     * This class corresponds to the database table Task_queue
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