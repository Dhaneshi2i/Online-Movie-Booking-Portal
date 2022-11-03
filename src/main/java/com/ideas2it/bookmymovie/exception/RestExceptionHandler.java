package com.ideas2it.bookmymovie.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The Class RestExceptionHandler.
 *
 * @author : Harini,Dhanesh,SivaDharshini
 * @version : 1.0
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Builds the response entity.
     *
     * @param apiError the api error
     * @return the response entity
     */
    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {

        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorMapper errorMapper) {

        return new ResponseEntity<>(errorMapper, errorMapper.getStatus());
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
                                                                  final HttpHeaders headers, final HttpStatus status,
                                                                  final WebRequest request) {
        Set<ApiError> errorMap = new LinkedHashSet<>();
        errorMap.add(new ApiError(HttpStatus.BAD_REQUEST, ex.getFieldErrors().get(0).getDefaultMessage(),
                ex.getFieldErrors() ));
        return new ResponseEntity(errorMap, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle no such element exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleNoSuchElementException(NotFoundException ex)
    {
        return buildResponseEntity(new ErrorMapper(HttpStatus.NOT_FOUND,ex.getMessage()));
    }

    /**
     * Handle no such element exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(AlreadyExistException.class)
    protected ResponseEntity<Object> handleAlreadyExistException(AlreadyExistException ex)
    {
        return buildResponseEntity(new ErrorMapper(HttpStatus.BAD_REQUEST,ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleAlreadyExistException(Exception ex)
    {
        return buildResponseEntity(new ErrorMapper(HttpStatus.BAD_REQUEST,ex.getMessage()));
    }
}