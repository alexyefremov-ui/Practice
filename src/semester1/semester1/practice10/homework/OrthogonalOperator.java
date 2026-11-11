package semester1.semester1.practice10.homework;

public interface OrthogonalOperator extends InvertibleOperator {
    default boolean verifyNormInvariance(ImmutableMatrix2D before, ImmutableMatrix2D after) {
        return Math.abs(before.getFrobeniusNorm() - after.getFrobeniusNorm()) < 1e-6;
    }
}
