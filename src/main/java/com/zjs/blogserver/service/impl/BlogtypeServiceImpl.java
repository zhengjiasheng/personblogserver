package com.zjs.blogserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjs.blogserver.bean.T_blogtype;
import com.zjs.blogserver.dao.T_blogtypeMapper;
import com.zjs.blogserver.service.BlogtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogtypeServiceImpl implements BlogtypeService {

    @Autowired
    private T_blogtypeMapper blogtypeMapper;

    @Override
    public T_blogtype findBlogtypeById(int blogtype_id) {
        T_blogtype blogtype = blogtypeMapper.selectByPrimaryKey(blogtype_id);
        return blogtype;
    }

    @Override
    public List<T_blogtype> findAllBlogtype() {
        List<T_blogtype> list = blogtypeMapper.selectAll(null);
        return list;
    }

    @Override
    public PageInfo<T_blogtype> findBlogtypeByPage(int pageNum, int pageSize,String keyword) {
        PageHelper.startPage(pageNum,pageSize);
        List<T_blogtype> list = blogtypeMapper.selectAll(keyword);
        PageInfo<T_blogtype> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int addBlogtype(T_blogtype blogtype) {
        int result = blogtypeMapper.insertSelective(blogtype);
        return result;
    }

    @Override
    public int updateBlogtype(T_blogtype blogtype) {
        int result = blogtypeMapper.updateByPrimaryKeySelective(blogtype);
        return result;
    }

    @Override
    public int deleteBlogtype(int blogtype_id) {
        int result = blogtypeMapper.deleteByPrimaryKey(blogtype_id);
        return result;
    }
}
