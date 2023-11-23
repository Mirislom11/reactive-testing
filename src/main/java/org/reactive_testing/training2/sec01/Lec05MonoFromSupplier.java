package org.reactive_testing.training2.sec01;

import java.util.concurrent.Callable;
import org.reactive_testing.training2.Util;
import reactor.core.publisher.Mono;

public class Lec05MonoFromSupplier {
  public static void main(String[] args){
    Mono<String> mono = Mono.fromSupplier(Lec05MonoFromSupplier::getName);
    mono.subscribe(Util.onNext());

    Callable<String> stringCallable = () -> getName();

    Mono.fromCallable(stringCallable)
        .subscribe(Util.onNext());
  }

  private static String getName () {
    System.out.println("Generating name.... ");
    return Util.faker().name().fullName();
  }
}
