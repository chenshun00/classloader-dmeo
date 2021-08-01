package io.github.chenshun00.demo.introduction.SPI;

import io.github.chenshun00.demo.introduction.model.Loader;

import java.sql.DriverManager;
import java.util.ServiceLoader;

/**
 * @author luobo.cs@raycloud.com
 * @since 2021/8/1 3:21 下午
 */
public class SPIDemo {

    /**
     * @see java.lang.ClassLoader#loadClass(String)
     */
    public static void main(String[] args) {
        final ServiceLoader<Test> load = ServiceLoader.load(Test.class,
                Thread.currentThread().getContextClassLoader().getParent());
        for (Test test : load) {
            test.str();
        }
        load2();
        load3();
    }


    /**
     * 我知道怎么去验证了.
     */
    public static void load2() {
        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(contextClassLoader.getParent().getParent());
            Loader loader = new Loader();
            loader.hello();
        } finally {
            Thread.currentThread().setContextClassLoader(contextClassLoader);
        }
    }

    public static void load3() {
        System.out.println(DriverManager.class.getClassLoader());
    }


}
