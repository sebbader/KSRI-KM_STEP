package main.java.web;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


<<<<<<< HEAD
@ApplicationPath("/test")
=======
@ApplicationPath("/")
>>>>>>> refs/remotes/origin/master
public class AppConfig extends Application {
	

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<Class<?>>();
		resources.add(JSONParser.class);

		return resources;
	}

}
