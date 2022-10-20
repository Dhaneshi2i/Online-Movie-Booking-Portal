package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.CastDto;

public interface CastService {
    CastDto addCast(CastDto castDto);
    CastDto getByCastId(int castId);
}
