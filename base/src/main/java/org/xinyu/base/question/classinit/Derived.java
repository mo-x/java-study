package org.xinyu.base.question.classinit;

/**
 * Created by zzq on 16-10-26.
 */
public class Derived extends Base
{
    public String whenAmISet = "set when declared";

    public Derived(){
        System.out.println("子类构造器");
    }

    @Override
    void preProcess()
    {
        whenAmISet = "set in preProcess()";
        System.out.println("子类方法调用："+whenAmISet);
    }

}
