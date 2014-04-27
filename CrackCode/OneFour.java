public class OneFour {
    /**
     * Replace all spaces in a String by %20
     *
     * @param str is the String where spaces are to be replaced
     */
    public static void replace(char[] str, int length) {
        int spacesCount = 0;
        int newLength;

        for (int i = 0; i < length; i++) {
            if (str[i].equals(' ')) {
                spacesCount++;
            }
        }

        newLength = length + (spacesCount*2);
        str[newLength] = '\0';
        for (int i = length-1; i >= 0; i--) {
            if (str[i].equals(' ')) {
                str[newLength-1] = '0';
                str[newLength-2] = '2';
                str[newLength-3] = '%';
                newLength -= 3;
            } else {
                str[newLength-1] = str[i];
                newLength -= 1;
            }
        }
    }
}
