package semester1.practice09.homework;

public class Task2WorkstationConfigurator {
    public static void main(String[] args) {
        System.out.println("================ КОНФІГУРАТОР РОБОЧОЇ СТАНЦІЇ ================");
        Motherboard motherboard = new Motherboard("ASUS ROG B650", "AM5", 4);
        PowerSupplyUnit psu = new PowerSupplyUnit("Seasonic 750W Gold", 750, 0.90);
        WorkstationPC pc = new WorkstationPC("DeepLearning-Rig", motherboard, psu);

        System.out.println("[ПЕРЕВІРКА СУМІСНОСТІ]:");
        pc.installCpu(new ProcessorUnit("Intel Core i9", 20000, "LGA1700", 24, 5.5, 253));
        pc.installCpu(new ProcessorUnit("AMD Ryzen 9 7950X", 20000, "AM5", 16, 5.7, 170));
        pc.installComponent(new GraphicsAccelerator("Дуже потужна GPU", 60000, 32, 500, 800));
        pc.installComponent(new GraphicsAccelerator("NVIDIA RTX 4080 Super", 50000, 16, 552, 320));

        int[] samples = {7400, 7450, 7420};
        NvmeSsdDrive ssd = new NvmeSsdDrive("Samsung 990 Pro 2TB", 8900, 2000, 7450, samples);
        samples[0] = 1;
        int[] copiedSamples = ssd.getSpeedSamples();
        copiedSamples[1] = 1;
        System.out.println("Захисне копіювання SSD: перший тест = " + ssd.getSpeedSamples()[0] + ", другий тест = " + ssd.getSpeedSamples()[1]);
        pc.installComponent(ssd);

        System.out.println();
        System.out.print(pc);
        System.out.println("================================================================");
    }
}
