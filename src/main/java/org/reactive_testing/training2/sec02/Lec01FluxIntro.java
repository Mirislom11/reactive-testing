package org.reactive_testing.training2.sec02;

import org.reactive_testing.training2.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {
  public static void main(String[] args) {
    Flux<Integer> flux = Flux.just(1, 2, 3, 4);
    flux.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
  }
}
