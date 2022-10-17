package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.CastDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;

import java.util.List;

public interface CastService {
    CastDto addCast(CastDto castDto);
    CastDto getCastByName(String name) throws NotFoundException;
    List<CastDto> getAllCast() throws NotFoundException;
}
