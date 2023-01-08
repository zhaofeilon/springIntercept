package com.example.springintercept.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
@Slf4j
public class LoginConfig implements WebMvcConfigurer {

    @Resource
    private LoginIntercept loginIntercept;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loginIntercept);
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new LoginIntercept());
        registration.addPathPatterns("/**");    // 拦截所有路径
        registration.excludePathPatterns("/login/**",
        "/**/*.html",                //html静态资源
        "/**/*.js",                  //js静态资源
        "/**/*.css" );  // 不拦截的路径

    }
}
