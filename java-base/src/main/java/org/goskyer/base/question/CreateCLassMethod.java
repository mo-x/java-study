package org.goskyer.base.question;

/**
 * Created by zzq on 16-10-19.
 * 创建类的几种方式
 */
public class CreateCLassMethod {

    public static void main(String[] args) {
        Example example = new Example();
        Class clazz = Example.class;
        try {
            Example exampleTest = (Example) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
