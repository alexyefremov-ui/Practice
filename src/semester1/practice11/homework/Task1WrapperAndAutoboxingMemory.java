package semester1.practice11.homework;

import java.util.ArrayList;
import java.util.List;

public class Task1WrapperAndAutoboxingMemory {
    public static void inspectIntegerCache(int[] testValues) {
        System.out.println("[1. INTEGER CACHE: == та equals()]:");
        for (int i = 0; i < testValues.length; i++) {
            int value = testValues[i];
            Integer first = Integer.valueOf(value);
            Integer second = Integer.valueOf(value);
            String cache = value >= -128 && value <= 127
                    ? "стандартний IntegerCache" : "поза гарантованим кешем";
            System.out.println(String.format("  Число %5d | == %5b | equals() %5b | %s",
                    value, first == second, first.equals(second), cache));
        }
    }

    public static void demonstrateAutoboxingUnderTheHood() {
        System.out.println("\n[2. AUTOBOXING, UNBOXING ТА NULL]:");

        Integer integerAuto = 42;
        Integer integerManual = Integer.valueOf(42);
        int integerValue = integerAuto;
        int integerExplicit = integerManual.intValue();
        System.out.println("  Integer: автоматично " + integerValue
                + ", явно через valueOf/intValue " + integerExplicit);

        Double doubleAuto = 12.5;
        Double doubleManual = Double.valueOf(12.5);
        double doubleValue = doubleAuto;
        double doubleExplicit = doubleManual.doubleValue();
        System.out.println("  Double: автоматично " + doubleValue
                + ", явно через valueOf/doubleValue " + doubleExplicit);

        Boolean booleanAuto = true;
        Boolean booleanManual = Boolean.valueOf(true);
        boolean booleanValue = booleanAuto;
        boolean booleanExplicit = booleanManual.booleanValue();
        System.out.println("  Boolean: автоматично " + booleanValue
                + ", явно через valueOf/booleanValue " + booleanExplicit);

        Character characterAuto = 'A';
        Character characterManual = Character.valueOf('A');
        char characterValue = characterAuto;
        char characterExplicit = characterManual.charValue();
        System.out.println("  Character: автоматично " + characterValue
                + ", явно через valueOf/charValue " + characterExplicit);

        List<Integer> sensorData = new ArrayList<>();
        sensorData.add(45);
        sensorData.add(null);
        sensorData.add(-12);
        sensorData.add(88);
        sensorData.add(null);
        sensorData.add(102);
        System.out.println("  Дані датчиків: " + sensorData);

        int sum = 0;
        for (int i = 0; i < sensorData.size(); i++) {
            Integer value = sensorData.get(i);
            if (value == null) {
                System.out.println("  Пропущено null за індексом " + i);
            } else {
                sum = sum + value.intValue();
            }
        }
        System.out.println("  Сума коректних чисел: " + sum);
    }

    public static List<Integer> parseTelemetryStream(String[] rawPackets) {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < rawPackets.length; i++) {
            String packet = rawPackets[i];
            if (packet == null || packet.trim().isEmpty()) {
                System.out.println("  Порожній або null-пакет пропущено");
                continue;
            }
            try {
                int number = Integer.parseInt(packet.trim());
                data.add(number);
            } catch (NumberFormatException e) {
                System.out.println("  Пакет '" + packet + "' відхилено (NumberFormatException)");
            }
        }
        return data;
    }

    public static void printExtremesAndStats(List<Integer> validData) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0;
        System.out.println("  Початкові межі: min = " + min + ", max = " + max);

        for (int i = 0; i < validData.size(); i++) {
            int number = validData.get(i);
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
            sum = sum + number;
        }
        System.out.println("  Розпізнані значення: " + validData);
        if (validData.isEmpty()) {
            System.out.println("  Немає чисел для визначення мінімуму та максимуму.");
        } else {
            System.out.println("  Мінімум: " + min + " | Максимум: " + max + " | Сума: " + sum);
        }

        List<Integer> byIndex = new ArrayList<>(validData);
        List<Integer> byValue = new ArrayList<>(validData);
        if (!byIndex.isEmpty()) {
            byIndex.remove(0);
            System.out.println("  Після remove(0) за індексом: " + byIndex);
        }
        byValue.remove(Integer.valueOf(-30));
        System.out.println("  Після remove(Integer.valueOf(-30)) за значенням: " + byValue);
    }

    public static void main(String[] args) {
        System.out.println("========== WRAPPER CLASSES ТА INTEGER CACHE ==========");
        int[] testValues = {-128, -50, 0, 127, 128, 500, 2026};
        inspectIntegerCache(testValues);
        demonstrateAutoboxingUnderTheHood();

        System.out.println("\n[3. ПАРСИНГ ТЕЛЕМЕТРІЇ ТА ЕКСТРЕМУМИ]:");
        String[] rawPackets = {"  145 ", "-30", "ERR_404", "980", "", null, "2147483647", "-85"};
        List<Integer> validData = parseTelemetryStream(rawPackets);
        printExtremesAndStats(validData);
    }
}
