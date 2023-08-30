package org.reactive_testing.mono.sec01;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscriber {

  public static void main(String[] args) {
    /*Mono<Integer> mono = Mono.just("ball")
        .map(String::length)
        .map(l -> l /0);*/
    Mono<String> mono = Mono.just("ball");

    mono.subscribe(
        Util.onNext(),
        Util.onError(),
        Util.onComplete()
    );
  }
}
