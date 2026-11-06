package semester1.practice09.homework;

public class CyberMercenary {
    private final String nickname;
    private final int baseAttack;
    private final BioMonitor bioMonitor;
    private final AbstractCyberImplant[] implants;
    private int implantCount;

    public CyberMercenary(String nickname, int baseAttack, int maxHp) {
        this.nickname = nickname;
        this.baseAttack = (baseAttack > 0) ? baseAttack : 1;
        this.bioMonitor = new BioMonitor(maxHp);
        this.implants = new AbstractCyberImplant[4];
        this.implantCount = 0;

    }

    public boolean installImplant(AbstractCyberImplant implant) {
        if (implant == null || implantCount >= implants.length) {
            System.out.println("Відмова: Немає вільного слота або імплант відсутній!");
            return false;
        }
        for (int i = 0; i < implantCount; i++) {
            if (implants[i].getSlot().equals(implant.getSlot())) {
                System.out.println("Помилка слота: [" + implant.getSlot()
                        + "] вже зайнятий імплантом '" + implants[i].getName() + "'!");
                return false;

            }
        }
        implants[implantCount] = implant;
        implantCount++;
        bioMonitor.reduceHumanity(implant.getHumanityCost());
        System.out.println("Встановлено: " + implant.getName() + " (-"
                + implant.getHumanityCost() + " людяності -> " + bioMonitor.getHumanity() + ")");
        if (bioMonitor.isCyberpsychosis()) {
            System.out.println("ПОПЕРЕДЖЕННЯ: КІБЕРПСИХОЗ! Атака x1.5, саморуйнування!");
        }

        return true;
    }

    public int getTotalAttack() {
        int attack = baseAttack;
        for (int i = 0; i < implantCount; i++) {
            attack += implants[i].getAttackBonus();
        }
        if (bioMonitor.isCyberpsychosis()) {
            attack = (int) (attack * 1.5);
        }
        return attack;
    }

    public int getTotalArmor() {
        int armor = 0;
        for (int i = 0; i < implantCount; i++) {
            armor += implants[i].getArmorBonus();
        }
        return armor;
    }

    public int getHp() {
        return bioMonitor.getHp();
    }

    public int getHumanity() {
        return bioMonitor.getHumanity();
    }

    public boolean isCyberpsychosis() {
        return bioMonitor.isCyberpsychosis();
    }

    public int receiveDamage(int rawDamage) {
        return bioMonitor.applyDamage(rawDamage, getTotalArmor());
    }
    public int endTurn() {
        if (bioMonitor.isCyberpsychosis()) {
            int overloadDamage = bioMonitor.getHp() / 10;
            return bioMonitor.applyDamage(overloadDamage, 0);
        }
        return 0;
    }

    public void useImmunoblockers(int amount) {
        bioMonitor.injectImmunoblockers(amount);
        System.out.println("Введено імуноблокатор (+" + amount
                + " людяності -> " + bioMonitor.getHumanity() + "/100)");
    }

    public void triggerFullOverdrive() {
        for (int i = 0; i < implantCount; i++) {
            System.out.println(implants[i].activateSpecialAbility());
        }
    }

    @Override public String toString() {
        String result = "CyberMercenary: " + nickname + " | ATK=" + getTotalAttack()
                + " | DEF=" + getTotalArmor() + "\n";
        result += "  BioMonitor: " + bioMonitor + "\n";
        result += "  Встановлено імплантів: " + implantCount + "/" + implants.length + "\n";

        for (int i = 0; i < implantCount; i++) {
            result += "    " + (i + 1) + ". " + implants[i] + "\n";
        }
        return result;
    }
}
