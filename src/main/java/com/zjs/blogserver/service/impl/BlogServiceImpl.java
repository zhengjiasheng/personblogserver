package com.zjs.blogserver.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjs.blogserver.bean.T_blog;
import com.zjs.blogserver.bean.T_blogtype;
import com.zjs.blogserver.controller.GeneralController;
import com.zjs.blogserver.dao.T_blogMapper;
import com.zjs.blogserver.dao.T_blogtypeMapper;
import com.zjs.blogserver.service.BlogService;
import com.zjs.blogserver.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private T_blogMapper blogMapper;
    @Autowired
    private GeneralController generalController;
    @Autowired
    private T_blogtypeMapper blogtypeMapper;

    @Override
    public T_blog findBlogById(int blog_id) {
        T_blog blog = blogMapper.selectByPrimaryKey(blog_id);
        return blog;
    }

    @Override
    public PageInfo<T_blog> findAllBlog(int pageNum, int pageSize, String type,boolean blog_status,String keyword) {
        PageHelper.startPage(pageNum,pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("type",type);
        map.put("blog_status",blog_status);
        map.put("keyword",keyword);
        List<T_blog> list = blogMapper.findAllBlog(map);
        PageInfo<T_blog> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<T_blog> findAllPublishBlog(int pageNum, int pageSize, String type, boolean blog_status) {
        PageHelper.startPage(pageNum,pageSize);
        List<T_blog> list = new ArrayList<>();
        if (type.equals("publish_date")){
            list = blogMapper.findAllBlogOrderByPublishDate(blog_status);
        }else if (type.equals("click_num")){
            list = blogMapper.findAllBlogOrderByClickNum(blog_status);
        }else if (type.equals("replace_num")){
            list = blogMapper.findAllBlogOrderByReplaceNum(blog_status);
        }
        PageInfo<T_blog> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<T_blog> findPublishBlogName() {
        List<T_blog> list = blogMapper.findPublishBlogName();
        return list;
    }

    @Override
    public int addBlog(T_blog blog) {
        int result = blogMapper.insertSelective(blog);
        return result;
    }

    @Override
    public int updateBlog(T_blog blog) {
        T_blog oldBlog = blogMapper.selectByPrimaryKey(blog.getBlog_id());
        if (oldBlog == null){
            return 0;
        }
        String oldBlogImgUrl = oldBlog.getBlog_imgurl();
        if (StringUtils.isNotEmpty(oldBlogImgUrl) && !oldBlogImgUrl.equals(blog.getBlog_imgurl())){
            String[] oldUrlArray = oldBlogImgUrl.split("/");
            generalController.deleteImg(oldUrlArray[4]);
        }
        int result = blogMapper.updateByPrimaryKeyWithBLOBs(blog);
        return result;
    }

    @Override
    public int publishBlog(int blog_id) {
        T_blog blog = new T_blog();
        blog.setBlog_id(blog_id);
        Date date = new Date();
        blog.setPublish_date(date);
        blog.setBlog_status(true);
        int result = blogMapper.updateByPrimaryKeySelective(blog);
        return result;
    }

    @Override
    public int addBlogClickNum(int blog_id) {
        T_blog blog = blogMapper.selectByPrimaryKey(blog_id);
        int clickNum = blog.getClick_num();
        blog.setClick_num(++clickNum);
        int result = blogMapper.updateByPrimaryKeySelective(blog);
        return result;
    }

    @Override
    public int updateReplaceNum(int blog_id,int replace_num) {
        T_blog blog = new T_blog();
        blog.setBlog_id(blog_id);
        blog.setReplace_num(replace_num);
        int result = blogMapper.updateByPrimaryKeySelective(blog);
        return result;
    }

    @Override
    public int deleteBlog(int blog_id) {
        T_blog blog = blogMapper.selectByPrimaryKey(blog_id);
        if (blog == null){
            return 0;
        }
        String blogImgUrl = blog.getBlog_imgurl();
        if (StringUtils.isNotEmpty(blogImgUrl)){
            String[] urlArray = blogImgUrl.split("/");
            generalController.deleteImg(urlArray[4]);
        }
        int result = blogMapper.deleteByPrimaryKey(blog_id);
        return result;
    }

    @Override
    public List<Map<String,Integer>> getBlogNumOfType() {
        List<Map<String, Integer>> list = blogMapper.getBlogNumOfType();
        List<T_blogtype> listType = blogtypeMapper.selectAll(null);
        for (T_blogtype blogtype : listType){
            boolean isExist = false;
            for (Map<String,Integer> map : list) {
                int blogtype_id  = map.get("blogtype_id");
                if (blogtype_id == blogtype.getBlogtype_id()){
                    isExist = true;
                    break;
                }
            }
            if (!isExist){
                Map<String, Integer> map = new HashMap<>();
                map.put("blogtype_id",blogtype.getBlogtype_id());
                map.put("sum",0);
                list.add(map);
            }
        }
        return list;
    }

    @Override
    public PageInfo<T_blog> findBlogByTypeId(Map<String,Object> map) {
        int pageNum = Integer.parseInt(map.get("pageNum").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        PageHelper.startPage(pageNum,pageSize);
        List<T_blog> list = blogMapper.getBlogByTypeId(map);
        PageInfo<T_blog> result = new PageInfo<>(list);
        return result;
    }
}
