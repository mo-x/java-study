package org.xinyu.jvm.init.demo1;

/**
 *
 * @description:
 * @author: monster_x
 * @create: 2018-09-02 00:52
 **/
public class SubClass extends SuperClass {

    static {
        System.out.println("Sub class init....");
    }
}
