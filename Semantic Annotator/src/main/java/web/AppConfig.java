package main.java.web;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import main.java.lucene.search.Autocompleter;


@ApplicationPath("/service")
public class AppConfig extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<Class<?>>();
		resources.add(JSONParser.class);
		resources.add(Autocompleter.class);

		return resources;
	}

}