package com.zjs.blogserver.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zjs.blogserver.bean.T_blog;

import java.util.List;
import java.util.Map;

public interface BlogService {
    T_blog findBlogById(int blog_id);

    PageInfo<T_blog> findAllBlog(int pageNum, int pageSize, String type,boolean blog_status,String keyword);

    PageInfo<T_blog> findAllPublishBlog(int pageNum,int pageSize,String type,boolean blog_status);

    List<T_blog> findPublishBlogName();

    int addBlog(T_blog blog);

    int updateBlog(T_blog blog);

    int publishBlog(int blog_id);

    int addBlogClickNum(int blog_id);

    int updateReplaceNum(int blog_id,int replace_num);

    int deleteBlog(int blog_id);

    List<Map<String,Integer>> getBlogNumOfType();

    PageInfo<T_blog> findBlogByTypeId(Map<String,Object> map);
}
