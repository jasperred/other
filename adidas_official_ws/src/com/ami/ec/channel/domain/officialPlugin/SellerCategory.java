package com.ami.ec.channel.domain.officialPlugin;

public class SellerCategory {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Seller_category.Seller_cat_id
     *
     * @mbggenerated
     */
    private String sellerCatId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Seller_category.Seller_cat_no
     *
     * @mbggenerated
     */
    private String sellerCatNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Seller_category.Seller_cat_name
     *
     * @mbggenerated
     */
    private String sellerCatName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Seller_category.Store_id
     *
     * @mbggenerated
     */
    private Long storeId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Seller_category.Seller_cat_id
     *
     * @return the value of Seller_category.Seller_cat_id
     *
     * @mbggenerated
     */
    public String getSellerCatId() {
        return sellerCatId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Seller_category.Seller_cat_id
     *
     * @param sellerCatId the value for Seller_category.Seller_cat_id
     *
     * @mbggenerated
     */
    public void setSellerCatId(String sellerCatId) {
        this.sellerCatId = sellerCatId == null ? null : sellerCatId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Seller_category.Seller_cat_no
     *
     * @return the value of Seller_category.Seller_cat_no
     *
     * @mbggenerated
     */
    public String getSellerCatNo() {
        return sellerCatNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Seller_category.Seller_cat_no
     *
     * @param sellerCatNo the value for Seller_category.Seller_cat_no
     *
     * @mbggenerated
     */
    public void setSellerCatNo(String sellerCatNo) {
        this.sellerCatNo = sellerCatNo == null ? null : sellerCatNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Seller_category.Seller_cat_name
     *
     * @return the value of Seller_category.Seller_cat_name
     *
     * @mbggenerated
     */
    public String getSellerCatName() {
        return sellerCatName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Seller_category.Seller_cat_name
     *
     * @param sellerCatName the value for Seller_category.Seller_cat_name
     *
     * @mbggenerated
     */
    public void setSellerCatName(String sellerCatName) {
        this.sellerCatName = sellerCatName == null ? null : sellerCatName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Seller_category.Store_id
     *
     * @return the value of Seller_category.Store_id
     *
     * @mbggenerated
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Seller_category.Store_id
     *
     * @param storeId the value for Seller_category.Store_id
     *
     * @mbggenerated
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}