package semester1.practice12.homework;

import java.util.Objects;

public abstract class ZoneItem {
    private final String id;
    private final String name;
    private final double weightKg;

    public ZoneItem(String id, String name, double weightKg) {
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Вага предмета має бути додатною");
        }
        this.id = id;
        this.name = name;
        this.weightKg = weightKg;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public abstract String getItemType();

    public abstract boolean isUsable();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ZoneItem other)) {
            return false;
        }
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
