package org.reactive_testing.flux.sec02;

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