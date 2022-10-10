package com.blog.api.restfull.controller;

import com.blog.api.restfull.dto.TArticleDto;
import com.blog.api.restfull.metier.impl.TArticleImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/article")
public class TArticleController {

    @Autowired private TArticleImpl article;

    @GetMapping(value = "/list")
    public List<TArticleDto> list(){
        return article.list();
    }

    @GetMapping(value = "/find{id}")
    public TArticleDto find(@PathVariable Long id){
        return article.find(id);
    }

    @GetMapping(value = "/save")
    public TArticleDto save(@RequestBody TArticleDto dto){
        return article.save(dto);
    }

    @GetMapping(value = "/update")
    public TArticleDto update(@RequestBody TArticleDto dto){
        return article.update(dto);
    }

    @GetMapping(value = "/delete{id}")
    public boolean delete(@PathVariable Long id){
        return article.delete(id);
    }
}
