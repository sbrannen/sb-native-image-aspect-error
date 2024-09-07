package org.example.demo.aspect;

import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  public final List<String> intercepted = new ArrayList<>();

  @Around(
      "within(org.example.demo..*) && execution(public * *(..)) && @within(org.example.demo.aspect.AutomaticLogger)")
  public Object log(@NotNull ProceedingJoinPoint jp) throws Throwable {
    intercepted.add(jp.getSignature().getDeclaringType().getCanonicalName() + "." + jp.getSignature().getName());

    Object result = jp.proceed(jp.getArgs());

    if (result instanceof Integer number) {
      // modify the value so it can be verified in a test
      result = number * 2;
    }

    // body removed for simplicity
    return result;
  }
}
