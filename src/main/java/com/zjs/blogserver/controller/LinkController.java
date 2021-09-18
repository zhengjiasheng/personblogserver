package com.zjs.blogserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.zjs.blogserver.bean.T_link;
import com.zjs.blogserver.service.LinkService;
import com.zjs.blogserver.util.AxiosResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j     //日志  log.info() log.debug() log.warn() log.error()
@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    /*
     * 通过主键查询友情链接
     * */
    @RequestMapping("/findLinkById")
    public AxiosResult findLinkById(int link_id) {
        T_link link = linkService.findLinkById(link_id);
        return AxiosResult.success(link);
    }

    /*
     * 查询全部友情链接
     * */
    @RequestMapping("/findAllLink")
    public AxiosResult findAllLink(){
        List<T_link> list = linkService.findAllLink();
        return AxiosResult.success(list);
    }

    /*
     * 分页查询友情链接
     * */
    @RequestMapping("/findLinkByPage")
    public AxiosResult findLinkByPage(int pageNum,int pageSize,String keyword){
        PageInfo<T_link> pageInfo = linkService.findLinkByPage(pageNum, pageSize,keyword);
        return AxiosResult.success(pageInfo);
    }

    /*
     * 新增友情链接
     * */
    @PostMapping("/addLink")
    public AxiosResult addLink(@RequestBody T_link link){
        int status = linkService.addLink(link);
        AxiosResult result;
        if (status == 1){
            result = AxiosResult.success(status);
        }else {
            result = AxiosResult.error("添加失败");
        }
        return result;
    }

    /*
     * 修改友情链接
     * */
    @PostMapping("/updateLink")
    public AxiosResult updateLink(@RequestBody T_link link){
        int status = linkService.updateLink(link);
        AxiosResult result;
        if (status == 1){
            result = AxiosResult.success(status);
        }else {
            result = AxiosResult.error("修改失败");
        }
        return result;
    }

    /*
     * 删除友情链接
     * */
    @RequestMapping("/deleteLink")
    public AxiosResult deleteLink(int link_id){
        int status = linkService.deleteLink(link_id);
        AxiosResult result;
        if (status == 1){
            result = AxiosResult.success(status);
        }else {
            result = AxiosResult.error("删除失败，数据不存在");
        }
        return result;
    }

    /*
     * 批量删除友情链接
     * 注意：前端发请求携带的数据服务端接收时本质上是字符串，不过可以用其他类型转化接收
     * 转化接收时一定要注意“匹配” 对象=对象 数组=list 对象=Map 并且也要注意里面的数据类型 整型 字符串 对象等，类型也要注意，当然，最主要的还是“匹配”
     * */
    @PostMapping("/deleteLinkList")
    public AxiosResult deleteLinkList(@RequestBody List<Integer> linkList){
        for (int i = 0;i < linkList.size();i++){
            linkService.deleteLink(linkList.get(i));
        }
        return AxiosResult.success(1);
    }

}
