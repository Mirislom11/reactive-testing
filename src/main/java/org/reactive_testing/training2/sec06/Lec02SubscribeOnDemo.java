package org.reactive_testing.training2.sec06;

import org.reactive_testing.training2.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec02SubscribeOnDemo {
  public static void main(String[] args){
    Flux<Object> flux = Flux.create(fluxSink -> {
      printThreadName("create");
      fluxSink.next(1);
    }).doOnNext(v -> printThreadName("sub " + v));

    flux
        .doFirst(() -> printThreadName("first2"))
        .subscribeOn(Schedulers.boundedElastic())
        .doFirst(() -> printThreadName("first1"))
        .subscribe(v -> printThreadName("sub " + v));

    Util.sleepSeconds(5);
  }

  private static void printThreadName (String msg) {
    System.out.println(msg + "\t\t" + " Thread : " + Thread.currentThread().getName());
  }
}
