package org.xinyu.base.question.classinit;

/**
 * Created by zzq on 16-10-19.
 * 类初始化的顺序
 *
 * 父类静态代码块->子类静态代码块->父类代码块->父类构造器->子类代码块->子类构造器
 *
 */

class HelloA {

    public static String str="父类静态变量";
    public HelloA() {
        System.out.println("HelloA");
    }

    {
        System.out.println("I'm A class");
    }

    static {
        System.out.println("static A");
    }

}

public class HelloB extends HelloA {
    public  int num ;
    public HelloB() {
        System.out.println("HelloB");
    }

    {
        System.out.println("I'm B class");
    }

    static {
        System.out.println("static B");
    }

    public static void main(String[] args) {
        new HelloB();
    }
}
