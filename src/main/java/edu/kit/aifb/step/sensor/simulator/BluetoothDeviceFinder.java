package edu.kit.aifb.step.sensor.simulator;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.bluetooth.RemoteDevice;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.obex.ClientSession;
import javax.obex.HeaderSet;
import javax.obex.Operation;
import javax.obex.ResponseCodes;

public class BluetoothDeviceFinder {

	private BluetoothDeviceListener listener;

	public void find() {
		listener =  new BluetoothDeviceListener();

		System.out.println("start searching for connected Bluetooth devices...");
		listener.searchForDevices(listener);

		System.out.println("start searching for services...");
		listener.searchForServices(listener);

	}

	public ArrayList<RemoteDevice> getDevices() {
		return listener.devices;
	}
	
	public HashMap<Object, String> getServices() {
		return listener.services;
	}

	public void sendMessage(String serverURL, String message, String sender) throws IOException {

//		try{
	        
			System.out.println("Connecting to " + serverURL);
			
			ClientSession clientSession = (ClientSession) Connector.open(serverURL);
			HeaderSet hsConnectReply = clientSession.connect(null);
			if (hsConnectReply.getResponseCode() != ResponseCodes.OBEX_HTTP_OK) {
				System.out.println("Failed to connect");
				return;
			}

			HeaderSet hsOperation = clientSession.createHeaderSet();
			hsOperation.setHeader(HeaderSet.NAME, sender);
			hsOperation.setHeader(HeaderSet.TYPE, "text");

			//Create PUT Operation
			Operation putOperation = clientSession.put(hsOperation);

			// Send some text to server
			System.out.println("sending message: \n" + message);
			byte data[] = message.getBytes("iso-8859-1");
			OutputStream os = putOperation.openOutputStream();
			os.write(data);
			os.close();
			System.out.println("message sent");

			putOperation.close();

			clientSession.disconnect(null);

			clientSession.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
