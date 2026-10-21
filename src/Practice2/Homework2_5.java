package Practice2;

public class Homework2_5 {
    public static void main(String[] args) {
        double strength = (int)(Math.random() * (18 - 8 + 1)) + 8;
        double agility = (int)(Math.random() * (18 - 8 + 1)) + 8;
        double intelligence = (int)(Math.random() * (18 - 8 + 1)) + 8;
        double hp = strength*100+agility*2;
        double mp = intelligence*15;
        double armor = agility/2;
        double dice1 = (int)(Math.random() * 6) + 1;
        double dice2 = (int)(Math.random() * 6) + 1;
        double attack = dice1 + dice2 + strength;
        final int MONSTER_ATTACK = 22;
        boolean isPlayerVictory = attack > MONSTER_ATTACK;

        System.out.println("/**************************************************\\");
        System.out.println("|                 ПАСПОРТ ГЕРОЯ RPG                |");
        System.out.println("\\**************************************************/");
        System.out.println("Ім'я персонажа:          Артур Світлоносний");
        System.out.println("Клас:                    Лицар");
        System.out.println(" ");
        System.out.println("[ХАРАКТЕРИСТИКИ]");
        System.out.println("Сила (STR):              " + strength);
        System.out.println("Спритність (AGI):        " + agility);
        System.out.println("Інтелект (INT):          " + intelligence);
        System.out.println(" ");
        System.out.println("[ПОХІДНІ АТРИБУТИ]");
        System.out.println("Очки здоров'я (HP):      " + hp);
        System.out.println("Очки мани (MP):          " + mp);
        System.out.println("Клас броні (Armor):      " + armor);
        System.out.println(" ");
        System.out.println("[СИМУЛЯЦІЯ БОЮ]");
        System.out.println("Кидок кубиків гравця:    " + dice1 + " + " + dice2 + " (бонус сили: +" + (dice1+dice2) + ")");
        System.out.println("Загальна атака гравця:   " + attack);
        System.out.println("Сила удару монстра:      " + MONSTER_ATTACK);
        System.out.println("Чи переміг гравець?      " + isPlayerVictory);
        System.out.println("\\**************************************************/");

    }
}
