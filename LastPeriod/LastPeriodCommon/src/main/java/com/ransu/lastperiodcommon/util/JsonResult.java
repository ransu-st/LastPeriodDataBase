package com.ransu.lastperiodcommon.util;

import lombok.Data;

@Data
public class JsonResult<T> {

	private int code;
	private String message;
	private T data;

	public JsonResult(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public JsonResult(int code, String message, T result) {
		this.code = code;
		this.message = message;
		this.data = result;
	}
}
