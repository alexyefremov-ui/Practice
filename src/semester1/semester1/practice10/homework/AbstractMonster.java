package semester1.semester1.practice10.homework;

public abstract class AbstractMonster {
    private final String name;
    private final String bestiaryCategory;
    protected int hp;
    protected final int maxHp;

    public AbstractMonster(String name, String bestiaryCategory, int maxHp) {
        this.name = name;
        this.bestiaryCategory = bestiaryCategory;
        this.maxHp = maxHp;
        this.hp = maxHp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public abstract int calculateMonsterAttack();

    public abstract String getBattleCry();

    public final boolean isAlive() {
        return hp > 0;
    }

    public void receiveDamage(int dmg) {
        if (dmg <= 0) {
            return;
        }
        hp = hp - dmg;
        if (hp < 0) {
            hp = 0;
        }
    }

    @Override
    public String toString() {
        String bar = "[";
        int filled = hp * 10 / maxHp;
        for (int i = 0; i < 10; i++) {
            bar = bar + (i < filled ? "#" : "-");
        }
        bar = bar + "]";
        return name + " [" + bestiaryCategory + " | HP " + hp + "/" + maxHp + " " + bar + "]";
    }
}
