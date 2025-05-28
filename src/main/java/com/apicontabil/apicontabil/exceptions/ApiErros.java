package com.apicontabil.apicontabil.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public record ApiErros(LocalDateTime timestamp, Integer code, String status, List<String> errors) {

	public static ApiErros of(LocalDateTime timestamp, Integer code, String status, List<String> errors) {
		return new ApiErros(timestamp, code, status, errors); 
	}
}
