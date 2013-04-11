package com.ami.ifs.dao;

import com.ami.ifs.dao.FieldMap;
import com.ami.ifs.dao.FieldMapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FieldMapMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Field_map
     *
     * @mbggenerated
     */
    int countByExample(FieldMapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Field_map
     *
     * @mbggenerated
     */
    int deleteByExample(FieldMapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Field_map
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long fieldMapId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Field_map
     *
     * @mbggenerated
     */
    int insert(FieldMap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Field_map
     *
     * @mbggenerated
     */
    int insertSelective(FieldMap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Field_map
     *
     * @mbggenerated
     */
    List<FieldMap> selectByExample(FieldMapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Field_map
     *
     * @mbggenerated
     */
    FieldMap selectByPrimaryKey(Long fieldMapId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Field_map
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") FieldMap record, @Param("example") FieldMapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Field_map
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") FieldMap record, @Param("example") FieldMapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Field_map
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(FieldMap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Field_map
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(FieldMap record);
}