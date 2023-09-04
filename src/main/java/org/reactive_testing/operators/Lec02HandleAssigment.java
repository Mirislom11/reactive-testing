package org.reactive_testing.operators;

import java.util.Objects;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Lec02HandleAssigment {

  public static void main(String[] args) {
    Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
        .map(Objects::toString)
        .handle((s, synchronousSink) -> {
          synchronousSink.next(s);
          if (s.equalsIgnoreCase("canada")) {
            synchronousSink.complete();
          }
        }).subscribe(Util.subscriber("Subscriber"));
  }
}
