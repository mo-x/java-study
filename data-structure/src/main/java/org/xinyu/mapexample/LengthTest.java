package org.xinyu.mapexample;

public class LengthTest {
  public static void main(String[] args) {
    // 这里length 你可以更改为2的次方进行调试
    int length = 16;
    int hashCode = 4;
    int h = hashCode % length;
    int hash = hashCode & (length - 1);
    System.out.println("取模运算：" + h);
    System.out.println("&运算：" + hash);
    System.out.println(Integer.toBinaryString(4));
    System.out.println("&");
    System.out.println(Integer.toBinaryString(16 - 1));
    System.out.println("=");
    System.out.println(Integer.toBinaryString(4 & 15));
  }
}
