package easy._434_number_of_segments_in_a_string;

public class Solution {
    public static void main(String[] args) {

        System.out.println(countSegments("Hello, my name is John"));
        System.out.println(countSegments("Hello"));
        System.out.println(countSegments(""));
        System.out.println(countSegments(null));
        System.out.println(countSegments("                 "));
        System.out.println(countSegments(", , , ,        a, eaefa"));
    }

    public static int countSegments(String s) {

        if (s == null || s.isEmpty()) return 0;

        int result = 0;
        boolean enableIncrement = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && !enableIncrement) {
                enableIncrement = true;
            } else if (s.charAt(i) != ' ' && enableIncrement) {
                result++;
                enableIncrement = false;
            }
        }

        return result;
    }
}
