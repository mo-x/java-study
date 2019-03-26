package org.goskyer.base.lambda;

import com.google.common.base.Supplier;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/** lambda demo */
public class Demo {

  public static void main(String[] args) {
    // thead safe DateFormatter
    ThreadLocal<DateFormatter> formatter =
        ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));
    //
    BinaryOperator<Long> add = (x, y) -> x + y;
    Predicate<Integer> atLeast5 = x -> x > 5;
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
    assertEquals(Arrays.asList("a", "b", "c"), collected);
    List<Integer> together =
        Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
    System.out.println(together);
    // reduce 求和
    int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
    System.out.println(count);

    BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
    int count1 = accumulator.apply(accumulator.apply(accumulator.apply(0, 1), 2), 3);
  }
}
