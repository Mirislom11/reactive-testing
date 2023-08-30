package org.reactive_testing.mono.sec01;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class StockPricePublisher {

  public static Flux<Integer> getPrice () {
    AtomicInteger atomicInteger = new AtomicInteger(100);
     return Flux.interval(Duration.ofSeconds(1))
         .map(i -> atomicInteger.getAndAccumulate(
             Util.faker().random().nextInt(-5, 5),
             Integer::sum
         ));

  }
}
