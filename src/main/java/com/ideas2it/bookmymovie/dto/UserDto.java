package com.ideas2it.bookmymovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private BigDecimal userId;
    private String userName;
    private String password;
    private String role;
    private CustomerDto customer;
}
