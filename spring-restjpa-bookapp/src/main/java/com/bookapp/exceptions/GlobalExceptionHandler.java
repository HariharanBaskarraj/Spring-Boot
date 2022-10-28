package com.bookapp.exceptions;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bookapp.model.APIErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Request Method Not Supported";
		APIErrors errors = new APIErrors(LocalDateTime.now(), message, status, status.value(), error);
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Media type is Not Supported";
		APIErrors errors = new APIErrors(LocalDateTime.now(), message, status, status.value(), error);
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Missing path variable";
		APIErrors errors = new APIErrors(LocalDateTime.now(), message, status, status.value(), error);
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Missing request parameter";
		APIErrors errors = new APIErrors(LocalDateTime.now(), message, status, status.value(), error);
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Type mismatch";
		APIErrors errors = new APIErrors(LocalDateTime.now(), message, status, status.value(), error);
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<Object> handleBookNotFound(BookNotFoundException ex) {
		String message = ex.getMessage();
		String error = "Book Not Found Exception";
		APIErrors errors = new APIErrors(LocalDateTime.now(), message, HttpStatus.FORBIDDEN,
				HttpStatus.FORBIDDEN.value(), error);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(HttpStatus.FORBIDDEN).headers(headers).body(errors);
	}

	@ExceptionHandler(IDNotFoundException.class)
	public ResponseEntity<Object> handleIdNotFound(IDNotFoundException ex) {
		String message = ex.getMessage();
		String error = "Id Not Found Exception";
		APIErrors errors = new APIErrors(LocalDateTime.now(), message, HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(),
				error);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(HttpStatus.CONFLICT).headers(headers).body(errors);
	}

}
