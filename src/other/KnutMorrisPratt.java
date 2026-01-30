package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnutMorrisPratt {
    public static void main(String[] args) {
        String text =    "aabaabaaaaaabaabaabaabbaaab";
        String pattern = "aabaab";

        String text2 =    "гогогольгоголь";
        String pattern2 = "гоголь";
        String pattern3 =   "гоголь";

        int[] arr = prefFunction(pattern2);
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));

        System.out.println();

        List<Integer> result = KMPSearch(text2, pattern2);
        result.forEach(integer -> System.out.print(integer + " "));

    }

    private static List<Integer> KMPSearch(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int[] prefixFunction = prefFunction(pattern);

        int textIndex = 0;
        int patternIndex = 0;

        while (textIndex < text.length()) {
            if (text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                textIndex++;
                patternIndex++;
            }
            if (patternIndex == pattern.length()) {
                result.add(textIndex - patternIndex);
                patternIndex = prefixFunction[patternIndex - 1];
            } else if (textIndex < text.length() && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
                if (patternIndex != 0) {
                    patternIndex = prefixFunction[patternIndex - 1];
                } else {
                    textIndex = textIndex + 1;
                }
            }
        }

        return result;
    }

    private static int[] prefFunction(String str) {
        int n = str.length();
        int[] pi = new int[n];
        pi[0] = 0;
        for (int i = 1; i < n; i++) {
            int k = pi[i-1];
            while (k > 0 && str.charAt(k) != str.charAt(i)) {
                k = pi[k-1];
            }
            if (str.charAt(k) == str.charAt(i)) {
                k++;
            }
            pi[i] = k;
        }
        return pi;
    }
}
