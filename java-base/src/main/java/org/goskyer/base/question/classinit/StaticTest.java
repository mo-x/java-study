package org.goskyer.base.question.classinit;

/**
 * Created by zzq on 16-10-26.
 */
public class StaticTest {

    private static int num = 0;
    public static void read(){
        System.out.println("read");
    }

    public StaticTest(){
        System.out.println("无参构造器");
    }
    public StaticTest(String s){
        System.out.println("有参构造器");
    }

    public static void main(String[] args) {
        int num =  StaticTest.num;
        StaticTest.read();
        System.out.println(num);
    }
}
