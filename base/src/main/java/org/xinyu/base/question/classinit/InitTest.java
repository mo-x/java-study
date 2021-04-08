package org.xinyu.base.question.classinit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zzq on 16-10-26.
 * 构造器--> initM()-->静态代码块
 */
public class InitTest {
    public static InitTest singleton = new InitTest();
    public static Map m;

    static {
        System.out.println("静态代码块调用");
    }

    private InitTest() {
        System.out.println("构造器调用");
    }

    public static void initM() {
        if (null == m) {
            System.out.println("m 为空");
            m = new HashMap();
        }
        m.put("1", "郑");
        m.put("2", "陈");
    }

    public static InitTest getInstance() {
        return singleton;
    }

    public static void main(String [] args) {

        InitTest singleton = InitTest.getInstance();
        //InitTest initTest = new InitTest();
    }
}
