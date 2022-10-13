package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.enums.Role;
import lombok.Data;

/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Users} entity
 */
@Data
public class UsersDto {
    private int userId;
    private String name;
    private String emailId;
    private long contactNumber;
    private Role role;
}