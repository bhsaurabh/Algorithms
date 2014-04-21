import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Fast implements Runnable {

    private Point[] points;
    private int N;
    private Scanner sc;

    public Fast() {
        /** Constructor - initialises the scanner object */
        this.sc = new Scanner(System.in);
    }
    
    private void getPoints() {
        /** Gets the points from STDIN and populates the points array
         *  The number of points must already be available in variable N
         *
         * Args: None
         *
         * Returns: None
         */
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            Point point = new Point(x, y);
            points[i] = point;
        }
    }

    private ArrayList<CollinearPoint> getCollinearPoints() {
        /** Finds all sets of 4 points that are collinear
         *
         * Args: None
         *
         * Returns:
         *   An ArrayList of CollinearPoint objects that hold the 4 collinear points
         */
        ArrayList<CollinearPoint> collinearPoints = new ArrayList<CollinearPoint>();
        // create an array to hold the slopes
        double[] slopes = new double[N];
        // make a copy of the points
        Point[] copy = new Point[N];
        for (int i = 0; i < N; i++) {
            copy[i] = points[i];
        }
       
        for (Point p : points) {
            Arrays.sort(copy, p.SLOPE_ORDER);
            // check if any 3 adjacent points have exact same slope
            for (int i = 0; i < N-3; i++) {
                if (p.slopeTo(copy[i]) != p.slopeTo(copy[i+1])) continue;
                if (p.slopeTo(copy[i+1]) != p.slopeTo(copy[i+2]))   continue;
                CollinearPoint obj = new CollinearPoint(p, copy[i], copy[i+1], copy[i+2]);
                collinearPoints.add(obj);
            }
        }
        return collinearPoints;
    }

    private void processCollinearSet(ArrayList<CollinearPoint> collinearSet) {
        /** Processes a collection of CollinearPoint objects
         * Uses the information to print and plot the collinear points
         */ 
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (CollinearPoint collection : collinearSet) {
            Point[] collinearPoints = collection.getPoints();
            Point p = collinearPoints[0];
            p.draw();
            System.out.print(p + " -> ");
            for (int i = 1; i < 4; i++) {
                collinearPoints[i].draw();
                p.drawTo(collinearPoints[i]);
                System.out.print(collinearPoints[i]);
                if (i == 3) {
                    System.out.println();
                }
                else {
                    System.out.print(" -> ");
                }
            }
        }
    }
    
    public void run() {
        /** Application calling code - Calls the methods in the correct order
         *
         * Args: None
         *
         * Returns: None
         */

        /* ----- Get the points and populate the array ----- */
        this.N = sc.nextInt();
        this.points = new Point[N];
        getPoints();

        /* ----- Find all sets of 4 points that are collinear ----- */
        ArrayList<CollinearPoint> collinearPoints = getCollinearPoints();
        processCollinearSet(collinearPoints);
    }

    public static void main(String[] args) {
        /** Instantiate the class and run it
         *
         * Args: 
         *   An array of Strings (passed in as command line arguments)
         *
         * Returns: None
         */
        Fast obj = new Fast();
        obj.run();
    }
}
