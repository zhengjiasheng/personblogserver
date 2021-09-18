package com.zjs.blogserver.controller;

import com.zjs.blogserver.bean.T_blogger;
import com.zjs.blogserver.service.BloggerService;
import com.zjs.blogserver.util.AxiosResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/blogger")
public class BloggerController {
    @Autowired
    private BloggerService bloggerService;

    /*
    * 后台登录
    * */
    @RequestMapping("/login")
    public AxiosResult loginBack(String user_name,String password){
        T_blogger blogger = new T_blogger();
        blogger.setUser_name(user_name);
        blogger.setPassword(password);
        return bloggerService.loginBack(blogger);
    }

    /*
     * 查询用户(博主)信息
     * */
    @RequestMapping("/findBloggerById")
    public AxiosResult findBloggerById(int blogger_id){
        T_blogger blogger = bloggerService.findBloggerById(blogger_id);
        AxiosResult result = AxiosResult.success(blogger);
        return result;
    }

    /*
     * 修改用户(博主)信息
     * */
    @PostMapping("/updateBlogger")
    public AxiosResult updateBlogger(@RequestBody T_blogger blogger){
        int status = bloggerService.updateBlogger(blogger);
        AxiosResult result;
        if (status == 1){
            result = AxiosResult.success("修改成功",status);
        }else {
            result = AxiosResult.error("修改失败，该用户不存在");
        }
        return result;
    }

    /*
    * 测试
    * */

    //实体校验测试
    @PostMapping("/saveTest")
    public AxiosResult saveTest(@Validated @RequestBody T_blogger blogger){
        System.out.println(blogger);
        return AxiosResult.success("添加成功");
    }

}
