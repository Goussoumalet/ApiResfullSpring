package com.blog.api.restfull.metier.impl;

import com.blog.api.restfull.converter.TUserConverter;
import com.blog.api.restfull.dto.TUserDto;
import com.blog.api.restfull.entity.TUser;
import com.blog.api.restfull.metier.TUserMetier;
import com.blog.api.restfull.dao.TPaysRepository;
import com.blog.api.restfull.dao.TUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TUserImpl implements TUserMetier {
    
    @Autowired private TUserRepository userRepository;
    @Autowired private TUserConverter userConverter;
    @Autowired private TPaysRepository paysRepository;
    
    @Override
    public List<TUserDto> list() {
        return userRepository.findAll().stream()
                .map(art -> userConverter.toDto(art))
                .collect(Collectors.toList());
    }

    @Override
    public TUserDto find(Long id) {
        if(userRepository.existsById(id))
            return  userConverter.toDto(userRepository.getById(id));
        return null;
    }

    @Override
    public TUserDto save(TUserDto dto) {
        if(dto.equals(null))
            return null;
        if(dto.getFk_pays().equals(null) || dto.getFk_pays().getId().equals(null) ||
                !paysRepository.existsById(dto.getFk_pays().getId())){
            return null;
        }
        TUser user = userConverter.toEntity(dto);
        userRepository.save(user);
        return userConverter.toDto(user);
    }

    @Override
    public TUserDto update(TUserDto dto) {
        if(dto.equals(null) || dto.getId().equals(null)
                || !userRepository.existsById(dto.getId()))
            return null;
        if(dto.getFk_pays().equals(null) || dto.getFk_pays().getId().equals(null) ||
                !paysRepository.existsById(dto.getFk_pays().getId())){
            return null;
        }
        TUser user = userConverter.toEntity(dto);
         userRepository.save(user);
        return userConverter.toDto(user);
    }

    @Override
    public boolean delete(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
