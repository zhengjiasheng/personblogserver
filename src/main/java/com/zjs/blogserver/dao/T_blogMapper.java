package com.zjs.blogserver.dao;

import com.zjs.blogserver.bean.T_blog;

import java.util.List;
import java.util.Map;

public interface T_blogMapper {
    int deleteByPrimaryKey(Integer blog_id);

    int insert(T_blog record);

    int insertSelective(T_blog record);

    T_blog selectByPrimaryKey(Integer blog_id);

    List<T_blog> findAllBlog(Map<String,Object> map);

    List<T_blog> findAllBlogOrderByPublishDate(Boolean blog_status);

    List<T_blog> findPublishBlogName();

    List<T_blog> findAllBlogOrderByClickNum(Boolean blog_status);

    List<T_blog> findAllBlogOrderByReplaceNum(Boolean blog_status);

    List<Map<String,Integer>> getBlogNumOfType();

    List<T_blog> getBlogByTypeId(Map<String,Object> map);

    int updateByPrimaryKeySelective(T_blog record);

    int updateByPrimaryKeyWithBLOBs(T_blog record);

    int updateByPrimaryKey(T_blog record);
}