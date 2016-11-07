package edu.kit.aifb.step.sensor.AdministrationShell;

import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;

import javax.bluetooth.*; 
import javax.microedition.io.*; 
import javax.obex.*;

import com.intel.bluetooth.obex.*;


public class BluetoothServiceRegistration extends IncomingDataServer {

	public SessionNotifier notifier;

	private String incomingData;
	private String sendingDevice;
	
	
	public BluetoothServiceRegistration () {
		// do nothing
	}

	
	//start server
	@Override
	public void startServer() {

		LocalDevice localDevice = null;
		try {
			
			localDevice = LocalDevice.getLocalDevice();
			System.out.println("Local Bluetooth Address: "+localDevice.getBluetoothAddress());
			System.out.println("Local Bluetooth Name: "+localDevice.getFriendlyName());
			
		} catch (BluetoothStateException e2) {
			e2.printStackTrace();
			System.out.println("Bluetooth Server could not access local Bluetooth device.");
			System.exit(1);
			
		}

		//Create a UUID for SPP
		UUID uuid = new UUID("1105", true);

		//open server with URL
		try {
			notifier = (SessionNotifier) Connector.open("btgoep://localhost:"+ uuid + ";name=MyBTService");
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("Bluetooth Server could not start.");
			System.exit(1);
		}

		//Wait for client connection
		System.out.println("\nBluetooth Server Started. Waiting for clients to connect...");
		int count = 0;

		try {
			RequestHandler handler = new RequestHandler();
			while(true) {
				notifier.acceptAndOpen(handler);
				setChanged();
				notifyObservers();
				System.out.println("Received OBEX connection #" + (++count));
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Bluetooth Server Stopped.");
		} 


		//        RemoteDevice dev = RemoteDevice.getRemoteDevice(connection);
		//        System.out.println("Remote device address: "+dev.getBluetoothAddress());
		//        System.out.println("Remote device name: "+dev.getFriendlyName(true));
		//
		//      //read string from spp client
		//        InputStream inStream=connection.openInputStream();
		//        BufferedReader bReader=new BufferedReader(new InputStreamReader(inStream));
		//        String lineRead=bReader.readLine();
		//        System.out.println(lineRead);
		//
		//        //send response to spp client
		//        OutputStream outStream=connection.openOutputStream();
		//        PrintWriter pWriter=new PrintWriter(new OutputStreamWriter(outStream));
		//        pWriter.write("Response String from SPP Server\r\n");
		//        pWriter.flush();
		//
		//        pWriter.close();

	}


	@Override
	public String getIncomingData() {
		return incomingData;
	}


	private void setIncomingData(String data) {
		this.incomingData = data;
	}


	@Override
	public String getSendingDevice() {
		return sendingDevice;
	}


	private void setSendingDevice(String sendingDevice) {
		this.sendingDevice = sendingDevice;
	}


	private class RequestHandler extends ServerRequestHandler {

		public int onPut(Operation op) {
			try {
				
				HeaderSet hs = op.getReceivedHeaders();
				String name = (String) hs.getHeader(HeaderSet.NAME);
				
				setSendingDevice(name);
				if (name != null) {
					System.out.println("put name:" + getSendingDevice());
				}

				
				InputStream is = op.openInputStream();
				StringBuffer buf = new StringBuffer();
				int data;
				while ((data = is.read()) != -1) {
					buf.append((char) data);
				}

				
				setIncomingData(buf.toString());
				System.out.println("received:" + getIncomingData());
				op.close();

				
				return ResponseCodes.OBEX_HTTP_OK;
				
				
			} catch (IOException e) {
				e.printStackTrace();
				return ResponseCodes.OBEX_HTTP_UNAVAILABLE;
			}
		}
	}


	public void run() {
		// TODO Auto-generated method stub
		
	}

	
}
