package org.reactive_testing.combining_publishers;

import java.time.Duration;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Emirates {
  public static Flux<String> getFlights () {
    return Flux.range(1, Util.faker().random().nextInt(1, 10))
        .delayElements(Duration.ofSeconds(1))
        .map(i -> "Emirates: " + Util.faker().random().nextInt(100, 900))
        .filter(i -> Util.faker().random().nextBoolean());

  }
}
