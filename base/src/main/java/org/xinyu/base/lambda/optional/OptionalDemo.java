package org.xinyu.base.lambda.optional;

import org.xinyu.base.lambda.base.predicte.Apple;

import java.util.Optional;

public class OptionalDemo {

  public static void main(String[] args) {
    Apple apple = new Apple("red", 2.0d, "red");
    String name = "";
    if (apple != null) {
      name = apple.getName();
    }
    apple = null;
    // 改进写法 optional获取name
    String uknow = Optional.ofNullable(apple).map(Apple::getName).orElse("Uknow");
    Optional<String> s = Optional.ofNullable(apple).map(Apple::getName);

    System.out.println("optional get:" +uknow);
    String insurance = "";

    Person person = new Person();
    person.setCar(new Car());

    // 传统if-else
    if (person != null) {
      if (person.getCar() != null) {
        if (person.getCar().getInsurance() != null) {
          insurance = person.getCar().getInsurance().getName();
        }
      }
    }
    // optional 优化写法
    String unknown =
        Optional.ofNullable(person)
            .map(Person::getCar)
            .map(Car::getInsurance)
            .map(Insurance::getName)
            .orElse("Unknown");
//    System.out.println(unknown);
  }

  public String getCarInsuranceName(Optional<Person> person) {
    return "";
  }
}

class Person {

  private String name;
  private Car car;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }
}

class Car {

  private Insurance insurance;

  public org.xinyu.base.lambda.optional.Insurance getInsurance() {
    return insurance;
  }

  public void setInsurance(org.xinyu.base.lambda.optional.Insurance insurance) {
    this.insurance = insurance;
  }
}

class Insurance {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
