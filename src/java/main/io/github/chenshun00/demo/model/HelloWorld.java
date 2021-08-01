package io.github.chenshun00.demo.model;

/**
 * 用于Debug演示双亲委任模型加载
 *
 * <ul>
 *     <li>{@link sun.misc.URLClassPath#findResource(String, boolean)}</li>
 *     <li>{@link java.net.URLClassLoader#findClass(String)}</li>
 * </ul>
 *
 * @author luobo.cs@raycloud.com
 * @since 2021/8/1 2:59 下午
 */
public class HelloWorld {

    /**
     * -verbose:class
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        final Class<Loader> loadClass = (Class<Loader>) contextClassLoader.loadClass("io.github.chenshun00.demo.model.Loader");
        final Loader loader = loadClass.newInstance();
        loader.hello();
    }
}
