package com.saksoft.crud.app.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(IDNotAvailableException.class)
	public ResponseEntity<ApiErrror> IDNotAvailableExceptionHandler(IDNotAvailableException e, HttpServletRequest request)
	{
		ApiErrror ap=new ApiErrror();
		ap.setCode(HttpStatus.NOT_FOUND.value());
		ap.setError(HttpStatus.NOT_FOUND);
		ap.setMessage(e.getMessage());
		ap.setTimesDate(new Date());
		ap.setTrace(e.toString());
		ap.setPath(request.getRequestURI());
		
		return new ResponseEntity<ApiErrror>(ap, HttpStatus.NOT_FOUND);
	}
}
