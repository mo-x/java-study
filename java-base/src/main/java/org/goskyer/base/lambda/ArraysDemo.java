package org.goskyer.base.lambda;

import java.util.Arrays;

public class ArraysDemo {

  public static void main(String[] args) {
    //
    double[] values = new double[10];
    Arrays.parallelSetAll(values, i -> i + 1);
    Arrays.stream(values).forEach(System.out::println);
  }
}
