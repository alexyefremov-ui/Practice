package semester1.practice12.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class RouteDispatcher {
    private ArrayList<String> cities;
    private int[][] distances;
    private HashSet<String> closedCities;
    private ArrayList<TripOrder> orders = new ArrayList<>();

    public RouteDispatcher(ArrayList<String> cities, int[][] distances, HashSet<String> closedCities) {
        if (cities == null || distances == null || closedCities == null
                || distances.length != cities.size()) {
            throw new IllegalArgumentException("Некоректна матриця доріг");
        }
        this.cities = new ArrayList<>(cities);
        this.closedCities = new HashSet<>(closedCities);
        this.distances = new int[distances.length][];
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] == null || distances[i].length != cities.size()) {
                throw new IllegalArgumentException("Матриця має бути квадратною");
            }
            this.distances[i] = new int[distances[i].length];
            for (int j = 0; j < distances[i].length; j++) {
                this.distances[i][j] = distances[i][j];
            }
        }
    }

    public void addOrder(TripOrder order) {
        if (order != null) {
            orders.add(order);
        }
    }

    public ArrayList<TripOrder> getOrdersCopy() {
        return new ArrayList<>(orders);
    }

    public HashSet<String> getClosedCitiesCopy() {
        return new HashSet<>(closedCities);
    }

    public int getDistance(String from, String to) {
        int i = cities.indexOf(from);
        int j = cities.indexOf(to);
        if (i == -1 || j == -1) {
            return 0;
        }
        return distances[i][j];
    }

    public HashSet<String> getDirectNeighbors(String city) {
        HashSet<String> neighbors = new HashSet<>();
        int index = cities.indexOf(city);
        if (index == -1) {
            return neighbors;
        }
        for (int i = 0; i < cities.size(); i++) {
            if (distances[index][i] > 0) {
                neighbors.add(cities.get(i));
            }
        }
        return neighbors;
    }

    public HashSet<String> getCommonNeighbors(String cityA, String cityB) {
        HashSet<String> common = getDirectNeighbors(cityA);
        common.retainAll(getDirectNeighbors(cityB));
        return common;
    }

    public HashSet<String> getExclusiveNeighbors(String cityA, String cityB) {
        HashSet<String> onlyA = getDirectNeighbors(cityA);
        onlyA.removeAll(getDirectNeighbors(cityB));
        return onlyA;
    }

    public int filterInvalidOrders() {
        HashSet<String> seenIds = new HashSet<>();
        Iterator<TripOrder> it = orders.iterator();
        int removed = 0;
        while (it.hasNext()) {
            TripOrder order = it.next();
            if (!seenIds.add(order.getOrderId())) {
                System.out.println("  [ДУБЛІКАТ] " + order.getOrderId());
                it.remove();
                removed++;
            } else if (closedCities.contains(order.getFromCity())
                    || closedCities.contains(order.getToCity())) {
                System.out.println("  [МІСТО ЗАКРИТЕ] " + order.getOrderId());
                it.remove();
                removed++;
            } else if (getDistance(order.getFromCity(), order.getToCity()) <= 0) {
                System.out.println("  [НЕМАЄ ДОРОГИ] " + order.getOrderId());
                it.remove();
                removed++;
            }
        }
        return removed;
    }

    public void printReport() {
        int totalDistance = 0;
        double totalCost = 0;
        for (TripOrder order : orders) {
            int distance = getDistance(order.getFromCity(), order.getToCity());
            Transport transport = order.getTransport();
            double time = transport.calculateTimeHours(distance);
            double cost = transport.calculateCostUah(distance);
            totalDistance += distance;
            totalCost += cost;
            System.out.printf("  %s | %s -> %s | %d км | %s | %.2f год | %.2f грн%n",
                    order.getOrderId(), order.getFromCity(), order.getToCity(),
                    distance, transport.getName(), time, cost);
        }
        System.out.printf("Загальна відстань: %d км | Загальна вартість: %.2f грн%n",
                totalDistance, totalCost);
    }
}
