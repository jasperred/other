package com.ami.ec.channel.dao.asp;

import com.ami.ec.channel.domain.asp.AspIfsKey;
import com.ami.ec.channel.domain.asp.AspIfsKeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AspIfsKeyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_key
     *
     * @mbggenerated
     */
    int countByExample(AspIfsKeyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_key
     *
     * @mbggenerated
     */
    int deleteByExample(AspIfsKeyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_key
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer ifsKeyId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_key
     *
     * @mbggenerated
     */
    int insert(AspIfsKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_key
     *
     * @mbggenerated
     */
    int insertSelective(AspIfsKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_key
     *
     * @mbggenerated
     */
    List<AspIfsKey> selectByExample(AspIfsKeyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_key
     *
     * @mbggenerated
     */
    AspIfsKey selectByPrimaryKey(Integer ifsKeyId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_key
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AspIfsKey record, @Param("example") AspIfsKeyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_key
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AspIfsKey record, @Param("example") AspIfsKeyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_key
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AspIfsKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_key
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AspIfsKey record);
}