package org.reactive_testing.operators.helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reactor.core.publisher.Flux;

public class OrderService {
  private static Map<Integer, List<PurchaseOrder>> db = new HashMap<>();

  static {
    List<PurchaseOrder> list1 = Arrays.asList(
       new PurchaseOrder(1),
       new PurchaseOrder(1),
       new PurchaseOrder(1),
       new PurchaseOrder(1),
       new PurchaseOrder(1)
    );
    List<PurchaseOrder> list2 = Arrays.asList(
        new PurchaseOrder(2),
        new PurchaseOrder(2),
        new PurchaseOrder(2),
        new PurchaseOrder(2),
        new PurchaseOrder(2)
    );
    db.put(1, list1);
    db.put(2, list2);
  }

  public static Flux<PurchaseOrder> getOrders (Integer userId) {
    return Flux.create(purchaseOrderFluxSink -> {
      db.get(userId).forEach(purchaseOrderFluxSink::next);
      purchaseOrderFluxSink.complete();
    });
  }
}
