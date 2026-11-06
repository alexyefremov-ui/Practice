package semester1.practice09.homework;

public abstract class AbstractCyberImplant {
    private final String name;
    private final String slot;
    private final int humanityCost;

    public AbstractCyberImplant(String name, String slot, int humanityCost) {
        this.name = name;
        this.slot = slot;
        this.humanityCost = (humanityCost >= 0) ? humanityCost : 0;
    }

    public String getName() {
        return name;
    }

    public String getSlot() {
        return slot;
    }
    public int getHumanityCost() {
        return humanityCost;
    }
    public abstract int getAttackBonus();
    public abstract int getArmorBonus();
    public abstract String activateSpecialAbility();

    @Override public String toString() {
        return String.format("[%s] %s (+%d ATK, +%d DEF, -%d Humanity)", slot, name, getAttackBonus(), getArmorBonus(), humanityCost);
    }
}
