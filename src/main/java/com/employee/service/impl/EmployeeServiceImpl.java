package com.employee.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.controller.EmployeeController;
import com.employee.exception.BadRequestException;
import com.employee.exception.EmployeeNotFound;
import com.employee.exception.ServerError;
import com.employee.model.Employee;
import com.employee.model.Mapper.EmployeeMapper;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeerepository;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Override
	public Response addEmployee(Map<String, Object> body) {
		// TODO Auto-generated method stub
		Employee employee=EmployeeMapper.employeemapper(body);
		if(employee.getEmployeeName()==null) {
			logger.info("Data is Invalid");
			throw new EmployeeNotFound("404", "Invalid Data to Save");
		}
		else if(employee.getEmployeeName()!=null){
			logger.info("Created Employee");
			return Response.status(Status.CREATED).entity(employeerepository.save(employee)).build();
			
		}
		throw new ServerError("500", "Internal Server error");
	}


	@Override
	public Response getEmployee() {
		// TODO Auto-generated method stub
		List<Employee> employeelist=new ArrayList<Employee>();
		employeelist=employeerepository.findAll();
		if(employeelist.size()==0) {
			logger.info("No Records Found for respective entity");
			throw new EmployeeNotFound("400", "No Data Found for employee");
		}
		
		return Response.status(Status.OK).entity(employeelist).build();
	}


	@Override
	public Response getEmployeeById(Long id) {
		// TODO Auto-generated method stub
	Optional<Employee> employeeoptional=employeerepository.findById(id);
	if(employeeoptional.isPresent()) {
		Employee employee=employeeoptional.get();
		logger.info("Employee is Present");
		return Response.status(Status.OK).entity(employee).build();
	}else if(!employeeoptional.isPresent()){
		logger.info("Invalid Employee Id");
		throw new EmployeeNotFound("404", "No Employee Found with above Id");
	}
		throw new ServerError("500", "internal Server error");
	}


	@Override
	public Response deleteById(Long id) {
		// TODO Auto-generated method stub
		if(id==null) {
			logger.info("Please provide valid Id");
			throw new BadRequestException("400", "bad Request");
		}
		else if(id!=null) {
			employeerepository.deleteById(id);
			Map<String, String> result = new HashMap<String, String>();
			result.put("Message", "Deleted Successfully");
			return Response.status(Status.NO_CONTENT).entity(result).build();
		}
		
		throw new ServerError("500", "Internal Server Error");
	}
	
	

}
