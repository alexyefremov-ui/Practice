package semester1.practice09.homework;

public class WorkstationPC {
    private final String buildName;
    private final Motherboard motherboard;
    private final PowerSupplyUnit psu;
    private final AbstractHardwareComponent[] components;
    private int componentCount;

    public WorkstationPC(String buildName, Motherboard motherboard, PowerSupplyUnit psu) {
        this.buildName = buildName;
        this.motherboard = motherboard;
        this.psu = psu;
        this.components = new AbstractHardwareComponent[motherboard.getMaxExpansionSlots()];
        this.componentCount = 0;
    }

    public boolean installCpu(ProcessorUnit cpu) {
        if (cpu == null) {
            return false;
        }
        if (!motherboard.isSocketCompatible(cpu.getSocket())) {
            System.out.println("Відмова: Процесор " + cpu.getModelName() + " (" + cpu.getSocket()
                    + ") несумісний із платою " + motherboard.getModel()
                    + " (Сокет " + motherboard.getSocketType() + ")!");
            return false;
        }
        for (int i = 0; i < componentCount; i++) {
            if (components[i].getCategory().equals("CPU")) {
                System.out.println("Відмова: Процесор вже встановлено!");
                return false;
            }
        }
        if (componentCount >= components.length) {
            System.out.println("Відмова: Немає вільних слотів!");
            return false;
        }
        if (getTotalPowerWatts() + cpu.getPowerWatts() > psu.getSafeContinuousWatts()) {
            System.out.println("Відмова: Потужність перевищує безпечний ліміт БЖ!");
            return false;
        }
        components[componentCount] = cpu;
        componentCount++;
        System.out.println("Встановлено: " + cpu);
        return true;
    }

    public boolean installComponent(AbstractHardwareComponent comp) {
        if (comp == null) {
            return false;
        }


        if (comp.getCategory().equals("CPU")) {
            System.out.println("Відмова: Процесор потрібно встановлювати через installCpu!");
            return false;
        }

        if (componentCount >= components.length) {
            System.out.println("Відмова: Немає вільних слотів!");
            return false;
        }

        if (getTotalPowerWatts() + comp.getPowerWatts() > psu.getSafeContinuousWatts()) {
            System.out.println("Відмова: " + comp.getModelName() + " перевищує безпечний ліміт БЖ!");
            return false;
        }

        components[componentCount] = comp;
        componentCount++;
        System.out.println("Встановлено: " + comp);
        return true;

    }

    public int getTotalPowerWatts() {

        int total = 0;
        for (int i = 0; i < componentCount; i++) {
            total += components[i].getPowerWatts();
        }
        return total;
    }

    public double getTotalSystemScore() {
        double total = 0;
        for (int i = 0; i < componentCount; i++) {
            total += components[i].getBenchmarkScore();
        }

        return total;
    }

    public double getTotalBuildPrice() {
        double total = 0;
        for (int i = 0; i < componentCount; i++) {
            total += components[i].getPriceUah();
        }

        return total;
    }

    @Override
    public String toString() {
        String result = "[ПАСПОРТ ЗБІРКИ '" + buildName + "']:\n";
        result += String.format("  Материнська плата: %s (Socket: %s, Слотів: %d/%d)\n",
                motherboard.getModel(), motherboard.getSocketType(),
                componentCount, motherboard.getMaxExpansionSlots());
        result += String.format("  Блок живлення: %s (Безпечний ліміт: %d Вт, ККД: %.0f%%)\n",
                psu.getModel(), psu.getSafeContinuousWatts(), psu.getEfficiencyCoefficient() * 100);
        result += String.format("  Внутрішнє споживання: %d Вт (З розетки: %.2f Вт)\n",
                getTotalPowerWatts(), psu.calculateWallPowerDraw(getTotalPowerWatts()));
        result += String.format("  Сумарний індекс продуктивності: %.2f балів\n", getTotalSystemScore());
        result += String.format("  Загальна вартість комплектуючих: %.2f грн\n", getTotalBuildPrice());

        return result;
    }
}
