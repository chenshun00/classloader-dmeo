package io.github.chenshun00.demo.introduction.SPI;

/**
 * @author luobo.cs@raycloud.com
 * @since 2021/8/1 3:22 下午
 */
public class TestImpl implements Test {

    @Override
    public void str() {
        System.out.println("TestImpl");
    }
}
