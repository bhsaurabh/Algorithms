public class KeyIndexedCounting {
    /** Linear time, Linear extra space, non-comparison based sort
     * @param a: Array to be sorted
     * @param R: number of classes the values of the array take
     */
    public static void sort(int[] a, int R) {
        int N = a.length;
        int[] freq = new int[R+1];
        int[] aux = new int[N];

        // Step 1: Count freuqncy of each integer using key as index 
        for (int i = 0; i < N; i++) {
            freq[a[i]+1]++;
        }

        // Step 2: Calculate cumulative frequencies of keys
        for (int i = 0; i < R; i++) {
            freq[i+1] += freq[i];
        }

        // Step 3: Input keys in correct order in an auxilliary array
        for (int i = 0; i < N; i++) {
            // also increment cumulative frequencies everytime an insertion is made
            aux[freq[a[i]]] = a[i];
            freq[a[i]]++;
        }

        // Step 4: Copy elements from auxilliary array to original array
        for (int i = 0; i < N; i++) {
            a[i] = aux[i];
        }
    }
}
