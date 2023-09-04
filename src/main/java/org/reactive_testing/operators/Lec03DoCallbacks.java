package org.reactive_testing.operators;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Lec03DoCallbacks {

  public static void main(String[] args) {
    Flux.create(fluxSink -> {
          System.out.println("Inside create");
          for (int i = 0; i < 5; i++) {
            fluxSink.next(i);
          }
          throw new RuntimeException("oops");
        })
        .doOnComplete(() -> System.out.println("doOnComplete"))
        .doFirst(() -> System.out.println("doFirst"))
        .doOnNext(o -> System.out.println("doOnNext"))
        .doOnSubscribe(s -> System.out.println("doOnSubscribe subscription: " + s))
        .doOnRequest(l -> System.out.println("doOnRequest l: " + l))
        .doOnError(err -> System.out.println("doOnError: " + err.getMessage()))
        .doOnTerminate(() -> System.out.println("doOnTerminate"))
        .doFinally(signal -> System.out.println("doFinally: " + signal))
        .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard: " + o))
        .take(2 )
        .subscribe(Util.subscriber("Subscriber"));
  }
}
