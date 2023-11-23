package org.reactive_testing.training2.sec01;

import org.reactive_testing.training2.Util;
import reactor.core.publisher.Mono;

public class MonoFromRunnable {
  public static void main(String[] args) {
    Mono.fromRunnable(timeConsumingProcess())
        .subscribe(
            Util.onNext(),
            Util.onError(),
            () -> {
              System.out.println("process is done Sending emails");
            });
  }

  private static Runnable timeConsumingProcess() {
    return () -> {
      Util.sleepSeconds(3);
      System.out.println("Operation completed");
    };
  }
}
