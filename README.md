# classloader-dmeo

classloader-dmeo

# PPT 大纲

* 提出问题
    * 出现NoSuchMethodError本质原因是什么.(classloader加载的类没有定义这个方法,换句话说,加载错class了)
    * jar包冲突为什么加载的不是正确的jar包.(为什么会加载错class,咋就不能加载到对的呢,为什么本地很少出现NoSuchMethodError)
    * classpath:,classpath*:和classloader有什么关系.
* 大纲
    * 简述类加载机制
        * 双亲委任模型
            * 加载.class文件(字节码)
        * SPI(Service Provider Interface)
            * 讨论:是否打破了双亲委任模型
        * 案例:helloWorld演示 + 初识sun.misc.URLClassPath
        * 自定义Classloader(demo演示)
        * 自定义classloader演示NoSuchMethodError
    * Tomcat Classloader
        * Tomcat加载模型,为什么说Tomcat打破了双亲委任模型(源代码)
        * 案例:Tomcat关闭时出现的NoClassDefFoundError是怎么回事
        * 案例:NoSuchMethodError出现的缘由以及为什么加载不对正确的jar
    * SpringBoot Classloader
        * SpringBoot的3种启动方式，不同启动方式之间classloader的区别(demo演示),为什么我们选择了PropertiesLauncher.
        * 案例:读取不到文件是怎么回事 + 深入sun.misc.URLClassPath
        * 案例:实现NoSuchMethodError定制化
    * APM(arthas/Skywalking/Pinpoint)是如何使用Classloader的
        * Class加载与隔离
            * 如何隔离agent与应用class
            * 应用如何加载plugin class
        * 案例
* 链接
    * http://www.jdotsoft.com/JarClassLoader.php
    * https://docs.spring.io/spring-boot/docs/current/reference/html/executable-jar.html#executable-jar.nested-jars.jar-structure
    * https://github.com/openwide-java/tomcat-classloader-ordered/
    * https://www.yuque.com/chenshun00/sbny2o/qazrl7
    * https://bz.apache.org/bugzilla/show_bug.cgi?id=57129
    * http://github.com/apache/tomcat
        * 7 FileDirContext.java
        * 8/8/10 DirResourceSet.java