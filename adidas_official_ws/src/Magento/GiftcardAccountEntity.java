/**
 * GiftcardAccountEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Magento;

public class GiftcardAccountEntity  implements java.io.Serializable {
    private java.lang.Integer giftcard_id;

    private java.lang.String code;

    private java.lang.Integer store_id;

    private java.lang.String date_created;

    private java.lang.String expire_date;

    private java.lang.Integer is_active;

    private java.lang.Integer is_redeemable;

    private java.lang.String status;

    private java.lang.Double balance;

    private Magento.GiftcardAccountEntityHistory[] history;

    public GiftcardAccountEntity() {
    }

    public GiftcardAccountEntity(
           java.lang.Integer giftcard_id,
           java.lang.String code,
           java.lang.Integer store_id,
           java.lang.String date_created,
           java.lang.String expire_date,
           java.lang.Integer is_active,
           java.lang.Integer is_redeemable,
           java.lang.String status,
           java.lang.Double balance,
           Magento.GiftcardAccountEntityHistory[] history) {
           this.giftcard_id = giftcard_id;
           this.code = code;
           this.store_id = store_id;
           this.date_created = date_created;
           this.expire_date = expire_date;
           this.is_active = is_active;
           this.is_redeemable = is_redeemable;
           this.status = status;
           this.balance = balance;
           this.history = history;
    }


    /**
     * Gets the giftcard_id value for this GiftcardAccountEntity.
     * 
     * @return giftcard_id
     */
    public java.lang.Integer getGiftcard_id() {
        return giftcard_id;
    }


    /**
     * Sets the giftcard_id value for this GiftcardAccountEntity.
     * 
     * @param giftcard_id
     */
    public void setGiftcard_id(java.lang.Integer giftcard_id) {
        this.giftcard_id = giftcard_id;
    }


    /**
     * Gets the code value for this GiftcardAccountEntity.
     * 
     * @return code
     */
    public java.lang.String getCode() {
        return code;
    }


    /**
     * Sets the code value for this GiftcardAccountEntity.
     * 
     * @param code
     */
    public void setCode(java.lang.String code) {
        this.code = code;
    }


    /**
     * Gets the store_id value for this GiftcardAccountEntity.
     * 
     * @return store_id
     */
    public java.lang.Integer getStore_id() {
        return store_id;
    }


    /**
     * Sets the store_id value for this GiftcardAccountEntity.
     * 
     * @param store_id
     */
    public void setStore_id(java.lang.Integer store_id) {
        this.store_id = store_id;
    }


    /**
     * Gets the date_created value for this GiftcardAccountEntity.
     * 
     * @return date_created
     */
    public java.lang.String getDate_created() {
        return date_created;
    }


    /**
     * Sets the date_created value for this GiftcardAccountEntity.
     * 
     * @param date_created
     */
    public void setDate_created(java.lang.String date_created) {
        this.date_created = date_created;
    }


    /**
     * Gets the expire_date value for this GiftcardAccountEntity.
     * 
     * @return expire_date
     */
    public java.lang.String getExpire_date() {
        return expire_date;
    }


    /**
     * Sets the expire_date value for this GiftcardAccountEntity.
     * 
     * @param expire_date
     */
    public void setExpire_date(java.lang.String expire_date) {
        this.expire_date = expire_date;
    }


    /**
     * Gets the is_active value for this GiftcardAccountEntity.
     * 
     * @return is_active
     */
    public java.lang.Integer getIs_active() {
        return is_active;
    }


    /**
     * Sets the is_active value for this GiftcardAccountEntity.
     * 
     * @param is_active
     */
    public void setIs_active(java.lang.Integer is_active) {
        this.is_active = is_active;
    }


    /**
     * Gets the is_redeemable value for this GiftcardAccountEntity.
     * 
     * @return is_redeemable
     */
    public java.lang.Integer getIs_redeemable() {
        return is_redeemable;
    }


    /**
     * Sets the is_redeemable value for this GiftcardAccountEntity.
     * 
     * @param is_redeemable
     */
    public void setIs_redeemable(java.lang.Integer is_redeemable) {
        this.is_redeemable = is_redeemable;
    }


    /**
     * Gets the status value for this GiftcardAccountEntity.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this GiftcardAccountEntity.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the balance value for this GiftcardAccountEntity.
     * 
     * @return balance
     */
    public java.lang.Double getBalance() {
        return balance;
    }


    /**
     * Sets the balance value for this GiftcardAccountEntity.
     * 
     * @param balance
     */
    public void setBalance(java.lang.Double balance) {
        this.balance = balance;
    }


    /**
     * Gets the history value for this GiftcardAccountEntity.
     * 
     * @return history
     */
    public Magento.GiftcardAccountEntityHistory[] getHistory() {
        return history;
    }


    /**
     * Sets the history value for this GiftcardAccountEntity.
     * 
     * @param history
     */
    public void setHistory(Magento.GiftcardAccountEntityHistory[] history) {
        this.history = history;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GiftcardAccountEntity)) return false;
        GiftcardAccountEntity other = (GiftcardAccountEntity) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.giftcard_id==null && other.getGiftcard_id()==null) || 
             (this.giftcard_id!=null &&
              this.giftcard_id.equals(other.getGiftcard_id()))) &&
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.store_id==null && other.getStore_id()==null) || 
             (this.store_id!=null &&
              this.store_id.equals(other.getStore_id()))) &&
            ((this.date_created==null && other.getDate_created()==null) || 
             (this.date_created!=null &&
              this.date_created.equals(other.getDate_created()))) &&
            ((this.expire_date==null && other.getExpire_date()==null) || 
             (this.expire_date!=null &&
              this.expire_date.equals(other.getExpire_date()))) &&
            ((this.is_active==null && other.getIs_active()==null) || 
             (this.is_active!=null &&
              this.is_active.equals(other.getIs_active()))) &&
            ((this.is_redeemable==null && other.getIs_redeemable()==null) || 
             (this.is_redeemable!=null &&
              this.is_redeemable.equals(other.getIs_redeemable()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.balance==null && other.getBalance()==null) || 
             (this.balance!=null &&
              this.balance.equals(other.getBalance()))) &&
            ((this.history==null && other.getHistory()==null) || 
             (this.history!=null &&
              java.util.Arrays.equals(this.history, other.getHistory())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getGiftcard_id() != null) {
            _hashCode += getGiftcard_id().hashCode();
        }
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getStore_id() != null) {
            _hashCode += getStore_id().hashCode();
        }
        if (getDate_created() != null) {
            _hashCode += getDate_created().hashCode();
        }
        if (getExpire_date() != null) {
            _hashCode += getExpire_date().hashCode();
        }
        if (getIs_active() != null) {
            _hashCode += getIs_active().hashCode();
        }
        if (getIs_redeemable() != null) {
            _hashCode += getIs_redeemable().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getBalance() != null) {
            _hashCode += getBalance().hashCode();
        }
        if (getHistory() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHistory());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHistory(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GiftcardAccountEntity.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Magento", "giftcardAccountEntity"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("giftcard_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "giftcard_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("store_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "store_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date_created");
        elemField.setXmlName(new javax.xml.namespace.QName("", "date_created"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expire_date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "expire_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("is_active");
        elemField.setXmlName(new javax.xml.namespace.QName("", "is_active"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("is_redeemable");
        elemField.setXmlName(new javax.xml.namespace.QName("", "is_redeemable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("balance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "balance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("history");
        elemField.setXmlName(new javax.xml.namespace.QName("", "history"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Magento", "giftcardAccountEntityHistory"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
