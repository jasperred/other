package com.ami.ifs.dao;

@javax.xml.bind.annotation.XmlType(name="ValueMapLine")
public class ValueMapLine {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Value_map_line.Value_map_line_id
     *
     * @mbggenerated
     */
    private Long valueMapLineId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Value_map_line.Value_map_id
     *
     * @mbggenerated
     */
    private Long valueMapId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Value_map_line.Org_prop
     *
     * @mbggenerated
     */
    private String orgProp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Value_map_line.Dest_prop
     *
     * @mbggenerated
     */
    private String destProp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Value_map_line.Org_value
     *
     * @mbggenerated
     */
    private String orgValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Value_map_line.Dest_value
     *
     * @mbggenerated
     */
    private String destValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Value_map_line.Status
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Value_map_line.Value_map_line_id
     *
     * @return the value of Value_map_line.Value_map_line_id
     *
     * @mbggenerated
     */
    public Long getValueMapLineId() {
        return valueMapLineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Value_map_line.Value_map_line_id
     *
     * @param valueMapLineId the value for Value_map_line.Value_map_line_id
     *
     * @mbggenerated
     */
    public void setValueMapLineId(Long valueMapLineId) {
        this.valueMapLineId = valueMapLineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Value_map_line.Value_map_id
     *
     * @return the value of Value_map_line.Value_map_id
     *
     * @mbggenerated
     */
    public Long getValueMapId() {
        return valueMapId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Value_map_line.Value_map_id
     *
     * @param valueMapId the value for Value_map_line.Value_map_id
     *
     * @mbggenerated
     */
    public void setValueMapId(Long valueMapId) {
        this.valueMapId = valueMapId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Value_map_line.Org_prop
     *
     * @return the value of Value_map_line.Org_prop
     *
     * @mbggenerated
     */
    public String getOrgProp() {
        return orgProp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Value_map_line.Org_prop
     *
     * @param orgProp the value for Value_map_line.Org_prop
     *
     * @mbggenerated
     */
    public void setOrgProp(String orgProp) {
        this.orgProp = orgProp == null ? null : orgProp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Value_map_line.Dest_prop
     *
     * @return the value of Value_map_line.Dest_prop
     *
     * @mbggenerated
     */
    public String getDestProp() {
        return destProp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Value_map_line.Dest_prop
     *
     * @param destProp the value for Value_map_line.Dest_prop
     *
     * @mbggenerated
     */
    public void setDestProp(String destProp) {
        this.destProp = destProp == null ? null : destProp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Value_map_line.Org_value
     *
     * @return the value of Value_map_line.Org_value
     *
     * @mbggenerated
     */
    public String getOrgValue() {
        return orgValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Value_map_line.Org_value
     *
     * @param orgValue the value for Value_map_line.Org_value
     *
     * @mbggenerated
     */
    public void setOrgValue(String orgValue) {
        this.orgValue = orgValue == null ? null : orgValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Value_map_line.Dest_value
     *
     * @return the value of Value_map_line.Dest_value
     *
     * @mbggenerated
     */
    public String getDestValue() {
        return destValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Value_map_line.Dest_value
     *
     * @param destValue the value for Value_map_line.Dest_value
     *
     * @mbggenerated
     */
    public void setDestValue(String destValue) {
        this.destValue = destValue == null ? null : destValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Value_map_line.Status
     *
     * @return the value of Value_map_line.Status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Value_map_line.Status
     *
     * @param status the value for Value_map_line.Status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}