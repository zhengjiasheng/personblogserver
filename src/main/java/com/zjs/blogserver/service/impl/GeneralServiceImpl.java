package com.zjs.blogserver.service.impl;

import com.zjs.blogserver.bean.T_blog;
import com.zjs.blogserver.bean.T_blogtype;
import com.zjs.blogserver.bean.T_comment;
import com.zjs.blogserver.bean.T_link;
import com.zjs.blogserver.dao.T_blogMapper;
import com.zjs.blogserver.dao.T_blogtypeMapper;
import com.zjs.blogserver.dao.T_commentMapper;
import com.zjs.blogserver.dao.T_linkMapper;
import com.zjs.blogserver.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GeneralServiceImpl implements GeneralService {

    @Autowired
    private T_blogMapper blogMapper;
    @Autowired
    private T_blogtypeMapper blogtypeMapper;
    @Autowired
    private T_commentMapper commentMapper;
    @Autowired
    private T_linkMapper linkMapper;

    @Override
    public Map<String, Integer> staticsitc() {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("type","publish_date");
        paramMap.put("blog_status",false);
        paramMap.put("keyword",null);
        List<T_blog> blogs = blogMapper.findAllBlog(paramMap);
        List<T_comment> comments = commentMapper.findAllComment(null);
        List<T_blogtype> blogtypes = blogtypeMapper.selectAll(null);
        List<T_link> links = linkMapper.findAllLink(null);
        Map<String, Integer> map = new HashMap<>();
        map.put("blogNum",blogs.size());
        map.put("commentNum",comments.size());
        map.put("blogtypeNum",blogtypes.size());
        map.put("linkNum",links.size());
        return map;
    }
}
