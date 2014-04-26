import java.util.Scanner;
import java.util.ArrayList;

public class Brute implements Runnable {
    /** Brute force algorithm to find all sets of 4 collinear points
     * Order of complexity: N^4
     */

    private Point[] points;     // array of points
    private int N;      // number of points
    private Scanner sc;     // for handling input

    public Brute() {
        /** Constructor: Initialise the scanner*/
        this.sc = new Scanner(System.in);
    }

    public void getPoints() {
        /** Gets points from standard input and populates the points array
         * Requires N to be set already
         * Also requires points array to already be initialised and ready to
         * be inserted into
         *
         * Args: None
         *
         * Returns: None
         */
        for (int i = 0; i < N; i++) {
            // get a point's coordinates
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            // create a new point out of these coordinates and insert in array
            Point point = new Point(x, y);
            points[i] = point;
        }
    }

    private ArrayList<CollinearPoint> findCollinearPoints() {
        /** Finds all sets of 4 collinear points
         *
         * Args: None
         *
         * Returns:
         *   An arraylist containing CollinearPoints objects
         */
        ArrayList<CollinearPoint> collinearSet = new ArrayList<CollinearPoint>();

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    for (int w = k+1; w < N; w++) {
                        Point p, q, r, s;
                        p = points[i];
                        q = points[j];
                        r = points[k];
                        s = points[w];

                        // check for collinearity
                        // should have same slope and 1 point in common
                        if (Math.abs(p.slopeTo(q)) != Math.abs(p.slopeTo(r)))   continue;
                        if (Math.abs(p.slopeTo(r)) != Math.abs(p.slopeTo(s)))   continue;

                        // these are collinear
                        CollinearPoint obj = new CollinearPoint(p, q, r, s);
                        collinearSet.add(obj);
                    }
                }
            }
        }
        return collinearSet;
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
        /** Execute the functions in correct order */
        // read number of points
        this.N = sc.nextInt();

        // initialise the points array
        this.points = new Point[N];

        // read the points and populate the points array
        getPoints();

        // Use brute force to find all collineat points
        ArrayList<CollinearPoint> collinearSet = findCollinearPoints();

        // Print and plot the points
        processCollinearSet(collinearSet);
    }

    public static void main(String[] args) {
        /** Application Entry Point */
        Brute obj = new Brute();
        obj.run();
    }
}
