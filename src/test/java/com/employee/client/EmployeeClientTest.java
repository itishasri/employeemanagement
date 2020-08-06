package com.employee.client;

import static org.junit.Assert.*;

import org.junit.Test;

import com.employee.client.EmployeeClient;
import com.employee.model.Employee;


public class EmployeeClientTest {

	@Test
	public void testAdd() {
		Employee employee = new Employee();                                                                             
		employee.setEmployeeName("Rohit Sharma");
		employee.setEmployeeMobileNumber(Long.parseLong("98643579"));
		employee.setEmployeeLocation("Mumbai");

		EmployeeClient employeeClient = new EmployeeClient();
		employeeClient.add(employee);
		assertNotNull(employeeClient);
	}
	@Test
	public void getEmp() {
		EmployeeClient employeeClient = new EmployeeClient();
		Employee employee = employeeClient.getEmployee((long) 132);
		assertNotNull(employee);
	}

	@Test
	public void getAllEmp() {
		EmployeeClient employeeClient = new EmployeeClient();
		employeeClient.getAllEmployee();
		assertNotNull(employeeClient);
	}

	@Test
	public void testDelete() {
		long id = 133;
		EmployeeClient employeeClient = new EmployeeClient();
		employeeClient.delete(id);
		assertNotNull(employeeClient);
	}



}
