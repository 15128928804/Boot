package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Liu on 2017/10/30.
 */
@Repository
public class DemoMapper {

    @Autowired
    private Demo de;

    Demo query() {
        Demo demo = new Demo();
       /* demo.setAge(11);
        demo.setHeight("5mm");
        demo.setName("uksi");*/
       demo.setName(de.getName());
       demo.setHeight(de.getHeight());
       demo.setAge(de.getAge());
       demo.setWeight(de.getWeight());
        return demo;
    }
}
