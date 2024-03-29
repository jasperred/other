package com.ami.ifs.dao;

import com.ami.ifs.dao.IfsStatus;
import com.ami.ifs.dao.IfsStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IfsStatusMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Status
     *
     * @mbggenerated
     */
    int countByExample(IfsStatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Status
     *
     * @mbggenerated
     */
    int deleteByExample(IfsStatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Status
     *
     * @mbggenerated
     */
    int insert(IfsStatus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Status
     *
     * @mbggenerated
     */
    int insertSelective(IfsStatus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Status
     *
     * @mbggenerated
     */
    List<IfsStatus> selectByExample(IfsStatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Status
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") IfsStatus record, @Param("example") IfsStatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ifs_Status
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") IfsStatus record, @Param("example") IfsStatusExample example);
}