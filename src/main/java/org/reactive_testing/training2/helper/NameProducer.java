package org.reactive_testing.training2.helper;

import java.util.function.Consumer;
import org.reactive_testing.training2.Util;
import reactor.core.publisher.FluxSink;

public class NameProducer implements Consumer<FluxSink<String>> {
  private FluxSink<String> fluxSink;
  @Override
  public void accept(FluxSink<String> stringFluxSink) {
    this.fluxSink = stringFluxSink;
  }

  public void produce () {
    String name = Util.faker().name().fullName();
    String thread = Thread.currentThread().getName();
    this.fluxSink.next(thread + " : " + name);
  }
}
