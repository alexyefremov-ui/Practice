package semester1.practice11.homework;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LogStreamSanitizer {
    public static void demonstrateFailFastCrash(List<String> logs) {
        try {
            for (String log : logs) {
                if (log != null && log.contains("CORRUPTED")) {
                    logs.remove(log); // Тільки приклад помилки, яку ми перехоплюємо.
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("  Перехоплено ConcurrentModificationException: "
                    + "список змінений напряму під час for-each.");
        }
    }

    public static int purgeLogsByKeywordSafely(List<String> logs, String keyword) {
        Iterator<String> it = logs.iterator();
        int removed = 0;
        while (it.hasNext()) {
            String log = it.next();
            if (log == null || log.trim().isEmpty() || log.contains(keyword)) {
                it.remove();
                removed++;
            }
        }
        return removed;
    }

    public static void enrichCriticalLogsWithListIterator(List<String> logs) {
        ListIterator<String> listIt = logs.listIterator();
        while (listIt.hasNext()) {
            String log = listIt.next();
            String trimmed = log.trim();
            listIt.set(trimmed);
            if (trimmed.startsWith("ERROR:")) {
                listIt.add("[ALERT-TRIGGERED]");
            }
        }
    }

    public static List<String> collectReverseOrder(List<String> logs) {
        List<String> reversed = new ArrayList<>();
        ListIterator<String> listIt = logs.listIterator(logs.size());
        while (listIt.hasPrevious()) {
            reversed.add(listIt.previous());
        }
        return reversed;
    }
}
