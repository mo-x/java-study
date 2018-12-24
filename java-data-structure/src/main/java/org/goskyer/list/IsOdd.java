package org.goskyer.list;

/**
 * @description: 位运算是否偶数
 * @author: zhiqin.zhang
 * @create: 2018/07/26 22:58
 * 一个数是偶数那么最后一个一定是 0 如果一个数是奇数那么最后一位一定是 1；
 * 而十进制 1 在 8 位二进制中表示为 0000 0001，
 * 我们只需将一个数个 1相与（&） 得到的结果如果是 1 则表示该数为奇数，否知为偶数
 **/
public class IsOdd {

    public boolean isOdd(int num) {
        return (num & 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new IsOdd().isOdd(3));
        System.out.println(new IsOdd().isOdd(4));
    }
}
