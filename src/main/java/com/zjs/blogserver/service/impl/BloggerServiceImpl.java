package com.zjs.blogserver.service.impl;

import com.zjs.blogserver.bean.T_blogger;
import com.zjs.blogserver.controller.GeneralController;
import com.zjs.blogserver.dao.T_bloggerMapper;
import com.zjs.blogserver.service.BloggerService;
import com.zjs.blogserver.util.AxiosResult;
import com.zjs.blogserver.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloggerServiceImpl implements BloggerService {

    @Autowired
    private T_bloggerMapper bloggerMapper;
    @Autowired
    private GeneralController generalController;

    @Override
    public AxiosResult loginBack(T_blogger blogger) {
        AxiosResult result = new AxiosResult();
        T_blogger t_blogger = bloggerMapper.findByUserName(blogger.getUser_name());
        if (t_blogger == null || !blogger.getPassword().equals(t_blogger.getPassword())){
            result = AxiosResult.error("用户名或密码有误");
        }else {
            result = AxiosResult.success("登录成功",t_blogger);
        }
        return result;
    }

    @Override
    public T_blogger findBloggerById(int blogger_id) {
        T_blogger blogger = bloggerMapper.selectByPrimaryKey(blogger_id);
        return blogger;
    }

    @Override
    public int updateBlogger(T_blogger blogger) {
        T_blogger oldBlogger = bloggerMapper.selectByPrimaryKey(blogger.getBlogger_id());
        if (oldBlogger == null){
            return 0;
        }
        String oldBloggerImgUrl = oldBlogger.getImg_url();
        //删除用户之前的头像
        if (StringUtils.isNotEmpty(oldBloggerImgUrl) && !oldBloggerImgUrl.equals(blogger.getImg_url())){
            String[] oldUrlArray = oldBloggerImgUrl.split("/");
            generalController.deleteImg(oldUrlArray[4]);
        }
        int result = bloggerMapper.updateByPrimaryKeySelective(blogger);
        return result;
    }


}
