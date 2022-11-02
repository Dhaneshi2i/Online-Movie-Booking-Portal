package com.ideas2it.bookmymovie.exception;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ApiValidationError extends ApiSubError {

    private String object;

    private String field;

    private Object rejectedValue;

    private String message;


    ApiValidationError(String object, String msg) {
        this.message = msg;
        this.object = object;
    }
}
