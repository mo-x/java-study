package org.goskyer.jvm.init.demo1;

/**
 * 被动使用类字段演示
 * 通过子类引用父类的静态字段 不会导致子类初始化
 * @description: 触发初始化
 * @author: monster_x
 * @create: 2018-09-02 00:51
 **/
public class SuperClass {

    static {
        System.out.println("Super class init ...");
    }

    public static int value = 123;

}

