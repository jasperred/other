package com.ami.ec.channel.dao.officialPlugin;

import com.ami.ec.channel.domain.officialPlugin.OrderLine;
import com.ami.ec.channel.domain.officialPlugin.OrderLineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderLineMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_line
     *
     * @mbggenerated
     */
    int countByExample(OrderLineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_line
     *
     * @mbggenerated
     */
    int deleteByExample(OrderLineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_line
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer orderLineId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_line
     *
     * @mbggenerated
     */
    int insert(OrderLine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_line
     *
     * @mbggenerated
     */
    int insertSelective(OrderLine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_line
     *
     * @mbggenerated
     */
    List<OrderLine> selectByExample(OrderLineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_line
     *
     * @mbggenerated
     */
    OrderLine selectByPrimaryKey(Integer orderLineId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_line
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") OrderLine record, @Param("example") OrderLineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_line
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") OrderLine record, @Param("example") OrderLineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_line
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OrderLine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Order_line
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OrderLine record);
}