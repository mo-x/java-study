package org.goskyer.base.question.classinit;

/**
 * Created by zzq on 16-10-26.
 */
public class Base
{
    public String whenAmISet = "set when declared";
    void preProcess() {
        System.out.println("父类方法");
    }

    Base() {
        System.out.println("父类构造器");
        preProcess();
    }


    public static void main(String[] args) {
        Derived d = new Derived();
        System.out.println( d.whenAmISet );
    }
}
