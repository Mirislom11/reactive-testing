package org.reactive_testing.training2.sec05;

import java.time.Duration;
import java.util.stream.Stream;
import org.reactive_testing.training2.Util;
import reactor.core.publisher.Flux;

public class Lec02HotPublisher {

  public static void main(String[] args) {
    Flux<String> movieStream =
        Flux.fromStream(Lec02HotPublisher::getMovie).delayElements(Duration.ofSeconds(2)).share();

    movieStream.subscribe(Util.subscriber("sam"));

    /*Util.sleepSeconds(5);*/

    movieStream.subscribe(Util.subscriber("mike"));
    Util.sleepSeconds(60);
  }

  private static Stream<String> getMovie() {
    System.out.println("Got the movie streaming req");
    return Stream.of(
        "Stream 1", "Stream 2", "Stream 3", "Stream 4", "Stream 5", "Stream 6", "Stream 7");
  }
}
