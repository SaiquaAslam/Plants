package com.sprint.plant.exception;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Saiqua Aslam
 *
 */

@ControllerAdvice
public class PMSException extends ResponseEntityExceptionHandler {
	/**
	 * customise exception
	 */
	@ExceptionHandler(PlantNotFoundException.class)

	public ResponseEntity<ErrorDetails> handleException(PlantNotFoundException exception, WebRequest request) {
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}

	/**
	 * default exception
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * validation exception
	 */
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
