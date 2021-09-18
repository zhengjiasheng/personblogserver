/*
 * 博客类型类
 * */
package com.zjs.blogserver.bean;

public class T_blogtype {
    private Integer blogtype_id;               //博客类型主键

    private String type_name;                  //类型名称

    private Integer order_no;                  //排序

    public T_blogtype() {
    }

    public T_blogtype(Integer blogtype_id, String type_name, Integer order_no) {
        this.blogtype_id = blogtype_id;
        this.type_name = type_name;
        this.order_no = order_no;
    }

    public Integer getBlogtype_id() {
        return blogtype_id;
    }

    public void setBlogtype_id(Integer blogtype_id) {
        this.blogtype_id = blogtype_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name == null ? null : type_name.trim();
    }

    public Integer getOrder_no() {
        return order_no;
    }

    public void setOrder_no(Integer order_no) {
        this.order_no = order_no;
    }

    @Override
    public String toString() {
        return "T_blogtype{" +
                "blogtype_id=" + blogtype_id +
                ", type_name='" + type_name + '\'' +
                ", order_no=" + order_no +
                '}';
    }
}