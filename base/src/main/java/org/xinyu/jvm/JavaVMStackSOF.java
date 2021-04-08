package org.xinyu.jvm;


/**
 * statckOverFlowError
 * 栈溢出
 */
public class JavaVMStackSOF {

    private int stackLenth = 1;

    public void statckLeak(){
        stackLenth++;
        statckLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        javaVMStackSOF.statckLeak();
 /*       try {

        }catch (Throwable e){
            System.out.println("stackLenth:"+javaVMStackSOF.stackLenth);
            throw e;
        }*/

    }
}
