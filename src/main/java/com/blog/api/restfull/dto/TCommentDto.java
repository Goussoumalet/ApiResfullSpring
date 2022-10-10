package com.blog.api.restfull.dto;

import com.blog.api.restfull.entity.TCategory;
import com.blog.api.restfull.entity.TUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TCommentDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("date_publication")
    private Date date_publication;

    @JsonProperty("fk_user")
    private TUserDto fk_user;

    @JsonProperty("fk_article")
    private TArticleDto fk_article;
}
