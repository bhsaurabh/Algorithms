/*************************************************************************
 * Name: Saurabh Bhatia
 * Email: saurabh.bhatia@me.com
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new BySlope();

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        // m = (y2 - y1) / (x2 - x1)
        int dy = that.getY() - this.getY(); // using accessors
        int dx = that.getX() - this.getX();
        if (dy == 0 && dx == 0) return Double.MIN_VALUE;
        if (dx == 0)    return Double.MAX_VALUE;
        if (dy == 0)    return 0.0;
        return (1.0 * dy)/dx;
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        int y2 = that.getY(), y1 = this.getY(), x2 = that.getX(), x1 = this.getX();
        if (y1 > y2)    return +1;
        if (y1 < y2)    return -1;
        if (x1 > x2)    return +1;
        if (x1 < x2)    return -1;
        return 0;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // accessors
    public int getX() { return this.x; }
    public int getY() { return this.y; }

    // mutators
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    // Comparator class for slope based comparisons
    private class BySlope implements Comparator<Point>
    {
        public int compare(Point v, Point w)
        {
            // compare based on slope made from invoking point
            return this.slopeTo(v) - this.slopeTo(w);
        }
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}