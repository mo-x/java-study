package org.goskyer.sort;


import java.util.stream.Stream;

/**
 * 冒泡排序-> 比较相邻的2个值的大小 然后进行交换
 * 性能稳定
 *
 * @description: 冒泡排序实现
 * @author: monster_x
 * @create: 2018-08-30 22:42
 **/
public class BubbleSort {

    public static void main(String[] args) {
        Integer[] arr = {5, 6, 0, 88, 99, 10, 5, 3};
        bubbleSort(arr);
    }


    private static Integer[] bubbleSort(Integer[] arr) {
        //外层循环控制排序趟数
        for (int i = 0; i < arr.length - 1; i++) {
            //内层循环控制每一趟排序多少次
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //交换值
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        Stream.of(arr).forEach(n -> System.out.print(n + ","));
        return arr;
    }
}
