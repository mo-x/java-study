package org.xinyu.search;

/**
 * 二分查找
 */
public class BinarySearch {

    public static int binSearch(int[] arr, int val) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] == val) {
                return middle;
            }
            if (arr[middle] < val) {
                low = low + 1;
            } else if (arr[middle] > val) {
                high = high - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binSearch(new int[]{1, 2, 3, 4, 5, 6, 8}, 5));

    }
}
