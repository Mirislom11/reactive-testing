package org.reactive_testing.operators;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec06OnError {

  public static void main(String[] args) {
    Flux.range(1, 10)
        .log()
        .map(i -> 10 / (5 - i))
        .onErrorResume(e -> fallback())
        .subscribe(Util.subscriber("Subscriber"));
  }

  private static Mono<Integer> fallback() {
    return Mono.fromSupplier(() -> Util.faker().random().nextInt(100, 200));
  }
}
