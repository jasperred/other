package com.ami.ec.channel.dao.pluginManager;

import com.ami.ec.channel.domain.pluginManager.BatRecord;
import com.ami.ec.channel.domain.pluginManager.BatRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_record
     *
     * @mbggenerated
     */
    int countByExample(BatRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_record
     *
     * @mbggenerated
     */
    int deleteByExample(BatRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long batRecordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_record
     *
     * @mbggenerated
     */
    int insert(BatRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_record
     *
     * @mbggenerated
     */
    int insertSelective(BatRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_record
     *
     * @mbggenerated
     */
    List<BatRecord> selectByExample(BatRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_record
     *
     * @mbggenerated
     */
    BatRecord selectByPrimaryKey(Long batRecordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_record
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") BatRecord record, @Param("example") BatRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_record
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") BatRecord record, @Param("example") BatRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BatRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Bat_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BatRecord record);
}