package com.blog.api.restfull.converter;

import com.blog.api.restfull.dto.TCommentDto;
import com.blog.api.restfull.entity.TComment;
import org.springframework.beans.factory.annotation.Autowired;

public class TCommentConverter implements Converter<TComment, TCommentDto>{

    @Autowired private TArticleConverter articleConverter;
    @Autowired private TUserConverter userConverter;


    @Override
    public TComment toEntity(TCommentDto tCommentDto) {
        return tCommentDto.equals(null) ? null :
                TComment.builder().id(tCommentDto.getId())
                        .comment(tCommentDto.getComment())
                        .date_publication(tCommentDto.getDate_publication())
                        .fk_article(articleConverter.toEntity(tCommentDto.getFk_article()))
                        .fk_user(userConverter.toEntity(tCommentDto.getFk_user()))
                        .build();
    }

    @Override
    public TCommentDto toDto(TComment tComment) {
        return tComment.equals(null) ? null :
                TCommentDto.builder().id(tComment.getId())
                        .comment(tComment.getComment())
                        .date_publication(tComment.getDate_publication())
                        .fk_article(articleConverter.toDto(tComment.getFk_article()))
                        .fk_user(userConverter.toDto(tComment.getFk_user()))
                        .build();
    }
}
