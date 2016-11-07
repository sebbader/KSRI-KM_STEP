package edu.kit.aifb.step;

import org.apache.jena.rdf.model.RDFNode;
import org.apache.log4j.Level;

public class Config {
	

	private RDFNode device;
	private String deviceMAC;
	private String namespace;
	private SensorAccessMode mode;
	private String logLevel;
	private String ldpContainer;
	private String user;
	private String pwd;

	public void setDevice(RDFNode d) {
		device = d;
	}
	public RDFNode getDevice() {
		return device;
	}

	public void setMac(String mac) {
		deviceMAC = mac;
	}
	public String getMAC() {
		return deviceMAC;
	}

	public void setNamespace(String ns) {
		namespace = ns;
	}
	public String getNamespace() {
		return namespace;
	}

	public void setMode(RDFNode m) {
		if (m.toString().contains("low-energy")) {
			mode = SensorAccessMode.BLE;
		} else {
			mode = SensorAccessMode.BLUETOOTH;
		}
	}
	public SensorAccessMode getMode() {
		return mode;
	}

	public void setLogLevel(String l) {
		logLevel = l;
	}
	public Level getLogLevel() {
		if (logLevel.contains("fatal")) {
			return Level.FATAL;
		} else if (logLevel.contains("error")) {
			return Level.ERROR;
		} else if (logLevel.contains("warn")) {
			return Level.WARN;
		} else if (logLevel.contains("info")) {
			return Level.INFO;
		} else if (logLevel.contains("debug")) {
			return Level.DEBUG;
		} else {
			return Level.INFO;
		}
	}
	
	public void setLDPContainer(String container) {
		ldpContainer = container;
	}
	public String getLDPContainer() {
		return ldpContainer;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}
