package easy._28_find_the_index_of_the_first_occurrence_in_a_string;

public class Solution {
    public static void main(String[] args) {
        int index = strStr("issipi", "issipi");
        System.out.println(index);
    }

    public static int strStrLC(String haystack, String needle) {

        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }
        return -1;
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (needle.charAt(0) == haystack.charAt(i)) {
                boolean check = true;
                int needleIndex = 1;
                for (int j = i + 1; j < needle.length() + i; j++) {
                    if (needle.charAt(needleIndex) != haystack.charAt(j)) {
                        check = false;
                        break;
                    }
                    needleIndex++;
                }
                if (check) {
                    return i;
                }
            }
        }
        return -1;
    }
}
