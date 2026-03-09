package easy._485_max_consecutive_ones;

public class Solution {
    public static void main(String[] args) {

        int[] array1 = {1, 1, 0, 1, 1, 1};
        int[] array2 = {1, 0, 1, 1, 0, 1};
        int[] array3 = {1, 0, 1, 1, 1, 1};

        System.out.println(findMaxConsecutiveOnes(array1));
        System.out.println(findMaxConsecutiveOnes(array2));
        System.out.println(findMaxConsecutiveOnes(array3));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {

        int result = 0;
        int count = 0;

        for (int num : nums) {

            if (num == 0) {
                result = Math.max(result, count);
                count = 0;
            } else {
                count++;
            }
        }

        return Math.max(result, count);
    }
}
