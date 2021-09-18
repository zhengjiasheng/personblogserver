package com.zjs.blogserver.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtils {
    /*
    * 添加文件/文件上传
    * @param file 文件
    * @param path 路径/地址
    * @return String fileName 文件名
    * */
    public static String addFile(MultipartFile file, String path){
        String filename =UUID.randomUUID().toString() + file.getOriginalFilename();
        File newFile = new File(path, filename);
        try {
            file.transferTo(newFile);
            return filename;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
    * 删除文件
    * @param path 文件路径
    * @param filename 文件名
    * @return true 删除成功
    * */
    public static boolean deleteFile(String path,String filename){
        File file = new File(path +"\\" + filename);
        if (file.exists()){
            file.delete();
            return true;
        }else {
            System.out.println(filename+"文件不存在");
            return false;
        }
    }
}
