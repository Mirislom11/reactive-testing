package org.reactive_testing.flux.sec01;

import java.util.List;
import java.util.stream.Stream;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class FluxFromStream {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4);
        Stream<Integer> stream = list.stream();

        Flux<Integer> integerFlux = Flux.fromStream(stream);

        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
