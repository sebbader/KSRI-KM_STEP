package application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


import sample.hello.resources.HelloResource;


@ApplicationPath(value = "/rest")
public class App extends Application {
//
//	public App() {
//		BeanConfig beanConfig = new BeanConfig();
//		beanConfig.setVersion("1.0.0");
//		beanConfig.setBasePath("/hello");
//		beanConfig.setResourcePackage("org.resteasy.rest");
//		beanConfig.setScan(true);
//	}


	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<Class<?>>();
		resources.add(HelloResource.class);
		


		return resources;
	}

}