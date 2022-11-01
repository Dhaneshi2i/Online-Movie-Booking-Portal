package com.ideas2it.bookmymovie.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorMapper {
    private String url;
    private String message;
    private Date now;

    public ErrorMapper(String url, String message, Date now) {
        super();
        this.url = url;
        this.message = message;
        this.now = now;
    }

}

