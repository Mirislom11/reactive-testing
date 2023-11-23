package org.reactive_testing.training2.sec04;

import java.util.Objects;
import org.reactive_testing.training2.Util;
import reactor.core.publisher.Flux;

public class Lec01Handle {
  public static void main(String[] args) {

    // handle = filter + map operators
    /*Flux.range(1, 20)
        .handle(
            (item, synchronousSink) -> {
              if (item % 2 == 0) {
                synchronousSink.next(item);
              } else {
                synchronousSink.next(item + "a");
              }
            })
        .subscribe(Util.subscriber());*/

    Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
        .map(Objects::toString)
        .handle((item, synchronousSink) -> {
          if (item.equalsIgnoreCase("Canada")){
            synchronousSink.complete();
          }else {
            synchronousSink.next(item);
          }
        }).subscribe(Util.subscriber());
  }
}
