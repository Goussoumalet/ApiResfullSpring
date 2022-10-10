package com.blog.api.restfull.dto;

import com.blog.api.restfull.entity.TPays;
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
public class TUserDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("inscription")
    private Date inscription;

    @JsonProperty("age")
    private Date age;

    @JsonProperty( "fk_pays")
    private TPaysDto fk_pays;
}
