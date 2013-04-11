package com.ami.ec.channel.dao.asp;

import com.ami.ec.channel.domain.asp.AspZlogOrderHead;
import com.ami.ec.channel.domain.asp.AspZlogOrderHeadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AspZlogOrderHeadMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Zlog_Order_head
     *
     * @mbggenerated
     */
    int countByExample(AspZlogOrderHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Zlog_Order_head
     *
     * @mbggenerated
     */
    int deleteByExample(AspZlogOrderHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Zlog_Order_head
     *
     * @mbggenerated
     */
    int insert(AspZlogOrderHead record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Zlog_Order_head
     *
     * @mbggenerated
     */
    int insertSelective(AspZlogOrderHead record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Zlog_Order_head
     *
     * @mbggenerated
     */
    List<AspZlogOrderHead> selectByExampleWithBLOBs(AspZlogOrderHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Zlog_Order_head
     *
     * @mbggenerated
     */
    List<AspZlogOrderHead> selectByExample(AspZlogOrderHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Zlog_Order_head
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AspZlogOrderHead record, @Param("example") AspZlogOrderHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Zlog_Order_head
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") AspZlogOrderHead record, @Param("example") AspZlogOrderHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Zlog_Order_head
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AspZlogOrderHead record, @Param("example") AspZlogOrderHeadExample example);
}