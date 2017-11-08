package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Liu on 2017/10/30.
 */

@RestController
@RequestMapping("/index")
public class TestController {

    @Autowired
    private DemoMapper demoMapper;

    @Value("${demo2.girl.name}")
    private String name;

    @Value("${demo3.name}")
    private String name2;

    @RequestMapping("/queryAll")
    public String queryAll() {

        Demo de = demoMapper.query();
        return "name-"+de.getName()+"-age-"+de.getAge()+"-height-"+de.getHeight();
    }

    @RequestMapping("/queryTwo")
    public String queryTwo() {
        return name2;
    }




}
