package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.CastDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

public interface CastService {
    CastDto addCast(CastDto castDto);
    CastDto getCastByName(String name) throws NotFoundException;
}
