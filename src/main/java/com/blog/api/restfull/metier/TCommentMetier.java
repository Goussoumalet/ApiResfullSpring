package com.blog.api.restfull.metier;

import com.blog.api.restfull.dto.TCommentDto;

import java.util.List;

public interface TCommentMetier {
    List<TCommentDto> list();
    TCommentDto find(Long id);
    TCommentDto save(TCommentDto dto);
    TCommentDto update(TCommentDto dto);
    boolean delete(Long id);
}
