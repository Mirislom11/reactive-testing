package org.reactive_testing.threading_schedulers;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class SubscribeOnMultipleItems {

  public static void main(String[] args) {
    Flux<Object> flux = Flux.create(fluxSink -> {
          printThreadName("create");
          for (int i = 0; i < 4; i++) {
            fluxSink.next(i);
            Util.sleepSeconds(2);
          }
        })
        .doOnNext(i -> printThreadName("next " + i));

    Runnable runnable = () -> flux
        .doOnNext(o -> System.out.println(" doOnNext: " + o + " " + Thread.currentThread().getName()))
        .subscribeOn(Schedulers.boundedElastic())
        .subscribe(v -> printThreadName("sub: " + v));

    for (int i = 0; i < 4; i++) {
      new Thread(runnable).start();
    }
    
    Util.sleepSeconds(5);

    /*Flux.range(1, 100)
        .parallel()
        .runOn(Schedulers.parallel())
        .map(i -> i * 10)
        .sequential()
        .subscribe(v -> printThreadName("sub: " + v));
    Util.sleepSeconds(5);*/

   /* Flux.range(1, 100)
        .flatMap(i -> Mono.just(i)
            .subscribeOn(Schedulers.boundedElastic())
            .map(j -> j * 10))
        .subscribe(v -> printThreadName("sub: " + v)  );
    Util.sleepSeconds(5);*/
  }

  private static void printThreadName(String message) {
    System.out.println(message + "\t\t: Thread: " + Thread.currentThread().getName());
  }
}
