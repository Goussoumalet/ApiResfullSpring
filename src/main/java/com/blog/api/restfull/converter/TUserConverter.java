package com.blog.api.restfull.converter;

import com.blog.api.restfull.dto.TUserDto;
import com.blog.api.restfull.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TUserConverter implements  Converter<TUser, TUserDto> {

    @Autowired
    private TPaysConverter paysConverter;

    @Override
    public TUser toEntity(TUserDto tUserDto) {
        return tUserDto.equals(null) ? null :
                TUser.builder().id(tUserDto.getId())
                        .username(tUserDto.getUsername())
                        .firstname(tUserDto.getFirstname())
                        .lastname(tUserDto.getLastname())
                        .inscription(tUserDto.getInscription())
                        .age(tUserDto.getAge())
                        .fk_pays(paysConverter.toEntity(tUserDto.getFk_pays()))
                        .build();
    }

    @Override
    public TUserDto toDto(TUser tUser) {
        return tUser.equals(null) ? null :
                TUserDto.builder().id(tUser.getId())
                        .username(tUser.getUsername())
                        .firstname(tUser.getFirstname())
                        .lastname(tUser.getLastname())
                        .inscription(tUser.getInscription())
                        .age(tUser.getAge())
                        .fk_pays(paysConverter.toDto(tUser.getFk_pays()))
                        .build();
    }
}
