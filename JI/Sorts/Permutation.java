import java.util.Arrays;

public class Permutation {
    public static boolean isPermutation(Comparable[] a, Comparable[] b) {
        /** Checks if a and b are permutations of one another
         *
         * Args:
         *   a, b: Arrays of comparables to be checked
         *
         * Returns:
         *   true, if a and b are permutations, false otherwise
         */
        if (a.length != b.length)   return false;
        Arrays.sort(a);
        Arrays.sort(b);

        // check if the 2 arrays are the same
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i]))
                return false;
        }
        return true;
    }
}
