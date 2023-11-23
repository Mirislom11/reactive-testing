package org.reactive_testing.training2.sec01;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {
  public static void main(String[] args){
    Mono<Integer> mono = Mono.just(1);

    mono.subscribe(i -> System.out.println("Received: " + i));
  }
}
