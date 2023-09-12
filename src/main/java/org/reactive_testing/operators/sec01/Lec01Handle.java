package org.reactive_testing.operators.sec01;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Lec01Handle {

  public static void main(String[] args) {
    Flux.range(1, 20)
        .handle(((integer, synchronousSink) -> {
          if (integer == 7) {
            synchronousSink.complete();
          } else {
            synchronousSink.next(integer);
          }
        }))
        .subscribe(Util.subscriber("Subscriber"));
  }
}
