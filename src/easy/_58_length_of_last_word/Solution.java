package easy._58_length_of_last_word;

public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("moon  "));
    }

    public static int lengthOfLastWord(String s) {
        int result = 0;

        outside:
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isLetter(s.charAt(i))) {
                result++;
                i--;
                while (i >= 0) {
                    if (!Character.isLetter(s.charAt(i))) {
                        break outside;
                    }
                    result++;
                    i--;
                }
            }
        }
        return result;
    }
}
