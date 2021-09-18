package com.zjs.blogserver.service;

import com.github.pagehelper.PageInfo;
import com.zjs.blogserver.bean.T_link;

import java.util.List;

public interface LinkService {

    T_link findLinkById(int link_id);

    List<T_link> findAllLink();

    PageInfo<T_link> findLinkByPage(int pageNum,int pageSize,String keyword);

    int addLink(T_link link);

    int updateLink(T_link link);

    int deleteLink(int link_id);
}
