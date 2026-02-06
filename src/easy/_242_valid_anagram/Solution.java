package easy._242_valid_anagram;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int count = map.getOrDefault(currentChar, 0);
            map.put(currentChar, ++count);
        }

        for (int i = 0; i < t.length(); i++) {
            char currentChar = t.charAt(i);
            int count = map.getOrDefault(currentChar, 0);

            if (count == 0) {
                return false;
            } else {
                map.put(currentChar, --count);
            }
        }
        return true;
    }
}
