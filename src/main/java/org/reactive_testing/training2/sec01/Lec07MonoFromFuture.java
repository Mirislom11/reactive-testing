package org.reactive_testing.training2.sec01;

import java.util.concurrent.CompletableFuture;
import org.reactive_testing.training2.Util;
import reactor.core.publisher.Mono;

public class Lec07MonoFromFuture {
  public static void main(String[] args){
    Mono.fromFuture(getName())
        .subscribe(Util.onNext());
    Util.sleepSeconds(1);
  }

  private static CompletableFuture<String> getName () {
    return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
  }
}
