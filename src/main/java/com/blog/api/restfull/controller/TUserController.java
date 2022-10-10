package com.blog.api.restfull.controller;

import com.blog.api.restfull.dto.TUserDto;
import com.blog.api.restfull.metier.impl.TUserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class TUserController {
    
    @Autowired private TUserImpl user;

    @GetMapping(value = "/list")
    public List<TUserDto> list(){
        return user.list();
    }

    @GetMapping(value = "/find{id}")
    public TUserDto find(@PathVariable Long id){
        return user.find(id);
    }

    @GetMapping(value = "/save")
    public TUserDto save(@RequestBody TUserDto dto){
        return user.save(dto);
    }

    @GetMapping(value = "/update")
    public TUserDto update(@RequestBody TUserDto dto){
        return user.update(dto);
    }

    @GetMapping(value = "/delete{id}")
    public boolean delete(@PathVariable Long id){
        return user.delete(id);
    }
}
