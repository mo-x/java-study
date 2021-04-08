package org.xinyu.sort;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 2,3,1, 45, 65, 33, 12
 * 第一轮： 1,2,3,45,65,33,12
 *
 * @description: 选择排序
 * @author: zhiqin.zhang
 * @create: 2018/07/15 21:51
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 45, 65, 33, 12};
        System.out.println("交换之前：");
        Stream.of(arr).forEach(n -> System.out.print(Arrays.toString(n) + " "));
        // 选择排序的优化
        // 做第i趟排序
        for (int i = 0; i < arr.length - 1; i++) {
            int k = i;
            // 选最小的记录
            // 这里k+1 是因为最小的已经排在前面了 前面的无须再遍历
            for (int j = k + 1; j < arr.length; j++) {
                // 找出最小数 记下目前找到的最小值所在的位置
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }
            // 在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if (i != k) {
                // 交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        System.out.println();
        System.out.println("交换后：");
        Stream.of(arr).forEach(n -> System.out.print(Arrays.toString(n) + " "));
    }
}
