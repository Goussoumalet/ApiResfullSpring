package com.blog.api.restfull.metier;

import com.blog.api.restfull.dto.TUserDto;

import java.util.List;

public interface TUserMetier {
    List<TUserDto> list();
    TUserDto find(Long id);
    TUserDto save(TUserDto dto);
    TUserDto update(TUserDto dto);
    boolean delete(Long id);
}
