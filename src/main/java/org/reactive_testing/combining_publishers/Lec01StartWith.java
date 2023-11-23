package org.reactive_testing.combining_publishers;

import org.reactive_testing.util.NameGenerator;
import org.reactive_testing.util.Util;

public class Lec01StartWith {

  public static void main(String[] args) {
    NameGenerator.generateNames()
        .take(2)
        .subscribe(Util.subscriber("Subscriber 1"));

    NameGenerator.generateNames()
        .take(2)
        .subscribe(Util.subscriber("Subscriber 2"));

  }
}
