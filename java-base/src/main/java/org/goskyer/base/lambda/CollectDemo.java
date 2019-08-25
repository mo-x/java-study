package org.goskyer.base.lambda;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectDemo {

  public static void main(String[] args) {
    //

  }

  static class Car {
    public boolean isRed;
    public String brand;
  }

  /**
   * partitioningBy收集器 用于数据分块 返回所有红色汽车
   *
   * @param cars
   * @return
   */
  public Map<Boolean, List<Car>> redCars(Stream<Car> cars) {
    return cars.collect(Collectors.partitioningBy(c -> c.isRed));
  }

  /**
   * groupingBy收集器 用于将数据分组
   *
   * @param cars
   * @return
   */
  public Map<String, List<Car>> groupByBrand(Stream<Car> cars) {
    return cars.collect(Collectors.groupingBy(o -> o.brand));
  }

  /**
   * 字符串
   *
   * @param cars
   * @return
   */
  public String test(List<Car> cars) {
    return cars.stream().map(o -> o.brand).collect(Collectors.joining(", ", "[", "]"));
  }
}
