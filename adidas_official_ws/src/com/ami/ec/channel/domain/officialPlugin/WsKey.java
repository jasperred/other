package com.ami.ec.channel.domain.officialPlugin;

public class WsKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Ws_key.user_no
     *
     * @mbggenerated
     */
    private String userNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Ws_key.ws_key
     *
     * @mbggenerated
     */
    private String wsKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Ws_key.status
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Ws_key.store_id
     *
     * @mbggenerated
     */
    private Long storeId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Ws_key.user_no
     *
     * @return the value of Ws_key.user_no
     *
     * @mbggenerated
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Ws_key.user_no
     *
     * @param userNo the value for Ws_key.user_no
     *
     * @mbggenerated
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Ws_key.ws_key
     *
     * @return the value of Ws_key.ws_key
     *
     * @mbggenerated
     */
    public String getWsKey() {
        return wsKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Ws_key.ws_key
     *
     * @param wsKey the value for Ws_key.ws_key
     *
     * @mbggenerated
     */
    public void setWsKey(String wsKey) {
        this.wsKey = wsKey == null ? null : wsKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Ws_key.status
     *
     * @return the value of Ws_key.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Ws_key.status
     *
     * @param status the value for Ws_key.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Ws_key.store_id
     *
     * @return the value of Ws_key.store_id
     *
     * @mbggenerated
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Ws_key.store_id
     *
     * @param storeId the value for Ws_key.store_id
     *
     * @mbggenerated
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}