package com.ideas2it.bookmymovie.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Component
public class RoleDto {
    private int roleId;
    private String roleType;
    @JsonManagedReference
    private List<UsersDto> users = new ArrayList<>();
}
