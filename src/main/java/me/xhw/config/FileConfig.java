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
            registry.addResourceHandler("/file/**").addResourceLocations("file:" + filepath);
    }



}
