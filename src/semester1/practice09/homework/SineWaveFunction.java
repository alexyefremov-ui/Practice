package semester1.practice09.homework;

public class SineWaveFunction extends AbstractFunction1D {
    private final double amplitude;
    private final double omega;
    private final double phase;

    public SineWaveFunction(String expressionName, double amplitude, double omega, double phase) {
        super(expressionName);
        this.amplitude = amplitude;
        this.omega = omega;
        this.phase = phase;
    }

    @Override
    public double evaluate(double x) {
        return amplitude * Math.sin(omega * x + phase);
    }

    @Override
    public double analyticDerivative(double x) {
        return amplitude * omega * Math.cos(omega * x + phase);
    }

    @Override
    public String toString() {
        return String.format("%s = %.2f*sin(%.2f*x + %.2f)", getExpressionName(), amplitude, omega, phase);
    }
}
