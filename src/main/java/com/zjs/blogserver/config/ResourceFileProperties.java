/*
* 读取配置文件application.yml中的属性值
* 读取上传文件的路径
* */
package com.zjs.blogserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:/application.yml"}, encoding = "utf-8")
@ConfigurationProperties(prefix = "spring.web.resources",ignoreInvalidFields=true, ignoreUnknownFields=true)
public class ResourceFileProperties {
    @Value(value = "${static-locations}")
    private String filePath;

    public String getFilePath(){
        return filePath;
    }
}

