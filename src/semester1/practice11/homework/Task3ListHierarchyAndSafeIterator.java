package semester1.practice11.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task3ListHierarchyAndSafeIterator {
    public static void main(String[] args) {
        System.out.println("========== LIST ТА БЕЗПЕЧНИЙ ITERATOR ==========");

        List<String> rawLogs = new ArrayList<>();
        rawLogs.add("INFO: Auth OK");
        rawLogs.add("CORRUPTED_PACKET_01");
        rawLogs.add("  ERROR: DB Timeout  ");
        rawLogs.add("DEBUG: Ping");
        rawLogs.add("CORRUPTED_PACKET_02");
        rawLogs.add(null);
        rawLogs.add("ERROR: Disk Full");
        rawLogs.add("INFO: Logout");
        System.out.println("Сирі логи (" + rawLogs.size() + "): " + rawLogs);

        System.out.println("\n[1. ПОМИЛКА FOR-EACH + REMOVE]:");
        // Демонструємо помилку на копії, щоб зберегти початкові дані.
        LogStreamSanitizer.demonstrateFailFastCrash(new ArrayList<>(rawLogs));

        List<String> arrayLogs = new ArrayList<>(rawLogs);
        List<String> linkedLogs = new LinkedList<>(rawLogs);

        System.out.println("\n[2. ARRAYLIST]:");
        int arrayRemoved = LogStreamSanitizer.purgeLogsByKeywordSafely(arrayLogs, "CORRUPTED");
        System.out.println("  Безпечно видалено: " + arrayRemoved + " | Після чистки: " + arrayLogs);
        LogStreamSanitizer.enrichCriticalLogsWithListIterator(arrayLogs);
        System.out.println("  Після ListIterator: " + arrayLogs);

        System.out.println("\n[3. LINKEDLIST]:");
        int linkedRemoved = LogStreamSanitizer.purgeLogsByKeywordSafely(linkedLogs, "CORRUPTED");
        LogStreamSanitizer.enrichCriticalLogsWithListIterator(linkedLogs);
        System.out.println("  Безпечно видалено: " + linkedRemoved);
        System.out.println("  Після ListIterator: " + linkedLogs);
        System.out.println("  Результати однакові: " + arrayLogs.equals(linkedLogs));
        System.out.println("  У зворотному порядку: "
                + LogStreamSanitizer.collectReverseOrder(linkedLogs));
    }
}
