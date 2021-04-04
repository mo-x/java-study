package org.xinyu.sort;


import java.util.Arrays;

/**
 * 直接选择排序
 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 */
public class DirectSelectSort {

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        System.out.println("排序之前：");
        Arrays.stream(a).forEach(b -> System.out.print(b + " "));
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            // 最小数的索引
            int n = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    //记录最小数和索引
                    min = a[j];
                    n = j;
                }
            }
            //交换当前遍历的位置最小数
            a[i] = min;
            a[n] = a[i];
        }
        System.out.println("排序之后：");
        Arrays.stream(a).forEach(b -> System.out.print(b + " "));

    }
}
