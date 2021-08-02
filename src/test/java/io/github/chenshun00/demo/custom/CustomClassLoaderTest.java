package io.github.chenshun00.demo.custom;

import org.apache.log4j.HTMLLayout;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author luobo.cs@raycloud.com
 * @since 2021/7/30 5:11 下午
 */
public class CustomClassLoaderTest {

    @Test(expected = ClassNotFoundException.class)
    public void loadClassFail() throws ClassNotFoundException {
        CustomClassLoaderTest.class.getClassLoader().loadClass("org.apache.log4j.FW");
    }

    @Test(expected = ClassCastException.class)
    public void testCast() throws Exception {
        final URL[] urls = loadUrls();
        CustomClassLoader customClassLoader = new CustomClassLoader(urls, Object.class.getClassLoader());
        CustomClassLoader customClassLoader2 = new CustomClassLoader(urls, Object.class.getClassLoader());
        final Class<?> aClass = customClassLoader.loadClass("org.apache.log4j.HTMLLayout", false);
        final Class<?> aClass2 = customClassLoader2.loadClass("org.apache.log4j.HTMLLayout", false);
        System.out.println("类名:" + aClass.getName());
        System.out.println("是否相同类:" + aClass.equals(aClass2));
        final Object first = aClass.newInstance();
        HTMLLayout firstLayout = (HTMLLayout) first;
    }

    @Test
    public void loadClass() throws Exception {
        final URL[] urls = loadUrls();
        CustomClassLoader customClassLoader = new CustomClassLoader(urls, Object.class.getClassLoader());
        CustomClassLoader customClassLoader2 = new CustomClassLoader(urls, Object.class.getClassLoader());

        final Class<?> aClass = customClassLoader.loadClass("org.apache.log4j.HTMLLayout", false);
        final Class<?> aClass2 = customClassLoader.loadClass("org.apache.log4j.HTMLLayout", false);
        System.out.println("类名:" + aClass.getName());
        System.out.println("是否相同类:" + aClass.equals(aClass2));

        final URL[] urLs = customClassLoader.getURLs();
        Assert.assertEquals(14, urLs.length);
        for (URL urL : urLs) {
            System.out.println("加载的URL:" + urL);
        }
    }

    private static URL toUrl(File file) {
        try {
            return file.toURI().toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL:" + file);
        }
    }

    @Test
    public void name() throws Exception {
        final URL[] urls = loadUrls();
        CustomClassLoader customClassLoader = new CustomClassLoader(urls, Object.class.getClassLoader());
        final Class<?> aClass = customClassLoader.loadClass("org.slf4j.LoggerFactory", true);
        final Method getLogger = aClass.getDeclaredMethod("getLogger", String.class);
        getLogger.setAccessible(true);
        final Object logger = getLogger.invoke(null, "chenshun00");
        System.out.println("slf4j.LoggerFactory基础信息:" + logger + "\t" + logger.getClass().getClassLoader());

        final Field log4jLogger = logger.getClass().getDeclaredField("logger");
        log4jLogger.setAccessible(true);
        final Object log4j = log4jLogger.get(logger);
        System.out.println("被slf4j.LoggerFactory引用的log4j信息:" + log4j + "\t" + log4j.getClass().getClassLoader());

        final Method info = logger.getClass().getDeclaredMethod("info", String.class);
        log(logger, info, "cccc");
        log(logger, info, "222");
        log(logger, info, "info");
    }

    public void log(Object obj, Method method, String msg) throws Exception {
        method.invoke(obj, msg);
    }

    private URL[] loadUrls() {
        String agentPath = "./src/test/resources/lib";
        File dir = new File(agentPath + "/lib");
        File[] files = dir.listFiles();
        assert files != null;
        URL[] urls = new URL[files.length];
        for (int i = 0; i < files.length; i++) {
            urls[i] = toUrl(files[i]);
        }
        return urls;
    }
}