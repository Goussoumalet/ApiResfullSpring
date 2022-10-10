package com.blog.api.restfull.converter;

import com.blog.api.restfull.dto.TCategoryDto;
import com.blog.api.restfull.entity.TCategory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TCategoryConverter implements Converter<TCategory, TCategoryDto>{

    @Override
    public TCategory toEntity(TCategoryDto tCategoryDto) {
        return tCategoryDto.equals(null) ? null :
                TCategory.builder().id(tCategoryDto.getId())
                        .title(tCategoryDto.getTitle())
                        .description(tCategoryDto.getDescription())
                        //.date(tCategoryDto.getDate())
                        .build();
    }

    @Override
    public TCategoryDto toDto(TCategory tCategory) {
        return tCategory.equals(null) ? null :
                TCategoryDto.builder().id(tCategory.getId())
                        .title(tCategory.getTitle())
                        .description(tCategory.getDescription())
                       // .date(tCategory.getDate())
                        .build();
    }
}
