package com.zjs.blogserver.service;

import com.zjs.blogserver.bean.T_blogger;
import com.zjs.blogserver.util.AxiosResult;

public interface BloggerService {

    AxiosResult loginBack(T_blogger blogger);

    T_blogger findBloggerById(int blogger_id);

    int updateBlogger(T_blogger blogger);
}
