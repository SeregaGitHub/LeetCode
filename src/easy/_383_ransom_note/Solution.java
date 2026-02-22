package easy._383_ransom_note;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char check = magazine.charAt(i);
            map.put(check, map.getOrDefault(check, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char check = ransomNote.charAt(i);
            int count = map.getOrDefault(check, 0);

            if (count == 0) {
                return false;
            } else {
                map.put(check, --count);
            }
        }

        return true;
    }
}
