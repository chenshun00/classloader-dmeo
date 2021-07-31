package io.github.chenshun00.demo.custom;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author luobo.cs@raycloud.com
 * @since 2021/7/30 5:02 下午
 */
public class CustomClassLoader extends URLClassLoader {

    private final ClassLoader parent;

    private final BootLoader bootLoader = new LauncherBootLoader();

    static {
        if (!ClassLoader.registerAsParallelCapable()) {
            System.err.println("CustomClassLoader ParallelClassLoader::registerAsParallelCapable() fail");
        }
    }

    public CustomClassLoader(URL[] urls) {
        super(urls);
        parent = Object.class.getClassLoader();
    }

    public CustomClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
        this.parent = parent;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
    }

    @Override
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> clazz = findLoadedClass(name);
            if (clazz == null) {
                //是不是应该被我加载
                if (onLoadClass(name)) {
                    // load a class used for Pinpoint itself by this ClassLoader
                    clazz = findClass(name);
                } else {
                    try {
                        // load a class by parent ClassLoader
                        if (parent != null) {
                            clazz = parent.loadClass(name);
                        } else {
                            clazz = this.bootLoader.findBootstrapClassOrNull(this, name);
                        }
                    } catch (ClassNotFoundException ignore) {
                    }
                    if (clazz == null) {
                        // if not found, try to load a class by this ClassLoader
                        clazz = findClass(name);
                    }
                }
            }
            if (resolve) {
                resolveClass(clazz);
            }
            return clazz;
        }
    }

    @Override
    public String toString() {
        return "CustomClassLoader{" +
                "parent=" + parent +
                ", bootLoader=" + bootLoader +
                '}';
    }

    /**
     * 满足一定规则加载
     *
     * @param name 名字
     * @return boolean
     */
    private boolean onLoadClass(String name) {
        return name.startsWith("io.github.chenshun00.demo");
    }
}
