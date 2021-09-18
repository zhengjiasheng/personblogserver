package com.zjs.blogserver.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.zjs.blogserver.bean.T_comment;
import com.zjs.blogserver.service.CommentService;
import com.zjs.blogserver.util.AxiosResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /*
    * 通过主键查询评论
    * */
    @RequestMapping("/findCommentById")
    public AxiosResult findCommentById(int comment_id){
        T_comment comment = commentService.findCommentById(comment_id);
        return AxiosResult.success(comment);
    }

    /*
     * 分页查询全部评论 按时间降序排序
     */
    @RequestMapping("/findAllCommentByPage")
    public AxiosResult findAllCommentByPage(int pageNum,int pageSize,String keyword){
        PageInfo<T_comment> pageInfo = commentService.findAllCommentByPage(pageNum, pageSize,keyword);
        return AxiosResult.success(pageInfo);
    }

    /*
    * 查询某篇博客的评论 按时间升序  并将评论按照一级评论分类
    * */
    @RequestMapping("/findCommentByBlogId")
    public AxiosResult findCommentByBlogId(int blog_id) {
        JSONArray result = commentService.findCommentByBlogId(blog_id);
        return AxiosResult.success(result);
    }

    /*
    * 添加评论
    * */
    @PostMapping("/addComment")
    public AxiosResult addComment(@RequestBody T_comment comment){
        Date date = new Date();
        comment.setComment_date(date);
        int status = commentService.addComment(comment);
        AxiosResult result;
        if (status == 1){
            result = AxiosResult.success(status);
        }else {
            result = AxiosResult.error("添加失败");
        }
        return result;
    }

    /*
    * 删除评论
    * */
    @RequestMapping("/deleteComment")
    public AxiosResult deleteComment(int comment_id){
        int status = commentService.deleteComment(comment_id);
        AxiosResult result;
        if (status == 1){
            result = AxiosResult.success(status);
        }else {
            result = AxiosResult.error("删除失败，数据不存在");
        }
        return result;
    }

    /*
    * 批量删除评论
    * */
    @PostMapping("/deleteCommentList")
    public AxiosResult deleteCommentList(@RequestBody List<Integer> commentIdlist){
        for (int i = 0;i < commentIdlist.size();i++){
            commentService.deleteComment(commentIdlist.get(i));
        }
        return AxiosResult.success(1);
    }
}
