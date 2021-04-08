package org.xinyu.base.lambda.base.function;

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
    // 平方
    int compute = Demo.compute(5, value -> value * value);
    // 求和
    int compute1 = Demo.compute(5, value -> value + value);
    // 求差
    int compute2 = Demo.compute(5, value -> value - 2);
    System.out.println(compute);
    System.out.println(compute1);
    System.out.println(compute2);
  }

  public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
    List<R> result = new ArrayList<>();
    for (T s : list) {
      // Function作为一个函数式接口，主要方法apply接收一个参数，返回一个值
      result.add(f.apply(s));
    }
    return result;
  }

  public static int compute(int a, Function<Integer, Integer> function) {
    return function.apply(a);
  }
}
