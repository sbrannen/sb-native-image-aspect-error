package org.example.demo;

import org.example.demo.service.ServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class Config {
  @Bean
  public ServiceImpl service() {
    return new ServiceImpl(42);
  }
}
