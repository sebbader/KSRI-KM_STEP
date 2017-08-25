/**
 * ArrayOfGeoCodeRec.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.tourenserver.www;

public class ArrayOfGeoCodeRec  implements java.io.Serializable {
    private de.tourenserver.www.GeoCodeRec[] geoCodeRec;

    public ArrayOfGeoCodeRec() {
    }

    public ArrayOfGeoCodeRec(
           de.tourenserver.www.GeoCodeRec[] geoCodeRec) {
           this.geoCodeRec = geoCodeRec;
    }


    /**
     * Gets the geoCodeRec value for this ArrayOfGeoCodeRec.
     * 
     * @return geoCodeRec
     */
    public de.tourenserver.www.GeoCodeRec[] getGeoCodeRec() {
        return geoCodeRec;
    }


    /**
     * Sets the geoCodeRec value for this ArrayOfGeoCodeRec.
     * 
     * @param geoCodeRec
     */
    public void setGeoCodeRec(de.tourenserver.www.GeoCodeRec[] geoCodeRec) {
        this.geoCodeRec = geoCodeRec;
    }

    public de.tourenserver.www.GeoCodeRec getGeoCodeRec(int i) {
        return this.geoCodeRec[i];
    }

    public void setGeoCodeRec(int i, de.tourenserver.www.GeoCodeRec _value) {
        this.geoCodeRec[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfGeoCodeRec)) return false;
        ArrayOfGeoCodeRec other = (ArrayOfGeoCodeRec) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.geoCodeRec==null && other.getGeoCodeRec()==null) || 
             (this.geoCodeRec!=null &&
              java.util.Arrays.equals(this.geoCodeRec, other.getGeoCodeRec())));
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
        if (getGeoCodeRec() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGeoCodeRec());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGeoCodeRec(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfGeoCodeRec.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.tourenserver.de/", "ArrayOfGeoCodeRec"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("geoCodeRec");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "GeoCodeRec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.tourenserver.de/", "GeoCodeRec"));
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
