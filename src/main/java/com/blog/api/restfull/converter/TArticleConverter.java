package com.blog.api.restfull.converter;

import com.blog.api.restfull.dto.TArticleDto;
import com.blog.api.restfull.entity.TArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TArticleConverter implements Converter<TArticle, TArticleDto>{

    @Autowired
    private TCategoryConverter categoryConverter;

    @Autowired
    private TUserConverter userConverter;

    @Override
    public TArticle toEntity(TArticleDto tArticleDto) {
        return tArticleDto.equals(null) ? null :
                TArticle.builder().id(tArticleDto.getId())
                        .title(tArticleDto.getTitle())
                        .description(tArticleDto.getDescription())
                        .date_publication(tArticleDto.getDate_publication())
                        .fk_user(userConverter.toEntity(tArticleDto.getFk_user()))
                        .fk_category(categoryConverter.toEntity(tArticleDto.getFk_category()))
                        .build();
    }

    @Override
    public TArticleDto toDto(TArticle tArticle) {
        return tArticle.equals(null) ? null :
                TArticleDto.builder().id(tArticle.getId())
                        .title(tArticle.getTitle())
                        .description(tArticle.getDescription())
                        .date_publication(tArticle.getDate_publication())
                        .fk_user(userConverter.toDto(tArticle.getFk_user()))
                        .fk_category(categoryConverter.toDto(tArticle.getFk_category()))
                        .build();
    }
}
