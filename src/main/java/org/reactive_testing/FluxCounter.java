package org.reactive_testing;

import java.util.concurrent.atomic.AtomicInteger;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class FluxCounter {

  public static void main(String[] args) {
    AtomicInteger atomicInteger = new AtomicInteger(0);
    Flux.generate(synchronousSink -> {
      String country = Util.faker().country().name();
      System.out.println("emitting: " + country);
      synchronousSink.next(country);
      atomicInteger.incrementAndGet();
      if (country.equalsIgnoreCase("canada"))
        synchronousSink.complete();
    })
        .subscribe(Util.subscriber());

    System.out.println(atomicInteger.get());
  }
}
