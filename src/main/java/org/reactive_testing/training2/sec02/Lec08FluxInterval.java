package org.reactive_testing.training2.sec02;

import java.time.Duration;
import org.reactive_testing.training2.Util;
import reactor.core.publisher.Flux;

public class Lec08FluxInterval {

  public static void main(String[] args){
    Flux.interval(Duration.ofSeconds(1))
        .subscribe(Util.onNext());

    Util.sleepSeconds(5);
  }
}
