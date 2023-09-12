package org.reactive_testing.hot_cold_publisher;

import java.time.Duration;
import java.util.stream.Stream;
import org.reactive_testing.util.Util;
import reactor.core.publisher.Flux;

public class Lec05PublisherCache {

  public static void main(String[] args) {
    Flux<String> movieStream = Flux.fromStream(Lec05PublisherCache::getMovie)
        .delayElements(Duration.ofSeconds(1))
        .cache();

    Util.sleepSeconds(3);
    movieStream
        .subscribe(Util.subscriber("mike"));

    Util.sleepSeconds(10);

    movieStream
        .subscribe(Util.subscriber("sam"));

    Util.sleepSeconds(60);
  }

  private static Stream<String> getMovie() {
    System.out.println("Got the movie streaming request");
    return Stream.of(
        "Scene 1",
        "Scene 2",
        "Scene 3",
        "Scene 4",
        "Scene 5",
        "Scene 6",
        "Scene 7",
        "Scene 8"
    );
  }
}
