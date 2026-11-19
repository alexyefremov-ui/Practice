package semester1.practice11.homework;

import java.util.ArrayList;

public class Task2ArrayListCapacityAndDynamicGrowth {
    public static void main(String[] args) {
        System.out.println("========== ЕМУЛЯТОР ARRAYLIST ТА ЙОГО ЄМНОСТІ ==========");
        var emulator = new CustomArrayCapacityEmulator<String>();
        // Правильно: тип String явно зазначений при створенні об'єкта.
        var typedList = new ArrayList<String>();
        // Небезпечно: var raw = new ArrayList<>(); -- тут виводиться Object.
        typedList.add("приклад");

        System.out.println("Початковий розмір: " + emulator.size()
                + " | Ємність: " + emulator.getCapacity());
        System.out.println("\n[1. ДОДАВАННЯ 35 ЕЛЕМЕНТІВ]:");
        for (int i = 1; i <= 35; i++) {
            int oldCapacity = emulator.getCapacity();
            emulator.add("Block-" + i);
            if (emulator.getCapacity() > oldCapacity) {
                System.out.println("  Розширення #" + emulator.getResizeCount() + ": "
                        + oldCapacity + " -> " + emulator.getCapacity()
                        + " (скопійовано " + oldCapacity + " елементів)");
            }
        }
        System.out.println("  Після додавання: size = " + emulator.size()
                + " | capacity = " + emulator.getCapacity());

        System.out.println("\n[2. ВСТАВКА ТА ВИДАЛЕННЯ]:");
        emulator.add(0, "HEADER");
        System.out.println("  Додано HEADER на початок. Перший: " + emulator.get(0));
        String deleted = emulator.remove(5);
        System.out.println("  Видалено з індексу 5: " + deleted);
        System.out.println("  Перший: " + emulator.get(0)
                + " | Останній: " + emulator.get(emulator.size() - 1));
        System.out.println("  size = " + emulator.size() + " | capacity = " + emulator.getCapacity());

        System.out.println("\n[3. TRIM TO SIZE]:");
        int before = emulator.getCapacity();
        emulator.trimToSize();
        System.out.println("  Ємність до/після: " + before + " -> " + emulator.getCapacity());
        System.out.println("  Розширень: " + emulator.getResizeCount()
                + " | Скопійовано при розширеннях: " + emulator.getTotalElementsCopied());
    }
}
