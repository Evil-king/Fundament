package com.hwq.fundament.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/sql")
    public Integer getSql(){
        Integer integer = jdbcTemplate.queryForObject("SELECT count(*) FROM books", Integer.class);
       return integer;
    }

}
