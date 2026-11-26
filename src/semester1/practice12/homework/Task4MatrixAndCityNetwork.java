package semester1.practice12.homework;

import java.util.ArrayList;
import java.util.HashSet;

public class Task4MatrixAndCityNetwork {
    public static void main(String[] args) {
        System.out.println("========== ЛОГІСТИЧНИЙ ДИСПЕТЧЕР: МАТРИЦЯ ТА МЕРЕЖА ==========");
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Київ");
        cities.add("Львів");
        cities.add("Одеса");
        cities.add("Дніпро");

        int[][] distances = {
            {0, 540, 480, 450},
            {540, 0, 790, 0},
            {480, 790, 0, 460},
            {450, 0, 460, 0}
        };
        HashSet<String> closed = new HashSet<>();
        closed.add("Одеса");
        RouteDispatcher dispatcher = new RouteDispatcher(cities, distances, closed);

        System.out.println("\n1. Множини сусідів міст:");
        System.out.println("  Сусіди Києва: " + dispatcher.getDirectNeighbors("Київ"));
        System.out.println("  Сусіди Львова: " + dispatcher.getDirectNeighbors("Львів"));
        System.out.println("  Спільні: " + dispatcher.getCommonNeighbors("Київ", "Львів"));
        System.out.println("  Тільки з Києва: " + dispatcher.getExclusiveNeighbors("Київ", "Львів"));

        dispatcher.addOrder(new TripOrder("ORD-1", "Київ", "Львів", new Train()));
        dispatcher.addOrder(new TripOrder("ORD-1", "Київ", "Львів", new Bus()));
        dispatcher.addOrder(new TripOrder("ORD-2", "Київ", "Одеса", new Bus()));
        dispatcher.addOrder(new TripOrder("ORD-3", "Львів", "Дніпро", new DeliveryTruck()));
        dispatcher.addOrder(new TripOrder("ORD-4", "Київ", "Дніпро", new DeliveryTruck()));

        System.out.println("\n2. Фільтрація заявок (закриті міста: " + dispatcher.getClosedCitiesCopy() + "):");
        int removed = dispatcher.filterInvalidOrders();
        System.out.println("  Видалено: " + removed + " | Залишилось: " + dispatcher.getOrdersCopy().size());

        System.out.println("\n3. Схвалені рейси:");
        dispatcher.printReport();
    }
}
