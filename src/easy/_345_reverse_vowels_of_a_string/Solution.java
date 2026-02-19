package easy._345_reverse_vowels_of_a_string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String str = "IceCreAm";
        String newStr = reverseVowels(str);
        System.out.println(newStr);
    }

    public static String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        char[] chars = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (!set.contains(s.charAt(left))) {
                left++;
            } else {
                if (set.contains(s.charAt(right))) {
                    swap(chars, left, right);
                    left++;
                }
                right--;
            }
        }

        return new String(chars);
    }

    private static void swap(char[] chars, int left, int right) {
        char buffer = chars[left];
        chars[left] = chars[right];
        chars[right] = buffer;
    }
}
