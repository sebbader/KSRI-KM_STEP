/**
 * CallInfoRec.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.tourenserver.www;

public class CallInfoRec  implements java.io.Serializable {
    private java.lang.String extID;

    private int VTID;

    private java.lang.String FMExtID;

    private java.util.Calendar dateFrom;

    private java.util.Calendar dateTo;

    private java.util.Calendar timeFrom;

    private java.util.Calendar timeTo;

    private int duration;

    private java.util.Calendar date;

    private java.util.Calendar arrival;

    private int drivingTime;

    private int distance;

    private int state;

    private int sequence;

    private java.lang.String customerID;

    private java.lang.String name;

    private java.lang.String name2;

    private java.lang.String title;

    private java.lang.String contactPerson;

    private java.lang.String phone1;

    private java.lang.String phone2;

    private java.lang.String country;

    private java.lang.String ZIP;

    private java.lang.String city;

    private java.lang.String street;

    private java.lang.String callInfo1;

    private java.lang.String callInfo2;

    private int notFound;

    public CallInfoRec() {
    }

    public CallInfoRec(
           java.lang.String extID,
           int VTID,
           java.lang.String FMExtID,
           java.util.Calendar dateFrom,
           java.util.Calendar dateTo,
           java.util.Calendar timeFrom,
           java.util.Calendar timeTo,
           int duration,
           java.util.Calendar date,
           java.util.Calendar arrival,
           int drivingTime,
           int distance,
           int state,
           int sequence,
           java.lang.String customerID,
           java.lang.String name,
           java.lang.String name2,
           java.lang.String title,
           java.lang.String contactPerson,
           java.lang.String phone1,
           java.lang.String phone2,
           java.lang.String country,
           java.lang.String ZIP,
           java.lang.String city,
           java.lang.String street,
           java.lang.String callInfo1,
           java.lang.String callInfo2,
           int notFound) {
           this.extID = extID;
           this.VTID = VTID;
           this.FMExtID = FMExtID;
           this.dateFrom = dateFrom;
           this.dateTo = dateTo;
           this.timeFrom = timeFrom;
           this.timeTo = timeTo;
           this.duration = duration;
           this.date = date;
           this.arrival = arrival;
           this.drivingTime = drivingTime;
           this.distance = distance;
           this.state = state;
           this.sequence = sequence;
           this.customerID = customerID;
           this.name = name;
           this.name2 = name2;
           this.title = title;
           this.contactPerson = contactPerson;
           this.phone1 = phone1;
           this.phone2 = phone2;
           this.country = country;
           this.ZIP = ZIP;
           this.city = city;
           this.street = street;
           this.callInfo1 = callInfo1;
           this.callInfo2 = callInfo2;
           this.notFound = notFound;
    }


    /**
     * Gets the extID value for this CallInfoRec.
     * 
     * @return extID
     */
    public java.lang.String getExtID() {
        return extID;
    }


    /**
     * Sets the extID value for this CallInfoRec.
     * 
     * @param extID
     */
    public void setExtID(java.lang.String extID) {
        this.extID = extID;
    }


    /**
     * Gets the VTID value for this CallInfoRec.
     * 
     * @return VTID
     */
    public int getVTID() {
        return VTID;
    }


    /**
     * Sets the VTID value for this CallInfoRec.
     * 
     * @param VTID
     */
    public void setVTID(int VTID) {
        this.VTID = VTID;
    }


    /**
     * Gets the FMExtID value for this CallInfoRec.
     * 
     * @return FMExtID
     */
    public java.lang.String getFMExtID() {
        return FMExtID;
    }


    /**
     * Sets the FMExtID value for this CallInfoRec.
     * 
     * @param FMExtID
     */
    public void setFMExtID(java.lang.String FMExtID) {
        this.FMExtID = FMExtID;
    }


    /**
     * Gets the dateFrom value for this CallInfoRec.
     * 
     * @return dateFrom
     */
    public java.util.Calendar getDateFrom() {
        return dateFrom;
    }


    /**
     * Sets the dateFrom value for this CallInfoRec.
     * 
     * @param dateFrom
     */
    public void setDateFrom(java.util.Calendar dateFrom) {
        this.dateFrom = dateFrom;
    }


    /**
     * Gets the dateTo value for this CallInfoRec.
     * 
     * @return dateTo
     */
    public java.util.Calendar getDateTo() {
        return dateTo;
    }


    /**
     * Sets the dateTo value for this CallInfoRec.
     * 
     * @param dateTo
     */
    public void setDateTo(java.util.Calendar dateTo) {
        this.dateTo = dateTo;
    }


    /**
     * Gets the timeFrom value for this CallInfoRec.
     * 
     * @return timeFrom
     */
    public java.util.Calendar getTimeFrom() {
        return timeFrom;
    }


    /**
     * Sets the timeFrom value for this CallInfoRec.
     * 
     * @param timeFrom
     */
    public void setTimeFrom(java.util.Calendar timeFrom) {
        this.timeFrom = timeFrom;
    }


    /**
     * Gets the timeTo value for this CallInfoRec.
     * 
     * @return timeTo
     */
    public java.util.Calendar getTimeTo() {
        return timeTo;
    }


    /**
     * Sets the timeTo value for this CallInfoRec.
     * 
     * @param timeTo
     */
    public void setTimeTo(java.util.Calendar timeTo) {
        this.timeTo = timeTo;
    }


    /**
     * Gets the duration value for this CallInfoRec.
     * 
     * @return duration
     */
    public int getDuration() {
        return duration;
    }


    /**
     * Sets the duration value for this CallInfoRec.
     * 
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }


    /**
     * Gets the date value for this CallInfoRec.
     * 
     * @return date
     */
    public java.util.Calendar getDate() {
        return date;
    }


    /**
     * Sets the date value for this CallInfoRec.
     * 
     * @param date
     */
    public void setDate(java.util.Calendar date) {
        this.date = date;
    }


    /**
     * Gets the arrival value for this CallInfoRec.
     * 
     * @return arrival
     */
    public java.util.Calendar getArrival() {
        return arrival;
    }


    /**
     * Sets the arrival value for this CallInfoRec.
     * 
     * @param arrival
     */
    public void setArrival(java.util.Calendar arrival) {
        this.arrival = arrival;
    }


    /**
     * Gets the drivingTime value for this CallInfoRec.
     * 
     * @return drivingTime
     */
    public int getDrivingTime() {
        return drivingTime;
    }


    /**
     * Sets the drivingTime value for this CallInfoRec.
     * 
     * @param drivingTime
     */
    public void setDrivingTime(int drivingTime) {
        this.drivingTime = drivingTime;
    }


    /**
     * Gets the distance value for this CallInfoRec.
     * 
     * @return distance
     */
    public int getDistance() {
        return distance;
    }


    /**
     * Sets the distance value for this CallInfoRec.
     * 
     * @param distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }


    /**
     * Gets the state value for this CallInfoRec.
     * 
     * @return state
     */
    public int getState() {
        return state;
    }


    /**
     * Sets the state value for this CallInfoRec.
     * 
     * @param state
     */
    public void setState(int state) {
        this.state = state;
    }


    /**
     * Gets the sequence value for this CallInfoRec.
     * 
     * @return sequence
     */
    public int getSequence() {
        return sequence;
    }


    /**
     * Sets the sequence value for this CallInfoRec.
     * 
     * @param sequence
     */
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }


    /**
     * Gets the customerID value for this CallInfoRec.
     * 
     * @return customerID
     */
    public java.lang.String getCustomerID() {
        return customerID;
    }


    /**
     * Sets the customerID value for this CallInfoRec.
     * 
     * @param customerID
     */
    public void setCustomerID(java.lang.String customerID) {
        this.customerID = customerID;
    }


    /**
     * Gets the name value for this CallInfoRec.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this CallInfoRec.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the name2 value for this CallInfoRec.
     * 
     * @return name2
     */
    public java.lang.String getName2() {
        return name2;
    }


    /**
     * Sets the name2 value for this CallInfoRec.
     * 
     * @param name2
     */
    public void setName2(java.lang.String name2) {
        this.name2 = name2;
    }


    /**
     * Gets the title value for this CallInfoRec.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this CallInfoRec.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the contactPerson value for this CallInfoRec.
     * 
     * @return contactPerson
     */
    public java.lang.String getContactPerson() {
        return contactPerson;
    }


    /**
     * Sets the contactPerson value for this CallInfoRec.
     * 
     * @param contactPerson
     */
    public void setContactPerson(java.lang.String contactPerson) {
        this.contactPerson = contactPerson;
    }


    /**
     * Gets the phone1 value for this CallInfoRec.
     * 
     * @return phone1
     */
    public java.lang.String getPhone1() {
        return phone1;
    }


    /**
     * Sets the phone1 value for this CallInfoRec.
     * 
     * @param phone1
     */
    public void setPhone1(java.lang.String phone1) {
        this.phone1 = phone1;
    }


    /**
     * Gets the phone2 value for this CallInfoRec.
     * 
     * @return phone2
     */
    public java.lang.String getPhone2() {
        return phone2;
    }


    /**
     * Sets the phone2 value for this CallInfoRec.
     * 
     * @param phone2
     */
    public void setPhone2(java.lang.String phone2) {
        this.phone2 = phone2;
    }


    /**
     * Gets the country value for this CallInfoRec.
     * 
     * @return country
     */
    public java.lang.String getCountry() {
        return country;
    }


    /**
     * Sets the country value for this CallInfoRec.
     * 
     * @param country
     */
    public void setCountry(java.lang.String country) {
        this.country = country;
    }


    /**
     * Gets the ZIP value for this CallInfoRec.
     * 
     * @return ZIP
     */
    public java.lang.String getZIP() {
        return ZIP;
    }


    /**
     * Sets the ZIP value for this CallInfoRec.
     * 
     * @param ZIP
     */
    public void setZIP(java.lang.String ZIP) {
        this.ZIP = ZIP;
    }


    /**
     * Gets the city value for this CallInfoRec.
     * 
     * @return city
     */
    public java.lang.String getCity() {
        return city;
    }


    /**
     * Sets the city value for this CallInfoRec.
     * 
     * @param city
     */
    public void setCity(java.lang.String city) {
        this.city = city;
    }


    /**
     * Gets the street value for this CallInfoRec.
     * 
     * @return street
     */
    public java.lang.String getStreet() {
        return street;
    }


    /**
     * Sets the street value for this CallInfoRec.
     * 
     * @param street
     */
    public void setStreet(java.lang.String street) {
        this.street = street;
    }


    /**
     * Gets the callInfo1 value for this CallInfoRec.
     * 
     * @return callInfo1
     */
    public java.lang.String getCallInfo1() {
        return callInfo1;
    }


    /**
     * Sets the callInfo1 value for this CallInfoRec.
     * 
     * @param callInfo1
     */
    public void setCallInfo1(java.lang.String callInfo1) {
        this.callInfo1 = callInfo1;
    }


    /**
     * Gets the callInfo2 value for this CallInfoRec.
     * 
     * @return callInfo2
     */
    public java.lang.String getCallInfo2() {
        return callInfo2;
    }


    /**
     * Sets the callInfo2 value for this CallInfoRec.
     * 
     * @param callInfo2
     */
    public void setCallInfo2(java.lang.String callInfo2) {
        this.callInfo2 = callInfo2;
    }


    /**
     * Gets the notFound value for this CallInfoRec.
     * 
     * @return notFound
     */
    public int getNotFound() {
        return notFound;
    }


    /**
     * Sets the notFound value for this CallInfoRec.
     * 
     * @param notFound
     */
    public void setNotFound(int notFound) {
        this.notFound = notFound;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CallInfoRec)) return false;
        CallInfoRec other = (CallInfoRec) obj;
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
            ((this.FMExtID==null && other.getFMExtID()==null) || 
             (this.FMExtID!=null &&
              this.FMExtID.equals(other.getFMExtID()))) &&
            ((this.dateFrom==null && other.getDateFrom()==null) || 
             (this.dateFrom!=null &&
              this.dateFrom.equals(other.getDateFrom()))) &&
            ((this.dateTo==null && other.getDateTo()==null) || 
             (this.dateTo!=null &&
              this.dateTo.equals(other.getDateTo()))) &&
            ((this.timeFrom==null && other.getTimeFrom()==null) || 
             (this.timeFrom!=null &&
              this.timeFrom.equals(other.getTimeFrom()))) &&
            ((this.timeTo==null && other.getTimeTo()==null) || 
             (this.timeTo!=null &&
              this.timeTo.equals(other.getTimeTo()))) &&
            this.duration == other.getDuration() &&
            ((this.date==null && other.getDate()==null) || 
             (this.date!=null &&
              this.date.equals(other.getDate()))) &&
            ((this.arrival==null && other.getArrival()==null) || 
             (this.arrival!=null &&
              this.arrival.equals(other.getArrival()))) &&
            this.drivingTime == other.getDrivingTime() &&
            this.distance == other.getDistance() &&
            this.state == other.getState() &&
            this.sequence == other.getSequence() &&
            ((this.customerID==null && other.getCustomerID()==null) || 
             (this.customerID!=null &&
              this.customerID.equals(other.getCustomerID()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.name2==null && other.getName2()==null) || 
             (this.name2!=null &&
              this.name2.equals(other.getName2()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.contactPerson==null && other.getContactPerson()==null) || 
             (this.contactPerson!=null &&
              this.contactPerson.equals(other.getContactPerson()))) &&
            ((this.phone1==null && other.getPhone1()==null) || 
             (this.phone1!=null &&
              this.phone1.equals(other.getPhone1()))) &&
            ((this.phone2==null && other.getPhone2()==null) || 
             (this.phone2!=null &&
              this.phone2.equals(other.getPhone2()))) &&
            ((this.country==null && other.getCountry()==null) || 
             (this.country!=null &&
              this.country.equals(other.getCountry()))) &&
            ((this.ZIP==null && other.getZIP()==null) || 
             (this.ZIP!=null &&
              this.ZIP.equals(other.getZIP()))) &&
            ((this.city==null && other.getCity()==null) || 
             (this.city!=null &&
              this.city.equals(other.getCity()))) &&
            ((this.street==null && other.getStreet()==null) || 
             (this.street!=null &&
              this.street.equals(other.getStreet()))) &&
            ((this.callInfo1==null && other.getCallInfo1()==null) || 
             (this.callInfo1!=null &&
              this.callInfo1.equals(other.getCallInfo1()))) &&
            ((this.callInfo2==null && other.getCallInfo2()==null) || 
             (this.callInfo2!=null &&
              this.callInfo2.equals(other.getCallInfo2()))) &&
            this.notFound == other.getNotFound();
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
        if (getFMExtID() != null) {
            _hashCode += getFMExtID().hashCode();
        }
        if (getDateFrom() != null) {
            _hashCode += getDateFrom().hashCode();
        }
        if (getDateTo() != null) {
            _hashCode += getDateTo().hashCode();
        }
        if (getTimeFrom() != null) {
            _hashCode += getTimeFrom().hashCode();
        }
        if (getTimeTo() != null) {
            _hashCode += getTimeTo().hashCode();
        }
        _hashCode += getDuration();
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        if (getArrival() != null) {
            _hashCode += getArrival().hashCode();
        }
        _hashCode += getDrivingTime();
        _hashCode += getDistance();
        _hashCode += getState();
        _hashCode += getSequence();
        if (getCustomerID() != null) {
            _hashCode += getCustomerID().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getName2() != null) {
            _hashCode += getName2().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getContactPerson() != null) {
            _hashCode += getContactPerson().hashCode();
        }
        if (getPhone1() != null) {
            _hashCode += getPhone1().hashCode();
        }
        if (getPhone2() != null) {
            _hashCode += getPhone2().hashCode();
        }
        if (getCountry() != null) {
            _hashCode += getCountry().hashCode();
        }
        if (getZIP() != null) {
            _hashCode += getZIP().hashCode();
        }
        if (getCity() != null) {
            _hashCode += getCity().hashCode();
        }
        if (getStreet() != null) {
            _hashCode += getStreet().hashCode();
        }
        if (getCallInfo1() != null) {
            _hashCode += getCallInfo1().hashCode();
        }
        if (getCallInfo2() != null) {
            _hashCode += getCallInfo2().hashCode();
        }
        _hashCode += getNotFound();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CallInfoRec.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.tourenserver.de/", "CallInfoRec"));
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
        elemField.setFieldName("FMExtID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "FMExtID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateFrom");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "DateFrom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateTo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "DateTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeFrom");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "TimeFrom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeTo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "TimeTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duration");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Duration"));
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
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "State"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sequence");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Sequence"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "CustomerID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Name2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactPerson");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "ContactPerson"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phone1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Phone1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phone2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Phone2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("street");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "Street"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("callInfo1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "CallInfo1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("callInfo2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "CallInfo2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notFound");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.tourenserver.de/", "NotFound"));
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
