package com.ami.ec.channel.dao.asp;

import com.ami.ec.channel.domain.asp.AspIfsIDnIfHead;
import com.ami.ec.channel.domain.asp.AspIfsIDnIfHeadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AspIfsIDnIfHeadMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_i_dn_if_head
     *
     * @mbggenerated
     */
    int countByExample(AspIfsIDnIfHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_i_dn_if_head
     *
     * @mbggenerated
     */
    int deleteByExample(AspIfsIDnIfHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_i_dn_if_head
     *
     * @mbggenerated
     */
    int insert(AspIfsIDnIfHead record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_i_dn_if_head
     *
     * @mbggenerated
     */
    int insertSelective(AspIfsIDnIfHead record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_i_dn_if_head
     *
     * @mbggenerated
     */
    List<AspIfsIDnIfHead> selectByExample(AspIfsIDnIfHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_i_dn_if_head
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AspIfsIDnIfHead record, @Param("example") AspIfsIDnIfHeadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_i_dn_if_head
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AspIfsIDnIfHead record, @Param("example") AspIfsIDnIfHeadExample example);
}