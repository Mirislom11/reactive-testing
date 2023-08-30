package org.reactive_testing;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Lec06FluxGenerateAssigment {

  public static void main(String[] args) {
    Flux.generate(synchronousSink -> {
      String country = Util.faker().country().name();
      System.out.println("emitting: " + country);
      synchronousSink.next(country);
      if (country.equalsIgnoreCase("canada"))
        synchronousSink.complete();
    }).subscribe(Util.subscriber("Subscriber"));
  }

}
