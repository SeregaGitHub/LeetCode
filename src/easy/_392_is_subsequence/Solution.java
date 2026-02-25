package easy._392_is_subsequence;

public class Solution {
    public static void main(String[] args) {

        String s = "abc";
        String t = "ahbgdc";
        String ss = "axc";
        String tt = "ahbgdc";
        String sss = "abc";
        String ttt = "ahbgdcxwz";

        System.out.println(isSubsequence(s, t));      // true
        System.out.println(isSubsequence(ss, tt));    // false
        System.out.println(isSubsequence(sss, ttt));  // true
    }

    public static boolean isSubsequence(String s, String t) {

        int index = 0;

        for (int i = 0; i < t.length(); i++) {

            if (index == s.length()) return true;

            if (t.charAt(i) == s.charAt(index)) {
                index++;
            }
        }

        return index == s.length();
    }
}
