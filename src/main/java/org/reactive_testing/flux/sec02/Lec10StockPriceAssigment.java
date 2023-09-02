package org.reactive_testing.flux.sec02;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import org.reactive_testing.mono.sec01.StockPricePublisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Lec10StockPriceAssigment {

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(1);

    StockPricePublisher.getPrice()
        .subscribeWith(new Subscriber<Integer>() {
          private Subscription subscription;

          @Override
          public void onSubscribe(Subscription subscription) {
            this.subscription = subscription;
            subscription.request(Long.MAX_VALUE);
          }

          @Override
          public void onNext(Integer integer) {
            System.out.println(LocalDateTime.now() + " : price: "+ integer);
            if (integer > 110 || integer < 90){
              this.subscription.cancel();
              latch.countDown();
            }
          }

          @Override
          public void onError(Throwable throwable) {
            latch.countDown();
          }

          @Override
          public void onComplete() {
            System.out.println("Completed");
            latch.countDown();
          }
        });
    latch.await();
  }
}
