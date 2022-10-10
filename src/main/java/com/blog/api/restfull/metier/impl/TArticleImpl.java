package com.blog.api.restfull.metier.impl;

import com.blog.api.restfull.converter.TArticleConverter;
import com.blog.api.restfull.dto.TArticleDto;
import com.blog.api.restfull.entity.TArticle;
import com.blog.api.restfull.metier.TArticleMetier;
import com.blog.api.restfull.dao.TArticleRepository;
import com.blog.api.restfull.dao.TCategoryRepository;
import com.blog.api.restfull.dao.TUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TArticleImpl implements TArticleMetier {

    @Autowired private TArticleRepository articleRepository;
    @Autowired private TArticleConverter articleConverter;
    @Autowired private TCategoryRepository categoryRepository;
    @Autowired private TUserRepository  userRepository;


    @Override
    public List<TArticleDto> list() {
        return articleRepository.findAll().stream()
                .map(art -> articleConverter.toDto(art))
                .collect(Collectors.toList());
    }

    @Override
    public TArticleDto find(Long id) {
        if(!articleRepository.existsById(id)){
            return null;
        }
         return  articleConverter.toDto(articleRepository.getById(id));

    }

    @Override
    public TArticleDto save(TArticleDto dto) {
        if(dto.equals(null))
        return null;
        if(dto.getFk_category().equals(null) || dto.getFk_category().getId().equals(null) ||
                !categoryRepository.existsById(dto.getFk_category().getId()) ||
                dto.getFk_user().equals(null)
                || dto.getFk_user().getId().equals(null) ||
                !userRepository.existsById(dto.getFk_user().getId())
        ){
            return null;
        }
        TArticle article = articleConverter.toEntity(dto);
        articleRepository.save(article);
        return articleConverter.toDto(article);
    }

    @Override
    public TArticleDto update(TArticleDto dto) {
        if(dto.equals(null) || dto.getId().equals(null)
           || !articleRepository.existsById(dto.getId()))
          return null;
        if(dto.getFk_category().equals(null) || dto.getFk_category().getId().equals(null) ||
                !categoryRepository.existsById(dto.getFk_category().getId()) ||
                dto.getFk_user().equals(null)
                || dto.getFk_user().getId().equals(null) ||
                !userRepository.existsById(dto.getFk_user().getId())
          ){
            return null;
          }

        TArticle article = articleConverter.toEntity(dto);
        articleRepository.saveAndFlush(article);
        return articleConverter.toDto(article);
    }

    @Override
    public boolean delete(Long id) {
        if(!articleRepository.existsById(id)){
            return false;
        }
         articleRepository.deleteById(id);
          return true;
    }
}
