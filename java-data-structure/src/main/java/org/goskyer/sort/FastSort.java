package org.goskyer.sort;

import java.util.Arrays;

/** 快速排序 */
public class FastSort {

  /**
   * 一次快速排序 找到中间点
   *
   * @param array 数组
   * @param lo 数组的前下标
   * @param hi 数组的后下标
   * @return key的下标index，也就是分片的间隔点
   */
  public static int partition(int[] array, int lo, int hi) {
    /** 固定的切分方式 */
    // 选取了基准点
    int key = array[lo];
    while (lo < hi) {
      // 从后半部分向前扫描
      while (array[hi] >= key && hi > lo) {
        hi--;
      }
      array[lo] = array[hi];
      // 从前半部分向后扫描
      while (array[lo] <= key && hi > lo) {
        lo++;
      }
      array[hi] = array[lo];
    }
    // 最后把基准存入
    array[hi] = key;
    return hi;
  }

  /**
   * 快速排序
   *
   * @param array
   * @param lo
   * @param hi
   */
  public static void quickSort(int[] array, int lo, int hi) {
    if (lo >= hi) {
      return;
    }
    // 进行第一轮排序获取分割点
    int index = partition(array, lo, hi);
    // 排序前半部分
    quickSort(array, lo, index - 1);
    // 排序后半部分
    quickSort(array, index + 1, hi);
  }

  public static void main(String[] args) {
    int[] arr = {1, 9, 3, 12, 7, 8, 3, 4, 65, 22};
    System.out.print("排序之前:");
    Arrays.stream(arr).forEach(b -> System.out.print(b + " "));
    quickSort(arr, 0, arr.length - 1);
    System.out.println();
    System.out.print("排序之后:");
    Arrays.stream(arr).forEach(b -> System.out.print(b + " "));
  }
}
