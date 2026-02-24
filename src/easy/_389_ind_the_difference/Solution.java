package easy._389_ind_the_difference;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        String s = "abcd";
        String t = "abcde";

        System.out.println(findTheDifference(s, t));
    }

    public static char findTheDifference(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            map.put(current, map.getOrDefault(current, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char current = t.charAt(i);
            int count = map.getOrDefault(current, 0);
            if (count == 0) {
                return current;
            }
            map.put(current, --count);
        }
        return 0;
    }
}
