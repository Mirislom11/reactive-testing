package org.reactive_testing.training2.sec04;

import java.util.function.Function;
import org.reactive_testing.training2.Util;
import org.reactive_testing.training2.helper.Person;
import reactor.core.publisher.Flux;

public class Lec11SwitchOnFirst {
  public static void main(String[] args) {
    getPerson()
        .switchOnFirst(
            ((signal, personFlux) -> {
              if (signal.isOnNext() && signal.get().getAge() > 10) {
                return personFlux;
              } else {
                return applyFilterMap().apply(personFlux);
              }
            }))
        .subscribe(Util.subscriber());
  }

  private static Flux<Person> getPerson() {
    return Flux.range(1, 10).map(item -> new Person());
  }

  private static Function<Flux<Person>, Flux<Person>> applyFilterMap() {
    return flux ->
        flux.filter(p -> p.getAge() > 10)
            .doOnNext(p -> p.setName(p.getName().toUpperCase()))
            .doOnDiscard(Person.class, p -> System.out.println("Not Allowing: " + p));
  }
}
