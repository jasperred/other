package com.ami.ec.channel.dao.asp;

import com.ami.ec.channel.domain.asp.AspIfsUnit;
import com.ami.ec.channel.domain.asp.AspIfsUnitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AspIfsUnitMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_unit
     *
     * @mbggenerated
     */
    int countByExample(AspIfsUnitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_unit
     *
     * @mbggenerated
     */
    int deleteByExample(AspIfsUnitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_unit
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_unit
     *
     * @mbggenerated
     */
    int insert(AspIfsUnit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_unit
     *
     * @mbggenerated
     */
    int insertSelective(AspIfsUnit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_unit
     *
     * @mbggenerated
     */
    List<AspIfsUnit> selectByExample(AspIfsUnitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_unit
     *
     * @mbggenerated
     */
    AspIfsUnit selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_unit
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AspIfsUnit record, @Param("example") AspIfsUnitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_unit
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AspIfsUnit record, @Param("example") AspIfsUnitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_unit
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AspIfsUnit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_unit
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AspIfsUnit record);
}