package semester1.practice11.homework;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class Task5StalkerBackpackAndSidorovichLoot {
    public static final double MAX_SAFE_RADIATION = 50.0;

    public static double getTotalRadiation(List<Artifact> backpack) {
        double total = 0;
        for (int i = 0; i < backpack.size(); i++) {
            total = total + backpack.get(i).getRadiationLevel();
        }
        return total;
    }

    public static void printBackpack(List<Artifact> backpack) {
        for (int i = 0; i < backpack.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + backpack.get(i));
        }
    }

    public static void demonstrateFailFastOnBackpack(List<Artifact> backpack) {
        // Використовуємо копію, щоб не пошкодити основний рюкзак.
        List<Artifact> copy = new ArrayList<>(backpack);
        try {
            for (Artifact artifact : copy) {
                if (artifact.isRadioactiveDud(MAX_SAFE_RADIATION)) {
                    copy.remove(artifact); // Навмисна помилка для демонстрації.
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("  Перехоплено ConcurrentModificationException: "
                    + "видаляти напряму під час for-each не можна!");
        }
    }

    public static int purgeRadioactiveDudsWithIterator(List<Artifact> backpack,
                                                         double maxSafeRadiation) {
        Iterator<Artifact> iterator = backpack.iterator();
        int removedDuds = 0;
        while (iterator.hasNext()) {
            Artifact current = iterator.next();
            if (current.isRadioactiveDud(maxSafeRadiation)) {
                System.out.println("  Вилучено: " + current.getName()
                        + " (радіація " + current.getRadiationLevel()
                        + ", ціна " + current.getCostKarbovanets() + ")");
                iterator.remove();
                removedDuds++;
            }
        }
        return removedDuds;
    }

    public static void distributeAndRankForSidorovich(List<Artifact> cleanLoot,
                                                        List<Artifact> leadSpecialContainer,
                                                        List<Artifact> standardBeltContainer) {
        // Впорядкування за ціною від найбільшої до найменшої через get та set.
        for (int i = 0; i < cleanLoot.size() - 1; i++) {
            int mostExpensiveIndex = i;
            for (int j = i + 1; j < cleanLoot.size(); j++) {
                if (cleanLoot.get(j).getCostKarbovanets()
                        > cleanLoot.get(mostExpensiveIndex).getCostKarbovanets()) {
                    mostExpensiveIndex = j;
                }
            }
            Artifact temp = cleanLoot.get(i);
            cleanLoot.set(i, cleanLoot.get(mostExpensiveIndex));
            cleanLoot.set(mostExpensiveIndex, temp);
        }

        for (int i = 0; i < cleanLoot.size(); i++) {
            Artifact artifact = cleanLoot.get(i);
            if (artifact.getCostKarbovanets() >= 15000) {
                leadSpecialContainer.add(artifact);
            } else {
                standardBeltContainer.add(artifact);
            }
        }
    }

    public static void findTopArtifactAndPrintReceipt(List<Artifact> cleanLoot) {
        int maxCost = Integer.MIN_VALUE;
        Artifact mostExpensive = null;
        int totalCost = 0;
        System.out.println("\n[4. ЧЕК СИДОРОВИЧА]:");
        for (int i = 0; i < cleanLoot.size(); i++) {
            Artifact artifact = cleanLoot.get(i);
            System.out.println("  #" + (i + 1) + " " + artifact);
            totalCost = totalCost + artifact.getCostKarbovanets();
            if (artifact.getCostKarbovanets() > maxCost) {
                maxCost = artifact.getCostKarbovanets();
                mostExpensive = artifact;
            }
        }
        if (mostExpensive != null) {
            System.out.println("  Найдорожчий: " + mostExpensive.getName()
                    + " (" + maxCost + " крб)");
        }
        System.out.println("  Загальна вартість: " + totalCost + " крб");
        System.out.println("  Сидорович: Ось твої " + totalCost + " карбованців, Скіфе!");
    }

    public static void main(String[] args) {
        System.out.println("========== S.T.A.L.K.E.R. 2: РЮКЗАК СКІФА ==========");
        System.out.println("Норма радіації одного артефакту: не вище "
                + MAX_SAFE_RADIATION + " мкЗв/год");

        var backpack = new ArrayList<Artifact>();
        backpack.add(new Artifact("Бенгальський вогонь", 9500, 14.5));
        backpack.add(new Artifact("Фоняча Пустушка", 0, 92.0));
        backpack.add(new Artifact("Крівник", 18500, 26.0));
        backpack.add(new Artifact("Аномальний Шлак", 1200, 135.4));
        backpack.add(new Artifact("Виверт", 11000, 18.0));
        backpack.add(new Artifact("Іржава Пустушка", 500, 78.5));
        backpack.add(new Artifact("Компас", 45000, 32.0));

        System.out.println("\n[1. РЮКЗАК ДО ОЧИЩЕННЯ]:");
        printBackpack(backpack);
        System.out.println("  Кількість: " + backpack.size());
        System.out.println(String.format("  Сума радіаційних показників: %.1f", getTotalRadiation(backpack)));

        System.out.println("\n[2. НЕБЕЗПЕКА FOR-EACH + REMOVE]:");
        demonstrateFailFastOnBackpack(backpack);

        System.out.println("\n[3. ОЧИЩЕННЯ ЧЕРЕЗ ITERATOR.REMOVE]:");
        int removed = purgeRadioactiveDudsWithIterator(backpack, MAX_SAFE_RADIATION);
        System.out.println("  Вилучено: " + removed + " | Залишилося: " + backpack.size());
        System.out.println(String.format("  Сума радіаційних показників після чистки: %.1f",
                getTotalRadiation(backpack)));

        List<Artifact> leadSpecialContainer = new ArrayList<>();
        List<Artifact> standardBeltContainer = new ArrayList<>();
        distributeAndRankForSidorovich(backpack, leadSpecialContainer, standardBeltContainer);
        System.out.println("\n  Свинцевий контейнер (від 15000 крб): " + leadSpecialContainer);
        System.out.println("  Стандартний контейнер (до 15000 крб): " + standardBeltContainer);

        findTopArtifactAndPrintReceipt(backpack);
    }
}
