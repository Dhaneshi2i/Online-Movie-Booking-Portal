package com.ideas2it.bookmymovie.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// TODO: Auto-generated Javadoc
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

//    private ResponseEntity<Map<Object,String>> buildResponseEntities(Map<ApiError,String> apiErrorMap) {
//        return new ResponseEntity<>(apiErrorMap, apiErrorMap.getOrDefault(handleMethodArgumentNotValid(get)));
//    }
    /**
     * Handle entity not found.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex)
    {

        return null;

    }

    /**
     * Handle constraint violation.
     *
     * @param ex the ex
     * @return the response entity
     */
//    protected ResponseEntity<Object> handleConstraintViolation(MethodArgumentNotValidException ex)
//    {
//        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
//        //apiError.setMessage(ex.getMessage());
//        apiError.addValidationErrors(ex.getMessage());
//        return buildResponseEntity(apiError);
//
//    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
                                                                  final HttpHeaders headers, final HttpStatus status,
                                                                  final WebRequest request) {
        ApiError apiError = new ApiError();
        Map<String, ApiError> errorMap = new HashMap<>();
        final List<String> details = new ArrayList<>();
        for (final ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }

        for(String detail :details) {
            ex.getBindingResult().getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(),new ApiError(HttpStatus.BAD_REQUEST,detail,ex.getFieldErrors()));
            });
        }




//        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,errorMap,ex.getLocalizedMessage());
//        final List<String> details = new ArrayList<>();
//        for (final ObjectError error : ex.getBindingResult().getAllErrors()) {
//            details.add(error.getDefaultMessage());
//        }
//        errorMap.put(apiError);
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
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
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
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
}