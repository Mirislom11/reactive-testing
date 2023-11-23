package org.reactive_testing.training2.helper;

import lombok.Data;
import lombok.ToString;
import org.reactive_testing.training2.Util;

@ToString
@Data
public class PurchaseOrder {
  private String item;
  private String price;
  private Integer userId;

  public PurchaseOrder(Integer userId) {
    this.item = Util.faker().commerce().productName();
    this.price = Util.faker().commerce().price();
    this.userId = userId;
  }
}
