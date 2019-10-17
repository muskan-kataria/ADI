import java.util.Arrays;
class LongestRepeatedSubstring {

    public static String get(String s,String[] suffies) {
        int n = s.length();

        /** Creating suffix array **/
       suffies = new String[n];
        for (int i = 0; i < n; i++) {
            suffies[i] = s.substring(i);
        }

        /** Sorting suffix array **/
        Arrays.sort(suffies);

        for (int i =0 ; i < suffies.length; i++){
            System.out.println(i + " :: " + suffies[i] );
        }
        String result = "";

        /** Finding longest common prefix **/
        for (int i = 0; i < n - 1; i++) {
            int len = getLongestCommonPrefix(suffies[i], suffies[i + 1]);

            if (len > result.length()) {
                result = suffies[i].substring(0, len);
            }
        }

        return result;
    }

    public static int getLongestCommonPrefix(String s1, String s2) {
        int len = 0;
        for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {
            if (s1.charAt(i) != s2.charAt(j)){
                break;
            }
            len++;
        }

        return len;
    }
}


class LongestRepeatedSubstringTest {
	 static String[] suffies;
    public static void main(String[] args) {
        //String s = "ask not what your country can do for you but what you can do for your country";
        String s="banana";
        String longestSuffix = LongestRepeatedSubstring.get(s,suffies);

        System.out.println("String :" + s);
        System.out.println("Longest Suffix String: " + longestSuffix);

	}
}