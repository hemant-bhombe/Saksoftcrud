package com.saksoft.crud.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiErrror {
	
	private Integer code;
	private String message;
	private Date timesDate;
	private String path;
	private HttpStatus error;
	private String trace;
}
