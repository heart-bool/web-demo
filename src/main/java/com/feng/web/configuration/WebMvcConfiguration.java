/**
 * Created by Administrator on 2017/3/24.
 */

package com.feng.web.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/***
 * @Description:
 *
 * @ClassName: WebMvcConfiguration
 * @Author: FENG WANG
 * @Email: <email>18908069164@163.com</email>
 * @Date 2017/3/24 9:55
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/public/**")
                .addResourceLocations("classpath:/public/");
    }
}
