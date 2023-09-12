package org.reactive_testing.hot_cold_publisher.assigment;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import reactor.core.publisher.Flux;

public class InventoryService {
  private final Map<String, Integer> db = new HashMap<>();

  public InventoryService() {
    db.put("Kids", 100);
    db.put("Automotive", 100);
  }

  public Consumer<PurchaseOrder> subscribeInventoryStream() {
    return p -> db.computeIfPresent(p.getCategory(),
        (k, v) -> v + Integer.parseInt(p.getPrice()));
  }
  public Flux<String> inventoryStream () {
    return Flux.interval(Duration.ofSeconds(2))
        .map(i -> db.toString());
  }
}
