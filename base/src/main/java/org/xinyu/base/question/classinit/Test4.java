package org.xinyu.base.question.classinit;

/**
 * Created by zzq on 16-10-27.
 */
public class Test4 {
    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("代码块");
    }

    public Test4() {
        System.out.println("构造器");
    }

    public static void main(String[] args) {
        new Test4();
        new Test4();
       // new Test4();
    /*    Class test4 = Test4.class;
        try {
            test4.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/
    }
}
