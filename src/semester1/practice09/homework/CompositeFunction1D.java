package semester1.practice09.homework;

public class CompositeFunction1D extends AbstractFunction1D {
    private final AbstractFunction1D outer;
    private final AbstractFunction1D inner;

    public CompositeFunction1D(AbstractFunction1D outer, AbstractFunction1D inner) {
        super("(" + outer.getExpressionName() + " ∘ " + inner.getExpressionName() + ")");

        this.outer = outer;
        this.inner = inner;
    }

    @Override
    public double evaluate(double x) {
        return outer.evaluate(inner.evaluate(x));
    }

    @Override
    public double analyticDerivative(double x) {
        return outer.analyticDerivative(inner.evaluate(x)) * inner.analyticDerivative(x);
    }
}
