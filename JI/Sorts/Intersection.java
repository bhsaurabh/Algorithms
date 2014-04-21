import java.util.Arrays;

public class Intersection {
    public static int count(int[] a, int[] b) {
        /** Counts the number of insertions in set a and set b O(n * logn * logn)
         *
         * Args:
         *   a, b: 2 arrays having the integers, between which intersection is found
         *
         * Returns:
         *   count: number of intersections between a and b
         */
        int count = 0;

        // sort the 2 arrays...use a comparator if needed
        Arrays.sort(a);
        Arrays.sort(b);

        // do a binary search
        for (int i : a) {
            boolean found = search(b, i);
            if (found) {
                count++;
            }
        }
        return count;
    }

    private static boolean search(int[] arr, int a) {
        /** Binary search implementation
         *
         * Args:
         *   arr: Array to search in
         *   a: element to search
         *
         * Returns:
         *   true, if a is found in arr; false otherwise
         */
        int lo = 0, hi = arr.length-1;
        int mid = (lo + hi) / 2;
        while (lo < hi) {
            if (arr[mid] < a) {
                lo = mid + 1;
            }
            else if (arr[mid] > a) {
                hi = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
