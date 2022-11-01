package com.ideas2it.bookmymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * This AuthResponse Class contains details of token for the request
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
    public class AuthResponse implements Serializable {
        private String webToken;
    }
