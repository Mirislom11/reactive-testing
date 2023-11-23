package org.reactive_testing.back_pressure;

import java.time.Duration;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class BackPressureLatestVsDrop {

  public static void main(String[] args) {
    /*Пример использования метода onBackpressureDrop:*/

    Flux.range(1, 1_000_000)
        .onBackpressureDrop()
        .publishOn(Schedulers.boundedElastic())
        .doOnNext(i -> {
          Util.sleepMillis(10);
        })
        .subscribe(Util.subscriber("Subscriber"));

    Util.sleepSeconds(60);
    /** В этом примере мы создаем поток данных с помощью метода range, который
    генерирует последовательность чисел от 1 до 1000000. Затем мы применяем метод
    onBackpressureDrop, чтобы отбросить элементы, которые не могут быть обработаны
    получателем.Далее мы используем метод observeOn, чтобы переключиться на другой поток
    для обработки данных.Наконец, мы подписываемся на поток данных и выводим каждый элемент
    в консоль.*/

    /*Flux.interval(Duration.ofMillis(1))
        .log()
        .onBackpressureLatest()
        .publishOn(Schedulers.boundedElastic())
        .doOnNext(i -> {
          Util.sleepMillis(100);
        })
        .log()
        .subscribe(Util.subscriber("Subscriber"));*/
  }
}
