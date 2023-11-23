package org.reactive_testing.training2.sec02;

import java.util.Arrays;
import java.util.List;
import org.reactive_testing.training2.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxFromArrayOrList {
  public static void main(String[] args) {
    List<String> strings = Arrays.asList("a", "b", "c");

    Flux.fromIterable(strings).subscribe(Util.onNext());

    Integer[] arr = {2, 3, 4, 5};
    Flux.fromArray(arr).subscribe(Util.onNext());
  }
}
