package org.xinyu.base.question;

/**
 * Created by zzq on 16-10-20.
 */
public class StringTest {


    public static void main(String[] args) {
        String str = "12.03";
        String[] res = str.split(".");    //出错！！！
        for (int i = 0; i < res.length; i++)
            System.out.println(res[i]);
        System.out.println(res.toString());
    }

}
