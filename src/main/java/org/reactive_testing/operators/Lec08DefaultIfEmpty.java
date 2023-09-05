package org.reactive_testing.operators;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Lec08DefaultIfEmpty {

  public static void main(String[] args) {
    getOrderNumbers()
        .filter(i -> i > 10)
        .defaultIfEmpty(-100)
        .subscribe(Util.subscriber("Subscriber"));
  }

  private static Flux<Integer> getOrderNumbers() {
    return Flux.range(1, 12);
  }
}
