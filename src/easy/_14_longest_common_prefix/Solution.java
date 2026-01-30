package easy._14_longest_common_prefix;

public class Solution {
    public static void main(String[] args) {
        String result = longestCommonPrefix(new String[] {"dog", "racecar", "car"});
        System.out.println(result);
    }

    private static String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();

        int len = strs.length;
        int minWordLen = Integer.MAX_VALUE;

        for (String str : strs) {
            minWordLen = Math.min(minWordLen, str.length());
        }

        outer:
        for (int i = 0; i < minWordLen; i++) {
            char check = strs[0].charAt(i);

            for (int j = 1; j < len; j++) {
                if (strs[j].charAt(i) != check) {
                    break outer;
                }
            }
            builder.append(check);
        }
        return builder.toString();
    }
}
