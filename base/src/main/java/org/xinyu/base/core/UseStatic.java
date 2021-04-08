package org.xinyu.base.core;

/**
 * Created by zzq on 16-10-26.
 */
public class UseStatic {
    public static int num = 0;


    public UseStatic(){
        System.out.println("构造器");

    }
    public static void main(String[] args) {
        UseStatic.num =1;
        System.out.println(UseStatic.num);
    }
}
