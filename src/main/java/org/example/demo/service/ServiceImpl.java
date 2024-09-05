package org.example.demo.service;


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
