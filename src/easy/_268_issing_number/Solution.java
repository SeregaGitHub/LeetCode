package easy._268_issing_number;

public class Solution {
    public static void main(String[] args) {
        int[] array = {8, 6, 5, 1, 0, 2, 4, 7};

        int result = missingNumber(array);
        System.out.println(result);
    }

    public static int missingNumber(int[] nums) {
        int result = 0;
        int xSum = 0;
        int ySum = 0;

        for (int i = 0, y = 1; i < nums.length; i++, y++) {
            xSum += nums[i];
            ySum += y;
        }

        result = ySum - xSum;
        return result;
    }
}
