package com.byzoro.controller;

import com.byzoro.entity.BasicIdc;
import com.byzoro.mapper.BasicIdcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/test")
@Controller
public class TestController {

    @Autowired
    private BasicIdcMapper basicIdcMapper;

    @RequestMapping("/test1")
    @ResponseBody
    public BasicIdc test1(){
        return  basicIdcMapper.selectByPrimaryKey((long) 1);
    }

}
