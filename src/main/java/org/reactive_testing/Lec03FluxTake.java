package org.reactive_testing;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxTake {

  public static void main(String[] args) {
    Flux.range(1, 10)
        .take(3)
        .subscribe(Util.subscriber());
  }

}
