### SpringBoot的三种启动方式

* IDEA main方法启动
* java -jar xx.jar 启动(java -cp xx.jar -jar xx.jar)
* java -cp /Users/chenshun/open/demo/target/ff org.springframework.boot.loader.PropertiesLauncher

#### main

```shell
/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home/bin/java -XX:TieredStopAtLevel=1 -noverify -Dspring.output.ansi.enabled=always -javaagent:/Users/chenshun/Library/Caches/JetBrains/IntelliJIdea2020.3/captureAgent/debugger-agent.jar -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true -Dfile.encoding=UTF-8 -classpath /Users/chenshun/open/demo/target/classes:/Users/chenshun/.m2/repository/org/springframework/boot/spring-boot-starter-web/2.5.3/spring-boot-starter-web-2.5.3.jar:/Users/chenshun/.m2/repository/org/springframework/boot/spring-boot-starter/2.5.3/spring-boot-starter-2.5.3.jar:/Users/chenshun/.m2/repository/org/springframework/boot/spring-boot/2.5.3/spring-boot-2.5.3.jar:/Users/chenshun/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/2.5.3/spring-boot-autoconfigure-2.5.3.jar:/Users/chenshun/.m2/repository/org/springframework/boot/spring-boot-starter-logging/2.5.3/spring-boot-starter-logging-2.5.3.jar:/Users/chenshun/.m2/repository/ch/qos/logback/logback-classic/1.2.4/logback-classic-1.2.4.jar:/Users/chenshun/.m2/repository/ch/qos/logback/logback-core/1.2.4/logback-core-1.2.4.jar:/Users/chenshun/.m2/repository/org/slf4j/slf4j-api/1.7.32/slf4j-api-1.7.32.jar:/Users/chenshun/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.14.1/log4j-to-slf4j-2.14.1.jar:/Users/chenshun/.m2/repository/org/apache/logging/log4j/log4j-api/2.14.1/log4j-api-2.14.1.jar:/Users/chenshun/.m2/repository/org/slf4j/jul-to-slf4j/1.7.32/jul-to-slf4j-1.7.32.jar:/Users/chenshun/.m2/repository/jakarta/annotation/jakarta.annotation-api/1.3.5/jakarta.annotation-api-1.3.5.jar:/Users/chenshun/.m2/repository/org/springframework/spring-core/5.3.9/spring-core-5.3.9.jar:/Users/chenshun/.m2/repository/org/springframework/spring-jcl/5.3.9/spring-jcl-5.3.9.jar:/Users/chenshun/.m2/repository/org/yaml/snakeyaml/1.28/snakeyaml-1.28.jar:/Users/chenshun/.m2/repository/org/springframework/boot/spring-boot-starter-json/2.5.3/spring-boot-starter-json-2.5.3.jar:/Users/chenshun/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.12.4/jackson-databind-2.12.4.jar:/Users/chenshun/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.12.4/jackson-annotations-2.12.4.jar:/Users/chenshun/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.12.4/jackson-core-2.12.4.jar:/Users/chenshun/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.12.4/jackson-datatype-jdk8-2.12.4.jar:/Users/chenshun/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.12.4/jackson-datatype-jsr310-2.12.4.jar:/Users/chenshun/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.12.4/jackson-module-parameter-names-2.12.4.jar:/Users/chenshun/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/2.5.3/spring-boot-starter-tomcat-2.5.3.jar:/Users/chenshun/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/9.0.50/tomcat-embed-core-9.0.50.jar:/Users/chenshun/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/9.0.50/tomcat-embed-el-9.0.50.jar:/Users/chenshun/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/9.0.50/tomcat-embed-websocket-9.0.50.jar:/Users/chenshun/.m2/repository/org/springframework/spring-web/5.3.9/spring-web-5.3.9.jar:/Users/chenshun/.m2/repository/org/springframework/spring-beans/5.3.9/spring-beans-5.3.9.jar:/Users/chenshun/.m2/repository/org/springframework/spring-webmvc/5.3.9/spring-webmvc-5.3.9.jar:/Users/chenshun/.m2/repository/org/springframework/spring-aop/5.3.9/spring-aop-5.3.9.jar:/Users/chenshun/.m2/repository/org/springframework/spring-context/5.3.9/spring-context-5.3.9.jar:/Users/chenshun/.m2/repository/org/springframework/spring-expression/5.3.9/spring-expression-5.3.9.jar:/Users/chenshun/.m2/repository/org/springframework/boot/spring-boot-loader/2.5.3/spring-boot-loader-2.5.3.jar com.example.demo.DemoApplication
```

#### jar

```shell
java -jar xxx.jar
```
#### explode

```shell
java -cp /Users/chenshun/open/demo/target/ff org.springframework.boot.loader.PropertiesLauncher
```

#### arthas 验证

```shell
sh as.sh
```

```shell
classloader -t
```

```shell
classloader -c 9876yfgr -u
```

##### result
```text
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/spring-boot-2.5.3.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/spring-boot-autoconfigure-2.5.3.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/logback-classic-1.2.4.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/logback-core-1.2.4.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/slf4j-api-1.7.32.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/log4j-to-slf4j-2.14.1.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/log4j-api-2.14.1.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/jul-to-slf4j-1.7.32.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/jakarta.annotation-api-1.3.5.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/spring-core-5.3.9.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/spring-jcl-5.3.9.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/snakeyaml-1.28.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/jackson-databind-2.12.4.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/jackson-annotations-2.12.4.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/jackson-core-2.12.4.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/jackson-datatype-jdk8-2.12.4.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/jackson-datatype-jsr310-2.12.4.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/jackson-module-parameter-names-2.12.4.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/tomcat-embed-core-9.0.50.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/tomcat-embed-el-9.0.50.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/tomcat-embed-websocket-9.0.50.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/spring-web-5.3.9.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/spring-beans-5.3.9.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/spring-webmvc-5.3.9.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/spring-aop-5.3.9.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/spring-context-5.3.9.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/spring-expression-5.3.9.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/spring-boot-loader-2.5.3.jar!/
jar:file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/spring-boot-jarmode-layertools-2.5.3.jar!/

file:/Users/chenshun/open/demo/target/demo-0.0.1-SNAPSHOT.jar
file:/Users/chenshun/Desktop/arthas-bin/arthas-agent.jar

[arthas@3230]$ classloader -c 42110406 -u
file:/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home/jre/lib/ext/sunec.jar
file:/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home/jre/lib/ext/nashorn.jar
file:/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home/jre/lib/ext/cldrdata.jar
file:/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home/jre/lib/ext/jfxrt.jar
file:/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home/jre/lib/ext/dnsns.jar
file:/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home/jre/lib/ext/localedata.jar
file:/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar
file:/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar
file:/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home/jre/lib/ext/jaccess.jar
file:/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home/jre/lib/ext/zipfs.jar
```