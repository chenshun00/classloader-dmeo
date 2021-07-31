package io.github.chenshun00.demo.noSuchMethodError;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author luobo.cs@raycloud.com
 * @since 2021/7/31 10:15 下午
 */
public class NoSuchMethodErrorDemoTest {

    @Test
    public void shouldNoSuchMethodError() throws Exception {
        NoSuchMethodErrorDemo noSuchMethodErrorDemo = new NoSuchMethodErrorDemo();
        final Class<?> aClass = noSuchMethodErrorDemo.shouldNoSuchMethodError(false);
        final Object object = aClass.newInstance();
        final Method second = aClass.getDeclaredMethod("second");
        second.invoke(object);
    }
}