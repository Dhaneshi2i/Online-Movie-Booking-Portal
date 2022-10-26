package com.ideas2it.bookmymovie.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class AuthRequest implements Serializable {
        private String userName;
        private String password;
    }
