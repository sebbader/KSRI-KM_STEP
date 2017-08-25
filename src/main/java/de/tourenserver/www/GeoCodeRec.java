/**
 * GeoCodeRec.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.tourenserver.www;

public class GeoCodeRec  implements java.io.Serializable {
    private java.lang.String country;

    private java.lang.String ZIP;

    private java.lang.String city;

    private java.lang.String district;

    private java.lang.String street;

    private java.lang.String HNr;

    private java.lang.String HNr2;

    private java.lang.String province;

    private java.lang.String provShort;

    private int x;

    private int y;

    private int NID;

    private int GS;

    public GeoCodeRec() {
    }

    public GeoCodeRec(
           java.lang.String country,
           java.lang.String ZIP,
           java.lang.String city,
           java.lang.String district,
           java.lang.String street,
           java.lang.String HNr,
           java.lang.String HNr2,
           java.lang.String province,
           java.lang.String provShort,
           int x,
           int y,
           int NID,
           int GS) {
           this.country = country;
           this.ZIP = ZIP;
           this.city = city;
           this.district = district;
           this.street = street;
           this.HNr = HNr;
           this.HNr2 = HNr2;
           this.province = province;
           this.provShort = provShort;
           this.x = x;
           this.y = y;
           this.NID = NID;
           this.GS = GS;
    }


    /**
     * Gets the country value for this GeoCodeRec.
     * 
     * @return country
     */
    public java.lang.String getCountry() {
        return country;
    }


    /**
     * Sets the country value for this GeoCodeRec.
     * 
     * @param country
     */
    public void setCountry(java.lang.String country) {
        this.country = country;
    }


    /**
     * Gets the ZIP value for this GeoCodeRec.
     * 
     * @return ZIP
     */
    public java.lang.String getZIP() {
        return ZIP;
    }


    /**
     * Sets the ZIP value for this GeoCodeRec.
     * 
     * @param ZIP
     */
    public void setZIP(java.lang.String ZIP) {
        this.ZIP = ZIP;
    }


    /**
     * Gets the city value for this GeoCodeRec.
     * 
     * @return city
     */
    public java.lang.String getCity() {
        return city;
    }


    /**
     * Sets the city value for this GeoCodeRec.
     * 
     * @param city
     */
    public void setCity(java.lang.String city) {
        this.city = city;
    }


    /**
     * Gets the district value for this GeoCodeRec.
     * 
     * @return district
     */
    public java.lang.String getDistrict() {
        return district;
    }


    /**
     * Sets the district value for this GeoCodeRec.
     * 
     * @param district
     */
    public void setDistrict(java.lang.String district) {
        this.district = district;
    }


    /**
     * Gets the street value for this GeoCodeRec.
     * 
     * @return street
     */
    public java.lang.String getStreet() {
        return street;
    }


    /**
     * Sets the street value for this GeoCodeRec.
     * 
     * @param street
     */
    public void setStreet(java.lang.String street) {
        this.street = street;
    }


    /**
     * Gets the HNr value for this GeoCodeRec.
     * 
     * @return HNr
     */
    public java.lang.String getHNr() {
        return HNr;
    }


    /**
     * Sets the HNr value for this GeoCodeRec.
     * 
     * @param HNr
     */
    public void setHNr(java.lang.String HNr) {
        this.HNr = HNr;
    }


    /**
     * Gets the HNr2 value for this GeoCodeRec.
     * 
     * @return HNr2
     */
    public java.lang.String getHNr2() {
        return HNr2;
    }


    /**
     * Sets the HNr2 value for this GeoCodeRec.
     * 
     * @param HNr2
     */
    public void setHNr2(java.lang.String HNr2) {
        this.HNr2 = HNr2;
    }


    /**
     * Gets the province value for this GeoCodeRec.
     * 
     * @return province
     */
    public java.lang.String getProvince() {
        return province;
    }


    /**
     * Sets the province value for this GeoCodeRec.
     * 
     * @param province
     */
    public void setProvince(java.lang.String province) {
        this.province = province;
    }


    /**
     * Gets the provShort value for this GeoCodeRec.
     * 
     * @return provShort
     */
    public java.lang.String getProvShort() {
        return provShort;
    }


    /**
     * Sets the provShort value for this GeoCodeRec.
     * 
     * @param provShort
     */
    public void setProvShort(java.lang.String provShort) {
        this.provShort = provShort;
    }


    /**
     * Gets the x value for this GeoCodeRec.
     * 
     * @return x
     */
    public int getX() {
        return x;
    }


    /**
     * Sets the x value for this GeoCodeRec.
     * 
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }


    /**
     * Gets the y value for this GeoCodeRec.
     * 
     * @return y
     */
    public int getY() {
        return y;
    }


    /**
     * Sets the y value for this GeoCodeRec.
     * 
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }


    /**
     * Gets the NID value for this GeoCodeRec.
     * 
     * @return NID
     */
    public int getNID() {
        return NID;
    }


    /**
     * Sets the NID value for this GeoCodeRec.
     * 
     * @param NID
     */
    public void setNID(int NID) {
        this.NID = NID;
    }


    /**
     * Gets the GS value for this GeoCodeRec.
     * 
     * @return GS
     */
    public int getGS() {
        return GS;
    }


    /**
     * Sets the GS value for this GeoCodeRec.
     * 
     * @param GS
     */
    public void setGS(int GS) {
        this.GS = GS;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GeoCodeRec)) return false;
        GeoCodeRec other = (GeoCodeRec) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.country==null && other.getCountry()==null) || 
             (this.country!=null &&
              this.country.equals(other.getCountry()))) &&
            ((this.ZIP==null && other.getZIP()==null) || 
             (this.ZIP!=null &&
              this.ZIP.equals(other.getZIP()))) &&
            ((this.city==null && other.getCity()==null) || 
             (this.city!=null &&
              this.city.equals(other.getCity()))) &&
            ((this.district==null && other.getDistrict()==null) || 
             (this.district!=null &&
              this.district.equals(other.getDistrict()))) &&
            ((this.street==null && other.getStreet()==null) || 
             (this.street!=null &&
              this.street.equals(other.getStreet()))) &&
            ((this.HNr==null && other.getHNr()==null) || 
             (this.HNr!=null &&
              this.HNr.equals(other.getHNr()))) &&
            ((this.HNr2==null && other.getHNr2()==null) || 
             (this.HNr2!=null &&
              this.HNr2.equals(other.getHNr2()))) &&
            ((this.province==null && other.getProvince()==null) || 
             (this.province!=null &&
              this.province.equals(other.getProvince()))) &&
            ((this.provShort==null && other.getProvShort()==null) || 
             (this.provShort!=null &&
              this.provShort.equals(other.getProvShort()))) &&
            this.x == other.getX() &&
            this.y == other.getY() &&
            this.NID == other.getNID() &&
            this.GS == other.getGS();
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
        if (getCountry() != null) {
            _hashCode += getCountry().hashCode();
        }
        if (getZIP() != null) {
            _hashCode += getZIP().hashCode();
        }
        if (getCity() != null) {
            _hashCode += getCity().hashCode();
        }
        if (getDistrict() != null) {
            _hashCode += getDistrict().hashCode();
        }
        if (getStreet() != null) {
            _hashCode += getStreet().hashCode();
        }
        if (getHNr() != null) {
            _hashCode += getHNr().hashCode();
        }
        if (getHNr2() != null) {
            _hashCode += getHNr2().hashCode();
        }
        if (getProvince() != null) {
            _hashCode += getProvince().hashCode();
        }
        if (getProvShort() != null) {
            _hashCode += getProvShort().hashCode();
        }
        _hashCode += getX();
        _hashCode += getY();
        _hashCode += getNID();
        _hashCode += getGS();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GeoCodeRec.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.tourenserver.de/", "GeoCodeRec"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("country");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Country"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ZIP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "ZIP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("city");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "City"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("district");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "District"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("street");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Street"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("HNr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "HNr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("HNr2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "HNr2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("province");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Province"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provShort");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "ProvShort"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "X"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("y");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Y"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "NID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "GS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
