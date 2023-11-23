package org.reactive_testing.combining_publishers;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Lec03Merge {

  public static void main(String[] args) {
    Flux<String> merge = Flux.merge(
        QatarFlights.getFlights(),
        Emirates.getFlights(),
        AmericanAirlines.getFlights()
    );

    merge.subscribe(Util.subscriber());
    Util.sleepSeconds(3);
  }
}
