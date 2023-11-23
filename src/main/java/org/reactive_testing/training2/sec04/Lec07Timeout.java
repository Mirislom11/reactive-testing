package org.reactive_testing.training2.sec04;

import java.time.Duration;
import org.reactive_testing.training2.Util;
import reactor.core.publisher.Flux;

public class Lec07Timeout {
  public static void main(String[] args) {
    getOrderNumbers().timeout(Duration.ofSeconds(2), fallBack()).subscribe(Util.subscriber());

    Util.sleepSeconds(60);
  }

  private static Flux<Integer> getOrderNumbers() {
    return Flux.range(1, 10).delayElements(Duration.ofSeconds(5));
  }

  private static Flux<Integer> fallBack() {
    return Flux.range(100, 10).delayElements(Duration.ofSeconds(1));
  }
}
