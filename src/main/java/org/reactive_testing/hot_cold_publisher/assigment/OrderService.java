package org.reactive_testing.hot_cold_publisher.assigment;

import java.time.Duration;
import java.util.Objects;
import org.reactive_testing.hot_cold_publisher.assigment.PurchaseOrder;
import reactor.core.publisher.Flux;

public class OrderService {

  private Flux<PurchaseOrder> flux;

  public Flux<PurchaseOrder> orderStream () {
    if (Objects.isNull(flux))
      flux = getOrderStream();
    return flux;
  }
  private Flux<PurchaseOrder> getOrderStream () {
    return Flux.interval(Duration.ofMillis(100))
        .map(i -> new PurchaseOrder())
        .publish()
        .refCount(2);
  }
}
