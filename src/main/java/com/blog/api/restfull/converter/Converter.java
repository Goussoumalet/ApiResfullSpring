package com.blog.api.restfull.converter;

public interface Converter<ENTITY, DTO> {
    ENTITY toEntity(DTO dto);
    DTO toDto(ENTITY entity);
}
