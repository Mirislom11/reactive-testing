package org.reactive_testing.threading_schedulers;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec03PublishOn {

  public static void main(String[] args) {
    Flux<Object> flux = Flux.create(fluxSink -> {
          printThreadName("create");
          for (int i = 0; i < 4; i++) {
            fluxSink.next(i);
            Util.sleepSeconds(2);
          }
        })
        .doOnNext(i -> printThreadName("next " + i));

    flux
        .publishOn(Schedulers.boundedElastic())
        .doOnNext(i -> printThreadName("next: " + i))
        .subscribe(v -> printThreadName("sub: " + v));

    Util.sleepSeconds(5);
  }

  private static void printThreadName(String message) {
    System.out.println(message + "\t\t: Thread: " + Thread.currentThread().getName());
  }
}

