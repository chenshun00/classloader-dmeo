package io.github.chenshun00.demo.custom;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * 引导加载程序
 *
 * @author luobo.cs@raycloud.com
 * @since 2021/07/30
 */
interface BootLoader {
    Enumeration<URL> findResources(String name) throws IOException;

    URL findResource(String name);

    Class<?> findBootstrapClassOrNull(ClassLoader classLoader, String name);
}
