package org.reactive_testing.mono.sec01;

import org.reactive_testing.util.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

  public static void main(String[] args) {
    Mono.fromRunnable(timeConsumingProcess())
        .subscribe(Util.onNext(),
            Util.onError(),
            () -> {
              System.out.println("process is done Sending email ");
            });
  }

  private static Runnable timeConsumingProcess () {
    return () -> {
      Util.sleepSeconds(3);
      System.out.println("Operation completed");
    };
  }
}
