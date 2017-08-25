/**
 * ArrayOfAppointment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.tourenserver.www;

public class ArrayOfAppointment  implements java.io.Serializable {
    private de.tourenserver.www.Appointment[] appointment;

    public ArrayOfAppointment() {
    }

    public ArrayOfAppointment(
           de.tourenserver.www.Appointment[] appointment) {
           this.appointment = appointment;
    }


    /**
     * Gets the appointment value for this ArrayOfAppointment.
     * 
     * @return appointment
     */
    public de.tourenserver.www.Appointment[] getAppointment() {
        return appointment;
    }


    /**
     * Sets the appointment value for this ArrayOfAppointment.
     * 
     * @param appointment
     */
    public void setAppointment(de.tourenserver.www.Appointment[] appointment) {
        this.appointment = appointment;
    }

    public de.tourenserver.www.Appointment getAppointment(int i) {
        return this.appointment[i];
    }

    public void setAppointment(int i, de.tourenserver.www.Appointment _value) {
        this.appointment[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfAppointment)) return false;
        ArrayOfAppointment other = (ArrayOfAppointment) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.appointment==null && other.getAppointment()==null) || 
             (this.appointment!=null &&
              java.util.Arrays.equals(this.appointment, other.getAppointment())));
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
        if (getAppointment() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAppointment());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAppointment(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfAppointment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.tourenserver.de/", "ArrayOfAppointment"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("appointment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Appointment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Appointment"));
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
