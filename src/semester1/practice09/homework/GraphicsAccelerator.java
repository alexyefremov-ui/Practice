package semester1.practice09.homework;

public class GraphicsAccelerator extends AbstractHardwareComponent {

    private final int vramGb;
    private final int tensorCores;
    private final int boardPowerWatts;

    public GraphicsAccelerator(String modelName, double priceUah, int vramGb,
                               int tensorCores, int boardPowerWatts) {
        super(modelName, priceUah);
        this.vramGb = (vramGb > 0) ? vramGb : 1;
        this.tensorCores = (tensorCores >= 0) ? tensorCores : 0;
        this.boardPowerWatts = (boardPowerWatts > 0) ? boardPowerWatts : 1;
    }

    @Override public int getPowerWatts() {
        return boardPowerWatts;
    }

    @Override public double getBenchmarkScore() {
        return vramGb * 250.0 + tensorCores * 1.5;
    }

    @Override public String getCategory() {
        return "GPU";
    }
}
