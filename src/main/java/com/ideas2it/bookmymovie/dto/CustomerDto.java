package com.ideas2it.bookmymovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDto {
    private BigDecimal customerId;
    private String customerName;
    private String mobileNumber;
    private String emailId;
    private String password;
}
