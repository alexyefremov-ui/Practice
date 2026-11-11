package semester1.semester1.practice10.homework;

public abstract class AbstractMathFunction implements Integrable1D {
    private final String formulaTitle;

    public AbstractMathFunction(String formulaTitle) {
        this.formulaTitle = formulaTitle;
    }

    public final String getFormulaTitle() {
        return formulaTitle;
    }
}
