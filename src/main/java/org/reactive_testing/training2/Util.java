package org.reactive_testing.training2;

import com.github.javafaker.Faker;
import java.util.function.Consumer;
import lombok.experimental.UtilityClass;
import org.reactive_testing.training2.sec02.DefaultSubscriber;
import org.reactivestreams.Subscriber;

@UtilityClass
public class Util {
  private static final Faker FAKER = Faker.instance();

  public static Consumer<Object> onNext() {
    return o -> System.out.println("Received: " + o);
  }

  public static Consumer<Throwable> onError() {
    return e -> System.out.println("ERROR: " + e.getMessage());
  }

  public static Runnable onComplete() {
    return () -> System.out.println("Completed");
  }

  public static Faker faker() {
    return FAKER;
  }

  public static void sleepSeconds(Integer seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static Subscriber<Object> subscriber () {
    return new DefaultSubscriber();
  }

  public static Subscriber<Object> subscriber(String name) {
    return new DefaultSubscriber(name);
  }

}
