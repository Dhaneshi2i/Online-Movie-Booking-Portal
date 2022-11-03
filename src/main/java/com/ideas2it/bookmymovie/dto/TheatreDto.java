package com.ideas2it.bookmymovie.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ideas2it.bookmymovie.model.Show;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * Theatre Dto class contains the theatre dto data.
 * </p>
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TheatreDto implements Serializable{

    private static final long serialVersionUID = 3710470335120544380L;

    private int id;

    @NotBlank(message = "Please, Enter theatre name. Theatre name should not be empty")
    private String theatreName;

    @NotBlank(message = "Please, Enter theatre city. Theatre location should not empty")
    @Pattern(regexp="^(Chennai|Mumbai|Delhi|Hyderabad|Kochi)$",message="Invalid city. Valid Values are 1. Chennai 2. Mumbai 3. Delhi 4.Hyderabad 5.Kochi ")
    private String theatreCity;

    private List<Show> shows = new ArrayList<>();
}
