package com.jvb.collect.basic.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.jvb.collect.basic.impl","com.jvb.collect.basic"})
public class SpringConfigClass {

    @Bean
    public DelegatedClassOne classOne(){
        return new DelegatedClassOne();
    }

    @Bean
    public DelegatedClassTwo classTwo(){
        return new DelegatedClassTwo();
    }

}
