import java.util.Arrays;

public class OneThree {
    /**
     * Given 2 strings decide if they are permutations of one another
     *
     * @param str1 and str2 are the 2 strings that are to be checked
     *
     * @return true, if str1 and str2 are permutations,
     * false otherwise
     */
    public static boolean arePermutations(String s1, String s2) {
        // if they are permutations, they should have same length
        if (s1.length != s2.length) {
            return false;
        }

        // if they are permutations, they should be the same strings upon sorting
        String s1Sorted = sort(s1);
        String s2Sorted = sort(s2);

        return s1Sorted.equals(s2Sorted);
    }

    private static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    /**
     * Alternate implementation to finding of 2 Strings are permutations
     *
     * @param str1 is the 1st String
     * @param str2 is the 2nd String
     *
     * @return true if str1 and str2 are permutaions, false otherwise
     */
    public static boolean isPermutation(String s1, String s2) {
        if (s1.length != s2.length) {
            return false;
        }

        // maintain character counts in a hash/array
        // assume extended ASCII
        int[] characters = new int[256];

        for (int i = 0; i < s1.length; i++) {
            int val = (int)(s1.charAt(i));
            characters[val]++;
        }

        // now check if s2 has the same characters
        for (int i = 0; i < s2.length; i++) {
            int val = (int)(s2.charAt(i));
            if (characters[val] == 0) {
                return false;
            }
            characters[val]--;
        }

        return true;
    }
}
