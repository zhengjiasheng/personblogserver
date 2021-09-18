/*
博客类
*/
package com.zjs.blogserver.bean;

import java.util.Date;

public class T_blog {
    private Integer blog_id;                       //博客主键

    private String blog_title;                     //博客标题

    private String blog_summary;                   //博客摘要

    private String blog_imgurl;                    //博客图片地址

    private Date publish_date;                     //发表时间

    private Integer click_num;                     //点击数

    private Integer replace_num;                  //评论数

    private Integer type_id;                      //所属博客类型  博客类型id

    private String key_word;                      //关键字

    private Boolean blog_status;                  //博客状态 0：未发布 1：发布

    private String blog_content;                  //博客内容

    public T_blog() {
    }

    public T_blog(Integer blog_id, String blog_title, String blog_summary, String blog_imgurl, Date publish_date, Integer click_num, Integer replace_num, Integer type_id, String key_word, Boolean blog_status, String blog_content) {
        this.blog_id = blog_id;
        this.blog_title = blog_title;
        this.blog_summary = blog_summary;
        this.blog_imgurl = blog_imgurl;
        this.publish_date = publish_date;
        this.click_num = click_num;
        this.replace_num = replace_num;
        this.type_id = type_id;
        this.key_word = key_word;
        this.blog_status = blog_status;
        this.blog_content = blog_content;
    }

    public Integer getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(Integer blog_id) {
        this.blog_id = blog_id;
    }

    public String getBlog_title() {
        return blog_title;
    }

    public void setBlog_title(String blog_title) {
        this.blog_title = blog_title == null ? null : blog_title.trim();
    }

    public String getBlog_summary() {
        return blog_summary;
    }

    public void setBlog_summary(String blog_summary) {
        this.blog_summary = blog_summary == null ? null : blog_summary.trim();
    }

    public String getBlog_imgurl() {
        return blog_imgurl;
    }

    public void setBlog_imgurl(String blog_imgurl) {
        this.blog_imgurl = blog_imgurl == null ? null : blog_imgurl.trim();
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public Integer getClick_num() {
        return click_num;
    }

    public void setClick_num(Integer click_num) {
        this.click_num = click_num;
    }

    public Integer getReplace_num() {
        return replace_num;
    }

    public void setReplace_num(Integer replace_num) {
        this.replace_num = replace_num;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getKey_word() {
        return key_word;
    }

    public void setKey_word(String key_word) {
        this.key_word = key_word == null ? null : key_word.trim();
    }

    public Boolean getBlog_status() {
        return blog_status;
    }

    public void setBlog_status(Boolean blog_status) {
        this.blog_status = blog_status;
    }

    public String getBlog_content() {
        return blog_content;
    }

    public void setBlog_content(String blog_content) {
        this.blog_content = blog_content == null ? null : blog_content.trim();
    }

    @Override
    public String toString() {
        return "T_blog{" +
                "blog_id=" + blog_id +
                ", blog_title='" + blog_title + '\'' +
                ", blog_summary='" + blog_summary + '\'' +
                ", blog_imgurl='" + blog_imgurl + '\'' +
                ", publish_date=" + publish_date +
                ", click_num=" + click_num +
                ", replace_num=" + replace_num +
                ", type_id=" + type_id +
                ", key_word='" + key_word + '\'' +
                ", blog_status=" + blog_status +
                ", blog_content='" + blog_content + '\'' +
                '}';
    }
}