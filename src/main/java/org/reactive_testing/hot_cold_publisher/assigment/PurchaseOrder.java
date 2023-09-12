package org.reactive_testing.hot_cold_publisher.assigment;

import org.reactive_testing.util.Util;

public class PurchaseOrder {
  private final String item;
  private final String price;
  private final String category;
  private final Integer quantity;

  public PurchaseOrder() {
    this.item = Util.faker().commerce().productName();
    this.price = Util.faker().commerce().price();
    this.category = Util.faker().commerce().department();
    this.quantity = Util.faker().random().nextInt(1, 10);
  }

  public String getItem() {
    return item;
  }

  public String getPrice() {
    return price;
  }

  public String getCategory() {
    return category;
  }

  public Integer getQuantity() {
    return quantity;
  }
}
