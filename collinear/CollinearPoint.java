import java.util.Iterator;
import java.lang.Iterable;

public class CollinearPoint implements Iterable<Point>{
    /** A class to hold 4 collinear points */
    private Point[] points; 
    
    public CollinearPoint(Point a, Point b, Point c, Point d) {
        /** Constructor: Initialise all 4 points */
        this.points = new Point[4];
        points[0] = a;
        points[1] = b;
        points[2] = c;
        points[3] = d;
    }
    
    public Iterator<Point> iterator() {
        /** Return a new Iterator to iterate upon
         *
         * Args: None
         * 
         * Returns:
         *   interator: An iterator to iterate over all 4 points
         */
        return new PointIterator();
    }

    private class PointIterator implements Iterator<Point> {
        /** An iterator used to iterate over the 4 points */

        private int current = 0;

        public boolean hasNext() {
            /** Check if there are more points to iterate over
             *
             * Args: None
             *
             * Returns:
             *   true, if there are more points, false otherwise
             */
            return current < 4;
        }

        public void remove() {
            // Not supported
        }

        public Point next() {
            /** Return the next point
             *
             * Args:  None
             *
             * Returns :
             *   returns the next point in the collection
             */
            return points[current++];
        }
    }
}
