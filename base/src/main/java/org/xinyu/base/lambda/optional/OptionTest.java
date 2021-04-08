package org.xinyu.base.lambda.optional;

import java.util.Optional;

public class OptionTest {

  public static void main(String[] args) {
    Optional<Integer> b1 = Optional.of(null);
    Optional<Integer> b2 = Optional.ofNullable(null);
    //    System.out.println(b1.get());
    System.out.println(b2.get());
  }
}
