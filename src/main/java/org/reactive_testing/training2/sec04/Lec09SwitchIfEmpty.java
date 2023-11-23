package org.reactive_testing.training2.sec04;

import org.reactive_testing.training2.Util;
import reactor.core.publisher.Flux;

public class Lec09SwitchIfEmpty {
  public static void main(String[] args){
    getOrderNumbers()
        .filter(i -> i > 10)
        .switchIfEmpty(fallback())
        .subscribe(Util.subscriber());
  }

  private static Flux<Integer> getOrderNumbers() {
    return Flux.range(1, 9);
  }

  private static Flux<Integer> fallback () {
    return Flux.range(20, 5);
  }
}
