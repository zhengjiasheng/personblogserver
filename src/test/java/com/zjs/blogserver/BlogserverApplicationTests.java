package com.zjs.blogserver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zjs.blogserver.bean.T_link;
import com.zjs.blogserver.config.ResourceFileProperties;
import com.zjs.blogserver.service.BlogService;
import com.zjs.blogserver.service.LinkService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.Action;
import java.util.List;
import java.util.Map;

@SpringBootTest
class BlogserverApplicationTests {

    @Autowired
    private LinkService linkService;

    @Autowired
    private ResourceFileProperties fileProperties;

    @Autowired
    private BlogService blogService;

    //查询全部链接测试，分页查询
    @Test
    void findAllLinkTest(){
        PageInfo<T_link> pageInfo = linkService.findLinkByPage(1,5,null);
        System.out.println(pageInfo);
        System.out.println(pageInfo.toString());
        System.out.println(JSON.toJSONString(pageInfo));
    }

    //添加链接测试，不设置属性值或属性值设置为空时，往数据库中插入的数据就没有该字段的值。即插入的这条数据没有该字段值
    @Test
    void addLink(){
        for (int i=0;i<10;i++){
            T_link link = new T_link(null,"火狐","www.huohu.com",3);
            int result = linkService.addLink(link);
        }
//        link.setLink_name("zzz");
//        link.setLink_url("www");
//        link.setOrder_no(2);
//        System.out.println("测试测试:"+result);
    }

    @Test
    void contextLoads() {
    }

//    获取配置文件中的资源文件路径（上传文件的路径）
    @Test
    void getFilePath(){
        String filePath = fileProperties.getFilePath();
        filePath = filePath.substring(5);
        System.out.println(filePath);
    }

    //JSON对象操作测试
    @Test
    public void jsonTest(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("img_url","http://8088/upload/");
        System.out.println(jsonObject.toJSONString());
    }

    @Test
    public void find(){
        List<Map<String, Integer>> list = blogService.getBlogNumOfType();
        System.out.println(list);
    }
}
