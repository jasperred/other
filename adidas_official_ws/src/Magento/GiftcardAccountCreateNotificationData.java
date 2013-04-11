/**
 * GiftcardAccountCreateNotificationData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Magento;

public class GiftcardAccountCreateNotificationData  implements java.io.Serializable {
    private java.lang.String recipient_name;

    private java.lang.String recipient_email;

    private java.lang.String recipient_store;

    public GiftcardAccountCreateNotificationData() {
    }

    public GiftcardAccountCreateNotificationData(
           java.lang.String recipient_name,
           java.lang.String recipient_email,
           java.lang.String recipient_store) {
           this.recipient_name = recipient_name;
           this.recipient_email = recipient_email;
           this.recipient_store = recipient_store;
    }


    /**
     * Gets the recipient_name value for this GiftcardAccountCreateNotificationData.
     * 
     * @return recipient_name
     */
    public java.lang.String getRecipient_name() {
        return recipient_name;
    }


    /**
     * Sets the recipient_name value for this GiftcardAccountCreateNotificationData.
     * 
     * @param recipient_name
     */
    public void setRecipient_name(java.lang.String recipient_name) {
        this.recipient_name = recipient_name;
    }


    /**
     * Gets the recipient_email value for this GiftcardAccountCreateNotificationData.
     * 
     * @return recipient_email
     */
    public java.lang.String getRecipient_email() {
        return recipient_email;
    }


    /**
     * Sets the recipient_email value for this GiftcardAccountCreateNotificationData.
     * 
     * @param recipient_email
     */
    public void setRecipient_email(java.lang.String recipient_email) {
        this.recipient_email = recipient_email;
    }


    /**
     * Gets the recipient_store value for this GiftcardAccountCreateNotificationData.
     * 
     * @return recipient_store
     */
    public java.lang.String getRecipient_store() {
        return recipient_store;
    }


    /**
     * Sets the recipient_store value for this GiftcardAccountCreateNotificationData.
     * 
     * @param recipient_store
     */
    public void setRecipient_store(java.lang.String recipient_store) {
        this.recipient_store = recipient_store;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GiftcardAccountCreateNotificationData)) return false;
        GiftcardAccountCreateNotificationData other = (GiftcardAccountCreateNotificationData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.recipient_name==null && other.getRecipient_name()==null) || 
             (this.recipient_name!=null &&
              this.recipient_name.equals(other.getRecipient_name()))) &&
            ((this.recipient_email==null && other.getRecipient_email()==null) || 
             (this.recipient_email!=null &&
              this.recipient_email.equals(other.getRecipient_email()))) &&
            ((this.recipient_store==null && other.getRecipient_store()==null) || 
             (this.recipient_store!=null &&
              this.recipient_store.equals(other.getRecipient_store())));
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
        if (getRecipient_name() != null) {
            _hashCode += getRecipient_name().hashCode();
        }
        if (getRecipient_email() != null) {
            _hashCode += getRecipient_email().hashCode();
        }
        if (getRecipient_store() != null) {
            _hashCode += getRecipient_store().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GiftcardAccountCreateNotificationData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Magento", "giftcardAccountCreateNotificationData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recipient_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recipient_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recipient_email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recipient_email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recipient_store");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recipient_store"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
