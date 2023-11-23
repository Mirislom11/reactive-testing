package org.reactive_testing.batching.assignment;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Lec04Assignment {

  public static void main(String[] args) {
    Set<String> allowedCategories = Set.of(
        "Science fiction",
        "Fantasy",
        "Suspense/Thriller"
    );

    bookStream()
        .filter(bookOrder -> allowedCategories.contains(bookOrder.getCategory()))
        .buffer(Duration.ofSeconds(5))
        .map(Lec04Assignment::revenueCalculator)
        .subscribe(Util.subscriber("Subscriber"));

    Util.sleepSeconds(60);
  }

  private static RevenueReport revenueCalculator(List<BookOrder> books) {
    Map<String, Double> map = books.stream()
        .collect(Collectors.groupingBy(
            BookOrder::getCategory,
            Collectors.summingDouble(BookOrder::getPrice)
        ));
    return new RevenueReport(map);
  }

  private static Flux<BookOrder> bookStream() {
    return Flux.interval(Duration.ofMillis(200))
        .map(i -> new BookOrder());
  }
}
