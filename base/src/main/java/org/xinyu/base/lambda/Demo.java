package org.xinyu.base.lambda;

import org.xinyu.base.lambda.base.predicte.Apple;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/** lambda demo */
public class Demo {
  static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

  public static void main(String[] args) {
    // thead safe DateFormatter
    ThreadLocal<DateFormatter> formatter =
        ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));
    //
    BinaryOperator<Long> add = (x, y) -> x + y;
    Predicate<Integer> atLeast5 = x -> x > 5;

    List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
    assertEquals(Arrays.asList("a", "b", "c"), collected);
    List<Integer> together =
        Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
    System.out.println(together);

    // reduce 求和
    int count = Stream.of(1, 2, 3).reduce(0, Integer::sum);
    System.out.println(count);
    Integer maxInt = Stream.of(1, 2, 3).max(Integer::compareTo).orElse(0);
    Integer minInt = Stream.of(1, 2, 3).min(Integer::compareTo).orElse(0);

    String s1 = Stream.of("a", "b", "c").filter("c"::equals).findFirst().orElse("");

    BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
    int count1 = accumulator.apply(accumulator.apply(accumulator.apply(0, 1), 2), 3);
    System.out.println(count1);


    // 自定义lambda函数
    GreetingService greetService = message -> System.out.println("Hello " + message);
    greetService.sayMessage("name");
    GreetingService greetingServiceI = message -> System.out.println("hello" + message);
    //
    IntPredicate evenNumbers = (int i) -> i % 2 == 0;
    evenNumbers.test(1000);

    // 同􏷑的Lambda􏶗􏷒同的函数式􏵥􏵦,不同的函数式接口
    Comparator<Apple> c1 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
    ToIntBiFunction<Apple, Apple> c2 =
        (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
    BiFunction<Apple, Apple, Integer> c3 =
        (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

    // 没有类型推断
    Comparator<Apple> appleComparator1 =
        (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
    // 有类型推断
    Comparator<Apple> appleComparator2 = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());

    Arrays.stream(numbers).forEach(System.out::println);

    Integer portNumber = 1337;
    // 􏸘􏸙􏸘􏸙错误:lambda表达式引用的局部变量必须是final或事实上是是final的
    //    Runnable r = () -> System.out.println(portNumber);
    portNumber = 31337;

    /**
     * {"hello", "world"} -> {"H","e","l", "o","W","r","d"}
     *
     * <p>流的平行化 flatMap和Map
     */
    String[] words = {"hello", "world"};
    List<String[]> collect =
        Arrays.stream(words).map(w -> w.split("")).distinct().collect(Collectors.toList());

    List<Stream<String>> collect1 =
        Arrays.stream(words)
            .map(w -> w.split(""))
            .map(Arrays::stream)
            .distinct()
            .collect(Collectors.toList());

    List<String> collect2 =
        Arrays.stream(words)
            .map(w -> w.split(""))
            .flatMap(Arrays::stream)
            .distinct()
            .collect(Collectors.toList());

    collect2.forEach(System.out::println);

    /** 匹配 anyMatch匹配任意一个元素 allMatch 匹配全部元素 */
    boolean isExist1 = Arrays.stream(words).anyMatch(s -> s.equals("hello"));
    boolean isExist2 = Arrays.stream(words).allMatch(s -> "hello".equals(s) || "world".equals(s));
    boolean isExist3 = Arrays.stream(words).noneMatch(s -> "hello".equals(s) || "world".equals(s));
    System.out.println(isExist3);

    Optional<String> optional1 = Arrays.stream(words).filter(s -> s.equals("hello1")).findAny();
    Optional<String> optional2 = Arrays.stream(words).filter(s -> s.equals("hello1")).findFirst();
  }
}
