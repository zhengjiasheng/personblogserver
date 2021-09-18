package com.zjs.blogserver.service;

import com.github.pagehelper.PageInfo;
import com.zjs.blogserver.bean.T_blogtype;

import java.util.List;

public interface BlogtypeService {
    T_blogtype findBlogtypeById(int blogtype_id);

    List<T_blogtype> findAllBlogtype();

    PageInfo<T_blogtype> findBlogtypeByPage(int pageNum,int pageSize,String keyword);

    int addBlogtype(T_blogtype blogtype);

    int updateBlogtype(T_blogtype blogtype);

    int deleteBlogtype(int blogtype_id);
}
