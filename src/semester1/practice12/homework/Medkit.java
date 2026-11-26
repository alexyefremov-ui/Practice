package semester1.practice12.homework;

public class Medkit extends ZoneItem {
    private int usesLeft;

    public Medkit(String id, String name, double weightKg, int usesLeft) {
        super(id, name, weightKg);
        if (usesLeft < 0) {
            throw new IllegalArgumentException("Кількість зарядів не може бути від'ємною");
        }
        this.usesLeft = usesLeft;
    }

    public boolean use() {
        if (usesLeft > 0) {
            usesLeft--;
            return true;
        }
        return false;
    }

    public int getUsesLeft() {
        return usesLeft;
    }

    @Override
    public String getItemType() {
        return "Аптечка";
    }

    @Override
    public boolean isUsable() {
        return usesLeft > 0;
    }

    @Override
    public String toString() {
        return getName() + " (" + usesLeft + " зар.)";
    }
}
