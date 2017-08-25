/**
 * FixedCall.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.tourenserver.www;

public class FixedCall  implements java.io.Serializable {
    private java.lang.String extID;

    private int VTID;

    private java.util.Calendar date;

    private java.util.Calendar arrival;

    private java.lang.String FMExtID;

    private int sequence;

    private boolean fixed;

    private int state;

    private int drivingTime;

    private int distance;

    private java.lang.String info;

    public FixedCall() {
    }

    public FixedCall(
           java.lang.String extID,
           int VTID,
           java.util.Calendar date,
           java.util.Calendar arrival,
           java.lang.String FMExtID,
           int sequence,
           boolean fixed,
           int state,
           int drivingTime,
           int distance,
           java.lang.String info) {
           this.extID = extID;
           this.VTID = VTID;
           this.date = date;
           this.arrival = arrival;
           this.FMExtID = FMExtID;
           this.sequence = sequence;
           this.fixed = fixed;
           this.state = state;
           this.drivingTime = drivingTime;
           this.distance = distance;
           this.info = info;
    }


    /**
     * Gets the extID value for this FixedCall.
     * 
     * @return extID
     */
    public java.lang.String getExtID() {
        return extID;
    }


    /**
     * Sets the extID value for this FixedCall.
     * 
     * @param extID
     */
    public void setExtID(java.lang.String extID) {
        this.extID = extID;
    }


    /**
     * Gets the VTID value for this FixedCall.
     * 
     * @return VTID
     */
    public int getVTID() {
        return VTID;
    }


    /**
     * Sets the VTID value for this FixedCall.
     * 
     * @param VTID
     */
    public void setVTID(int VTID) {
        this.VTID = VTID;
    }


    /**
     * Gets the date value for this FixedCall.
     * 
     * @return date
     */
    public java.util.Calendar getDate() {
        return date;
    }


    /**
     * Sets the date value for this FixedCall.
     * 
     * @param date
     */
    public void setDate(java.util.Calendar date) {
        this.date = date;
    }


    /**
     * Gets the arrival value for this FixedCall.
     * 
     * @return arrival
     */
    public java.util.Calendar getArrival() {
        return arrival;
    }


    /**
     * Sets the arrival value for this FixedCall.
     * 
     * @param arrival
     */
    public void setArrival(java.util.Calendar arrival) {
        this.arrival = arrival;
    }


    /**
     * Gets the FMExtID value for this FixedCall.
     * 
     * @return FMExtID
     */
    public java.lang.String getFMExtID() {
        return FMExtID;
    }


    /**
     * Sets the FMExtID value for this FixedCall.
     * 
     * @param FMExtID
     */
    public void setFMExtID(java.lang.String FMExtID) {
        this.FMExtID = FMExtID;
    }


    /**
     * Gets the sequence value for this FixedCall.
     * 
     * @return sequence
     */
    public int getSequence() {
        return sequence;
    }


    /**
     * Sets the sequence value for this FixedCall.
     * 
     * @param sequence
     */
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }


    /**
     * Gets the fixed value for this FixedCall.
     * 
     * @return fixed
     */
    public boolean isFixed() {
        return fixed;
    }


    /**
     * Sets the fixed value for this FixedCall.
     * 
     * @param fixed
     */
    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }


    /**
     * Gets the state value for this FixedCall.
     * 
     * @return state
     */
    public int getState() {
        return state;
    }


    /**
     * Sets the state value for this FixedCall.
     * 
     * @param state
     */
    public void setState(int state) {
        this.state = state;
    }


    /**
     * Gets the drivingTime value for this FixedCall.
     * 
     * @return drivingTime
     */
    public int getDrivingTime() {
        return drivingTime;
    }


    /**
     * Sets the drivingTime value for this FixedCall.
     * 
     * @param drivingTime
     */
    public void setDrivingTime(int drivingTime) {
        this.drivingTime = drivingTime;
    }


    /**
     * Gets the distance value for this FixedCall.
     * 
     * @return distance
     */
    public int getDistance() {
        return distance;
    }


    /**
     * Sets the distance value for this FixedCall.
     * 
     * @param distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }


    /**
     * Gets the info value for this FixedCall.
     * 
     * @return info
     */
    public java.lang.String getInfo() {
        return info;
    }


    /**
     * Sets the info value for this FixedCall.
     * 
     * @param info
     */
    public void setInfo(java.lang.String info) {
        this.info = info;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FixedCall)) return false;
        FixedCall other = (FixedCall) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.extID==null && other.getExtID()==null) || 
             (this.extID!=null &&
              this.extID.equals(other.getExtID()))) &&
            this.VTID == other.getVTID() &&
            ((this.date==null && other.getDate()==null) || 
             (this.date!=null &&
              this.date.equals(other.getDate()))) &&
            ((this.arrival==null && other.getArrival()==null) || 
             (this.arrival!=null &&
              this.arrival.equals(other.getArrival()))) &&
            ((this.FMExtID==null && other.getFMExtID()==null) || 
             (this.FMExtID!=null &&
              this.FMExtID.equals(other.getFMExtID()))) &&
            this.sequence == other.getSequence() &&
            this.fixed == other.isFixed() &&
            this.state == other.getState() &&
            this.drivingTime == other.getDrivingTime() &&
            this.distance == other.getDistance() &&
            ((this.info==null && other.getInfo()==null) || 
             (this.info!=null &&
              this.info.equals(other.getInfo())));
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
        if (getExtID() != null) {
            _hashCode += getExtID().hashCode();
        }
        _hashCode += getVTID();
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        if (getArrival() != null) {
            _hashCode += getArrival().hashCode();
        }
        if (getFMExtID() != null) {
            _hashCode += getFMExtID().hashCode();
        }
        _hashCode += getSequence();
        _hashCode += (isFixed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getState();
        _hashCode += getDrivingTime();
        _hashCode += getDistance();
        if (getInfo() != null) {
            _hashCode += getInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FixedCall.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.tourenserver.de/", "FixedCall"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "ExtID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VTID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "VTID"));
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
        elemField.setFieldName("arrival");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Arrival"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FMExtID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "FMExtID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sequence");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Sequence"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fixed");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Fixed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "State"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("drivingTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "DrivingTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distance");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Distance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("info");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Info"));
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
