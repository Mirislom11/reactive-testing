package org.reactive_testing.training2.helper;

import lombok.Data;
import lombok.ToString;
import org.reactive_testing.training2.Util;

@Data
@ToString
public class Person {
  private String name;
  private Integer age;

  public Person() {
    this.name = Util.faker().name().name();
    this.age = Util.faker().random().nextInt(1, 100);
  }
}
