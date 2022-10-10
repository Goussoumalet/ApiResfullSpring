package com.blog.api.restfull.controller;

import com.blog.api.restfull.dto.TCategoryDto;
import com.blog.api.restfull.metier.impl.TCategoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/category")
public class TCategoryController {

    @Autowired private TCategoryImpl category;

    @GetMapping(value = "/list")
    public List<TCategoryDto> list(){
        return category.list();
    }

    @GetMapping(value = "/find{id}")
    public TCategoryDto find(@PathVariable Long id){
        return category.find(id);
    }

    @PostMapping(value = "/save")
    public TCategoryDto save(@RequestBody TCategoryDto dto){
        return category.save(dto);
    }

    @PutMapping(value = "/update")
    public TCategoryDto update(@RequestBody TCategoryDto dto){
        return category.update(dto);
    }

    @DeleteMapping(value = "/delete{id}")
    public boolean delete(@PathVariable Long id){
        return category.delete(id);
    }
}
