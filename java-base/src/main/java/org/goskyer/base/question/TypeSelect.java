package org.goskyer.base.question;

/**
 * 基本类型
 */
public class TypeSelect {

    public static void main(String[] args) {
        TypeSelect typeSelect = new TypeSelect();
        typeSelect.longMethod(10l);//基本类型
        Long aLong = Long.valueOf(10L);
        typeSelect.longMethod(aLong);//包装类型

        typeSelect.longMethod(1);//基本类型
        typeSelect.longMethod(Integer.valueOf(1));//基本类型
        typeSelect.longMethod(Integer.valueOf(1));//基本类型
        int i = 100;
        typeSelect.longMethod(i);//基本类型

    }

    public void longMethod(Long lng) {
        System.out.println("包装类型");
    }


    public void longMethod(long lng) {
        System.out.println("基本类型");
    }
}
