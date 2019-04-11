package org.goskyer.base.lambda.base.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** function 使用示例 */
public class Demo {

  public static void main(String[] args) {
    // 1.使用方法
    List<Integer> l = map(Arrays.asList("lambda", "in", "action"), String::length);
    l.forEach(System.out::println);
    // 2.简写
    List<Integer> collect =
        Stream.of("lambda", "in", "action").map(String::length).collect(Collectors.toList());
    collect.forEach(System.out::println);
  }

  public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
    List<R> result = new ArrayList<>();
    for (T s : list) {
      result.add(f.apply(s));
    }
    return result;
  }
}
