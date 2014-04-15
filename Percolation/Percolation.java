public class Percolation {
    /* Models a Percolation system.
     * Useful for creating a monte-carlo simulation of the same */

    private WeightedQuickUnionUF uf;
    private boolean[] grid;
    // useful indices in the grid
    private int TOP, BOTTOM;
    private int N;

    public Percolation(int N) {
        /* Constructor: Create a NxN grid with all sites blocked */
        this.N = N;

        // create a grid having N^2 + 2 sites (2 additional sites: top and bottom)
        this.grid = new boolean[N*N + 2];
        this.uf = new WeightedQuickUnionUF(N*N + 2);
        this.TOP = 0;
        this.BOTTOM = N*N + 1;

        // open top and bottom sites
        this.grid[TOP] = true;
        this.grid[BOTTOM] = true;
    }

    public void open(int i, int j) {
        /* API: Open site (row i, column j) if it is not already */

        // map (i, j) to a single number in the array
        int index = ((i - 1) * N) + j + 1;

        // Proceed only if site is blocked
        if (grid[index])    return;
        grid[index] = true;

        // if this is a site in top row, connect to TOP site
        if (i == 1)
            uf.union(index, TOP);
        // if this is a site in bottom row, connect to BOTTOM site
        if (i == N-1)
            uf.union(index, BOTTOM);

        // scan surroundings for open sites and connect if there exists any
        scanSurroundings(index, i, j);
    }

    private void scanSurroundings(int index, int row, int col) {
        /* Helper: Look through surroundings and connect with neighboring open sites */

        // Look up
        if (row > 1 && isOpen(row-1, col))
            uf.union(index, index-N);

        // Look down
        if (row < N && isOpen(row+1, col))
            uf.union(index, index+N);

        // Look left
        if (col > 1 && isOpen(row, col-1))
            uf.union(index, index-1);

        // Look right
        if (col < N && isOpen(row, col+1))
            uf.union(index, index+1);
    }
    
    public boolean isOpen(int i, int j) {
        /* API: Is site (row i, column j) open? */
        // calculate index
        int index = ((i - 1) * N) + j + 1;
        // Check the grid to see if this is open
        return grid[index];
    }

    public boolean isFull(int i, int j) {
        /* API: Is site (row i, column j) full? */

        // calculate index
        int index = ((i - 1) * N) + j + 1;
        // check if connected to TOP site
        return uf.connected(index, TOP);
    }

    public boolean percolates() {
        /* API: Does this system percolate? */
        return uf.connected(TOP, BOTTOM);
    }
}
