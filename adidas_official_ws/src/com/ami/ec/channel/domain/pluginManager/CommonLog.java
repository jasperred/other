package com.ami.ec.channel.domain.pluginManager;

import java.util.Date;

public class CommonLog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Common_log.Id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Common_log.Is_abnormal
     *
     * @mbggenerated
     */
    private Boolean isAbnormal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Common_log.Log_time
     *
     * @mbggenerated
     */
    private Date logTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Common_log.Log_content
     *
     * @mbggenerated
     */
    private String logContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Common_log.Id
     *
     * @return the value of Common_log.Id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Common_log.Id
     *
     * @param id the value for Common_log.Id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Common_log.Is_abnormal
     *
     * @return the value of Common_log.Is_abnormal
     *
     * @mbggenerated
     */
    public Boolean getIsAbnormal() {
        return isAbnormal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Common_log.Is_abnormal
     *
     * @param isAbnormal the value for Common_log.Is_abnormal
     *
     * @mbggenerated
     */
    public void setIsAbnormal(Boolean isAbnormal) {
        this.isAbnormal = isAbnormal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Common_log.Log_time
     *
     * @return the value of Common_log.Log_time
     *
     * @mbggenerated
     */
    public Date getLogTime() {
        return logTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Common_log.Log_time
     *
     * @param logTime the value for Common_log.Log_time
     *
     * @mbggenerated
     */
    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Common_log.Log_content
     *
     * @return the value of Common_log.Log_content
     *
     * @mbggenerated
     */
    public String getLogContent() {
        return logContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Common_log.Log_content
     *
     * @param logContent the value for Common_log.Log_content
     *
     * @mbggenerated
     */
    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }
}