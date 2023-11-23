package org.reactive_testing.combining_publishers;

import reactor.core.publisher.Flux;

public class FluxZip {

  public static void main(String[] args) {
    Flux<String> flux1 = Flux.just("A", "B", "C");
    Flux<String> flux2 = Flux.just("1", "2", "3");

    Flux<String> zippedFlux = Flux.zip(flux1, flux2, (s1, s2) -> s1 + s2);

    zippedFlux.subscribe(System.out::println);
  }
}
