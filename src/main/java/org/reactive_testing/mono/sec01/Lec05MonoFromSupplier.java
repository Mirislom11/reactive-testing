package org.reactive_testing.mono.sec01;

import java.util.function.Supplier;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Mono;

public class Lec05MonoFromSupplier {

  public static void main(String[] args) {
    /*Mono<String> mono = Mono.just(getName());*/

    Supplier<String> supplier = Lec05MonoFromSupplier::getName;
    Mono<String> mono = Mono.fromSupplier(supplier);
    mono.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
  }

  private static String getName() {
    System.out.println("Generating name....");
    return Util.faker().name().fullName();
  }
}
