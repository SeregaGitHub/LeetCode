package easy._387_first_unique_character_in_a_string;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        System.out.println(firstUniqChar("leetcode"));      // 0
        System.out.println(firstUniqChar("loveleetcode"));  // 2
        System.out.println(firstUniqChar("aabb"));          // -1
        System.out.println(firstUniqChar("aadadaad"));      // -1
    }

    public static int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
