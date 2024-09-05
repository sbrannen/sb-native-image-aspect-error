package org.example.demo;

import org.example.demo.service.Service;
import org.example.demo.service.ServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
  @Bean
  public Service service() {
    return new ServiceImpl(42);
  }
}
