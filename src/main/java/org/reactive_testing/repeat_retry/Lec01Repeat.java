package org.reactive_testing.repeat_retry;

import java.util.concurrent.atomic.AtomicInteger;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Lec01Repeat {

  private static AtomicInteger atomicInteger = new AtomicInteger(1);

  public static void main(String[] args) {
    getIntegers()
        .repeat(() -> atomicInteger.get() < 14)
        .subscribe(Util.subscriber("Subscriber"));
  }

  private static Flux<Integer> getIntegers() {
    return Flux.range(1, 3)
        .doOnSubscribe(s -> System.out.println("Subscribed"))
        .doOnComplete(() -> System.out.println("Completed"))
        .map(i -> atomicInteger.getAndIncrement());
  }
}
