package com.athira.demo.common;

import org.springframework.http.HttpStatus;

public class APIResponse { // Storing response from appserver

	private Integer status;
	private Object data; // emailId, roleId, jwtToken
	private Object error;
	
	public APIResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public APIResponse(Integer status, Object data, Object error) {
		super();
		this.status = HttpStatus.OK.value(); // 200, 401, 404
		this.data = data;
		this.error = error;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}
	
}
