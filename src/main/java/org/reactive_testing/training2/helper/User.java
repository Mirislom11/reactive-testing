package org.reactive_testing.training2.helper;

import lombok.Data;
import lombok.ToString;
import org.reactive_testing.training2.Util;

@Data
@ToString
public class User {
  private Integer id;
  private String name;

  public User(Integer id) {
    this.id = id;
    this.name = Util.faker().name().fullName();
  }
}
