package semester1.practice09.homework;

public class SubdermalTitaniumArmor extends AbstractCyberImplant {
    public SubdermalTitaniumArmor() {
        super("Підшкірна Титанова Броня", "Шкіра", 20);
    }

    @Override
    public int getAttackBonus() {
        return 10;
    }
    @Override
    public int getArmorBonus() {
        return 65;
    }
    @Override
    public String activateSpecialAbility() {
        return "Титанові пластини поглинають кінетичний удар!";
    }
}
