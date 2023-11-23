package org.reactive_testing.training2.sec03;

import org.reactive_testing.training2.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {
  public static void main(String[] args) {
    Flux.create(
            fluxSink -> {
              /*for(int i = 0; i < 10; i++) {
                Util.sleepSeconds(1);
                fluxSink.next(Util.faker().name());
              }*/
              String country;
              do {
                country = Util.faker().country().name();
                fluxSink.next(country);
              } while (!country.equalsIgnoreCase("canada"));
              fluxSink.complete();
            })
        .subscribe(Util.subscriber());
  }
}
