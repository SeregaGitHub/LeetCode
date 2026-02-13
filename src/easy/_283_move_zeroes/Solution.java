package easy._283_move_zeroes;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        int[] array = {0, 1, 0, 3, 12};
        int[] arr = {0, 0, 1, 2, 3, 0, 0, 0, 4, 12, 0, 0};

        moveZeroes(array);
        Arrays.stream(array).forEach(i -> System.out.print(i + " "));
        System.out.println();
        moveZeroes(arr);
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
    }

    public static void moveZeroes(int[] nums) {

        int zeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, zeroIndex, i);
                zeroIndex++;
            }
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int buffer = nums[left];
        nums[left] = nums[right];
        nums[right] = buffer;
    }
}
