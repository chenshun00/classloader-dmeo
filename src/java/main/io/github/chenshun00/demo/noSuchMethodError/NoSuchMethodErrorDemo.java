package io.github.chenshun00.demo.noSuchMethodError;

import io.github.chenshun00.demo.custom.CustomClassLoader;

import java.net.URL;

/**
 * @author luobo.cs@raycloud.com
 * @since 2021/7/31 10:09 下午
 */
public class NoSuchMethodErrorDemo {

    public Class<?> shouldNoSuchMethodError(boolean shouldOrNot) throws Exception {
        final URL f1 = this.getClass().getClassLoader().getResource("lib/no-such-method-error-1.0-SNAPSHOT.jar");
        final URL f2 = this.getClass().getClassLoader().getResource("lib/no-such-method-error-2.0-SNAPSHOT.jar");
        CustomClassLoader customClassLoader = new CustomClassLoader(shouldOrNot ? new URL[]{f1, f2}
                : new URL[]{f2, f1}, Object.class.getClassLoader());
        return customClassLoader.loadClass("com.example.noSuchMethodErrorDemo.FirstDemo");
    }

}
