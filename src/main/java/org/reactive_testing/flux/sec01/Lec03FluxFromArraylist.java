package org.reactive_testing.flux.sec01;

import java.util.Arrays;
import java.util.List;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxFromArraylist {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c", "d");
        Flux.fromIterable(strings)
                .subscribe(Util.onNext());
    }
}
