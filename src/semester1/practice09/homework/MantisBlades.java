package semester1.practice09.homework;

public class MantisBlades extends AbstractCyberImplant {
    public MantisBlades() {
        super("Термальні Клинки Богомола", "Руки", 25);
    }

    @Override public int getAttackBonus() {
        return 110;
    }
    @Override public int getArmorBonus() {
        return 5;
    }

    @Override public String activateSpecialAbility() {
        return "Розпечені клинки Богомола розтинають броню ворога!";
    }
}
