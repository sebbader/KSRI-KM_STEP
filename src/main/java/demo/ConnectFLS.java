package demo;

import java.rmi.RemoteException;
import java.util.HashMap;

import de.tourenserver.www.CallInfoRec;
import de.tourenserver.www.FixedCall;
import de.tourenserver.www.GeoCodeRec;
import de.tourenserver.www.VisiTourSoap;
import de.tourenserver.www.VisiTourSoapProxy;

public class ConnectFLS {


	public CallInfoRec showCallInfo(Integer VTID, String extID) throws RemoteException {
		VisiTourSoap service = new VisiTourSoapProxy();
		return service.showCallInfo(VTID, extID);
	}

	/**
	 * 
	 * @param VTID
	 * @param extID
	 * @return
	 * @throws RemoteException
	 */
	public HashMap<String, Float> getGPSofCustomer(Integer VTID, String extID) throws RemoteException {
		
		VisiTourSoap service = new VisiTourSoapProxy();
		CallInfoRec callInfo = service.showCallInfo(VTID, extID);

		String country = callInfo.getCountry();
		String ZIP = callInfo.getZIP();
		String city = callInfo.getCity();
		String street = callInfo.getStreet();
		String HNr = "1";
		GeoCodeRec geoCode = service.geocode(country, ZIP, city, null, street, HNr, null, false).getGeoCodeRec(0);

		float gps_longitude = ( (float) geoCode.getX()) / 100000;
		float gps_latitude = ( (float) geoCode.getY()) / 100000;

		HashMap<String, Float> gps = new HashMap<String, Float>();
		gps.put("gps_longitude", gps_longitude);
		gps.put("gps_latitude", gps_latitude);
		
		return gps;

	}
	
	
	public void getFixedSchedule(Integer VTID, String extID) throws RemoteException {
		
		VisiTourSoap service = new VisiTourSoapProxy();
		FixedCall[] calls = service.fixSchedule(extID, VTID, null, null, null, null, null, null, null, null, null, null, null, null, true, null).getFixedCall();
		
		calls[0].getDrivingTime();
	}


}
