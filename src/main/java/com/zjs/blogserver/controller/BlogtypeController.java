package com.zjs.blogserver.controller;

import com.github.pagehelper.PageInfo;
import com.zjs.blogserver.bean.T_blogtype;
import com.zjs.blogserver.service.BlogtypeService;
import com.zjs.blogserver.util.AxiosResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogtype")
public class BlogtypeController {

    @Autowired
    private BlogtypeService blogtypeService;

    /*
     * 通过主键查询博客类型
     * */
    @RequestMapping("/findBlogtypeById")
    public AxiosResult findBlogtypeById(int blogtype_id) {
        T_blogtype blogtype = blogtypeService.findBlogtypeById(blogtype_id);
        return AxiosResult.success(blogtype);
    }

    /*
     * 查询全部博客类型
     * */
    @RequestMapping("/findAllBlogtype")
    public AxiosResult findAllBlogtype(){
        List<T_blogtype> list = blogtypeService.findAllBlogtype();
        return AxiosResult.success(list);
    }

    /*
     * 分页查询博客类型
     * */
    @RequestMapping("/findBlogtypeByPage")
    public AxiosResult findBlogtypeByPage(int pageNum,int pageSize,String keyword){
        PageInfo<T_blogtype> pageInfo = blogtypeService.findBlogtypeByPage(pageNum, pageSize,keyword);
        return AxiosResult.success(pageInfo);
    }

    /*
     * 新增博客类型
     * */
    @PostMapping("/addBlogtype")
    public AxiosResult addBlogtype(@RequestBody T_blogtype blogtype){
        int status = blogtypeService.addBlogtype(blogtype);
        AxiosResult result;
        if (status == 1){
            result = AxiosResult.success(status);
        }else {
            result = AxiosResult.error("添加失败");
        }
        return result;
    }

    /*
    * 修改博客类型
    * */
    @PostMapping("/updateBlogtype")
    public AxiosResult updateBlogtype(@RequestBody T_blogtype blogtype){
        int status = blogtypeService.updateBlogtype(blogtype);
        AxiosResult result;
        if (status == 1){
            result = AxiosResult.success(status);
        }else {
            result = AxiosResult.error("修改失败");
        }
        return result;
    }

    /*
     * 删除博客类型
     * */
    @RequestMapping("/deleteBlogtype")
    public AxiosResult deleteBlogtype(int blogtype_id){
        int status = blogtypeService.deleteBlogtype(blogtype_id);
        AxiosResult result;
        if (status == 1){
            result = AxiosResult.success(status);
        }else {
            result = AxiosResult.error("删除失败，数据不存在");
        }
        return result;
    }

    /*
     * 批量删除博客类型
     * */
    @PostMapping("/deleteBlogtypeList")
    public AxiosResult deleteBlogtypeList(@RequestBody List<Integer> blogtypeIdList){
        for (int i = 0;i < blogtypeIdList.size();i++){
            blogtypeService.deleteBlogtype(blogtypeIdList.get(i));
        }
        return AxiosResult.success(1);
    }
}
