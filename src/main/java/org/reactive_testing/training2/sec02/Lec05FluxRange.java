package org.reactive_testing.training2.sec02;

import org.reactive_testing.training2.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {
  public static void main(String[] args) {
    Flux.range(3, 10)
        .log()
        .map(i -> Util.faker().name().fullName())
        .log()
        .subscribe(Util.onNext());
  }
}
