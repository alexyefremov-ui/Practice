package semester1.semester1.practice10.homework;

public class Noonwraith extends AbstractMonster implements SpectralPhantom {
    private boolean incorporeal;

    public Noonwraith() {
        super("Полудниця", "Примари", 300);
        incorporeal = true;
    }

    @Override
    public int calculateMonsterAttack() {
        return 70;
    }

    @Override
    public String getBattleCry() {
        return "Полудниця здіймає моторошний крик!";
    }

    @Override
    public boolean isIncorporeal() {
        return incorporeal;
    }

    @Override
    public void bindWithYrdenSign() {
        incorporeal = false;
        System.out.println("  Ірден робить примару матеріальною.");
    }
}
