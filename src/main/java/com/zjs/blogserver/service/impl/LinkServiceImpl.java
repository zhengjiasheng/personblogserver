package com.zjs.blogserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjs.blogserver.bean.T_link;
import com.zjs.blogserver.dao.T_linkMapper;
import com.zjs.blogserver.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private T_linkMapper linkMapper;

    @Override
    public T_link findLinkById(int link_id) {
        T_link link = linkMapper.selectByPrimaryKey(link_id);
        return link;
    }

    @Override
    public List<T_link> findAllLink() {
        List<T_link> list = linkMapper.findAllLink(null);
        return list;
    }

    @Override
    public PageInfo<T_link> findLinkByPage(int pageNum, int pageSize,String keyword) {
        //使用分页插件  当前页  页大小
        PageHelper.startPage(pageNum,pageSize);
        List<T_link> list = linkMapper.findAllLink(keyword);
        //对查询的结果进行分页处理==分页查询
        PageInfo<T_link> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int addLink(T_link link) {
        int result = linkMapper.insertSelective(link);
        return result;
    }

    @Override
    public int updateLink(T_link link) {
        int result = linkMapper.updateByPrimaryKeySelective(link);
        return result;
    }

    @Override
    public int deleteLink(int link_id) {
        int result = linkMapper.deleteByPrimaryKey(link_id);
        return result;
    }
}
