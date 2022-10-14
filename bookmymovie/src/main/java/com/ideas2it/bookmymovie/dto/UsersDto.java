package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * A DTO for the {@link com.ideas2it.bookmymovie.model.Users} entity
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UsersDto {
    private int userId;
    private String name;
    private String emailId;
    private long contactNumber;
    private Role role;
}

