package org.reactive_testing.operators.helper;

import lombok.Data;
import lombok.ToString;
import org.reactive_testing.util.Util;

@Data
@ToString
public class PurchaseOrder {
  private String item;
  private String price;
  private Integer userId;

  public PurchaseOrder(Integer userId) {
    this.item = Util.faker().commerce().productName();
    this.userId = userId;
    this.price = Util.faker().commerce().price();
  }
}

