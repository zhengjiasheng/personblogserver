package com.zjs.blogserver.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zjs.blogserver.bean.T_blog;
import com.zjs.blogserver.service.BlogService;
import com.zjs.blogserver.util.AxiosResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    /*
     * 通过主键查询博客
     * */
    @RequestMapping("/findBlogById")
    public AxiosResult findBlogById(int blog_id){
        T_blog blog = blogService.findBlogById(blog_id);
        return AxiosResult.success(blog);
    }

    /*
     * 查询全部博客(分页查询，按照type排序)
     * */
    @RequestMapping("/findAllBlog")
    public AxiosResult findAllBlog(int pageNum,int pageSize,String type,boolean blog_status,String keyword){
        System.out.println(keyword);
        PageInfo<T_blog> pageInfo = blogService.findAllBlog(pageNum, pageSize, type,blog_status,keyword);
        return AxiosResult.success(pageInfo);
    }

    /*
    * 查询发布的博客名字（不分页）
    * */
    @RequestMapping("/findPublishBlogName")
    public AxiosResult findPublishBlogName(){
        List<T_blog> list = blogService.findPublishBlogName();
        return AxiosResult.success(list);
    }

    /*
    * 查询全部发布博客（分页查询，按照type排序）
    * */
    @RequestMapping("/findAllPublishBlog")
    public AxiosResult findAllPublishBlog(int pageNum,int pageSize,String type,boolean blog_status){
        PageInfo<T_blog> pageInfo = blogService.findAllPublishBlog(pageNum, pageSize, type, blog_status);
        return AxiosResult.success(pageInfo);
    }

    /*
     * 新增博客
     * */
    @PostMapping("/addBlog")
    public AxiosResult addBlog(@RequestBody T_blog blog){
        if (blog.getBlog_status() == true){
            Date date = new Date();
            blog.setPublish_date(date);
        }
        int status = blogService.addBlog(blog);
        AxiosResult result;
        if (status == 1){
            result = AxiosResult.success(status);
        }else {
            result = AxiosResult.error("添加失败");
        }
        return result;
    }

    /*
     * 修改博客
     * */
    @PostMapping("/updateBlog")
    public AxiosResult updateBlog(@RequestBody T_blog blog){
        if (blog.getBlog_status() == true){
            Date date = new Date();
            blog.setPublish_date(date);
        }else {
            blog.setPublish_date(null);
        }
        int status = blogService.updateBlog(blog);
        AxiosResult result;
        if (status == 1){
            result = AxiosResult.success(status);
        }else {
            result = AxiosResult.error("修改失败，博客不存在");
        }
        return result;
    }

    /*
    * 发表博客
    * */
    @RequestMapping("/publishBlog")
    public AxiosResult publishBlog(int blog_id){
        int status = blogService.publishBlog(blog_id);
        AxiosResult result;
        if (status == 1){
            result = AxiosResult.success(status);
        }else {
            result = AxiosResult.error("发布失败");
        }
        return result;
    }

    /*
     * 增加博客点击数
     * */
    @RequestMapping("/addBlogClickNum")
    public AxiosResult addBlogClickNum(int blog_id){
        int status = blogService.addBlogClickNum(blog_id);
        AxiosResult result;
        if (status == 1){
            result = AxiosResult.success(status);
        }else {
            result = AxiosResult.error("点击数增加失败");
        }
        return result;
    }

    /*
    * 修改评论数
    * */
    public int updateReplaceNum(int blog_id,int replace_num){
        int status = blogService.updateReplaceNum(blog_id, replace_num);
        return status;
    }

    /*
     * 删除博客
     * */
    @RequestMapping("/deleteBlog")
    public AxiosResult deleteBlog(int blog_id){
        int status = blogService.deleteBlog(blog_id);
        AxiosResult result;
        if (status == 1){
            result = AxiosResult.success(status);
        }else {
            result = AxiosResult.error("删除失败，数据不存在");
        }
        return result;
    }

    /*
     * 批量删除博客
     * */
    @PostMapping("/deleteBlogList")
    public AxiosResult deleteBlogList(@RequestBody List<Integer> blogIdList){
        for (int i = 0;i < blogIdList.size();i++){
            blogService.deleteBlog(blogIdList.get(i));
        }
        return AxiosResult.success(1);
    }

    /*
     * 获取各种类型的博客数量
     * */
    @RequestMapping("/getBlogNumOfType")
    public AxiosResult getBlogNumOfType(){
        List<Map<String, Integer>> result = blogService.getBlogNumOfType();
        return AxiosResult.success(result);

    }

    /*
     * 通过博客类型查询博客
     * */
    @RequestMapping("/findBlogByTypeId")
    public AxiosResult findBlogByTypeId(@RequestParam(required = false) Map<String,Object> map){
        PageInfo<T_blog> pageInfo = blogService.findBlogByTypeId(map);
        return AxiosResult.success(pageInfo);
    }
}
