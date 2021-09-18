/*
 * 友情链接类
 * */
package com.zjs.blogserver.bean;

public class T_link {
    private Integer link_id;                      //友情链接主键

    private String link_name;                     //友情链接名/网站名称

    private String link_url;                      //友情链接地址/网站地址

    private Integer order_no;                     //序号

    public T_link() {
    }

    public T_link(Integer link_id, String link_name, String link_url, Integer order_no) {
        this.link_id = link_id;
        this.link_name = link_name;
        this.link_url = link_url;
        this.order_no = order_no;
    }

    public Integer getLink_id() {
        return link_id;
    }

    public void setLink_id(Integer link_id) {
        this.link_id = link_id;
    }

    public String getLink_name() {
        return link_name;
    }

    public void setLink_name(String link_name) {
        this.link_name = link_name == null ? null : link_name.trim();
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url == null ? null : link_url.trim();
    }

    public Integer getOrder_no() {
        return order_no;
    }

    public void setOrder_no(Integer order_no) {
        this.order_no = order_no;
    }

    @Override
    public String toString() {
        return "T_link{" +
                "link_id=" + link_id +
                ", link_name='" + link_name + '\'' +
                ", link_url='" + link_url + '\'' +
                ", order_no=" + order_no +
                '}';
    }
}