package com.zjs.blogserver.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjs.blogserver.bean.T_comment;
import com.zjs.blogserver.dao.T_commentMapper;
import com.zjs.blogserver.service.BlogService;
import com.zjs.blogserver.service.CommentService;
import com.zjs.blogserver.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private T_commentMapper commentMapper;
    @Autowired
    private BlogService blogService;

    @Override
    public T_comment findCommentById(int comment_id) {
        T_comment comment = commentMapper.selectByPrimaryKey(comment_id);
        return comment;
    }

    @Override
    public PageInfo<T_comment> findAllCommentByPage(int pageNum, int pageSize,String keyword) {
        PageHelper.startPage(pageNum,pageSize);
        List<T_comment> list = commentMapper.findAllComment(keyword);
        PageInfo<T_comment> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public JSONArray findCommentByBlogId(int blog_id) {
        List<T_comment> list = commentMapper.findCommentByBlogId(blog_id);
        JSONArray commentArray = new JSONArray();
        for (T_comment comment : list){
            if (comment.getParent_id() == null){   //一级评论
                JSONObject commentObject = new JSONObject();
                JSONArray children = new JSONArray();
                commentObject.put("comment",comment);
                commentObject.put("children",children);
                commentArray.add(commentObject);
            }else {                               //二级评论
                for (int i=0;i<commentArray.size();i++){
                    JSONObject oneLevelComment = commentArray.getJSONObject(i);
                    T_comment oneLevelCommentObject = oneLevelComment.getObject("comment", T_comment.class);
                    JSONArray oneLevelCommentchildren = oneLevelComment.getJSONArray("children");
                    if (comment.getParent_id() == oneLevelCommentObject.getComment_id()) {
                        oneLevelCommentchildren.add(comment);
                        break;
                    }
                    Boolean isFind = false;
                    for (int j=0;j<oneLevelCommentchildren.size();j++){
                        T_comment twoLevelCommentObject = oneLevelCommentchildren.getObject(j, T_comment.class);
                        if (comment.getParent_id() == twoLevelCommentObject.getComment_id()) {
                            oneLevelCommentchildren.add(comment);
                            isFind = true;
                            break;
                        }
                    }
                    if (isFind){
                        break;
                    }
                }
            }
        }
        return commentArray;
    }

    @Override
    public int addComment(T_comment comment) {
        int status = commentMapper.insertSelective(comment);
        if (status == 0){
            return 0;
        }
        int commentNum = commentMapper.findCommentNumByBlogId(comment.getBlog_id());
        int result = blogService.updateReplaceNum(comment.getBlog_id(), commentNum);
        return result;
    }

    @Override
    public int deleteComment(int comment_id) {
        T_comment comment = commentMapper.selectByPrimaryKey(comment_id);
        if (comment == null){
            return 0;
        }
        int status = commentMapper.deleteByPrimaryKey(comment_id);
        if (status == 0){
            return 0;
        }
        int commentNum = commentMapper.findCommentNumByBlogId(comment.getBlog_id());
        int result = blogService.updateReplaceNum(comment.getBlog_id(), commentNum);
        return result;
    }
}
