public class LSD {
    /**
     * LSD Radix sort for Strings
     * @param a: An array of Strings that are to be sorted
     * @param W: Fixed length of all Strings
     */
    public static void sort(String[] a, int W) {
        int R = 256;    // radix R is 256 for extended ASCII
        int N = a.length;   // number of Strings to be sorted
        String[] aux = new String[N];

        for (int d = W-1; d >= 0; d--) {
            int[] count = new int[R+1];

            // Step 1: Count frequency of every sort key
            for (int i = 0; i < N; i++) {
                char ch = a[i].charAt(d);   // sort key
                count[(int)(ch) + 1]++;
            }

            // Step 2: Calculate cumulative frequencies of sort keys
            for (int i = 0; i < R; i++) {
                count[i+1] += count[i];
            }

            // Step 3: Use CF to correctly index keys and values
            for (int i = 0; i < N; i++) {
                char ch = a[i].charAt(d);
                aux[count[(int)(ch)]++] = a[i];
            }

            // Step 4: Copy Strings from auxiliary array into original
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }
}
