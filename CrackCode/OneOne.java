public class OneOne {
    /**
     * Check if a String has all unique characters
     *
     * @param str is the String to be checked
     *
     * @return true if all characters in String are unique, 
     * false otherwise
     */
    public static boolean isUnique(String str) {
        // assume that the String is an extended ASCII
        if (str.length > 256) {
            return false;
        }

        boolean[] characters = new boolean[256];  // keep track of characters that occur
        for (int i = 0; i < str.length; i++) {
            int val = str.charAt(i);
            if (characters[val]) {
                return false;  // this character was already found earlier
            }
            characters[val] = true;
        }

        // no repeating characters found
        return true;
    }
}
