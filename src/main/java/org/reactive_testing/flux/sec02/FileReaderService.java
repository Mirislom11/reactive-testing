package org.reactive_testing.flux.sec02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

public class FileReaderService {

  private Callable<BufferedReader> openReader(Path path) {
    return () -> Files.newBufferedReader(path);
  }

  private BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> read() {
    return ((bufferedReader, stringSynchronousSink) -> {
      try {
        String line = bufferedReader.readLine();
        if (Objects.isNull(line)) {
          stringSynchronousSink.complete();
        } else {
          stringSynchronousSink.next(line);
        }
      } catch (IOException e) {
        stringSynchronousSink.error(e);
      }
      return bufferedReader;
    });
  }

  private Consumer<BufferedReader> closedReader() {
    return bufferedReader -> {
      try {
        bufferedReader.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    };
  }

  public Flux<String> read(Path path) {
    return Flux.generate(
        openReader(path),
        read(),
        closedReader()
    );
  }
}
