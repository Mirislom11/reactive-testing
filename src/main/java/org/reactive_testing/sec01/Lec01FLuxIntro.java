package org.reactive_testing.sec01;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Lec01FLuxIntro {
    public static void main(String[] args) {
        Flux<Object> fLux = Flux.just(1, 2, 3, "a", Util.faker().name().fullName());

        fLux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
