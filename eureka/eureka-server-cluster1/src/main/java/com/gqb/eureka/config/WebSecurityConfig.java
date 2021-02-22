package com.gqb.eureka.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * eureka默认会开启CSRF防御，认为post，put,delete等请求都是不安全的，如果不加上token的话，则会直接被拦截，解决办法是：放开所有的/Eureka的请求
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);//加上这句是为了，eureka控制台和/actuator请求可以安全控制
        http.csrf().ignoringAntMatchers("/eureka/**");//忽略eureka的请求
    }

}
