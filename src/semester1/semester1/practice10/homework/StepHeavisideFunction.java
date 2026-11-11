package semester1.semester1.practice10.homework;

public class StepHeavisideFunction extends AbstractMathFunction {
    private final double threshold;
    private final double lowValue;
    private final double highValue;

    public StepHeavisideFunction(double threshold, double lowValue, double highValue) {
        super(String.format("Step(x) = %.1f при x < %.1f; %.1f при x >= %.1f",
                lowValue, threshold, highValue, threshold));
        this.threshold = threshold;
        this.lowValue = lowValue;
        this.highValue = highValue;
    }

    @Override
    public double evaluate(double x) {
        if (x < threshold) {
            return lowValue;
        }
        return highValue;
    }
}
