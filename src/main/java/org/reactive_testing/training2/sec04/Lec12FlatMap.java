package org.reactive_testing.training2.sec04;

import org.reactive_testing.training2.Util;
import org.reactive_testing.training2.helper.OrderService;
import org.reactive_testing.training2.helper.UserService;

public class Lec12FlatMap {

  public static void main(String[] args) {
    UserService.getUsers()
        .flatMap(user -> OrderService.getOrders(user.getId()))
        .subscribe(Util.subscriber());
  }
}
