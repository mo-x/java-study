package org.xinyu.mapexample;

public class HashTest {

  public static void main(String[] args) {

    // 假设数组长度为不为2的幂次方
    int key = 0b1010; // 10
    int len = 0b1101; // 13
    System.out.println(key & len); // 8
    // key值产生了变化 会发现数组下标没有改变
    key = 0b1000;
    System.out.println(key & len); // 8

    // 数组长度为2的幂次方 数组下标会产生变化
    // 意味着key值要产生了变化，元素所放的位置就会变化
    key = 0b1010; // 10
    len = 0b1111; // 15 = 16-1
    System.out.println(key & len); // 10
    key = 0b1000;
    System.out.println(key & len); // 8
  }
}
