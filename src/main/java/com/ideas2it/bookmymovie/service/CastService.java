package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.CastDto;

import java.util.List;

/**
 * <p>
 * This {@Code CastService} interface used for crud operations
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
public interface CastService {

    /**
     * <p>
     * This method is used to create Cast Details
     * </p>
     *
     * @param castDto it contains cast dto objects
     * @return CastResponseDto
     */
    CastDto addCast(CastDto castDto);

    /**
     * <p>
     * This method gets castId as parameter and get the Cast Details which matches the id
     * </p>
     *
     * @param castId it contains cast id
     * @return CastDto
     */
    CastDto getByCastId(int castId);

    List<CastDto> getAllCasts();
}
