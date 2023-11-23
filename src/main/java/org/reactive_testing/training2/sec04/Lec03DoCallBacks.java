package org.reactive_testing.training2.sec04;

import org.reactive_testing.training2.Util;
import reactor.core.publisher.Flux;

public class Lec03DoCallBacks {
  public static void main(String[] args) {
    Flux.create(
            fluxSink -> {
              for (int i = 0; i < 5; i++) {
                Util.sleepSeconds(1);
                fluxSink.next(Util.faker().name().fullName());
              }
              fluxSink.complete();
              System.out.println("--completed");
            })
        .doOnComplete(() -> System.out.println("doOnComplete"))
        .doFirst(() -> System.out.println("doFirst"))
        .doOnNext(e -> System.out.println("doOnNext element: " + e))
        .doOnSubscribe(s -> System.out.println("doOnSubscribe: " + s))
        .doOnRequest(l -> System.out.println("doOnRequest: " + l))
        .doOnError(err -> System.out.println("doOnError: " + err.getMessage()))
        .doOnSubscribe(s -> System.out.println("doOnSubscribe: " + s))
        .doOnTerminate(() -> System.out.println("doOnTerminate"))
        .doOnCancel(() -> System.out.println("doOnCancel"))
        .doFinally(signal -> System.out.println("doFinally: " + signal))
        .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard: " + o))
        .subscribe(Util.subscriber());
  }
}
