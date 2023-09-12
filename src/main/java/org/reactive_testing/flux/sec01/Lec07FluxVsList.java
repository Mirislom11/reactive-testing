package org.reactive_testing.flux.sec01;

import org.reactive_testing.util.NameGenerator;
import org.reactive_testing.util.Util;

public class Lec07FluxVsList {
    public static void main(String[] args) {
        /*List<String> names = NameGenerator.getNames(5);
        System.out.println(names);*/

        NameGenerator.getFluxNames(5)
            .subscribe(Util.subscriber("Subscriber"));

    }
}
