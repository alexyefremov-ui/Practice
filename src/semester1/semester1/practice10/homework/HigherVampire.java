package semester1.semester1.practice10.homework;

public class HigherVampire extends AbstractMonster implements FlyingMonster, RegeneratingMonster {
    private boolean airborne;
    private boolean regenerationBlocked;

    public HigherVampire() {
        super("Вищий Вампір Детлафф", "Вампіри", 650);
        airborne = true;
        regenerationBlocked = false;
    }

    @Override
    public int calculateMonsterAttack() {
        return 130;
    }

    @Override
    public String getBattleCry() {
        return "Детлафф випускає моторошне гарчання!";
    }

    @Override
    public boolean isAirborne() {
        return airborne;
    }

    @Override
    public void knockDownToGround() {
        airborne = false;
        System.out.println("  Аард збиває вампіра з повітря.");
    }

    @Override
    public int regenerateHealth() {
        if (regenerationBlocked || !isAlive()) {
            return 0;
        }
        int oldHp = hp;
        hp = Math.min(maxHp, hp + 120);
        return hp - oldHp;
    }

    @Override
    public void applyMoonDustBomb() {
        regenerationBlocked = true;
        System.out.println("  Бомба «Місячний пил» зупиняє регенерацію вампіра.");
    }
}
