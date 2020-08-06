package com.employee.model.Mapper;

import java.util.Map;

import com.employee.model.Employee;
import com.employee.model.builder.EmployeeBuilder;

public class EmployeeMapper {

	public static Employee employeemapper(Map<String, Object> body) {
		String employeeName=body.get("employeeName").toString();
		Long employeeMobileNumber=Long.parseLong(body.get("employeeMobileNumber").toString());
		String employeeLocation=body.get("employeeLocation").toString();
		EmployeeBuilder employeebuilder=new EmployeeBuilder();
		return employeebuilder.setEmployeeMobileNo(employeeMobileNumber).
				setEmployeeName(employeeName).setEmployeeLocation(employeeLocation).build();
		
	}
}
