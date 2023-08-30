package org.reactive_testing.mono.sec01;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmpty {

  public static void main(String[] args) {
    userRepository(21).subscribe(Util.onNext(), Util.onError(), Util.onComplete());
  }

  private static Mono<String> userRepository(Integer userId) {
    if (userId == 1) {
      return Mono.just(Util.faker().name().firstName());
    } else if (userId == 2) {
      return Mono.empty();
    } else {
      return Mono.error(new RuntimeException("Not in the allowed range"));
    }
  }
}
