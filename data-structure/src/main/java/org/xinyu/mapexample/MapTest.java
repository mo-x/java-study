package org.xinyu.mapexample;

public class MapTest {

  /** 扰动函数 @param args */
  public static void main(String[] args) {
    //
    int h = "hello".hashCode();
    int w = "world".hashCode();
    int hash = (h ^ (h >>> 16)) & 0x7fffffff;
    System.out.println(hash % 16);
    System.out.println(Integer.toBinaryString(h));
    System.out.println(Integer.toBinaryString((h ^ (h >>> 16))));
  }
}
