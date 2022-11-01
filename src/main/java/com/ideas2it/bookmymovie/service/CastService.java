package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.CastDto;

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
}
