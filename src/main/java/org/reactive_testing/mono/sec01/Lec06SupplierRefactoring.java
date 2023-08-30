package org.reactive_testing.mono.sec01;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {

  public static void main(String[] args) {
    getName(1);
    getName(2)
        .subscribeOn(Schedulers.boundedElastic())
        .subscribe(Util.onNext());
    getName(3);
    Util.sleepSeconds(5);
  }

  private static Mono<String> getName(int number) {
    System.out.println(
        "entered getName method number: " + number + " thread name: " + Thread.currentThread()
            .getName());
    return Mono.fromSupplier(() -> {
      System.out.println("Generating name....");
      Util.sleepSeconds(3);
      return Util.faker().name().fullName();
    }).map(String::toUpperCase);
  }
}
