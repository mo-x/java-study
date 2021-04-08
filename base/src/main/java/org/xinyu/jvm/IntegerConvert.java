package org.xinyu.jvm;

public class IntegerConvert {

  /**
   * Integer 转为二进制
   *
   * @param num
   * @return
   */
  public static String convert(float num) {
    int intVal = Float.floatToIntBits(num);
    return intVal > 0 ? "0" + Integer.toBinaryString(intVal) : Integer.toBinaryString(intVal);
  }

  public static void main(String[] args) {
    String value = convert(100.2f);
    System.out.println(value);
  }
}
