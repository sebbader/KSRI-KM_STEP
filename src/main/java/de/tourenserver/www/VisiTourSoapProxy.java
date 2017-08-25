package de.tourenserver.www;

public class VisiTourSoapProxy implements de.tourenserver.www.VisiTourSoap {
  private String _endpoint = null;
  private de.tourenserver.www.VisiTourSoap visiTourSoap = null;
  
  public VisiTourSoapProxy() {
    _initVisiTourSoapProxy();
  }
  
  public VisiTourSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initVisiTourSoapProxy();
  }
  
  private void _initVisiTourSoapProxy() {
    try {
      visiTourSoap = (new de.tourenserver.www.VisiTourLocator()).getVisiTourSoap();
      if (visiTourSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)visiTourSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)visiTourSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (visiTourSoap != null)
      ((javax.xml.rpc.Stub)visiTourSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public de.tourenserver.www.VisiTourSoap getVisiTourSoap() {
    if (visiTourSoap == null)
      _initVisiTourSoapProxy();
    return visiTourSoap;
  }
  
  public void call(int functionCode, java.lang.Integer mandator, java.lang.String agent, java.lang.String extID, javax.xml.rpc.holders.IntHolder VTID, java.lang.String customerExtID, java.lang.String name, java.lang.String name2, java.lang.String title, java.lang.String contactPerson, java.lang.String phone1, java.lang.String phone2, java.lang.String email, java.lang.String callInfo1, java.lang.String callInfo2, java.lang.String userfield1, java.lang.String userfield2, java.lang.String country, java.lang.String ZIP, java.lang.String city, java.lang.String district, java.lang.String street, java.lang.String HNr, java.lang.Integer x, java.lang.Integer y, java.lang.String regionID, java.lang.String areaOfExpertiseID, java.lang.String teamID, java.lang.String taskTypeID, java.lang.Integer servicetype, java.lang.Integer priority, java.lang.String fixedFieldManagerID, java.lang.String forbiddenFieldManagerID, java.lang.String preferredFieldmanagerID, java.lang.String preferredFieldmanagerID2, java.lang.String allowedFieldmanagerIDs, java.lang.Integer externalProcessing, java.lang.String skills, java.lang.Integer units, java.util.Calendar dateFrom, java.util.Calendar dateTo, java.util.Calendar timeFrom, java.util.Calendar timeTo, java.lang.String openingHours, java.lang.String weekday, java.lang.String timeAttribute, java.lang.Integer duration, java.lang.Integer preparationtime, java.lang.Integer postProcessing, java.lang.Integer setupTime, java.lang.Integer sequenceGroup, java.lang.Integer extraPenalty, java.lang.Float delayPenalty, java.util.Calendar fixedDate, java.lang.Integer state, java.lang.Integer maxDetour, java.lang.Integer reservationtime, java.lang.String showCall, java.lang.String secondaryVisit, java.lang.String equipmentNr, java.lang.String equipmentName, java.lang.Integer interruptible, java.lang.Integer maxCost, java.lang.Integer maxKm, javax.xml.rpc.holders.IntHolder callResult, javax.xml.rpc.holders.StringHolder infoText, de.tourenserver.www.holders.ArrayOfAppointmentHolder appointments) throws java.rmi.RemoteException{
    if (visiTourSoap == null)
      _initVisiTourSoapProxy();
    visiTourSoap.call(functionCode, mandator, agent, extID, VTID, customerExtID, name, name2, title, contactPerson, phone1, phone2, email, callInfo1, callInfo2, userfield1, userfield2, country, ZIP, city, district, street, HNr, x, y, regionID, areaOfExpertiseID, teamID, taskTypeID, servicetype, priority, fixedFieldManagerID, forbiddenFieldManagerID, preferredFieldmanagerID, preferredFieldmanagerID2, allowedFieldmanagerIDs, externalProcessing, skills, units, dateFrom, dateTo, timeFrom, timeTo, openingHours, weekday, timeAttribute, duration, preparationtime, postProcessing, setupTime, sequenceGroup, extraPenalty, delayPenalty, fixedDate, state, maxDetour, reservationtime, showCall, secondaryVisit, equipmentNr, equipmentName, interruptible, maxCost, maxKm, callResult, infoText, appointments);
  }
  
  public int fieldManager(javax.xml.rpc.holders.IntHolder FMVTID, java.lang.String FMExtID, java.lang.String type, java.lang.Boolean active, java.lang.String prename, java.lang.String name, java.lang.String regionID, java.lang.String areaOfExpertiseID, java.lang.String teamID, java.lang.String SCountry, java.lang.String SZIP, java.lang.String SCity, java.lang.String SDistrict, java.lang.String SStreet, javax.xml.rpc.holders.IntHolder SX, javax.xml.rpc.holders.IntHolder SY, javax.xml.rpc.holders.IntHolder SNID, java.lang.String ECountry, java.lang.String EZIP, java.lang.String ECity, java.lang.String EDistrict, java.lang.String EStreet, javax.xml.rpc.holders.IntHolder EX, javax.xml.rpc.holders.IntHolder EY, javax.xml.rpc.holders.IntHolder ENID, java.lang.String info, java.lang.String email, java.lang.String phone, java.lang.String mobile, java.lang.String fax, java.lang.String LSkills, java.lang.Integer capacity, java.lang.Integer speedPercent, java.lang.Integer workPercent, java.lang.Integer overtime, java.lang.Float costDay, java.lang.Float costCall, java.lang.Float costKm, java.lang.Float costHour, java.lang.Float costHourOvertime) throws java.rmi.RemoteException{
    if (visiTourSoap == null)
      _initVisiTourSoapProxy();
    return visiTourSoap.fieldManager(FMVTID, FMExtID, type, active, prename, name, regionID, areaOfExpertiseID, teamID, SCountry, SZIP, SCity, SDistrict, SStreet, SX, SY, SNID, ECountry, EZIP, ECity, EDistrict, EStreet, EX, EY, ENID, info, email, phone, mobile, fax, LSkills, capacity, speedPercent, workPercent, overtime, costDay, costCall, costKm, costHour, costHourOvertime);
  }
  
  public de.tourenserver.www.ArrayOfFixedCall fixSchedule(java.lang.String extID, java.lang.Integer VTID, java.util.Calendar start, java.util.Calendar end, java.lang.String regionID, java.lang.String teamID, java.lang.String areaOfExpertiseID, java.lang.String FMExtID, java.lang.Boolean unFix, java.lang.Boolean confirmCalls, java.lang.Boolean unconfirmCalls, java.lang.Boolean fixCalls, java.lang.Boolean fixTime, java.lang.Integer fixNextCalls, java.lang.Boolean show, java.lang.Boolean showReturn) throws java.rmi.RemoteException{
    if (visiTourSoap == null)
      _initVisiTourSoapProxy();
    return visiTourSoap.fixSchedule(extID, VTID, start, end, regionID, teamID, areaOfExpertiseID, FMExtID, unFix, confirmCalls, unconfirmCalls, fixCalls, fixTime, fixNextCalls, show, showReturn);
  }
  
  public de.tourenserver.www.ArrayOfGeoCodeRec geocode(java.lang.String country, java.lang.String ZIP, java.lang.String city, java.lang.String district, java.lang.String street, java.lang.String HNr, java.lang.Boolean fuzzy, java.lang.Boolean callSimulation) throws java.rmi.RemoteException{
    if (visiTourSoap == null)
      _initVisiTourSoapProxy();
    return visiTourSoap.geocode(country, ZIP, city, district, street, HNr, fuzzy, callSimulation);
  }
  
  public void mobileMessage(java.lang.Integer mandator, java.lang.String agent, java.lang.String FMExtID, java.util.Calendar timeStamp, int messageType, java.lang.Integer VTID, java.lang.String callID, java.lang.Integer duration, java.lang.Integer newState, java.lang.Integer substate, java.lang.String info, java.lang.Boolean searchNextCall, java.lang.Boolean scheduleNextCall, java.lang.Integer scheduleCalls, java.lang.String sentCallExtIDs, java.lang.String sentCallVTIDs, javax.xml.rpc.holders.IntHolder mobileMessageResult, de.tourenserver.www.holders.ArrayOfNextCallHolder nextCalls) throws java.rmi.RemoteException{
    if (visiTourSoap == null)
      _initVisiTourSoapProxy();
    visiTourSoap.mobileMessage(mandator, agent, FMExtID, timeStamp, messageType, VTID, callID, duration, newState, substate, info, searchNextCall, scheduleNextCall, scheduleCalls, sentCallExtIDs, sentCallVTIDs, mobileMessageResult, nextCalls);
  }
  
  public de.tourenserver.www.CallInfoRec showCallInfo(java.lang.Integer VTID, java.lang.String extID) throws java.rmi.RemoteException{
    if (visiTourSoap == null)
      _initVisiTourSoapProxy();
    return visiTourSoap.showCallInfo(VTID, extID);
  }
  
  public int workSchedule(java.lang.Integer FMVTID, java.lang.String FMExtID, java.util.Calendar startDate, java.util.Calendar endDate, java.util.Calendar startTime, java.util.Calendar endTime, java.lang.Integer startLocation, java.lang.Integer endLocation, java.lang.String days, java.lang.Integer type, java.lang.String info, java.lang.Boolean replanning) throws java.rmi.RemoteException{
    if (visiTourSoap == null)
      _initVisiTourSoapProxy();
    return visiTourSoap.workSchedule(FMVTID, FMExtID, startDate, endDate, startTime, endTime, startLocation, endLocation, days, type, info, replanning);
  }
  
  
}