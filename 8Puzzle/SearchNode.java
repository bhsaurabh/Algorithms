public class SearchNode implements Comparable<SearchNode> {
    private Board board;
    private int moves;
    private SearchNode previous;
    private int cachedPriority;  // cache the priority to avoid re-computing it 

    /**
     * Constructor: Initialise a search node
     * @param board: is the board to be stored in the SearchNode
     * @param moves: is the number of moves from initial configuration to reach here
     * @param previous: the SearchNode we arrived from 
     */
    public SearchNode(Board board, int moves, SearchNode previous) {
        this.board = board;
        this.moves = moves;
        this.previous = previous;
        this.cachedPriority = -1;
    }

    /**
     * Returns the board
     * @return the board stored in the SearchNode
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * Returns the moves 
     * @return the moves stored in the SearchNode
     */
    public int getMoves() {
        return this.moves;
    }


    /**
     * Returns the previous node 
     * @return the previous Node stored in the SearchNode
     */
    public SearchNode getPrevious() {
        return this.previous;
    }


    /**
     * Updates the number of moves needed to reach this SearchNode 
     * @param moves: the number of moves needed to reach this node
     */
    public int setMoves(int moves) {
        this.moves = moves;
    }

    /* Get the priority of this node */
    private int priority() {
        if (cachedPriority == -1) {
            // calculate the priority
            cachedPriority = moves + board.manhattan();
        }
        return cachedPriority;
    }

    /**
     * Used for comparing a SearchNode with the current one
     * @param that: SearchNode to be compared with
     * @return -1 if current is less; +1 if current is more; 0 if equal
     */
    public int compareTo(SearchNode that) {
        if (this.priority() < that.priority())
            return -1;
        else if (this.priority() > that.priority())
            return +1;
        else
            return 0;
    }
}
