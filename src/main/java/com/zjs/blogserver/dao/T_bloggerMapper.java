package com.zjs.blogserver.dao;

import com.zjs.blogserver.bean.T_blogger;
/*
 * 查询返回的类型是响应的实体类
 * 增加、删除、修改返回的是int类型  返回 1 表示成功  返回 0 表示失败
 * 当这条数据在数据库中不存在时，增删改是失败的，返回的是0
 * */
public interface T_bloggerMapper {

    T_blogger findByUserName(String user_name);

    int deleteByPrimaryKey(Integer blogger_id);

    int insert(T_blogger record);

    int insertSelective(T_blogger record);

    T_blogger selectByPrimaryKey(Integer blogger_id);

    int updateByPrimaryKeySelective(T_blogger record);

    int updateByPrimaryKeyWithBLOBs(T_blogger record);

    int updateByPrimaryKey(T_blogger record);
}