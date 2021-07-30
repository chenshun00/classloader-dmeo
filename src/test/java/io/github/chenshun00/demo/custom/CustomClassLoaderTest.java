package io.github.chenshun00.demo.custom;

import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author luobo.cs@raycloud.com
 * @since 2021/7/30 5:11 下午
 */
public class CustomClassLoaderTest {

    @Test(expected = ClassNotFoundException.class)
    public void loadClassFail() throws ClassNotFoundException {
        CustomClassLoaderTest.class.getClassLoader().loadClass("org.apache.log4j.Level");
    }

    @Test
    public void loadClass() throws ClassNotFoundException {
        String agentPath = "/Users/chenshun/open/classloader-dmeo/src/test/resources/lib";
        File dir = new File(agentPath + "/lib");
        File[] files = dir.listFiles();
        assert files != null;
        URL[] urls = new URL[files.length];
        for (int i = 0; i < files.length; i++) {
            urls[i] = toUrl(files[i]);
        }
        CustomClassLoader customClassLoader = new CustomClassLoader(urls, Object.class.getClassLoader());

        final Class<?> aClass = customClassLoader.loadClass("org.apache.log4j.Level", false);
        System.out.println(aClass.getName());
    }

    private static URL toUrl(File file) {
        try {
            return file.toURI().toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL:" + file);
        }
    }
}