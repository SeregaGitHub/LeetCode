package easy._66_plus_one;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = plusOne(new int[]{9, 9});
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = 1 + digits[i];

            if (sum == 10 && i > 0) {
                digits[i] = 0;
            } else if (sum == 10) {
                int[] array = new int[digits.length + 1];
                array[0] = 1;
                return array;
            } else {
                digits[i] = sum;
                return digits;
            }
        }
        return digits;
    }
}
