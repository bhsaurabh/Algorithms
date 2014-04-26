public class MSD {
    
    private int R = 256;    // radix is 256 for extended ASCII

    /**
     * Most Significant Digit First Radix Sort
     * @param a: an array of Strings to sort
     */
    public static void sort(String[] a) {
        // have an auxilliary array to copy elements into
        String[] aux = new String[a.length];
        sort(a, aux, 0, a.length-1, 0);
    }

    private static void sort(String[] a, String[] aux, int lo, int hi, int d) {
        if (hi <= lo)   return;
        int[] count = int[R+2];

        // Step 1: Store frequency of keys in count array
        for (int i = lo; i <= hi; i++) {
            char ch = charAt(a[i], d);
            count[ch + 2]++;
        }

        // Step 2: Calculate cumulative frequencies
        for (int r = 0; r < R+1; r++) {
            count[r+1] += count[r];
        }

        // Step 3: Copy elements into auxilliary array in correct order
        for (int i = lo; i <= hi; i++) {
            char ch = charAt(a[i], d);
            aux[count[ch + 1]++] = a[i];
        }

        // Step 4: Copy from auxilliary array into original array
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i-lo];   // as elements are stored in aux from 0 onwards
        }

        // Sort recursively
        for (int r = 0; r < R; r++) {
            sort(a, aux, lo + count[r], lo + count[r+1] - 1, d+1);
        }
    }

    private static char charAt(String a, int d) {
        if (d < a.length) {
            return a.charAt(d);
        }
        return -1;
    }
}
