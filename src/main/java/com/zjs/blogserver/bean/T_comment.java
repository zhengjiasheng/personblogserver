/*
* 评论类
* \*/
package com.zjs.blogserver.bean;

import java.util.Date;

public class T_comment {
    private Integer comment_id;                                   //评论主键

    private String user_ip;                                       //评论者ip  qq邮箱

    private String user_name;                                    //评论者昵称

    private Integer blog_id;                                      //所属博客

    private String comment_content;                               //评论内容 限制500字

    private Date comment_date;                                    //评论时间

    private Integer parent_id;                                    //评论的父级id 为空时表示一级评论

    private String parent_user;                                   //评论的父级user(名） 为空时表示一级评论

    public T_comment() {
    }

    public T_comment(Integer comment_id, String user_ip, String user_name, Integer blog_id, String comment_content, Date comment_date, Integer parent_id, String parent_user) {
        this.comment_id = comment_id;
        this.user_ip = user_ip;
        this.user_name = user_name;
        this.blog_id = blog_id;
        this.comment_content = comment_content;
        this.comment_date = comment_date;
        this.parent_id = parent_id;
        this.parent_user = parent_user;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getUser_ip() {
        return user_ip;
    }

    public void setUser_ip(String user_ip) {
        this.user_ip = user_ip == null ? null : user_ip.trim();
    }

    public Integer getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(Integer blog_id) {
        this.blog_id = blog_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content == null ? null : comment_content.trim();
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getParent_user() {
        return parent_user;
    }

    public void setParent_user(String parent_user) {
        this.parent_user = parent_user == null ? null : parent_user.trim();
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "T_comment{" +
                "comment_id=" + comment_id +
                ", user_ip='" + user_ip + '\'' +
                ", user_name='" + user_name + '\'' +
                ", blog_id=" + blog_id +
                ", comment_content='" + comment_content + '\'' +
                ", comment_date=" + comment_date +
                ", parent_id=" + parent_id +
                ", parent_user='" + parent_user + '\'' +
                '}';
    }
}