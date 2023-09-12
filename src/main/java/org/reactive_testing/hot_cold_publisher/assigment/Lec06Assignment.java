package org.reactive_testing.hot_cold_publisher.assigment;

import org.reactive_testing.util.Util;

public class Lec06Assignment {

  public static void main(String[] args) {
    OrderService orderService = new OrderService();
    RevenueService revenueService = new RevenueService();
    InventoryService inventoryService = new InventoryService();

    orderService.orderStream().subscribe(revenueService.subscribeOrderStream());
    orderService.orderStream().subscribe(inventoryService.subscribeInventoryStream());

    inventoryService.inventoryStream()
        .subscribe(Util.subscriber("inventory"));

    revenueService.revenueStream()
        .subscribe(Util.subscriber("revenue"));

    Util.sleepSeconds(60);
  }
}
