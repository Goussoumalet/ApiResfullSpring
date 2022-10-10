package com.blog.api.restfull.metier.impl;

import com.blog.api.restfull.converter.TCommentConverter;
import com.blog.api.restfull.dao.TUserRepository;
import com.blog.api.restfull.dto.TCommentDto;
import com.blog.api.restfull.entity.TComment;
import com.blog.api.restfull.metier.TCommentMetier;
import com.blog.api.restfull.dao.TArticleRepository;
import com.blog.api.restfull.dao.TCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TCommentImpl implements TCommentMetier {

    @Autowired private TCommentRepository commentRepository;
    @Autowired (required = false) private TCommentConverter commentConverter;
    @Autowired private TArticleRepository articleRepository;
    @Autowired private TUserRepository userRepository;

    @Override
    public List<TCommentDto> list() {
        return commentRepository.findAll().stream()
                .map(com -> commentConverter.toDto(com))
                .collect(Collectors.toList());
    }

    @Override
    public TCommentDto find(Long id) {
        if(!commentRepository.existsById(id)){
            return null;
        }
        return commentConverter.toDto(commentRepository.getById(id));
    }

    @Override
    public TCommentDto save(TCommentDto dto) {
        if(dto.equals(null))
         return null;

        if(dto.getFk_article().equals(null) || dto.getFk_article().getId().equals(null)
                || !articleRepository.existsById(dto.getFk_article().getId()) ||
                dto.getFk_user().equals(null) || dto.getFk_user().getId().equals(null)
                || !userRepository.existsById(dto.getFk_user().getId())
           ){
            return  null;
           }
            TComment comment = commentConverter.toEntity(dto);
            commentRepository.save(comment);
            return commentConverter.toDto(comment);
    }

    @Override
    public TCommentDto update(TCommentDto dto) {
        if(dto.equals(null) || dto.getId().equals(null) ||
                !commentRepository.existsById(dto.getId())){
            return null;
        }

        if(dto.getFk_article().equals(null) || dto.getFk_article().getId().equals(null)
                || !articleRepository.existsById(dto.getFk_article().getId()) ||
                dto.getFk_user().equals(null) || dto.getFk_user().getId().equals(null)
                || !userRepository.existsById(dto.getFk_user().getId())
           ){
            return  null;
          }
            TComment comment = commentConverter.toEntity(dto);
            commentRepository.save(comment);
            return commentConverter.toDto(comment);

    }

    @Override
    public boolean delete(Long id) {
        if(!commentRepository.existsById(id)){
            return false;
        }
        commentRepository.deleteById(id);
        return true;

    }
}
