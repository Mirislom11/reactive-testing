package org.reactive_testing;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.reactive_testing.util.Util;

public class Lec09FileReaderServiceAssigment {

  public static void main(String[] args) {
    FileReaderService fileReaderService = new FileReaderService();
    Path path = Paths.get("src/main/resources/file01.txt");
    fileReaderService.read(path)
        .subscribe(Util.subscriber("Subscriber"));
  }

}
