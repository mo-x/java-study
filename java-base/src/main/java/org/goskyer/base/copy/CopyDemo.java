package org.goskyer.base.copy;

/**
 * Created by zzqno on 2017-3-6.
 */
public class CopyDemo implements Cloneable{


    public static void main(String[] args) {
        CopyDemo demo = new CopyDemo();
        CopyDemo demo1 = null;
        try {
             demo1 = (CopyDemo) demo.clone();//false
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(demo);
        System.out.println(demo1);
        System.out.println(demo == demo1);
        System.out.println(demo.equals(demo1));
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
