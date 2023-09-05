package org.reactive_testing.operators;

import java.time.Duration;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Lec05DelayElements {

  public static void main(String[] args) {
    Flux.range(1, 100)
        .log()
        .delayElements(Duration.ofSeconds(1))
        .subscribe(Util.subscriber("Subscriber"));

    Util.sleepSeconds(101);
  }
}
