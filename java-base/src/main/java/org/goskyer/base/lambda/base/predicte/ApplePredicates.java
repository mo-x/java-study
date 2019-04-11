package org.goskyer.base.lambda.base.predicte;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplePredicates {

  public static <T> List<T> filter(List<T> list, Predicate<T> p) {
    // 1.原始写法
    List<T> result = new ArrayList<>(list.size());
    for (T e : list) {
      if (p.test(e)) {
        result.add(e);
      }
    }
    //    return result;
    // 2.lambda写法
    return result.stream().filter(p).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    Apple apple = new Apple("红苹果", 2.0d, "red");
    List<Apple> collect = Stream.of(apple).collect(Collectors.toList());
    List<Apple> filter = filter(collect, p -> "red".equals(p.getColor()));
    System.out.println(filter.size());

    Predicate<Apple> applePredicate1 = apple1 -> "red".equals(apple1.getColor());
    Predicate<Apple> applePredicate2 = apple1 -> apple1.getWeight() >= 2.0d;
    Predicate<Apple> applePredicate3 =
        apple1 -> "red".equals(apple1.getColor()) && apple1.getWeight() >= 2.0d;

    List<Apple> collect1 =
        collect.stream().filter(applePredicate1.and(applePredicate2)).collect(Collectors.toList());
    System.out.println(collect1.size());

    List<Apple> collect2 =
        collect.stream()
            .filter(apple1 -> "red".equals(apple1.getColor()) && apple1.getWeight() >= 2.0d)
            .collect(Collectors.toList());
    System.out.println(collect2.size());
  }
}
