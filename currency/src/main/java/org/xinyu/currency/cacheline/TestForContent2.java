package org.xinyu.currency.cacheline;

public class TestForContent2 {
    static final int LINE_NUM = 1024;
    static final int COLUM_NUM = 1024;

    public static void main(String[] args) {
        long[][] array = new long[LINE_NUM][COLUM_NUM];
        long start = System.currentTimeMillis();
        for (int i = 0; i < LINE_NUM; i++) {
            for (int j = 0; j < COLUM_NUM; j++) {
                array[j][i] = i * 2 + j;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("cache time:" + (end - start));
    }
}
