package org.goskyer.sort;

import java.util.stream.Stream;

/**
 * 插入排序
 * 比较数字把最小值插入到最前面
 *
 * @author zhiqin.zhang
 */
public class InsertSort {

    public static void main(String[] args) {
        //
        Integer[] arr = {5, 6, 0, 88, 99, 10, 5, 3};
        for (int i = 0; i < arr.length; i++) {
            int integer = arr[i];
            for (int j = 1; j < arr.length; j++) {
                if (arr[integer] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[integer];
                    arr[integer] = temp;
                }
            }
        }
        Stream.of(arr).forEach(n -> System.out.println(n + " "));
    }
}
