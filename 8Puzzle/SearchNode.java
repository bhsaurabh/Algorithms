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
