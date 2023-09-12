package org.reactive_testing.hot_cold_publisher.assigment;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import reactor.core.publisher.Flux;

public class RevenueService {

  private final Map<String, Double> db = new HashMap<>();

  public RevenueService() {
    db.put("Kids", 0.0);
    db.put("Automotive", 0.0);
  }

  public Consumer<PurchaseOrder> subscribeOrderStream() {
    return p -> db.computeIfPresent(p.getCategory(),
        (k, v) -> v + Double.parseDouble(p.getPrice()));
  }
  public Flux<String> revenueStream () {
    return Flux.interval(Duration.ofSeconds(2))
        .map(i -> db.toString());

  }

}
