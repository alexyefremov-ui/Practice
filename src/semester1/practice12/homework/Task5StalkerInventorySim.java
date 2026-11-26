package semester1.practice12.homework;

import java.util.HashSet;

public class Task5StalkerInventorySim {
    public static void main(String[] args) {
        System.out.println("========== S.T.A.L.K.E.R. 2: СПОРЯДЖЕННЯ СТАЛКЕРА ==========");
        Stalker skif = new Stalker("Скіф");
        System.out.println("Сталкер: " + skif.getCallSign() + " | Максимум на поясі: 4 артефакти");

        System.out.println("\n1. Пояс артефактів (HashSet):");
        Artifact medusa = new Artifact("ART-1", "Медуза", 0.4, -2.0, 15);
        Artifact soul = new Artifact("ART-2", "Душа", 0.5, 3.5, 25);
        Artifact duplicate = new Artifact("ART-1", "Медуза", 0.4, -2.0, 15);
        Artifact compass = new Artifact("ART-3", "Компас", 0.6, 2.5, 40);
        if (skif.equipArtifact(medusa)) {
            System.out.println("  Надіто: " + medusa);
        }
        if (skif.equipArtifact(soul)) {
            System.out.println("  Надіто: " + soul);
        }
        if (!skif.equipArtifact(duplicate)) {
            System.out.println("  Дублікат " + duplicate.getName() + " (" + duplicate.getId() + ") відхилено");
        }
        if (skif.equipArtifact(compass)) {
            System.out.println("  Надіто: " + compass);
        }

        System.out.println("\n2. Ревізія рюкзака через Iterator.remove():");
        Medkit simple = new Medkit("MED-1", "Звичайна аптечка", 0.3, 1);
        Medkit army = new Medkit("MED-2", "Армійська аптечка", 0.4, 2);
        Detector empty = new Detector("DET-1", "Детектор Відгук", 0.5, 0);
        Detector veles = new Detector("DET-2", "Детектор Велес", 0.7, 85);
        skif.addToBackpack(simple);
        skif.addToBackpack(army);
        skif.addToBackpack(empty);
        skif.addToBackpack(veles);
        simple.use(); // Аптечка стала порожньою.
        int removed = skif.cleanBackpack();
        System.out.println("  Викинуто: " + removed + " | Залишилося: " + skif.getBackpackCopy().size());

        System.out.println("\n3. Стан спорядження:");
        System.out.println("  Пояс: " + skif.getArtifactBeltCopy().size() + " артефакти");
        System.out.println("  Рюкзак: " + skif.getBackpackCopy());
        System.out.printf("  Захист: %d%% | Радіація: %+.2f мЗв/хв | Вага: %.2f кг%n",
                skif.getTotalProtection(), skif.getNetRadiation(), skif.getTotalWeightKg());

        skif.visitLocation("Залісся");
        skif.visitLocation("Кордон");
        skif.visitLocation("Звалище");
        skif.visitLocation("Янтар");
        HashSet<String> allyLocations = new HashSet<>();
        allyLocations.add("Залісся");
        allyLocations.add("Янтар");
        allyLocations.add("Росток");
        allyLocations.add("Прип'ять");

        System.out.println("\n4. Синхронізація КПК (HashSet):");
        System.out.println("  Локації Скіфа: " + skif.getVisitedLocationsCopy());
        System.out.println("  Локації союзника: " + allyLocations);
        System.out.println("  Спільні (A та B): " + skif.getCommonLocations(allyLocations));
        System.out.println("  Нові (B \\ A): " + skif.getNewLocationsFromAlly(allyLocations));
    }
}
