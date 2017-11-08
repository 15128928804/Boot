package com.example.myBatis.mapper;

import com.example.user.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * Created by Liu on 2017/11/8.
 */
@Mapper
public interface MyBatisUser {

    @Insert("insert into tp_user(tel,password,nickname) values(#{tel},md5(#{pwd}),#{tel})")
    void createrUser(Map<String,Object> reqMap);

    @Select("select * from test.tp_user where user_id = #{id}")
    User getUser(@Param("id") Integer id);


}
