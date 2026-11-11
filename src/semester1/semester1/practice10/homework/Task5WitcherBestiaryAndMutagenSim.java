package semester1.semester1.practice10.homework;

public class Task5WitcherBestiaryAndMutagenSim {
    public static void main(String[] args) {
        WitcherHunter geralt = new WitcherHunter("Школа Вовка", 220, 150);
        AbstractMonster[] contracts = {
                new RoyalGriffin(),
                new Noonwraith(),
                new HigherVampire(),
                new AncientLeshen()
        };

        System.out.println("========== ВІДЬМАК 3: БЕСТІАРІЙ ТА ПОЛЮВАННЯ ==========");
        System.out.println("Мисливець: " + geralt.getDescription());
        for (int i = 0; i < contracts.length; i++) {
            AbstractMonster monster = contracts[i];
            System.out.println("\nКонтракт №" + (i + 1) + ": " + monster);
            System.out.println("  " + monster.getBattleCry());
            System.out.println("  Сила атаки монстра: " + monster.calculateMonsterAttack());
            int damage = geralt.executeSilverStrike(monster);
            System.out.println("  [final executeSilverStrike] Срібний меч завдав " + damage + " шкоди.");
            System.out.println("  Після удару: " + monster);
            if (monster instanceof RegeneratingMonster regen) {
                System.out.println("  Відновлення здоров'я: +" + regen.regenerateHealth() + " HP");
            }
        }
    }
}
