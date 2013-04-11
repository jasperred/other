/**
 * AssociativeMultiArray.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Magento;

public class AssociativeMultiArray  implements java.io.Serializable {
    private Magento.AssociativeEntity[] associativeArray;

    public AssociativeMultiArray() {
    }

    public AssociativeMultiArray(
           Magento.AssociativeEntity[] associativeArray) {
           this.associativeArray = associativeArray;
    }


    /**
     * Gets the associativeArray value for this AssociativeMultiArray.
     * 
     * @return associativeArray
     */
    public Magento.AssociativeEntity[] getAssociativeArray() {
        return associativeArray;
    }


    /**
     * Sets the associativeArray value for this AssociativeMultiArray.
     * 
     * @param associativeArray
     */
    public void setAssociativeArray(Magento.AssociativeEntity[] associativeArray) {
        this.associativeArray = associativeArray;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AssociativeMultiArray)) return false;
        AssociativeMultiArray other = (AssociativeMultiArray) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.associativeArray==null && other.getAssociativeArray()==null) || 
             (this.associativeArray!=null &&
              java.util.Arrays.equals(this.associativeArray, other.getAssociativeArray())));
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
        if (getAssociativeArray() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAssociativeArray());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAssociativeArray(), i);
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
        new org.apache.axis.description.TypeDesc(AssociativeMultiArray.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Magento", "associativeMultiArray"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("associativeArray");
        elemField.setXmlName(new javax.xml.namespace.QName("", "associativeArray"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Magento", "associativeEntity"));
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
