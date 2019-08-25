package org.goskyer.base.lambda;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.partitioningBy;
import static org.apache.hbase.thirdparty.com.google.common.primitives.Ints.asList;

public class OrderTest {

  public static void main(String[] args) {
    //
    /*List<Integer> numbers = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
    List<Integer> sameOrder = numbers.stream().collect(Collectors.toList());
    System.out.println("");*/

    Set<Integer> numbers = new HashSet<>(asList(4, 3, 2, 1));
    List<String> collect = Stream.of("a", "b", "c", "d", "e").collect(Collectors.toList());
    Set<String> collect1 = Stream.of("a", "b", "c", "d", "e").collect(Collectors.toSet());
    // 串行
    collect1.stream().sequential().forEach(System.out::print);
    System.out.println("");
    // 并行
    collect1.parallelStream().forEach(System.out::print);
    System.out.println("");
    collect1.forEach(System.out::print);
    System.out.println("");
    collect1.stream().forEachOrdered(System.out::print);
  }
}
