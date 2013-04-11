/**
 * EnterpriseGiftcardaccountListEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Magento;

public class EnterpriseGiftcardaccountListEntity  implements java.io.Serializable {
    private java.lang.String giftcardaccount_id;

    private java.lang.String code;

    private java.lang.String used_amount;

    private java.lang.String base_amount;

    public EnterpriseGiftcardaccountListEntity() {
    }

    public EnterpriseGiftcardaccountListEntity(
           java.lang.String giftcardaccount_id,
           java.lang.String code,
           java.lang.String used_amount,
           java.lang.String base_amount) {
           this.giftcardaccount_id = giftcardaccount_id;
           this.code = code;
           this.used_amount = used_amount;
           this.base_amount = base_amount;
    }


    /**
     * Gets the giftcardaccount_id value for this EnterpriseGiftcardaccountListEntity.
     * 
     * @return giftcardaccount_id
     */
    public java.lang.String getGiftcardaccount_id() {
        return giftcardaccount_id;
    }


    /**
     * Sets the giftcardaccount_id value for this EnterpriseGiftcardaccountListEntity.
     * 
     * @param giftcardaccount_id
     */
    public void setGiftcardaccount_id(java.lang.String giftcardaccount_id) {
        this.giftcardaccount_id = giftcardaccount_id;
    }


    /**
     * Gets the code value for this EnterpriseGiftcardaccountListEntity.
     * 
     * @return code
     */
    public java.lang.String getCode() {
        return code;
    }


    /**
     * Sets the code value for this EnterpriseGiftcardaccountListEntity.
     * 
     * @param code
     */
    public void setCode(java.lang.String code) {
        this.code = code;
    }


    /**
     * Gets the used_amount value for this EnterpriseGiftcardaccountListEntity.
     * 
     * @return used_amount
     */
    public java.lang.String getUsed_amount() {
        return used_amount;
    }


    /**
     * Sets the used_amount value for this EnterpriseGiftcardaccountListEntity.
     * 
     * @param used_amount
     */
    public void setUsed_amount(java.lang.String used_amount) {
        this.used_amount = used_amount;
    }


    /**
     * Gets the base_amount value for this EnterpriseGiftcardaccountListEntity.
     * 
     * @return base_amount
     */
    public java.lang.String getBase_amount() {
        return base_amount;
    }


    /**
     * Sets the base_amount value for this EnterpriseGiftcardaccountListEntity.
     * 
     * @param base_amount
     */
    public void setBase_amount(java.lang.String base_amount) {
        this.base_amount = base_amount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EnterpriseGiftcardaccountListEntity)) return false;
        EnterpriseGiftcardaccountListEntity other = (EnterpriseGiftcardaccountListEntity) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.giftcardaccount_id==null && other.getGiftcardaccount_id()==null) || 
             (this.giftcardaccount_id!=null &&
              this.giftcardaccount_id.equals(other.getGiftcardaccount_id()))) &&
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.used_amount==null && other.getUsed_amount()==null) || 
             (this.used_amount!=null &&
              this.used_amount.equals(other.getUsed_amount()))) &&
            ((this.base_amount==null && other.getBase_amount()==null) || 
             (this.base_amount!=null &&
              this.base_amount.equals(other.getBase_amount())));
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
        if (getGiftcardaccount_id() != null) {
            _hashCode += getGiftcardaccount_id().hashCode();
        }
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getUsed_amount() != null) {
            _hashCode += getUsed_amount().hashCode();
        }
        if (getBase_amount() != null) {
            _hashCode += getBase_amount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EnterpriseGiftcardaccountListEntity.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Magento", "enterpriseGiftcardaccountListEntity"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("giftcardaccount_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "giftcardaccount_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("used_amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "used_amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("base_amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "base_amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
