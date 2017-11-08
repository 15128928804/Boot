package com.example.user.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

/**
 * @Author：zhuangfei
 * @Description：
 * @Date：15:40 2017/10/30
 */
public class User {

    private int user_id;

    private String tel;

    @Max(value=9999999,message="超过最大数")
    @Min(value=0000000,message="密码设定不正确")
    private String password;

    private String nickname;

    private String secert;

    private String portrait;

    private String i_card;

    private int area;

    private Date create_time;

    private Date update_time;

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", tel=" + tel +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", secert='" + secert + '\'' +
                ", portrait='" + portrait + '\'' +
                ", i_card='" + i_card + '\'' +
                ", area=" + area +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSecert() {
        return secert;
    }

    public void setSecert(String secert) {
        this.secert = secert;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getI_card() {
        return i_card;
    }

    public void setI_card(String i_card) {
        this.i_card = i_card;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
