package org.xinyu.base.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zzqno on 2017-3-27.
 * JDK动态代理实现
 * 被代理的对象必须实现接口
 */
public class JdkProxy implements InvocationHandler {

    //被代理的目标对象
    private Object object;

    public JdkProxy(Object object){
        this.object = object;
    }

    public <T> T getProxy(){
        return (T) Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         * 如果要实现特定方法拦截
         * 可在这里进行判断方法名
         */
        before();
        Object result = method.invoke(object, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }

    public static void main(String[] args) {
    /*    Hello hello = new HelloImpl();
        JdkProxy dynamicProxy = new JdkProxy(hello);
      *//*  FleeceCountQuestion helloProxy = (FleeceCountQuestion) Proxy.newProxyInstance(hello.getClass().getClassLoader(),hello.getClass().getInterfaces(),dynamicProxy);
        helloProxy.say("zzq");*//*
        Hello helloProxy = dynamicProxy.getProxy();
        helloProxy.say("zzq");*/

        CGlibProxy.CGlibStatiicClass cGlibStatiicClass = new CGlibProxy.CGlibStatiicClass();

        JdkProxy jdkProxy = new JdkProxy(cGlibStatiicClass);
      /*  Object proxy = jdkProxy.getProxy();
        if(proxy instanceof CGlibProxy.CGlibStatiicClass){
            CGlibProxy.CGlibStatiicClass proxyStaticClass = (CGlibProxy.CGlibStatiicClass) proxy;
            proxyStaticClass.add();
        }*/
        Object proxy = jdkProxy.getProxy();
        System.out.println(proxy instanceof CGlibProxy.CGlibStatiicClass );
        System.out.println(proxy.getClass());

        System.out.println(cGlibStatiicClass.getClass().getClassLoader().toString());
        System.out.println(cGlibStatiicClass.getClass().getInterfaces().toString());
    }
}
