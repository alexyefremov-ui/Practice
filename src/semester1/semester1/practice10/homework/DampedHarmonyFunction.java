package semester1.semester1.practice10.homework;

public class DampedHarmonyFunction extends AbstractMathFunction implements NewtonRootFindable {
    private final double amplitude;
    private final double decayRate;
    private final double omega;

    public DampedHarmonyFunction(double amplitude, double decayRate, double omega) {
        super(String.format("D(x) = %.2f * exp(-%.2f*x) * cos(%.2f*x)",
                amplitude, decayRate, omega));
        this.amplitude = amplitude;
        this.decayRate = decayRate;
        this.omega = omega;
    }

    @Override
    public double evaluate(double x) {
        return amplitude * Math.exp(-decayRate * x) * Math.cos(omega * x);
    }

    @Override
    public double derivative(double x) {
        return -amplitude * Math.exp(-decayRate * x) *
                (decayRate * Math.cos(omega * x) + omega * Math.sin(omega * x));
    }
}
