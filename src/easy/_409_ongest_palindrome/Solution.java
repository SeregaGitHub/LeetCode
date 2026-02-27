package easy._409_ongest_palindrome;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

        String s1 = "abccccdd";
        String s2 = "a";

        System.out.println(longestPalindrome(s1));
        System.out.println(longestPalindrome(s2));
    }

    public static int longestPalindrome(String s) {

        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));

        int count = 0;

        for (int i = 1; i < s.length(); i++) {
            char check = s.charAt(i);
            if (set.contains(check)) {
                count += 2;
                set.remove(check);
            } else {
                set.add(check);
            }
        }

        return set.isEmpty() ? count : ++count;
    }
}
