package org.reactive_testing.training2.sec03;

import org.reactive_testing.training2.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {
  public static void main(String[] args){
    Flux.generate(
            synchronousSink -> {
              System.out.println("emitting");
              synchronousSink.next(Util.faker().country().name());
              synchronousSink.complete();
            })
        .subscribe(Util.subscriber());
  }
}
