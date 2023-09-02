package org.reactive_testing.flux.sec02;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class FluxGenerateWithState {

  public static void main(String[] args) {
    Flux.generate(
        () -> 1,
        (counter, sink) -> {
          String country = Util.faker().country().name();
          sink.next(counter);
          if (counter >= 10 || country.equalsIgnoreCase("canada"))
            sink.complete();
          return counter + 1;
        }
    )
        .take(4)
        .subscribe(Util.subscriber("Subscriber"));
  }
}
