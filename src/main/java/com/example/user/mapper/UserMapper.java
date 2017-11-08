package com.example.user.mapper;

import com.example.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author：zhuangfei
 * @Description：
 * @Date：14:55 2017/10/30
 */
@Repository
public class UserMapper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createUser(String tel, String pwd) {
        jdbcTemplate.update("INSERT into test.tp_user(tel,password,nickname,secret) VALUES (?,md5(?),?,'')", tel,pwd,tel);
    }

    public void createUser2(String tel, String password) {
        jdbcTemplate.update("INSERT into test.tp_user(tel,password,nickname,secret) VALUES (?,md5(?),?,'')", tel,password,tel);
    }

    public User getUser(Integer id) {
        List<User> list = jdbcTemplate.query("select tel,nickname,password from test.tp_user where user_id=",new Object[]{id},new BeanPropertyRowMapper(User.class));
        if(list != null && list.size() > 0) {
            User user = list.get(0);
            return user;
        } else {
            return  null;
        }
    }

    public void updateUser(String user_id, String nickname) {
        jdbcTemplate.update("UPDATE test.tp_user SET nickname=? where user_id=?", nickname, user_id);
    }

    public void deleteUser(Integer id) {
        jdbcTemplate.update("delete from test.tp_user where user_id=?",id);
    }
}
