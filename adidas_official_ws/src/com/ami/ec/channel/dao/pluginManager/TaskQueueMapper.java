package com.ami.ec.channel.dao.pluginManager;

import com.ami.ec.channel.domain.pluginManager.TaskQueue;
import com.ami.ec.channel.domain.pluginManager.TaskQueueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskQueueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    int countByExample(TaskQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    int deleteByExample(TaskQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long taskQueueId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    int insert(TaskQueue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    int insertSelective(TaskQueue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    List<TaskQueue> selectByExample(TaskQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    TaskQueue selectByPrimaryKey(Long taskQueueId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TaskQueue record, @Param("example") TaskQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TaskQueue record, @Param("example") TaskQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TaskQueue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Task_queue
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TaskQueue record);
}