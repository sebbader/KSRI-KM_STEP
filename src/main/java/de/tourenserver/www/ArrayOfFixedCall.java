/**
 * ArrayOfFixedCall.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.tourenserver.www;

public class ArrayOfFixedCall  implements java.io.Serializable {
    private de.tourenserver.www.FixedCall[] fixedCall;

    public ArrayOfFixedCall() {
    }

    public ArrayOfFixedCall(
           de.tourenserver.www.FixedCall[] fixedCall) {
           this.fixedCall = fixedCall;
    }


    /**
     * Gets the fixedCall value for this ArrayOfFixedCall.
     * 
     * @return fixedCall
     */
    public de.tourenserver.www.FixedCall[] getFixedCall() {
        return fixedCall;
    }


    /**
     * Sets the fixedCall value for this ArrayOfFixedCall.
     * 
     * @param fixedCall
     */
    public void setFixedCall(de.tourenserver.www.FixedCall[] fixedCall) {
        this.fixedCall = fixedCall;
    }

    public de.tourenserver.www.FixedCall getFixedCall(int i) {
        return this.fixedCall[i];
    }

    public void setFixedCall(int i, de.tourenserver.www.FixedCall _value) {
        this.fixedCall[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfFixedCall)) return false;
        ArrayOfFixedCall other = (ArrayOfFixedCall) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fixedCall==null && other.getFixedCall()==null) || 
             (this.fixedCall!=null &&
              java.util.Arrays.equals(this.fixedCall, other.getFixedCall())));
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
        if (getFixedCall() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFixedCall());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFixedCall(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfFixedCall.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.tourenserver.de/", "ArrayOfFixedCall"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fixedCall");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "FixedCall"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.tourenserver.de/", "FixedCall"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
