package com.blog.api.restfull.metier.impl;

import com.blog.api.restfull.converter.TPaysConverter;
import com.blog.api.restfull.dto.TPaysDto;
import com.blog.api.restfull.entity.TPays;
import com.blog.api.restfull.metier.TPaysMetier;
import com.blog.api.restfull.dao.TPaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TPaysImpl implements TPaysMetier {

    @Autowired private TPaysRepository paysRepository;
    @Autowired private TPaysConverter paysConverter;

    @Override
    public List<TPaysDto> list() {
         return paysRepository.findAll().stream()
                .map(cat -> paysConverter.toDto(cat))
                .collect(Collectors.toList());
    }

    @Override
    public TPaysDto find(Long id) {
        if(!paysRepository.existsById(id)){
            return null;
        }
        return paysConverter.toDto(paysRepository.getById(id));
    }

    @Override
    public TPaysDto save(TPaysDto dto) {
        if(dto.equals(null)){
            return null;
        }
        TPays pays = paysConverter.toEntity(dto);
        paysRepository.save(pays);
        return paysConverter.toDto(pays);
    }

    @Override
    public TPaysDto update(TPaysDto dto) {
        if(dto.equals(null) || dto.getId().equals(null) ||
                !paysRepository.existsById(dto.getId())){
            return null;
        }
        TPays pays = paysConverter.toEntity(dto);
        paysRepository.save(pays);
        return paysConverter.toDto(pays);
    }

    @Override
    public boolean delete(Long id) {
        if(!paysRepository.existsById(id)){
            return false;
        }
        paysRepository.deleteById(id);
        return true;
    }
}
