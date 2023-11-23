package org.reactive_testing.training2.sec05;

import reactor.core.publisher.Flux;

public class RefCountExample {
  public static void main(String[] args){
    // publish().refCount()
    Flux<Integer> flux = Flux.range(1, 10);

// Поток будет подключен к подписчику только один раз.
    Flux<Integer> connectableFlux = flux.publish().autoConnect();

    connectableFlux.subscribe(System.out::println);

// Второй подписчик не получит никаких элементов.
    connectableFlux.subscribe(System.out::println);
  }
}
