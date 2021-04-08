package org.xinyu.example;

import java.util.Arrays;

/**
 * letcode 21.删除有序数组中的重复项
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * <p>不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * <p>示例 1:
 *
 * <p>给定数组 nums = [1,1,2],
 *
 * <p>函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * <p>你不需要考虑数组中超出新长度后面的元素。 示例 2:
 *
 * <p>给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * <p>函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * <p>你不需要考虑数组中超出新长度后面的元素。 说明:
 *
 * <p>为什么返回数值是整数，但输出的答案是数组呢?
 *
 * <p>请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * <p>你可以想象内部操作如下:
 *
 * <p>// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝 int len = removeDuplicates(nums);
 *
 * <p>// 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。 for (int i = 0; i < len; i++) {
 * print(nums[i]); }
 */
public class RemoveDuplicates {

    /**
     * 首先给定的数组是有序的
     * 说明只要从0号位开始判断相邻的两个数字是否相等即可
     * 利用快慢指针来做循环时判断相邻两个元素是否相等
     * 不相等的情况下将slow位置+1并将快指针的值赋予slow位置 这样数组前的值都是不重复的
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slowIndex = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            //判断相邻两个元素是否相等
            //不相等慢指针加一 来代表不重复个数
            if (nums[fast] != nums[slowIndex]) {
                slowIndex++;
                nums[slowIndex] = nums[fast];
            }
        }
        //为什么这里+1
        //题目要求返回不重复数组的长度
        //而索引是从0开始的 所以此处+1
        return slowIndex + 1;
    }


    public static void main(String[] args) {
        int[] its = {0, 0, 1, 1, 2, 2};
        System.out.println(removeDuplicates(its));
        System.out.println(Arrays.toString(its));
    }
}
