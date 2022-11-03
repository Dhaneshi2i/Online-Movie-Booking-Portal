package com.ideas2it.bookmymovie.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * ApiError
 *
 * @author : Harini,Dhanesh,SivaDharshini
 * @version : 1.0
 */
@Data
public class ApiError {

    /** The status. */
    private HttpStatus status;

    /** The time stamp. */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timeStamp;

    /** The message. */
    private String message;

    /** The sub errors. */
    private List<ApiSubError> subErrors;



//    public ApiError(HttpStatus status, String message, Throwable ex)
//    {
//        this();
//        this.status= status;
//        this.message = ex.getMessage();
//        this.debugMessage= ex.getLocalizedMessage();
//
//
//    }

    public ApiError(HttpStatus status, String detail,List<FieldError> subError) {
        this();
        this.status = status;
        this.message = detail;
        this.subErrors = addValidationErrors(subError);
    }

    public ApiError() {
    }

    public ApiError(HttpStatus status) {
        this.status = status;
    }

    /**
     * Adds the sub error.
     *
     * @param subError the sub error
     */
    private List<ApiSubError> addSubError(ApiSubError subError)
    {
        if(subErrors == null )
        {
            subErrors = new ArrayList<>();
        }
        subErrors.add(subError);
        return subErrors;
    }



    /**
     * Adds the validation error.
     *
     * @param object the object
     * @param field the field
     * @param rejectedValue the rejected value
     * @param message the message
     */
    private List<ApiSubError> addValidationError(String object, String field, Object rejectedValue, String message)
    {
        return addSubError(new ApiValidationError(object, field, rejectedValue, message));
    }

    /**
     * Adds the validation error.
     *
     * @param fieldError the field error
     */
    private List<ApiSubError> addValidationError(FieldError fieldError) {
        return this.addValidationError(
                fieldError.getObjectName(),
                fieldError.getField(),
                fieldError.getRejectedValue(),
                fieldError.getDefaultMessage());

    }

    /**
     * Adds the validation errors.
     *
     * @param fieldErrors the field errors
     */
    public List<ApiSubError> addValidationErrors(List<FieldError> fieldErrors)
    {
        List<ApiSubError> error = null;
        for(FieldError fieldError: fieldErrors)
        {
            error = addValidationError(fieldError);
        }
        return error;
    }

    public void addValidationErrors(String message) {
    }
}