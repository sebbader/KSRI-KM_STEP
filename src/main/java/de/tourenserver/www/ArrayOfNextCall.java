/**
 * ArrayOfNextCall.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.tourenserver.www;

public class ArrayOfNextCall  implements java.io.Serializable {
    private de.tourenserver.www.NextCall[] nextCall;

    public ArrayOfNextCall() {
    }

    public ArrayOfNextCall(
           de.tourenserver.www.NextCall[] nextCall) {
           this.nextCall = nextCall;
    }


    /**
     * Gets the nextCall value for this ArrayOfNextCall.
     * 
     * @return nextCall
     */
    public de.tourenserver.www.NextCall[] getNextCall() {
        return nextCall;
    }


    /**
     * Sets the nextCall value for this ArrayOfNextCall.
     * 
     * @param nextCall
     */
    public void setNextCall(de.tourenserver.www.NextCall[] nextCall) {
        this.nextCall = nextCall;
    }

    public de.tourenserver.www.NextCall getNextCall(int i) {
        return this.nextCall[i];
    }

    public void setNextCall(int i, de.tourenserver.www.NextCall _value) {
        this.nextCall[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfNextCall)) return false;
        ArrayOfNextCall other = (ArrayOfNextCall) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nextCall==null && other.getNextCall()==null) || 
             (this.nextCall!=null &&
              java.util.Arrays.equals(this.nextCall, other.getNextCall())));
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
        if (getNextCall() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNextCall());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNextCall(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfNextCall.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.tourenserver.de/", "ArrayOfNextCall"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nextCall");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "NextCall"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.tourenserver.de/", "NextCall"));
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
