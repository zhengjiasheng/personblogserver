package com.zjs.blogserver.dao;

import com.zjs.blogserver.bean.T_link;

import java.util.List;

public interface T_linkMapper {
    int deleteByPrimaryKey(Integer link_id);

    int insert(T_link record);

    int insertSelective(T_link record);

    T_link selectByPrimaryKey(Integer link_id);

    int updateByPrimaryKeySelective(T_link record);

    int updateByPrimaryKey(T_link record);

    List<T_link> findAllLink(String keyword);
}