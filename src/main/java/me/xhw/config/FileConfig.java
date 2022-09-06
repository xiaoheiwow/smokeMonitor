package me.xhw.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 许德承
 * @date 2021/11/2 17:12
 */
@Configuration
public class FileConfig implements WebMvcConfigurer {


    @Value("${filepath}")
    private String filepath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //上传的图片在D盘下的OTA目录下，访问路径如：http://localhost:8081/OTA/d3cf0281-bb7f-40e0-ab77-406db95ccf2c.jpg
        //其中OTA表示访问的前缀。"file:D:/OTA/"是文件真实的存储路径
        //linux
//        registry.addResourceHandler("/pic/**").addResourceLocations("file:"+filePath);
            registry.addResourceHandler("/file/**").addResourceLocations("file:" + filepath);
    }



}
