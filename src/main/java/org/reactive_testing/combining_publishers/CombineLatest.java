package org.reactive_testing.combining_publishers;

import reactor.core.publisher.Flux;

public class CombineLatest {

  public static void main(String[] args) {
    Flux<Integer> flux1 = Flux.just(1, 2, 3);
    Flux<Integer> flux2 = Flux.just(10, 20, 30);

    Flux<Integer> combinedFlux = Flux.combineLatest(flux1, flux2, Integer::sum);

    combinedFlux.subscribe(System.out::println);
  }
}
