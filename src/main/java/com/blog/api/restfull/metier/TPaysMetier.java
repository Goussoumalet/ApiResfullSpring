package com.blog.api.restfull.metier;

import com.blog.api.restfull.dto.TPaysDto;

import java.util.List;

public interface TPaysMetier {
    List<TPaysDto> list();
    TPaysDto find(Long id);
    TPaysDto save(TPaysDto dto);
    TPaysDto update(TPaysDto dto);
    boolean delete(Long id);
}
