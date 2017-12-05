package org.goskyer.base.proxy;

/**
 * Created by zzqno on 2017-3-27.
 * 静态代理的实现
 */
public class HelloProxy implements Hello {
    private Hello hello;

    public HelloProxy() {
        hello = new HelloImpl();
    }

    public void say(String name) {
        before();
        hello.say(name);
        after();
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }

    public static void main(String[] args) {
        HelloProxy proxy = new HelloProxy();
        proxy.say("jay");
    }
}
