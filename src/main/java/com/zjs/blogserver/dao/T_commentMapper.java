package com.zjs.blogserver.dao;

import com.zjs.blogserver.bean.T_comment;

import java.util.List;

public interface T_commentMapper {
    int deleteByPrimaryKey(Integer comment_id);

    int insert(T_comment record);

    int insertSelective(T_comment record);

    T_comment selectByPrimaryKey(Integer comment_id);

    List<T_comment> findAllComment(String keyword);

    List<T_comment> findCommentByBlogId(int blog_id);

    int findCommentNumByBlogId(int blog_id);

    int updateByPrimaryKeySelective(T_comment record);

    int updateByPrimaryKey(T_comment record);
}