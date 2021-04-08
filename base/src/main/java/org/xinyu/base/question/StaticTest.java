package org.xinyu.base.question;

/**
 * Created by zzqno on 2017-5-8.
 */
public class StaticTest {

    static int cnt = 6;
    static {
        cnt /= 3;
        System.out.println("static2: " + cnt);
    }


    static {
        cnt += 9;
        System.out.println("static1: " + cnt);
    }

    public static void main(String[] args) {
        System.out.println("cnt =" + cnt);
    }



}
