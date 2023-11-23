package org.reactive_testing.training2.sec04;

import org.reactive_testing.training2.Util;
import reactor.core.publisher.Flux;

public class Lec06OnError {
  public static void main(String[] args){
    Flux.range(1, 10)
        .log()
        .map(i -> 10 / (5 - i))
        .onErrorContinue((err, obj) -> {

        })
        .subscribe(Util.subscriber());
  }
}
