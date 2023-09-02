package org.reactive_testing.sec01;

import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {
    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);

        integerFlux.subscribe(i -> System.out.println("Sub1: " + i));
        integerFlux.subscribe(i -> System.out.println("Sub2: " + i));
    }
}
