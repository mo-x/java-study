package org.xinyu.sort;

import java.util.stream.Stream;

/**
 * @description: 直接插入排序
 * @author: monster_x
 * @create: 2018-08-31 09:52
 **/
public class StraightInsertionSort {

    public static void main(String[] args) {
        Integer[] a = {5, 6, 0, 88, 99, 10, 5, 3};
        for (int i = 1; i < a.length; i++) {
            // 待插入元素
            int temp = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                // 将大于temp的往后移动一位
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = temp;
        }
        Stream.of(a).forEach(n -> System.out.print(n + ","));
    }

    /**
     * 交换数组元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(Integer[] arr, int a, int b) {
//        arr[a] = arr[a] + arr[b];
//        arr[b] = arr[a] - arr[b];
//        arr[a] = arr[a] - arr[b];
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
