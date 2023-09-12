package org.reactive_testing.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import reactor.core.publisher.Flux;

public class NameGenerator {

  public static List<String> getNames (Integer count) {
    List<String> list = new ArrayList<>(count);
    for (int i = 0; i < count; i++) {
      list.add(getName());
    }
    return list;
  }

  public static Flux<String> getFluxNames (Integer count) {
    AtomicInteger atomicInteger = new AtomicInteger();
    return Flux.generate(stringSynchronousSink -> {
      if (atomicInteger.get() == count) {
        stringSynchronousSink.complete();
      }else {
        Util.sleepSeconds(1);
        stringSynchronousSink.next(Util.faker().name().fullName());
        atomicInteger.incrementAndGet();
      }
    });
  }
  private static String getName () {
    Util.sleepSeconds(1);
    return Util.faker().name().fullName();
  }
}
