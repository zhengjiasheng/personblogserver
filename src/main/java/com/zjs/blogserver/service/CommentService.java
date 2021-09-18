package com.zjs.blogserver.service;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.zjs.blogserver.bean.T_comment;

public interface CommentService {
    T_comment findCommentById(int comment_id);

    PageInfo<T_comment> findAllCommentByPage(int pageNum,int pageSize,String keyword);

    JSONArray findCommentByBlogId(int blog_id);

    int addComment(T_comment comment);

    int deleteComment(int comment_id);
}
