package org.reactive_testing.training2.sec01;

import org.reactive_testing.training2.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
  public static void main(String[] args) {
    // publisher

    Mono<String> mono = Mono.just("ball");

    // 1
    // mono.subscribe();

    //
    mono.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
  }
}
