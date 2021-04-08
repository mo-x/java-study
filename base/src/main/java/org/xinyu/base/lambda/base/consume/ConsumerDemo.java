package org.xinyu.base.lambda.base.consume;

import java.util.function.Consumer;

public class ConsumerDemo {

  public static void main(String[] args) {
    Consumer<Integer> consumer =
        x -> {
          int a = x + 2;
          // a= 12
          System.out.println(a);
          // a= 12_
          System.out.println(a + "_");
        };
    System.out.println("lazy...");
    consumer.accept(10);

    Consumer<User> userConsumer =
        user -> {
          if (user.getName().startsWith("a")) {
            System.out.println(user.getName());
          }
        };
    User user = new User();
    user.setName("a");
    userConsumer.accept(user);

    NameConsumer nameConsumer = new NameConsumer();
    nameConsumer.accept(user);
  }

  static class NameConsumer implements Consumer<User> {
    @Override
    public void accept(User user) {
      if (user.getName().startsWith("a")) {
        System.out.println(user.getName());
      }
    }
  }
}

class User {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
