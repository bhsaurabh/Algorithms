public class InversionsTest {
    /* Testing set for number of inversions */
    public static void main(String[] args) {
        Integer[] a = {1,3,5,2,4,6};
        int numInversions = Inversions.countInversions(a);
        System.out.println(numInversions);
    }
}
