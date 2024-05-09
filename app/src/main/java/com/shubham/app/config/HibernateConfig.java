package com.shubham.app.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.shubham.app")
@EntityScan("com.shubham.app")
public class HibernateConfig {
}
