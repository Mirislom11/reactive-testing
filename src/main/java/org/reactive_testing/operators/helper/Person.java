package org.reactive_testing.operators.helper;

import lombok.Data;
import org.reactive_testing.util.Util;

@Data
public class Person {
  private String name;
  private Integer age;

  public Person() {
    this.name = Util.faker().name().firstName();
    this.age = Util.faker().random().nextInt(1, 30);
  }

}
