package org.reactive_testing.training2.sec01;

import org.reactive_testing.training2.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {

  public static void main(String[] args) {
    userRepository(3).subscribe(Util.onNext(), Util.onError(), Util.onComplete());
  }

  private static Mono<String> userRepository(Integer userId) {
    // 1
    if (userId == 1) {
      return Mono.just(Util.faker().name().firstName());
    } else if (userId == 2) {
      return Mono.empty();
    } else {
      return Mono.error(() -> new RuntimeException("User not found"));
    }
  }
}
