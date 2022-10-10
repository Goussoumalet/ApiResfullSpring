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
public class TArticleDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("date_publication")
    private Date date_publication;

    @JsonProperty("fk_user")
    private TUserDto fk_user;

    @JsonProperty("fk_category")
    private TCategoryDto fk_category;
}
