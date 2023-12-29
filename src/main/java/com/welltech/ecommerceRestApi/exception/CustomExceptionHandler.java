package com.welltech.ecommerceRestApi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception e, WebRequest request) throws Exception{
        ErrorDetails errorDetails = ErrorDetails.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage())
                .timeStamp(LocalDateTime.now())
                .details(request.getDescription(false))
                .build();

        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserExistException.class)
    public final ResponseEntity<ErrorDetails> handleUserExistException(Exception e, WebRequest request) throws Exception{
        ErrorDetails errorDetails = ErrorDetails.builder()
                .status(HttpStatus.CONFLICT.value())
                .message(e.getMessage())
                .timeStamp(LocalDateTime.now())
                .details(request.getDescription(false))
                .build();

        return new ResponseEntity<>(errorDetails,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception e,WebRequest request) throws Exception{
        ErrorDetails errorDetails = ErrorDetails.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.getMessage())
                .timeStamp(LocalDateTime.now())
                .details(request.getDescription(false))
                .build();

        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Validation exception
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST.value(),
                e.getFieldError().getDefaultMessage(),
                LocalDateTime.now(),
                request.getDescription(false));

        return new ResponseEntity(errorDetails,HttpStatus.BAD_REQUEST);

    }
}
