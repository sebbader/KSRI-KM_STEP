package edu.kit.aifb.step.sensor.simulator;

import java.util.Observable;

public class Sensor extends Observable {

	private double temperature;
	private double pressure;
	
	private long updateIntervall;
	public boolean stop = false;

	/**
	 * 
	 * @param updateIntervall the time in milliseconds until a new value is generated
	 * @throws InterruptedException 
	 */
	public Sensor(long updateIntervall)  {
		this.updateIntervall = updateIntervall;
	}

	public void startSensing() {
		stop = false;

		while(!stop) {
			try {
				Thread.sleep(updateIntervall);
				getNewValues();
			} catch (InterruptedException e) {
				break;
			}
		}
		
	}

	private void getNewValues() {
		this.temperature = Math.random() * 100;
		this.pressure = Math.random() * 10000;
		
		setChanged();
		notifyObservers(this);
	}

	public double getTemperature() {
		return temperature;
	}


	public double getPressure() {
		return pressure;
	}
}
