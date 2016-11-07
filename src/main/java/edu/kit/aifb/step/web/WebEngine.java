package edu.kit.aifb.step.web;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import edu.kit.aifb.step.sensor.web.AdministrationShellWebAPI;

@ApplicationPath(value = "/wrapper")
public class WebEngine extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(AdministrationShellWebAPI.class);
        return s;
    }
	

}
