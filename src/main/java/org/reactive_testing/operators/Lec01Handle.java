package org.reactive_testing.operators;

import reactor.core.publisher.Flux;
import org.reactive_testing.util.Util;

public class Lec01Handle {

  public static void main(String[] args) {
    Flux.range(1, 20)
        .handle(((integer, synchronousSink) -> {
          if (integer % 2 == 0) {
            synchronousSink.next(integer);
          } else {
            synchronousSink.next(integer + "a");
          }
        }))
        .subscribe(Util.subscriber("Subscriber"));
  }
}
