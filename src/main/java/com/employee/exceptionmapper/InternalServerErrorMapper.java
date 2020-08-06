package com.employee.exceptionmapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.employee.exception.ServerError;
import com.employee.response.CustomError;



public class InternalServerErrorMapper implements ExceptionMapper<ServerError> {

	@Override
	public Response toResponse(ServerError exception) {
		CustomError error = new CustomError();
		error.setErrorCode(exception.getErrorCode());
		error.setErrorMessage(exception.getErrorMessage());
		return Response.status(500).entity(error).type(MediaType.APPLICATION_JSON).build();
	}

}
