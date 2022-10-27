package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.CastDto;
import com.ideas2it.bookmymovie.dto.responseDto.CastResponseDto;

public interface CastService {
    CastResponseDto addCast(CastDto castDto);
    CastDto getByCastId(int castId);
}
