package org.reactive_testing.training2.sec01;

import org.reactive_testing.training2.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06MonoFromSupplierRefactoring {

  public static void main(String[] args){
    getName();
    getName()
        .subscribeOn(Schedulers.boundedElastic())
        .subscribe(Util.onNext());
    getName();
    Util.sleepSeconds(4);
  }

  private static Mono<String> getName () {
    System.out.println("entered getName method");
    return Mono.fromSupplier(() -> {
      System.out.println("Generating name ....");
      Util.sleepSeconds(3);
      return Util.faker().name().fullName();
    }).map(String::toUpperCase);
  }
}
