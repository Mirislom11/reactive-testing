package org.reactive_testing.training2.sec05;

import reactor.core.publisher.Flux;

public class Test {

  public Test() {
    throw new RuntimeException();
  }

  public static void main(String[] args){
    Test test = new Test();
    /*Flux<Object> flux = Flux.create(fluxSink -> {
          System.out.println("created");
          for (int i = 0; i < 5; i++) {
            fluxSink.next(i);
          }
          fluxSink.complete();
        })
        .publish()
        .refCount(3);

    flux.subscribe(System.out::println);
    flux.subscribe(System.out::println);
    flux.subscribe(System.out::println);*/
  }
}
