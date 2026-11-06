package semester1.practice09.homework;

public class Task5CyberpunkRipperdocSim {
    public static void main(String[] args) {
        System.out.println("================ CYBERPUNK 2077: КЛІНІКА РІППЕРДОКА ================");
        CyberMercenary david = new CyberMercenary("Девід Мартінес", 120, 1000);
        System.out.println("Пацієнт: Девід Мартінес");
        System.out.println(david);

        System.out.println("[ВСТАНОВЛЕННЯ ІМПЛАНТІВ]:");
        david.installImplant(new SandevistanOs());
        david.installImplant(new MantisBlades());
        david.installImplant(new SandevistanOs());
        david.installImplant(new SubdermalTitaniumArmor());
        david.installImplant(new KiroshiOptics());

        System.out.println("\n[ДОСЬЄ НАЙМАНЦЯ ПЕРЕД БОЄМ]:");
        System.out.println(david);

        System.out.println("--- БІЙ ПРОТИ АДАМА СМЕШЕРА ---");
        int enemyHp = 1000;
        int enemyArmor = 80;
        david.triggerFullOverdrive();

        for (int round = 1; round <= 4 && enemyHp > 0 && david.getHp() > 0; round++) {

            System.out.println("\nРаунд " + round + ":");
            int attackDamage = Math.max(5, david.getTotalAttack() - enemyArmor);
            enemyHp = Math.max(0, enemyHp - attackDamage);
            System.out.println("Девід атакує: " + attackDamage + " шкоди. HP Адама Смешера: " + enemyHp);

            if (enemyHp > 0) {
                int receivedDamage = david.receiveDamage(150);
                System.out.println("Адам Смешер атакує: " + receivedDamage + " шкоди. HP Девіда: " + david.getHp());
            }

            int overload = david.endTurn();
            if (overload > 0) {
                System.out.println("Перевантаження нервової системи: -" + overload + " HP!");
            }
            if (round == 1) {
                david.useImmunoblockers(30);
            }
        }

        if (enemyHp == 0) {
            System.out.println("\nПЕРЕМОГА! Адам Смешер переможений!");
        } else {

            System.out.println("\nБій завершено. HP Адама Смешера: " + enemyHp);
        }

        System.out.println("Фінальний стан Девіда: HP=" + david.getHp() + ", Людяність=" + david.getHumanity() + ", Кіберпсихоз=" + david.isCyberpsychosis());
        System.out.println("====================================================================");
    }
}
