package org.reactive_testing;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Main {

  public static void main(String[] args) {

    Flux.create(synchronousSink -> {

          synchronousSink.next(1);
          synchronousSink.next(2);

        })
        .subscribe(System.out::println);
  }
}