package org.reactive_testing.operators.sec01;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Lec03DoCallBacks {

  public static void main(String[] args) {
    Flux.create(fluxSink -> {
          System.out.println("inside create");
          for (int i = 0; i < 10; i++) {
            fluxSink.next(i);
          }
          fluxSink.complete();
          System.out.println("--completed");
        })
        .doFirst(() -> System.out.println("doFirst"))
        .doOnNext(o -> System.out.println("doOnNext: " + o))
        .doOnSubscribe(s -> System.out.println("doOnSubscribe: " + s))
        .doOnRequest(l -> System.out.println("doOnRequest: " + l))
        .doOnError(err -> System.out.println("doOnError: " + err.getMessage()))
        .doOnTerminate(() -> System.out.println("doOnTerminate"))
        .doOnCancel(() -> System.out.println("doOnCancel"))
        .doFinally((signalType) -> System.out.println("doFinally: " + signalType))
        .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard: " + o) )
        .doOnComplete(() -> System.out.println("doOnComplete"))
        .subscribe(Util.subscriber("Subscriber"));
  }

}
