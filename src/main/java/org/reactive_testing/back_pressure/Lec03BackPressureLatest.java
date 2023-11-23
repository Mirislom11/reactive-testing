package org.reactive_testing.back_pressure;

import java.util.ArrayList;
import java.util.List;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec03BackPressureLatest {

  public static void main(String[] args) {
    /*System.setProperty("reactor.bufferSize.small", "16");*/
    List<Integer> list = new ArrayList<>();
    Flux.create(fluxSink -> {
          for (int i = 0; i < 501; i++) {
            fluxSink.next(i);
            System.out.println("Pushed: " + i);
          }
        })
        .onBackpressureLatest()
        .publishOn(Schedulers.boundedElastic())
        .doOnNext(i -> {
          Util.sleepMillis(100);
        }).subscribe(Util.subscriber());

    Util.sleepSeconds(100);
  }
}
