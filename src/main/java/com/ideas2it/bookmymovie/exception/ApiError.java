package com.ideas2it.bookmymovie.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * ApiError
 *
 * @author : Harini,Dhanesh,SivaDharshini
 * @version : 1.0
 */
@Data
public class ApiError {

    private HttpStatus status;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timeStamp = LocalDateTime.now();

    private String message;

    private List<ApiSubError> subErrors;

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
     * @param field the field
     * @param rejectedValue the rejected value
     * @param message the message
     */
    private List<ApiSubError> addValidationError(String field, Object rejectedValue, String message) {
        return addSubError(new ApiValidationError(field, rejectedValue, message));
    }

    /**
     * Adds the validation error.
     *
     * @param fieldError the field error
     */
    private List<ApiSubError> addValidationError(FieldError fieldError) {
        return this.addValidationError(
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

}