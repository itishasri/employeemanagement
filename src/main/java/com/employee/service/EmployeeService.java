package com.employee.service;

import java.util.Map;

import javax.ws.rs.core.Response;

public interface EmployeeService {

	public Response addEmployee(Map<String, Object> body);
	
	public Response getEmployee();
	
	public Response getEmployeeById(Long id);
	
	public Response deleteById(Long id);
}
