package org.reactive_testing.combining_publishers;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class FluxConcat {

  public static void main(String[] args) {
    Flux<String> sam = Flux.just("Sam");
    Flux<String> jack = Flux.just("Jack");
    Flux<String> michael = Flux.just("Michael");

    Flux.concat(sam, michael, jack)
        .subscribe(Util.subscriber());
  }
}
