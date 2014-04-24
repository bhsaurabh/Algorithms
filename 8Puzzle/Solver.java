public class Solver {
    private Stack<Board> boards;
    private boolean isSolvable;
    private int moves;

    /**
     * Constructor
     * @param initial: the initial board to be re-arranged
     */
    public Solver(Board initial) {
        boards = new Stack<Board>();
        if (initial.isGoal()) {
            this.isSolvable = true;
            this.moves = 0;
            boards.push(initial);
            return;
        }
        if (initial.twin().isGoal()) {
            this.isSolvable = false;
            return;
        }

        // Use the A* search algorithm. Maintain a Minimum Priority Queue having searchnodes
        MinPQ<SearchNode> pq = new MinPQ<SearchNode>();
        MinPQ<SearchNode> pqTwin = new MinPQ<SearchNode>();
        moves = 0;
        Board board = initial;
        Board boardTwin = initial.twin();
        
        // create search nodes and enqueue in PQ
        SearchNode node = new SearchNode(board, moves, null);
        SearchNode nodeTwin = new SearchNode(boardTwin, moves, null);
        pq.insert(node);
        pqTwin.insert(node);

        int MAX_ITERATIONS = 100;
        while (moves < MAX_ITERATIONS) {
            moves++;
            // dequeue from the PQ (to get least cost node)
            node = pq.delMin();
            nodeTwin = pqTwin.delMin();
            board = node.getBoard();
            boardTwin = nodeTwin.getBoard();
            
            // No solution if the Twin board is the goal board
            if (boardTwin.isGoal()) {
                this.isSolvable = false;
                return;
            }
            if (board.isGoal()) {
                this.isSolvable = true;
                this.boards.push(board);
                // push all nodes in stack
                while (node.previous != null) {
                    node = node.getPrevious();
                    this.boards.push(node.getBoard());
                }
                return;
            }

            // process and check neighbors
            node.setMoves(++node.getMoves());
            nodeTwin.setMoves(++nodeTwin.getNodes());
            Iterable<Board> neighbors = board.neighbors();
            for (Board neighbor : neighbors) {
                // Dont insert on PQ if already on it
                if (node.getPrevious() != null && neighbor.equals(node.getPrevious().getBoard()))
                    continue;
                SearchNode newNode = new SearchNode(neighbor, node.getMoves(), node); 
                pq.insert(newNode);
            }
            // similar for twin node
            Iterable<Board> neighborTwins = boardTwin.neighbors();
            for (Board neighborTwin : neighborTwins) {
                // Dont insert on PQ if already on it
                if (nodeTwin.getPrevious() != null && neighborTwin.equals(nodeTwin.getPrevious().getBoard()))
                    continue;
                SearchNode newNodeTwin = new SearchNode(neighborTwin, nodeTwin.getMoves(), nodeTwin);
                pqTwin.insert(newNodeTwin);
            }
        }
    }

    /**
     * Check if the board is solvable or not
     * @return true if solvable, false otherwise
     */
    public boolean isSolvable() {
        return this.solvable;
    }

    /**
     * Return the max number of moves required to get to the goal position
     * @return max number of moves needed to get to goal position
     */
    public int moves() {
        if (isSolvable()) {
            return this.boards.size() - 1;
        }
        else {
            return -1;
        }
    }

    /**
     * Returns an Iterable that iterates over the solution boards
     * @return an iterable which has the solution to the puzzle
     */
    public Iterable<Board> solution() {
        if (isSolvable())
            return this.boards;
        else
            return null;
    }
}
