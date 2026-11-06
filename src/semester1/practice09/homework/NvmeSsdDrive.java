package semester1.practice09.homework;

public class NvmeSsdDrive extends AbstractHardwareComponent {
    private final int capacityGb;
    private final int readSpeedMbSec;
    private final int[] speedSamples;

    public NvmeSsdDrive(String modelName, double priceUah, int capacityGb,
                        int readSpeedMbSec, int[] speedSamples) {
        super(modelName, priceUah);
        this.capacityGb = (capacityGb > 0) ? capacityGb : 1;
        this.readSpeedMbSec = (readSpeedMbSec > 0) ? readSpeedMbSec : 1;
        if (speedSamples == null) {
            this.speedSamples = new int[0];

        } else {
            this.speedSamples = new int[speedSamples.length];
            for (int i = 0; i < speedSamples.length; i++) {
                this.speedSamples[i] = speedSamples[i];

            }
        }
    }

    public int[] getSpeedSamples() {
        int[] copy = new int[speedSamples.length];
        for (int i = 0; i < speedSamples.length; i++) {
            copy[i] = speedSamples[i];
        }
        return copy;
    }

    @Override public int getPowerWatts() {
        return 12;
    }

    @Override public double getBenchmarkScore() {
        return readSpeedMbSec * 0.25;
    }

    @Override public String getCategory() {
        return "NVMe SSD";
    }
}
