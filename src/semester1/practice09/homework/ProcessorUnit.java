package semester1.practice09.homework;

public class ProcessorUnit extends AbstractHardwareComponent {
    private final String socket;
    private final int cores;
    private final double boostClockGhz;
    private final int tdpWatts;

    public ProcessorUnit(String modelName, double priceUah, String socket, int cores, double boostClockGhz, int tdpWatts) {
        super(modelName, priceUah);
        this.socket = socket;
        this.cores = (cores > 0) ? cores : 1;
        this.boostClockGhz = (boostClockGhz > 0) ? boostClockGhz : 1;
        this.tdpWatts = (tdpWatts > 0) ? tdpWatts : 1;
    }

    public String getSocket() {
        return socket;
    }

    @Override
    public int getPowerWatts() {
        return tdpWatts;
    }
    @Override
    public double getBenchmarkScore() {
        return cores * boostClockGhz * 120.0;
    }
    @Override
    public String getCategory() {
        return "CPU";
    }
}
