package org.reactive_testing.batching;

import java.time.Duration;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec04Window {

  public static void main(String[] args) {
    eventStream()
        .window(5)
        .flatMap(Lec04Window::saveEvents)
        .subscribe(Util.subscriber("Subscriber"));

    Util.sleepSeconds(60);
  }

  private static Flux<String> eventStream() {
    return Flux.interval(Duration.ofMillis(500))
        .map(i -> "event: " + i);
  }

  private static Mono<Void> saveEvents (Flux<String> flux) {
    return flux
        .doOnNext(e -> System.out.println("saving: " + e))
        .doOnComplete(() -> {
          System.out.println("saved this batch");
          System.out.println("-----------------");
        })
        .then();
  }
}
