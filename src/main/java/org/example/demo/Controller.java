package org.example.demo;

import org.example.demo.aspect.AutomaticLogger;
import org.example.demo.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AutomaticLogger
public class Controller {
  private final Service service;

  public Controller(Service service) {
    this.service = service;
  }

  @GetMapping("/hello")
  String hello() {
    return "World" + service.getConstant();
  }
}
