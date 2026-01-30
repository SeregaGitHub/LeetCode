package easy._205_isomorphic_strings;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char val = t.charAt(i);
            char check = map.getOrDefault(key, val);

            if (check != val || (map.containsValue(val) && !map.containsKey(key))) {
                return false;
            }

            map.put(key, check);
        }

        return true;
    }
}
