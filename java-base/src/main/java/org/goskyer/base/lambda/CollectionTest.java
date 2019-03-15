package org.goskyer.base.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionTest {

  public static void main(String[] args) {
    // map
    List<Integer> numbers = Arrays.asList(3, 2);
    numbers.stream().map(i -> i * i).forEach(System.out::println);
    List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
    costBeforeTax.stream().map((cost) -> cost + .12d * cost).forEach(System.out::println);

    // map flatMap
    List<String> words = new ArrayList<>();
    words.add("your");
    words.add("name");
    // ['y','o','u','r'] ['n','a','m','e']
    Stream<Stream<Character>> result = words.stream().map(CollectionTest::characterStream);
    // ['y','o','u','r','n','a','m','e']
    Stream<Character> letters = words.stream().flatMap(CollectionTest::characterStream);

    Map<Long, Long> collect = new HashMap<>();
    collect.put(1111L, 2L);
    collect.put(2222L, 3L);
    Map<Long, Long> sortedMap = new LinkedHashMap<>();
    // map 根据value排序
    collect.entrySet().stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
    sortedMap.forEach((k, v) -> System.out.println("k:" + k + ",v:" + v));
  }

  public static Stream<Character> characterStream(String s) {
    List<Character> result = new ArrayList<>();
    for (char c : s.toCharArray()) {
      result.add(c);
    }
    return result.stream();
  }
}
