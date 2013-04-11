package com.ami.ec.channel.dao.pluginManager;

import com.ami.ec.channel.domain.pluginManager.IfDefine;
import com.ami.ec.channel.domain.pluginManager.IfDefineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IfDefineMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IF_define
     *
     * @mbggenerated
     */
    int countByExample(IfDefineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IF_define
     *
     * @mbggenerated
     */
    int deleteByExample(IfDefineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IF_define
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer ifId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IF_define
     *
     * @mbggenerated
     */
    int insert(IfDefine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IF_define
     *
     * @mbggenerated
     */
    int insertSelective(IfDefine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IF_define
     *
     * @mbggenerated
     */
    List<IfDefine> selectByExampleWithBLOBs(IfDefineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IF_define
     *
     * @mbggenerated
     */
    List<IfDefine> selectByExample(IfDefineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IF_define
     *
     * @mbggenerated
     */
    IfDefine selectByPrimaryKey(Integer ifId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IF_define
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") IfDefine record, @Param("example") IfDefineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IF_define
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") IfDefine record, @Param("example") IfDefineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IF_define
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") IfDefine record, @Param("example") IfDefineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IF_define
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(IfDefine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IF_define
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(IfDefine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IF_define
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(IfDefine record);
}