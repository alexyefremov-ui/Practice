package semester1.semester1.practice10.homework;

public class RoyalGriffin extends AbstractMonster implements FlyingMonster {
    private boolean airborne;

    public RoyalGriffin() {
        super("Королівський Грифон", "Гібриди", 400);
        airborne = true;
    }

    @Override
    public int calculateMonsterAttack() {
        return 65;
    }

    @Override
    public String getBattleCry() {
        return "Грифон видає пронизливий крик!";
    }

    @Override
    public boolean isAirborne() {
        return airborne;
    }

    @Override
    public void knockDownToGround() {
        airborne = false;
        System.out.println("  Аард збиває грифона на землю.");
    }
}
