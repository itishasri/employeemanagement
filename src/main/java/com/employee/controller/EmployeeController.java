package com.employee.controller;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.employee.model.Employee;
import com.employee.service.impl.EmployeeServiceImpl;

@RestController
@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeServiceImpl employeeserviceimpl;
	
	@POST	
	public Response addEmployee(@RequestBody Map<String, Object> employee) {
		System.out.println("Into COnntroller");
		logger.info("Adding Data to Employee");
		return employeeserviceimpl.addEmployee(employee);
		
		
	}
	
	@GET
	public Response getEmployee() {
		
		return employeeserviceimpl.getEmployee();		
	}
	
	@GET
	@Path("/{id}")
	public Response getEmployeeId(@PathParam(value = "id") Long id) {
				
		return employeeserviceimpl.getEmployeeById(id);
		
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteById(@PathParam(value = "id") Long id) {
		return employeeserviceimpl.deleteById(id);
	}
}
