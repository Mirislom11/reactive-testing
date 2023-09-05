package org.reactive_testing.operators;

import org.reactive_testing.operators.helper.OrderService;
import org.reactive_testing.operators.helper.UserService;
import org.reactive_testing.util.Util;

public class Lec12FlatMap {

  public static void main(String[] args) {

    UserService.getUsers()
        .flatMap(user -> OrderService.getOrders(user.getUserId()))
        .subscribe(Util.subscriber("Subscriber"));
  }
}
