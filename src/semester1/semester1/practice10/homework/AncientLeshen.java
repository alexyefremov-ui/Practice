package semester1.semester1.practice10.homework;

public final class AncientLeshen extends AbstractMonster implements RegeneratingMonster {
    private boolean regenerationBlocked;

    public AncientLeshen() {
        super("Прадавній Лісовик", "Релікти", 550);
        regenerationBlocked = false;
    }

    @Override
    public int calculateMonsterAttack() {
        return 100;
    }

    @Override
    public String getBattleCry() {
        return "Лісовик скликає воронів з лісу!";
    }

    @Override
    public int regenerateHealth() {
        if (regenerationBlocked || !isAlive()) {
            return 0;
        }
        int oldHp = hp;
        hp = Math.min(maxHp, hp + 50);
        return hp - oldHp;
    }

    @Override
    public void applyMoonDustBomb() {
        regenerationBlocked = true;
        System.out.println("  Бомба «Місячний пил» зупиняє регенерацію лісовика.");
    }
}
