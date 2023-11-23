package org.reactive_testing.training2.sec04;

import java.util.function.Function;
import org.reactive_testing.training2.Util;
import org.reactive_testing.training2.helper.Person;
import reactor.core.publisher.Flux;

public class Lec10Transform {
  public static void main(String[] args) {
    getPerson()
        .transform(applyFilterMap())
        .subscribe(Util.subscriber());
  }

  private static Flux<Person> getPerson() {
    return Flux.range(1, 10)
        .map(i -> new Person());
  }

  private static Function<Flux<Person>, Flux<Person>> applyFilterMap () {
    return flux -> flux
        .filter(p -> p.getAge() > 10)
        .map(p -> {
          p.setName(p.getName().toUpperCase());
          return p;
        });
  }
}
