package org.reactive_testing.flux.sec02;

import org.reactive_testing.util.Util;
import org.w3c.dom.ls.LSOutput;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {

  public static void main(String[] args) {
    Flux.generate(synchronousSink -> {
      System.out.println("emitting");
      synchronousSink.next(Util.faker().country().name());
    }).subscribe(Util.subscriber("Syncronous subscriber"));
  }

}
