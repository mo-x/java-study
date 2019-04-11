package org.goskyer.base.lambda.base.predicte;



public class Apple {

  private String name;
  private Double weight;
  private String color;

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public Apple(String name, Double weight, String color) {
    this.name = name;
    this.weight = weight;
    this.color = color;
  }
}
