package semester1.semester1.practice10.homework;

public class WitcherHunter {
    private final String schoolName;
    private final int silverSwordAtk;
    private final int signIntensity;

    public WitcherHunter(String schoolName, int silverSwordAtk, int signIntensity) {
        this.schoolName = schoolName;
        this.silverSwordAtk = silverSwordAtk;
        this.signIntensity = signIntensity;
    }

    public String getDescription() {
        return "Ґеральт із Рівії (" + schoolName + " | меч " + silverSwordAtk +
                " ATK | знаки " + signIntensity + "%)";
    }

    public void applyBestiaryTactics(AbstractMonster target) {
        if (target instanceof SpectralPhantom phantom && phantom.isIncorporeal()) {
            phantom.bindWithYrdenSign();
        }
        if (target instanceof FlyingMonster flying && flying.isAirborne()) {
            flying.knockDownToGround();
        }
        if (target instanceof RegeneratingMonster regen) {
            regen.applyMoonDustBomb();
        }
    }

    public final int executeSilverStrike(AbstractMonster target) {
        if (!target.isAlive()) {
            return 0;
        }
        applyBestiaryTactics(target);
        int damage = silverSwordAtk + signIntensity / 5;
        if (target instanceof SpectralPhantom) {
            damage = damage + 10;
        }
        if (target instanceof RegeneratingMonster) {
            damage = damage + 80;
        }
        if (target instanceof FlyingMonster flying && flying.isAirborne()) {
            damage = damage / 2;
        }
        if (target instanceof SpectralPhantom phantom && phantom.isIncorporeal()) {
            damage = damage * 20 / 100;
        }
        target.receiveDamage(damage);
        return damage;
    }
}
