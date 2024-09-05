# Spring Boot native image with @Aspect

This sample repository allows to reproduce problem with native image when
[custom aspect](./src/main/java/org/example/demo/aspect/LoggingAspect.java) is
used.

```
Caused by: java.lang.UnsupportedOperationException: CGLIB runtime enhancement not supported on native image. Make sure to include a pre-generated class on the classpath instead: org.example.demo.service.ServiceImpl$$SpringCGLIB$$0
```

To see the error, run:
```sh
mvn -P native spring-boot:build-image
docker run -it --rm demo:0.0.1-SNAPSHOT
```
