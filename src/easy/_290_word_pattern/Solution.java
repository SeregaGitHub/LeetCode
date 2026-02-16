package easy._290_word_pattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        System.out.println(wordPattern("abba", "dog cat cat dog"));   // true
        System.out.println(wordPattern("abba", "dog cat cat fish"));  // false
        System.out.println(wordPattern("abba", "dog dog dog dog"));   // false
        System.out.println(wordPattern("aaa", "dog dog dog dog"));    // false
        System.out.println(wordPattern("aaa", "dog dog dog"));        // true
        System.out.println(wordPattern("qwerty", "qwerty"));          // false
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int leftIndex = 0;
            int rightIndex = 0;

            while (rightIndex <= s.length()) {
                if (rightIndex == s.length() || s.charAt(i) == ' ') {
                    String subStr = s.substring(leftIndex, rightIndex);
                    String check;

                    if (count < pattern.length()) {
                        check = map.get(pattern.charAt(count));
                    } else {
                        return false;
                    }

                    if (check == null) {
                        if (map.containsValue(subStr)) {
                            return false;
                        } else {
                            map.put(pattern.charAt(count), subStr);
                        }
                    } else {
                        if (!check.equals(subStr)) {
                            return false;
                        }
                    }

                    leftIndex = i + 1;
                    count++;
                }
                rightIndex++;
                i++;
            }
        }
        return count == pattern.length();
    }
}
