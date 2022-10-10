package com.blog.api.restfull.controller;

import com.blog.api.restfull.dto.TCommentDto;
import com.blog.api.restfull.metier.impl.TCommentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/comment")
public class TCommentController {
    
    @Autowired private TCommentImpl comment;

    @GetMapping(value = "/list")
    public List<TCommentDto> list(){
        return comment.list();
    }

    @GetMapping(value = "/find{id}")
    public TCommentDto find(@PathVariable Long id){
        return comment.find(id);
    }

    @PostMapping(value = "/save")
    public TCommentDto save(@RequestBody TCommentDto dto){
        return comment.save(dto);
    }

    @PutMapping(value = "/update")
    public TCommentDto update(@RequestBody TCommentDto dto){
        return comment.update(dto);
    }

    @DeleteMapping(value = "/delete{id}")
    public boolean delete(@PathVariable Long id){
        return comment.delete(id);
    }
}
