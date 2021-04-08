package org.xinyu.base.stackTraceElement;

/**
 * 使用StackTraceElement
 * 根据方法调用的不同返回不同的返回值
 */
public class StatckTraceElementTest {

    public static String m() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        for (StackTraceElement st : stackTrace) {
            if ("m1".equals(st.getMethodName())) {
                return "m1";
            } else if ("m2".equals(st.getMethodName())) {
                return "m2";
            }
        }
        return "";
    }

    public static void main(String[] args) {
        new Invoker().m1();
    }

}

class Invoker {
    public void m1() {
        System.out.println(StatckTraceElementTest.m());
    }

    public void m2() {
        System.out.println(StatckTraceElementTest.m());
    }
}
