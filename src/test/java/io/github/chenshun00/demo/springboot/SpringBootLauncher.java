package io.github.chenshun00.demo.springboot;

import org.junit.Test;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author luobo.cs@raycloud.com
 * @since 2021/07/31
 */
public class SpringBootLauncher {
    @Test
    public void mainLauncher() {
        final ClassLoader classLoader = this.getClass().getClassLoader();
        if (classLoader instanceof URLClassLoader) {
            URLClassLoader urlClassLoader = (URLClassLoader) classLoader;
            final URL[] urLs = urlClassLoader.getURLs();
            for (URL urL : urLs) {
                System.out.println(urL.toString());
            }
        }
    }
}
