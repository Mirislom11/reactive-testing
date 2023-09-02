package org.reactive_testing.flux.sec02;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {

  public static void main(String[] args) {
    Mono<String> mono = Mono.just("a");
    Flux<String> flux = Flux.from(mono);
    flux.subscribe(Util.onNext());
  }

  private static void doSomething (Flux<String> flux ) {

  }
}
