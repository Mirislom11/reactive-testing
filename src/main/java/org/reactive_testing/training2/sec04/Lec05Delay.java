package org.reactive_testing.training2.sec04;

import java.time.Duration;
import org.reactive_testing.training2.Util;
import reactor.core.publisher.Flux;

public class Lec05Delay {
  public static void main(String[] args) {
    /*Flux.range(1, 100)
        .delayElements(Duration.ofSeconds(1))
        .doOnNext(e -> System.out.println("Emitted: "  + e))
        .subscribe(Util.subscriber());
    Util.sleepSeconds(100);*/

    Flux.range(1, 3)
        .map(i -> i / (2 - i))
        .onErrorReturn(3)
        .doFinally(signalType -> System.out.println("doFinally" + signalType))
        .subscribe(Util.subscriber());
  }
}
