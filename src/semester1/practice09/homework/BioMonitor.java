package semester1.practice09.homework;

public class BioMonitor {
    private int hp;
    private final int maxHp;
    private int humanity;
    private boolean cyberpsychosis;

    public BioMonitor(int maxHp) {
        this.maxHp = (maxHp > 0) ? maxHp : 1000;
        this.hp = this.maxHp;
        this.humanity = 100;
        this.cyberpsychosis = false;
    }

    public int getHp() {
        return hp;
    }

    public int getHumanity() {
        return humanity;
    }

    public boolean isCyberpsychosis() {
        return cyberpsychosis;
    }

    public void reduceHumanity(int cost) {
        if (cost > 0) {
            humanity = Math.max(0, humanity - cost);
        }
        cyberpsychosis = humanity < 20;
    }

    public void injectImmunoblockers(int restoreAmount) {
        if (restoreAmount > 0) {
            humanity += restoreAmount;
            if (humanity > 100) {
                humanity = 100;
            }
        }
        if (humanity >= 20) {
            cyberpsychosis = false;
        }
    }

    public int applyDamage(int rawDamage, int totalArmor) {

        if (rawDamage <= 0) {
            return 0;
        }

        int damage = Math.max(5, rawDamage - totalArmor);
        hp = Math.max(0, hp - damage);
        return damage;
    }

    @Override
    public String toString() {
        String hpBar = "[";
        String humanityBar = "[";
        int hpBlocks = (int) (hp * 10.0 / maxHp);
        int humanityBlocks = humanity / 10;

        for (int i = 0; i < 10; i++) {
            hpBar += (i < hpBlocks) ? "█" : "░";
            humanityBar += (i < humanityBlocks) ? "█" : "░";
        }
        hpBar += "]";
        humanityBar += "]";
        String state = cyberpsychosis ? "КІБЕРПСИХОЗ" : "Стабільний";

        return "HP " + hpBar + " " + hp + "/" + maxHp + " | Людяність " + humanityBar + " " + humanity + "/100 (" + state + ")";
    }
}
