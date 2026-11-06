package semester1.practice09.homework;

public class MatrixPipeline {
    private final String pipelineName;
    private final AbstractMatrixOperator[] stages;
    private int stageCount;

    public MatrixPipeline(String pipelineName, int capacity) {
        this.pipelineName = pipelineName;
        this.stages = new AbstractMatrixOperator[(capacity > 0) ? capacity : 1];
        this.stageCount = 0;

    }

    public void addStage(AbstractMatrixOperator op) {
        if (op != null && stageCount < stages.length) {
            stages[stageCount] = op;
            stageCount++;
        } else {
            System.out.println("Не вдалося додати етап конвеєра!");
        }
    }

    public EncapsulatedMatrix runPipeline(EncapsulatedMatrix initial) {
        if (initial == null) {
            System.out.println("Помилка: вхідна матриця відсутня!");
            return null;

        }

        System.out.println("Конвеєр: " + pipelineName);
        System.out.println("[ВХІДНА МАТРИЦЯ X0]:");
        System.out.print(initial);
        EncapsulatedMatrix current = initial;

        for (int i = 0; i < stageCount; i++) {

            boolean canApply = stages[i].isApplicable(current);
            current = stages[i].executeSafely(current);
            if (canApply) {
                System.out.println("---> Етап " + (i + 1) + ": '"
                        + stages[i].getOperatorName() + "' виконано успішно:");
            } else {

                System.out.println("---> Етап " + (i + 1) + ": пропущено");
            }

            System.out.print(current);


        }
        return current;
    }
}
