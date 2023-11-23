package org.reactive_testing.operators;

import org.reactive_testing.operators.helper.Player;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec12FlatMap {

  public static void main(String[] args) {
    /*Flux<Player> playerFlux = Flux
        .just("Michael Jordan", "Scottie Pippen", "Steve Kerr")
        .flatMap(n -> Mono.just(n)
            .map(p -> {
              System.out.println("Thread name: " + Thread.currentThread().getName());
              String[] split = p.split("\\s");
              return new Player(split[0], split[1]);
            })
            .subscribeOn(Schedulers.parallel())
        );
    playerFlux
        .subscribe(Util.subscriber("Subscriber"));*/

    Flux.just(
            "apple", "orange", "banana", "kiwi", "strawberry")
        .buffer(3)
        .flatMap(x ->
            Flux.fromIterable(x)
                .map(String::toUpperCase)
                .subscribeOn(Schedulers.parallel())
                .log()
        ).subscribe();
    Util.sleepSeconds(5);
  }
}
