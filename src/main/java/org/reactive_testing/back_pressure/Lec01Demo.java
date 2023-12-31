package org.reactive_testing.back_pressure;

import java.util.ArrayList;
import java.util.List;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec01Demo {

  public static void main(String[] args) {
    /*System.setProperty("reactor.bufferSize.small", "16");*/
    List<Object> list = new ArrayList<>();
    Flux.create(fluxSink -> {
          for (int i = 0; i < 1000000; i++) {
            Util.sleepSeconds(10);
            System.out.println("Pushed: " + i);
            fluxSink.next(i);
          }
        })
        .onBackpressureLatest()
        .publishOn(Schedulers.boundedElastic())
        .doOnNext(i -> {
          Util.sleepMillis(10);
        }).subscribe(Util.subscriber());

    Util.sleepSeconds(60);
    System.out.println(list);
  }
}
