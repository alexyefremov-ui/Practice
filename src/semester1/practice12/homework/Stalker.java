package semester1.practice12.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Stalker {
    private final String callSign;
    private HashSet<Artifact> artifactBelt = new HashSet<>();
    private ArrayList<ZoneItem> backpack = new ArrayList<>();
    private HashSet<String> visitedLocations = new HashSet<>();

    public Stalker(String callSign) {
        this.callSign = callSign;
    }

    public String getCallSign() {
        return callSign;
    }

    public boolean equipArtifact(Artifact art) {
        if (art == null || artifactBelt.contains(art) || artifactBelt.size() >= 4) {
            return false;
        }
        return artifactBelt.add(art);
    }

    public void addToBackpack(ZoneItem item) {
        if (item != null) {
            backpack.add(item);
        }
    }

    public int cleanBackpack() {
        Iterator<ZoneItem> it = backpack.iterator();
        int removed = 0;
        while (it.hasNext()) {
            ZoneItem item = it.next();
            if (!item.isUsable()) {
                System.out.println("  Викинуто [" + item.getItemType() + "]: " + item.getName());
                it.remove();
                removed++;
            }
        }
        return removed;
    }

    public double getTotalWeightKg() {
        double total = 0;
        for (Artifact art : artifactBelt) {
            total += art.getWeightKg();
        }
        for (ZoneItem item : backpack) {
            total += item.getWeightKg();
        }
        return total;
    }

    public double getNetRadiation() {
        double total = 0;
        for (Artifact art : artifactBelt) {
            total += art.getRadiation();
        }
        return total;
    }

    public int getTotalProtection() {
        int total = 0;
        for (Artifact art : artifactBelt) {
            total += art.getProtection();
        }
        return total;
    }

    public HashSet<Artifact> getArtifactBeltCopy() {
        return new HashSet<>(artifactBelt);
    }

    public ArrayList<ZoneItem> getBackpackCopy() {
        return new ArrayList<>(backpack);
    }

    public void visitLocation(String name) {
        if (name != null) {
            visitedLocations.add(name);
        }
    }

    public HashSet<String> getVisitedLocationsCopy() {
        return new HashSet<>(visitedLocations);
    }

    public HashSet<String> getCommonLocations(HashSet<String> ally) {
        HashSet<String> common = new HashSet<>(visitedLocations);
        common.retainAll(ally);
        return common;
    }

    public HashSet<String> getNewLocationsFromAlly(HashSet<String> ally) {
        HashSet<String> newPlaces = new HashSet<>(ally);
        newPlaces.removeAll(visitedLocations);
        return newPlaces;
    }
}
