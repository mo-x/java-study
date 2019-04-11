package org.goskyer.base.lambda;

public class GreetingServiceImpl implements GreetingService {

  @Override
  public void sayMessage(String message) {
    System.out.println("impl" + message);
  }
}
