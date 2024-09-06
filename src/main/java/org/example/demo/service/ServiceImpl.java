package org.example.demo.service;

import org.example.demo.aspect.AutomaticLogger;

@AutomaticLogger
public class ServiceImpl implements Service {
  private final Integer constant;

  public ServiceImpl(int constant) {
    this.constant = constant;
  }

  @Override
  public int getConstant() {
    return constant;
  }
}
