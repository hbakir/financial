package ch.bakir.financial.core;

import static java.lang.Math.abs;

/**
 * Created by hicham on 17.11.15.
 */
public abstract class IntervalBisection {

    public abstract double computeFunction(double v);

    protected double precisionvalue;
    protected int iterations;
    protected double lowerbound;
    protected double upperbound;

    public IntervalBisection() {
        iterations = 20;
        precisionvalue = 1e-3;

    }

    public IntervalBisection(int iterations, double precisionvalue) {
        this.iterations = iterations;
        this.precisionvalue = precisionvalue;

    }

    public double getPrecisionvalue() {
        return precisionvalue;
    }

    public int getIterations() {
        return iterations;
    }

    public double evaluateRoot(double lower, double higher) {


        /**
         * initial guess value
         * */
        double fa;

        /**
         * initial guess value
         * */
        double fb;

        /**
         * function evaluation f(x)
         * */
        double fc;

        double midvalue = 0;
        double precvalue = 0;
        fa = computeFunction(lower);
        fb = computeFunction(higher);
        int i = 0;
        if (fa * fb > 0) {
            midvalue = 0;
        } else do {
            i++;
            precvalue = midvalue;
            midvalue = lower + 0.5 * (higher - lower);
            fc = computeFunction(midvalue);

            if (fa * fc < 0) {
                higher = midvalue;
            } else if (fa * fc > 0) {
                lower = midvalue;
            }
        } while ((abs(fc) > precisionvalue && i < iterations));

        return midvalue;

    }

}
