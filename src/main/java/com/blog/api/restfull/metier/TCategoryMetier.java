package com.blog.api.restfull.metier;

import com.blog.api.restfull.dto.TCategoryDto;

import java.util.List;

public interface TCategoryMetier {
    List<TCategoryDto> list();
    TCategoryDto find(Long id);
    TCategoryDto save(TCategoryDto dto);
    TCategoryDto update(TCategoryDto dto);
    boolean delete(Long id);
}
