public class KMP {

    private String pat;  // pattern to be searched
    private int[][] dfa;  // deterministic finite state machine
    private int M;  // length of pattern
    private int R;  // the radix (256 for Extended ASCII, ~16384 for unicode

    /**
     * Knuth Morris Pratt algorithm for substring search
     * Constructor takes the pattern that has to be searched
     * @param pat is the pattern to be searched for
     */
    public KMP(String pat) {
        this.pat = pat;
        this.M = pat.length;
        this.R = 256;  // working with Extended ASCII character set
        this.dfa = new int[R][M];

        // DFA construction
        dfa[pat.charAt(0)][0] = 1;  // move to state 1 if 1st character of pattern is found
        for (int X = 0, j = 1; j < M; j++) {
            // X is the state that is used to get DFA elements from
            // Step 1: Copy dfa[][X] into dfa[][j]
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            // Step 2: For matching character, correct the destination state
            dfa[pat.charAt(j)][j] = j+1;
            // Step 3: Increment the state X
            X = dfa[pat.charAt(j)][X];
        }
    }
}
