package semester1.practice09.homework;

public class Motherboard {
    private final String model;
    private final String socketType;
    private final int maxExpansionSlots;


    public Motherboard(String model, String socketType, int maxExpansionSlots) {

        this.model = model;
        this.socketType = socketType;
        if (maxExpansionSlots >= 1 && maxExpansionSlots <= 8) {
            this.maxExpansionSlots = maxExpansionSlots;
        } else {

            this.maxExpansionSlots = 4;
        }
    }

    public String getModel() {
        return model;
    }
    public String getSocketType() {
        return socketType;
    }
    public int getMaxExpansionSlots() {
        return maxExpansionSlots;
    }

    public boolean isSocketCompatible(String cpuSocket) {
        return socketType.equalsIgnoreCase(cpuSocket);
    }
}
