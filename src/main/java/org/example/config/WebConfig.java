package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置类
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    //@Autowired
    //private TokenInterceptor tokenInterceptor;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(demoInterceptor).addPathPatterns("/**");

//        registry.addInterceptor(tokenInterceptor)
//                .addPathPatterns("/**") // 拦截所有请求
//                .excludePathPatterns("/login"); // 不拦截哪些请求
//    }
}
