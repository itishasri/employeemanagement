package com.employee.model.builder;

import com.employee.model.Employee;

public class EmployeeBuilder {

	private Long employeeId;
	private String employeeName;
	private Long employeeMobileNo;
	private String employeeLocation;

	public EmployeeBuilder setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
		return this;
	}

	public EmployeeBuilder setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
		return this;
	}

	public EmployeeBuilder setEmployeeMobileNo(Long employeeMobileNo) {
		this.employeeMobileNo = employeeMobileNo;
		return this;
	}

	public EmployeeBuilder setEmployeeLocation(String employeeLocation) {
		this.employeeLocation = employeeLocation;
		return this;
	}


	public Employee build() {
		Employee emp = new Employee(employeeId, employeeName, employeeMobileNo, employeeLocation);
		return emp;
	}


}
