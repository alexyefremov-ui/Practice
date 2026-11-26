package semester1.practice12.homework;

import java.util.HashSet;
import java.util.Iterator;

public class PointSetUtils {
    public static HashSet<Point2D> union(HashSet<Point2D> a, HashSet<Point2D> b) {
        HashSet<Point2D> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    public static HashSet<Point2D> intersection(HashSet<Point2D> a, HashSet<Point2D> b) {
        HashSet<Point2D> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    public static HashSet<Point2D> difference(HashSet<Point2D> a, HashSet<Point2D> b) {
        HashSet<Point2D> result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }

    public static int removeFarPoints(HashSet<Point2D> points, double maxRadius) {
        Iterator<Point2D> it = points.iterator();
        int removed = 0;
        while (it.hasNext()) {
            Point2D point = it.next();
            if (point.distanceFromOrigin() > maxRadius) {
                it.remove();
                removed++;
            }
        }
        return removed;
    }
}
