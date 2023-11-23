package org.reactive_testing.repeat_retry;

import java.time.Duration;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

public class Lec02Retry {
  public static void main(String[] args) {
    getIntegers()
        .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(3)))
        .subscribe(Util.subscriber("Subscriber"));
    Util.sleepSeconds(60);
  }

  private static Flux<Integer> getIntegers() {
    return Flux.range(1, 3)
        .doOnSubscribe(s -> System.out.println("Subscribed"))
        .doOnComplete(() -> System.out.println("Completed"))
        .map(i -> i / (Util.faker().random().nextInt(1, 5) > 3 ? 0 : 1))
        .doOnError(err -> System.out.println("--error"));
  }
}
