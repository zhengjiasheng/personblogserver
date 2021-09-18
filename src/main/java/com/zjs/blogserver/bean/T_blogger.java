/*
博主类
*/
package com.zjs.blogserver.bean;

import org.jetbrains.annotations.NotNull;

public class T_blogger {
    private Integer blogger_id;              //博主主键

    //实体校验
    @NotNull("用户名不能为空")
    private String user_name;                //用户名(不可重复)

    @NotNull("密码不能为空")
    private String password;                 //密码

    private String nick_name;                //昵称

    private String sign;                     //个性签名

    private String img_url;                 //头像地址

    private String profile;                  //个人信息

    public T_blogger() {
    }

    public T_blogger(Integer blogger_id, String user_name, String password, String nick_name, String sign, String img_url, String profile) {
        this.blogger_id = blogger_id;
        this.user_name = user_name;
        this.password = password;
        this.nick_name = nick_name;
        this.sign = sign;
        this.img_url = img_url;
        this.profile = profile;
    }

    public Integer getBlogger_id() {
        return blogger_id;
    }

    public void setBlogger_id(Integer blogger_id) {
        this.blogger_id = blogger_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name == null ? null : nick_name.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url == null ? null : img_url.trim();
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile == null ? null : profile.trim();
    }

    @Override
    public String toString() {
        return "T_blogger{" +
                "blogger_id=" + blogger_id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", sign='" + sign + '\'' +
                ", img_url='" + img_url + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}