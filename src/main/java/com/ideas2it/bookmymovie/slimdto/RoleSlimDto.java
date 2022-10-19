package com.ideas2it.bookmymovie.slimdto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.NamedQuery;

@Getter
@Setter
@NoArgsConstructor
public class RoleSlimDto {
    private int roleId;
    private String name;
}
