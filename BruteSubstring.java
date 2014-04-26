public class BruteSubstring {
    public static int search(String pat, String text) {
        int M = text.length;
        int N = pat.length;

        for (int i = 0; i <= M-N; i++) {
            int j;
            for (j = 0; j < N; j++) {
                if (text.charAt(i+j) != pat.charAt(j))
                    break;
                if (j == N) {
                    // found the pattern
                    return i;
                }
            }
        }
        return M;
    }
}
