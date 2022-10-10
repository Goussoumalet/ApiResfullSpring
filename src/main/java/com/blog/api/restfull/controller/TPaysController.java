package com.blog.api.restfull.controller;

import com.blog.api.restfull.dto.TPaysDto;
import com.blog.api.restfull.metier.impl.TPaysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/pays")
public class TPaysController {
    
    @Autowired private TPaysImpl pays;

    @GetMapping(value = "/list")
    public List<TPaysDto> list(){
        return pays.list();
    }

    @GetMapping(value = "/find{id}")
    public TPaysDto find(@PathVariable Long id){
        return pays.find(id);
    }

    @PostMapping(value = "/save")
    public TPaysDto save(@RequestBody TPaysDto dto){
        return pays.save(dto);
    }

    @PutMapping(value = "/update")
    public TPaysDto update(@RequestBody TPaysDto dto){
        return pays.update(dto);
    }

    @DeleteMapping(value = "/delete{id}")
    public boolean delete(@PathVariable Long id){
        return pays.delete(id);
    }
}
