package com.employee.exceptionmapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.employee.exception.EmployeeNotFound;
import com.employee.response.CustomError;


public class EmployeeNotFoundExceptonMapper implements ExceptionMapper<EmployeeNotFound> {

	@Override
	public Response toResponse(EmployeeNotFound exception) {
		CustomError error = new CustomError();
		error.setErrorCode(exception.getErrorCode());
		error.setErrorMessage(exception.getErrorMessage());
		return Response.status(404).entity(error).type(MediaType.APPLICATION_JSON_PATCH_JSON).build();
	}

}
