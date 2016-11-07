package edu.kit.aifb.step.sensor.simulator;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.bluetooth.DataElement;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.obex.ClientSession;
import javax.obex.HeaderSet;
import javax.obex.Operation;
import javax.obex.ResponseCodes;

/**
 * CLass to find connected Bluetooth devices. 
 * Precondition is that the device and the unit running 
 * the JAVA code are already connected.
 * Possible error source is a missing/outdated version
 * of BlueZ (on Linux)
 * 
 * @author sba
 * @see http://www.aviyehuda.com/blog/2010/01/08/connecting-to-bluetooth-devices-with-java/
 *
 */
public class BluetoothDeviceListener implements DiscoveryListener{

	private static Object lock=new Object();
	public ArrayList<RemoteDevice> devices;
	public HashMap<Object, String> services;

	public BluetoothDeviceListener() {
		devices = new ArrayList<RemoteDevice>();
		services = new HashMap<Object, String>();
	}


	public void searchForDevices(DiscoveryListener listener) {

		try{
			System.out.println("Device Inquiry started. ");
			
			LocalDevice localDevice = LocalDevice.getLocalDevice();
			if (DiscoveryAgent.NOT_DISCOVERABLE == localDevice.getDiscoverable()) localDevice.setDiscoverable(DiscoveryAgent.GIAC); //make LOCAL device discoverable
			System.out.println("Local Bluetooth device status: " + localDevice.getDiscoverable());
			System.out.println("Local Bluetooth device address: " + localDevice.getBluetoothAddress());
			System.out.println("Local Bluetooth device name: " + localDevice.getFriendlyName());
			
			DiscoveryAgent agent = localDevice.getDiscoveryAgent();
			agent.startInquiry(DiscoveryAgent.GIAC, listener);
			
			try {
				synchronized(lock){
					lock.wait();
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
			
			System.out.println("Device Inquiry Completed. ");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public void searchForServices(DiscoveryListener listener) {

		try{
			System.out.println("Service search started.");
			
			LocalDevice localDevice = LocalDevice.getLocalDevice();
			DiscoveryAgent agent = localDevice.getDiscoveryAgent();

			UUID[] uuidSet = new UUID[1];
			uuidSet[0]=new UUID(0x1105); //OBEX Object Push service: 0x1105

			int[] attrIDs =  new int[] {
					0x0100 // Service name
			};

			for (RemoteDevice device : devices) {
				agent.searchServices(attrIDs,uuidSet,device,listener);

				try {
					synchronized(lock){
						lock.wait();
					}
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}

			}

			System.out.println("Service search finished.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//    @Override
	public void deviceDiscovered(RemoteDevice btDevice, DeviceClass arg1) {
		String name;
		try {
			name = btDevice.getFriendlyName(false);
		} catch (Exception e) {
			name = btDevice.getBluetoothAddress();
		}

		devices.add(btDevice);
		System.out.println("Remote device found: " + name);
		System.out.println("Remote device address: " + btDevice.getBluetoothAddress());
		System.out.println("Remote device major class: " + arg1.getMajorDeviceClass());
		System.out.println("Remote device minor class: " + arg1.getMinorDeviceClass());
		System.out.println("Remote device service classes: " + arg1.getServiceClasses());

	}

	//    @Override
	public void inquiryCompleted(int arg0) {
		synchronized(lock){
			lock.notify();
		}
	}

	//    @Override
	public void serviceSearchCompleted(int arg0, int arg1) {
		synchronized (lock) {
			lock.notify();
		}
	}

	//    @Override
	public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
		System.out.println("any type of service found");
		for (int i = 0; i < servRecord.length; i++) {
			String url = servRecord[i].getConnectionURL(ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false);
			if (url == null) {
				continue;
			}
			DataElement serviceName = servRecord[i].getAttributeValue(0x0100);
			if (serviceName != null) {
				System.out.println("service " + serviceName.getValue() + " found " + url);

				services.put(serviceName.getValue(), url);
//				if(serviceName.getValue().equals("OBEX Object Push")){
//					sendMessageToDevice(url);                
//				}
			} else {
				System.out.println("service found " + url);
				services.put("", url);
			}


		}
	}

}
