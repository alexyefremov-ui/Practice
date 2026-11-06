package semester1.practice09.homework;

public class KiroshiOptics extends AbstractCyberImplant {
    public KiroshiOptics() {
        super("Оптика Kiroshi", "Оптика", 5);
    }

    @Override public int getAttackBonus() {
        return 0;
    }

    @Override public int getArmorBonus() {
        return 0;
    }

    @Override public String activateSpecialAbility() {
        return "Оптика Kiroshi показує слабкі місця ворога!";
    }
}
