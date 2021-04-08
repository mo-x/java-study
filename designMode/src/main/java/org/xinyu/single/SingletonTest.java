package org.xinyu.single;

/**
 * Created by zzqno on 2017-2-26.
 */
public class SingletonTest {

    private SingletonTest() {}

    private static SingletonTest test;

    public static synchronized SingletonTest getSingleTest() {
        if (test == null)
            return new SingletonTest();
        else
            return test;
    }

    public static void main(String[] args) {

        SingletonTest test = SingletonTest.getSingleTest();
        SingletonTest test1 = SingletonTest.getSingleTest();
        System.out.println(test == test1);
    }
}