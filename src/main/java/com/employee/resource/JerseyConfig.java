package com.employee.resource;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.employee.controller.EmployeeController;


@Component
public class JerseyConfig extends ResourceConfig{
	
	public JerseyConfig() {
		register(EmployeeController.class);
		

	}

}
