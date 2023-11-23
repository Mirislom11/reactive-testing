package org.reactive_testing.training2.sec02;

import java.util.Arrays;
import java.util.List;
import org.reactive_testing.training2.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxFromStream {
  public static void main(String[] args){
    List<Integer> list = Arrays.asList(1,2,3,4);
    Flux<Integer> integerFlux = Flux.fromStream(() ->list.stream());

    integerFlux.subscribe(
        Util.onNext(),
        Util.onError(),
        Util.onComplete()
    );
    integerFlux.subscribe(
        Util.onNext(),
        Util.onError(),
        Util.onComplete()
    );
  }
}
