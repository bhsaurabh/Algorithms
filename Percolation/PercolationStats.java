import java.util.Random;

public class PercolationStats {
    /* Perform the Monte-Carlo Simulation on a percolation system */

    private Percolation system;
    private double[] thresholds;

    // some data members good to store to avoid slowness
    private double mu, std;
    private boolean muStored, stdStored;

    public PercolationStats(int N, int T) {
        /* Constructor: Perform T independent computational experiments on a NxN grid */
        this.thresholds = new double[T];
        Random rand = new Random();

        // pre-process
        for (int testNum = 0; testNum < T; testNum++) {
            thresholds[testNum] = 0.0;

            while(!system.percolates()) {
                thresholds[testNum]++;
                // initialise all sites to be blocked
                this.system = new Percolation(N);
            
                // choose a site (i, j) at random and open it
                int i = rand.nextInt(), j = rand.nextInt();
                system.open(i, j);
            }

            // store fraction of open sites in thresholds array
            thresholds[testNum] /= (N*N);
        }
    }

    public double mean() {
        /* API: Sample mean of percolation thresholds */
        double mu = 0.0;
        for (double threshold : thresholds)
            mu += threshold;
        mu /= thresholds.length;
        this.mu = mu;
        this.muStored = true;
        return mu;
    }

    public double stddev() {
        /* API: Sample standard deviation of percolation thresholds */
        if (!muStored)  mean();
        double std = 0.0;

        for (double threshold : thresholds) {
            std += (threshold - mu) * (threshold - mu);
        }

        std /= (thresholds.length - 1);
        return std;
    }

    public double confidenceLo() {
        /* API: Returns the lower bound of the 95% confidence interval */
        if (!stdStored)   stddev();
        double sigma = Math.sqrt(std);
        double rootT = Math.sqrt(thresholds.length);
        return (mean() - (1.96 * sigma / rootT));
    }
    
    public double confidenceHi() {
        /* API: Returns the upper bound of the 95% confidence interval */
        if (!stdStored)   stddev();
        double sigma = Math.sqrt(std);
        double rootT = Math.sqrt(thresholds.length);
        return (mean() + (1.96 * sigma / rootT));
    }

}
