package com.employee.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.employee.model.Employee;



public class EmployeeClient {


	private Client client;

	public EmployeeClient() {
		client = ClientBuilder.newClient();
	}
	
	public Employee add(Employee employee) {
		WebTarget target = client.target("http://localhost:8081/employee");
		Response response = target.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(employee, MediaType.APPLICATION_JSON));
		if (response.getStatus() != 201) {
			throw new RuntimeException(response.getStatus() + "Internal Server Error");
		}
		return employee;
	}


	public List<Employee> getAllEmployee() {
		WebTarget target = client.target("http://localhost:8081/employee");
		List<Employee> emp = target.request(MediaType.APPLICATION_JSON).get(List.class);
		return emp;
	}

	public void delete(Long employeeId) {

		WebTarget target = client.target("http://localhost:8081/employee");
		Response response = target.path("/"+employeeId).request(MediaType.APPLICATION_JSON).delete();

		if (response.getStatus() != 204) {
			throw new RuntimeException(response.getStatus() + ":there was an error in the server");
		}
	}

	
	public Employee getEmployee(Long id) {
		WebTarget target = client.target("http://localhost:8081/employee");
		Employee response = target.path("/" + id).request(MediaType.APPLICATION_JSON).get(Employee.class);
		return response;
	}



}
