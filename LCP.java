public class LCP {
    /**
     * Compute the Longest Common Prefix for 2 Strings
     * @param s: the first String to be checked
     * @param t: the second String to be checked
     * @return lcp: the index of the last element in the LCP
     */
    public static int lcp(String s, String t) {
        // Only need to check till smaller of 2 Strings
        int N = Math.min(s.length, t.length);

        for (int i = 0; i < N; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return i-1;
            }
        }
        return N-1;
    }
}
