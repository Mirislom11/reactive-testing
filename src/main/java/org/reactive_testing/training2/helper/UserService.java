package org.reactive_testing.training2.helper;

import reactor.core.publisher.Flux;

public class UserService {

  public static Flux<User> getUsers () {
    return Flux.range(1, 2)
        .map(id -> new User(id));
  }
}
