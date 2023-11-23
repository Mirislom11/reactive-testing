package org.reactive_testing.batching;

import java.time.Duration;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Lec02BufferDuration {
  public static void main(String[] args) {
    eventStream()
        .bufferTimeout(5, Duration.ofSeconds(2))
        .subscribe(Util.subscriber("Subscriber"));

    Util.sleepSeconds(60);
  }

  private static Flux<String> eventStream() {
    return Flux.interval(Duration.ofMillis(10))
        .map(i -> "event: " + i);
  }
}
