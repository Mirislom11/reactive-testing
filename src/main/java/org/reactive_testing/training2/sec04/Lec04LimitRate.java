package org.reactive_testing.training2.sec04;

import org.reactive_testing.training2.Util;
import reactor.core.publisher.Flux;

public class Lec04LimitRate {
  public static void main(String[] args) {
    Flux.range(1, 1000).log().limitRate(100).subscribe(Util.subscriber());
  }
}
