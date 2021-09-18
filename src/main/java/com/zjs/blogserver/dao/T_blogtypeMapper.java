package com.zjs.blogserver.dao;

import com.zjs.blogserver.bean.T_blogtype;

import java.util.List;

public interface T_blogtypeMapper {
    int deleteByPrimaryKey(Integer blogtype_id);

    int insert(T_blogtype record);

    int insertSelective(T_blogtype record);

    T_blogtype selectByPrimaryKey(Integer blogtype_id);

    List<T_blogtype> selectAll(String keyword);

    int updateByPrimaryKeySelective(T_blogtype record);

    int updateByPrimaryKey(T_blogtype record);
}