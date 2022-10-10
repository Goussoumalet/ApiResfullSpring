package com.blog.api.restfull.metier.impl;

import com.blog.api.restfull.converter.TCategoryConverter;
import com.blog.api.restfull.dto.TCategoryDto;
import com.blog.api.restfull.entity.TCategory;
import com.blog.api.restfull.metier.TCategoryMetier;
import com.blog.api.restfull.dao.TCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TCategoryImpl implements TCategoryMetier {

    @Autowired private TCategoryRepository categoryRepository;
    @Autowired private TCategoryConverter categoryConverter;

    @Override
    public List<TCategoryDto> list() {
        return categoryRepository.findAll().stream()
                .map(cat -> categoryConverter.toDto(cat))
                .collect(Collectors.toList());
    }

    @Override
    public TCategoryDto find(Long id) {
        if(!categoryRepository.existsById(id)){
            return null;
        }
        return categoryConverter.toDto(categoryRepository.getById(id));

    }

    @Override
    public TCategoryDto save(TCategoryDto dto) {
        if(dto.equals(null)){
            return null;
        }
        TCategory category = categoryConverter.toEntity(dto);
        categoryRepository.save(category);
        return categoryConverter.toDto(category);
    }

    @Override
    public TCategoryDto update(TCategoryDto dto) {
        if(dto.equals(null) || dto.getId().equals(null) ||
           !categoryRepository.existsById(dto.getId())){
            return null;
        }
        TCategory category = categoryConverter.toEntity(dto);
         categoryRepository.save(category);
        return categoryConverter.toDto(category);
    }

    @Override
    public boolean delete(Long id) {
        if(!categoryRepository.existsById(id)){
            return false;
        }
        categoryRepository.deleteById(id);
        return true;

    }
}
