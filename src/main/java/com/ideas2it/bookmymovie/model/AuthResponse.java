package com.ideas2it.bookmymovie.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
    public class AuthResponse implements Serializable {
        private String webToken;
    }
