package com.blog.api.restfull.converter;

import com.blog.api.restfull.dto.TPaysDto;
import com.blog.api.restfull.entity.TPays;
import org.springframework.stereotype.Component;

@Component
public class TPaysConverter implements Converter<TPays, TPaysDto>{
    @Override
    public TPays toEntity(TPaysDto tPaysDto) {
        return tPaysDto.equals(null) ? null :
                TPays.builder().id(tPaysDto.getId())
                        .name(tPaysDto.getName())
                        .description(tPaysDto.getDescription())
                        .date(tPaysDto.getDate())
                        .build();
    }

    @Override
    public TPaysDto toDto(TPays tPays) {
        return tPays.equals(null) ? null :
                TPaysDto.builder().id(tPays.getId())
                        .name(tPays.getName())
                        .description(tPays.getDescription())
                        .date(tPays.getDate())
                        .build();
    }
}
