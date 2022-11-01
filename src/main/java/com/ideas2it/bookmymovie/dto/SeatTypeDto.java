package com.ideas2it.bookmymovie.dto;

import com.ideas2it.bookmymovie.model.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatTypeDto {

    private int seatTypeId;
    @NotBlank
    private String seatType;
    @NotNull
    private int noOfColumns;
    @NotNull
    private int noOfRows;
    @NotNull
    private float price;
}
