package ch.bakir.financial.core;

import static java.lang.Math.E;
import static java.lang.Math.pow;

/**
 * Created by hicham on 17.11.15.
 */
public class Main {
    public static void main(String args[]) {
        IntervalBisection example = new IntervalBisection(20, 1e-4) {
            @Override
            public double computeFunction(double x) {
                return 2 - pow(E, x);
            }
        };

        System.out.println(example.evaluateRoot(0.5, 1.0));
    }
}
