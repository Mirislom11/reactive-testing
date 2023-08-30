package org.reactive_testing;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {

  public static void main(String[] args) {
    Flux.create(fluxSink -> {
          String country;
          do {
            country = Util.faker().country().name();
            System.out.println("emitting: " + country);
            fluxSink.next(country);
          } while (!country.equalsIgnoreCase("canada"));
          fluxSink.complete();
        })
        .take(3)
        .subscribe(Util.subscriber("Subscriber"));
  }
}
