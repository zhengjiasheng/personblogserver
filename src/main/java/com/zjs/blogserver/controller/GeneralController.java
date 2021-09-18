package com.zjs.blogserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.zjs.blogserver.config.ResourceFileProperties;
import com.zjs.blogserver.service.GeneralService;
import com.zjs.blogserver.util.AxiosResult;
import com.zjs.blogserver.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/general")
public class GeneralController {

    @Autowired
    private ResourceFileProperties fileProperties;
    @Autowired
    private GeneralService generalService;
    /*
     * 文件上传 （上传图片）
     * */

    @PostMapping("/uploadImg")
    public AxiosResult uploadImg(@RequestParam("file") MultipartFile file,@RequestParam Map<String,String> map){
        String filePath = fileProperties.getFilePath().substring(5);
        if (map.size() != 0){
            FileUtils.deleteFile(filePath,map.get("oldFileName").toString());
        }
        String fileName = FileUtils.addFile(file, filePath);
        AxiosResult result;
        if (fileName != null){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("img_url","http://localhost:8088/upload/"+fileName);
            result = AxiosResult.success("文件上传成功", jsonObject);
        }else {
            result = AxiosResult.error("文件上传失败");
        }
        return result;
    }

    /*
     * 删除文件（删除图片）
     * */

    @RequestMapping("/deleteImg")
    public AxiosResult deleteImg(String fileName){
        String filePath = fileProperties.getFilePath().substring(5);
        boolean isDel = FileUtils.deleteFile(filePath, fileName);
        AxiosResult result;
        if (isDel){
            result = AxiosResult.success("删除成功");
        }else {
            result = AxiosResult.error("文件不存在");
        }
        return result;
    }

    /*
    * 统计数据
    * */
    @RequestMapping("/staticsitc")
    public AxiosResult staticsitc(){
        Map<String, Integer> staticsitc = generalService.staticsitc();
        return AxiosResult.success(staticsitc);
    }
}
