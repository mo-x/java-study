package org.goskyer.base.lambda;

/** 函数式接口编写示例 添加 @FunctionalInterface 注解标明该接口为函数式接口 */
@FunctionalInterface
public interface GreetingService {

  void sayMessage(String message);

  /** 允许有默认方法 */
  default void doSomeMoreWork1() {
    // Method body
  }

  default void doSomeMoreWork2() {
    // Method body
  }

  /** 允许静态方法 */
  static void printHello() {
    System.out.println("Hello");
  }

  /**
   * 允许重写Object public 方法
   *
   * @param obj
   * @return
   */
  @Override
  boolean equals(Object obj);
}
