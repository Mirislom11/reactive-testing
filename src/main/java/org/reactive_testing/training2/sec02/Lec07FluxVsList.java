package org.reactive_testing.training2.sec02;

import java.util.List;
import org.reactive_testing.training2.Util;
import org.reactive_testing.training2.sec02.helper.NameGenerator;

public class Lec07FluxVsList {
  public static void main(String[] args){
    /*List<String> names = NameGenerator.getNames(5);
    System.out.println(names);
    Util.sleepSeconds(6);*/

    NameGenerator.getFluxNames(5)
        .subscribe(Util.onNext());
  }
}
