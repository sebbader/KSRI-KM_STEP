/**
 * Appointment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.tourenserver.www;

public class Appointment  implements java.io.Serializable {
    private int functionCode;

    private int status;

    private java.util.Calendar date;

    private java.util.Calendar time;

    private int detour;

    private java.lang.String FMVTID;

    private java.lang.String FMExtID;

    private java.lang.String info;

    private float cost;

    public Appointment() {
    }

    public Appointment(
           int functionCode,
           int status,
           java.util.Calendar date,
           java.util.Calendar time,
           int detour,
           java.lang.String FMVTID,
           java.lang.String FMExtID,
           java.lang.String info,
           float cost) {
           this.functionCode = functionCode;
           this.status = status;
           this.date = date;
           this.time = time;
           this.detour = detour;
           this.FMVTID = FMVTID;
           this.FMExtID = FMExtID;
           this.info = info;
           this.cost = cost;
    }


    /**
     * Gets the functionCode value for this Appointment.
     * 
     * @return functionCode
     */
    public int getFunctionCode() {
        return functionCode;
    }


    /**
     * Sets the functionCode value for this Appointment.
     * 
     * @param functionCode
     */
    public void setFunctionCode(int functionCode) {
        this.functionCode = functionCode;
    }


    /**
     * Gets the status value for this Appointment.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Appointment.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * Gets the date value for this Appointment.
     * 
     * @return date
     */
    public java.util.Calendar getDate() {
        return date;
    }


    /**
     * Sets the date value for this Appointment.
     * 
     * @param date
     */
    public void setDate(java.util.Calendar date) {
        this.date = date;
    }


    /**
     * Gets the time value for this Appointment.
     * 
     * @return time
     */
    public java.util.Calendar getTime() {
        return time;
    }


    /**
     * Sets the time value for this Appointment.
     * 
     * @param time
     */
    public void setTime(java.util.Calendar time) {
        this.time = time;
    }


    /**
     * Gets the detour value for this Appointment.
     * 
     * @return detour
     */
    public int getDetour() {
        return detour;
    }


    /**
     * Sets the detour value for this Appointment.
     * 
     * @param detour
     */
    public void setDetour(int detour) {
        this.detour = detour;
    }


    /**
     * Gets the FMVTID value for this Appointment.
     * 
     * @return FMVTID
     */
    public java.lang.String getFMVTID() {
        return FMVTID;
    }


    /**
     * Sets the FMVTID value for this Appointment.
     * 
     * @param FMVTID
     */
    public void setFMVTID(java.lang.String FMVTID) {
        this.FMVTID = FMVTID;
    }


    /**
     * Gets the FMExtID value for this Appointment.
     * 
     * @return FMExtID
     */
    public java.lang.String getFMExtID() {
        return FMExtID;
    }


    /**
     * Sets the FMExtID value for this Appointment.
     * 
     * @param FMExtID
     */
    public void setFMExtID(java.lang.String FMExtID) {
        this.FMExtID = FMExtID;
    }


    /**
     * Gets the info value for this Appointment.
     * 
     * @return info
     */
    public java.lang.String getInfo() {
        return info;
    }


    /**
     * Sets the info value for this Appointment.
     * 
     * @param info
     */
    public void setInfo(java.lang.String info) {
        this.info = info;
    }


    /**
     * Gets the cost value for this Appointment.
     * 
     * @return cost
     */
    public float getCost() {
        return cost;
    }


    /**
     * Sets the cost value for this Appointment.
     * 
     * @param cost
     */
    public void setCost(float cost) {
        this.cost = cost;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Appointment)) return false;
        Appointment other = (Appointment) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.functionCode == other.getFunctionCode() &&
            this.status == other.getStatus() &&
            ((this.date==null && other.getDate()==null) || 
             (this.date!=null &&
              this.date.equals(other.getDate()))) &&
            ((this.time==null && other.getTime()==null) || 
             (this.time!=null &&
              this.time.equals(other.getTime()))) &&
            this.detour == other.getDetour() &&
            ((this.FMVTID==null && other.getFMVTID()==null) || 
             (this.FMVTID!=null &&
              this.FMVTID.equals(other.getFMVTID()))) &&
            ((this.FMExtID==null && other.getFMExtID()==null) || 
             (this.FMExtID!=null &&
              this.FMExtID.equals(other.getFMExtID()))) &&
            ((this.info==null && other.getInfo()==null) || 
             (this.info!=null &&
              this.info.equals(other.getInfo()))) &&
            this.cost == other.getCost();
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
        _hashCode += getFunctionCode();
        _hashCode += getStatus();
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        if (getTime() != null) {
            _hashCode += getTime().hashCode();
        }
        _hashCode += getDetour();
        if (getFMVTID() != null) {
            _hashCode += getFMVTID().hashCode();
        }
        if (getFMExtID() != null) {
            _hashCode += getFMExtID().hashCode();
        }
        if (getInfo() != null) {
            _hashCode += getInfo().hashCode();
        }
        _hashCode += new Float(getCost()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Appointment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Appointment"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("functionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "FunctionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("time");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("detour");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Detour"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FMVTID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "FMVTID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FMExtID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "FMExtID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("info");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Info"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Cost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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
