package org.reactive_testing.training2.sec03;

import org.reactive_testing.training2.helper.NameProducer;
import org.reactive_testing.training2.Util;
import reactor.core.publisher.Flux;

public class Lec08FluxPush {
  public static void main(String[] args){
    NameProducer nameProducer = new NameProducer();

    Flux.push(nameProducer)
        .subscribe(Util.subscriber());
    Runnable runnable = nameProducer::produce;

    for(int i = 0; i < 10; i++) {
      new Thread(runnable).start();
    }
  }
}
