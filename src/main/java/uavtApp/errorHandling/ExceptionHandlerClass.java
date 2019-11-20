package uavtApp.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import uavtApp.entity.ErrorResponse;

@ControllerAdvice
public class ExceptionHandlerClass extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exc){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(exc.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
}
