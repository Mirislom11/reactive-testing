package org.reactive_testing.operators.helper;

import lombok.Data;
import lombok.ToString;
import org.reactive_testing.util.Util;

@Data
@ToString
public class User {
  private Integer userId;
  private String name;

  public User(Integer userId) {
    this.userId = userId;
    this.name = Util.faker().name().fullName();
  }


}
