package com.ami.ec.channel.dao.asp;

import com.ami.ec.channel.domain.asp.AspOrderHead;
import com.ami.ec.channel.domain.asp.AspOrderHeadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AspOrderHeadMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_head
     *
     * @mbggenerated
     */
    int countByExample(AspOrderHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_head
     *
     * @mbggenerated
     */
    int deleteByExample(AspOrderHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_head
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String orderHeadId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_head
     *
     * @mbggenerated
     */
    int insert(AspOrderHead record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_head
     *
     * @mbggenerated
     */
    int insertSelective(AspOrderHead record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_head
     *
     * @mbggenerated
     */
    List<AspOrderHead> selectByExampleWithBLOBs(AspOrderHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_head
     *
     * @mbggenerated
     */
    List<AspOrderHead> selectByExample(AspOrderHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_head
     *
     * @mbggenerated
     */
    AspOrderHead selectByPrimaryKey(String orderHeadId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_head
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AspOrderHead record, @Param("example") AspOrderHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_head
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") AspOrderHead record, @Param("example") AspOrderHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_head
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AspOrderHead record, @Param("example") AspOrderHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_head
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AspOrderHead record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_head
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AspOrderHead record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_head
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AspOrderHead record);
}