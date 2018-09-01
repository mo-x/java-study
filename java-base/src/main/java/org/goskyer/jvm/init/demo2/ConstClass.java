package org.goskyer.jvm.init.demo2;

/**
 * 被动引用
 * 常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类，因此不会触发定义常量类的初始化
 * @description:
 * @author: monster_x
 * @create: 2018-09-02 01:44
 **/
public class ConstClass {
    static {
        System.out.println("ConstClass init...");
    }

    public static final String HELLOWORLD = "hello world";

}
