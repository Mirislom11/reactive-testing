package org.reactive_testing.operators;

import java.time.Duration;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Lec07Timeout {

  public static void main(String[] args) {
    getOrderNumbers()
        .timeout(Duration.ofSeconds(2), fallback())
        .subscribe(Util.subscriber("Subscriber"));

    Util.sleepSeconds(60);
  }

  private static Flux<Integer> getOrderNumbers() {
    return Flux.range(1, 10)
        .delayElements(Duration.ofSeconds(5));
  }

  private static Flux<Integer> fallback() {
    return Flux.range(100, 10)
        .delayElements(Duration.ofMillis(200));
  }
}
