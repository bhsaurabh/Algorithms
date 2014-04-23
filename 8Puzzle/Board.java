import java.util.Iterator;
import java.lang.Iterable;

public class Board {
    private int[][] board;
    private int N;
    private int[][] goal;

    /**
     * Construct a board from an NxN array of blocks
     * @param blocks are the blocks to be placed
     */
    public Board(int[][] blocks) {
        this.goal = null;
        this.N = blocks[0].length;
        this.board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                this.board[i][j] = blocks[i][j];
            }
        }       
    }

    /**
     * Returns the board dimension
     * @return N the board dimension
     */
    public int dimension() {
        return N;
    }

    /**
     * Returns the hamming distance: number of out-of place blocks
     * @return hamming distance
     */
    public int hamming() {
        int distance = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isEnd(i, j) && (board[i][j] != ((i * N) + j + 1)))
                    distance++;
            }
        }
        return distance;
    }

    /**
     * Returns the manhattan distance sum
     * @return sum of manhattan distances of every point out of place
     */
    public int manhattan() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = board[i][j];
                if (value != 0 && value != ((i*N) + j + 1) && !isEnd(i, j)) {
                    // calculate manhattan distance
                    int originalX = (value - 1) / N;
                    int originalY = (value - 1- originalX*N);
                    sum += Math.abs(originalX - i) + Math.abs(originalY - j);
                }
            }
        }
        return sum;
    }

    /*******************************************
     * Helper function for calculating distances
     ******************************************/
     private boolean isEnd(int i, int j) {
        return (i == N-1 && j == N-1);
     }


     /**
      * Check if the current board is the goal board or not
      * @return true, if the current board is the goal board; false otherwise
      */
     public boolean isGoal() {
        if (this.goal == null) {
            this.goal = new int[N][N];
            createGoalBoard();
        }
        return compareBoards(this.board, this.goal);
     }

     // generatre the goal board
     private void createGoalBoard() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (isEnd(i, j))    this.board[i][j] = 0;
                else    this.board[i][j] = (1 + (i*N) + j);
     }

     // check if 2 boards are equal
     private boolean compareBoards(int[][] first, int[][] second) {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (first[i][j] != second[i][j])
                    return false;
        return true;
     }

     /**
      * Get a board obtained by swapping 2 adjacent in the same row
      * @return Board with 2 adjacent elements swapped
      */
     public Board twin() {
        Board newBoard = new Board(this.board);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                if (board[i][j] != 0 && board[i][j+1] != 0) {
                    newBoard.exch(i, j, i, j+1);
                    return newBoard;
                }
            }
        }
        return newBoard;
     }

     // helper to swap elements in a board
     private void exch(int i, int j, int p, int q) {
        if (i < 0 || p >= N || j < 0 || q >= N)
            return;
        int temp = board[i][j];
        board[i][j] = board[p][q];
        board[p][q] = temp;
     }
}
