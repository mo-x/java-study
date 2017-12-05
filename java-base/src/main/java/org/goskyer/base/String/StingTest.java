package org.goskyer.base.String;

/**
 * Created by zzqno on 2017-5-15.
 */
public class StingTest {

    public static void main(String[] args) {
        String str = new String("abc"); //语句(1)
        String str1 = "abc";//语句(2)
        String str2 = new String("abc");//语句(3)

        System.out.println(str == str1);//语句(4) false
        System.out.println(str == str2);//语句(5) false
        System.out.println(str1 == str2);//语句(6) false

        System.out.println(str == str.intern());//语句(7) false
        System.out.println(str1 == str1.intern());//语句(8) true
        System.out.println(str.intern() == str2.intern());//语句(9) true
        System.out.println("----------------");
        System.out.println(str.intern() ==  str1.intern());
        System.out.println(str.intern() ==  str.intern());
        System.out.println("----------------");
        String hello = "hello";//语句(10)
        String hel = "hel";//语句(11)
        String lo = "lo";//语句(12)

        System.out.println(hello == "hel" + "lo");//语句(13) true
        System.out.println(hello == "hel" + lo);//语句(14)  false
    }
}
