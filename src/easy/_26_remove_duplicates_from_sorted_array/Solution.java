package easy._26_remove_duplicates_from_sorted_array;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int result = removeDuplicatesLC(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(result);
    }

    public static int removeDuplicatesLC(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                continue;
            } else {
                arr[count] = arr[i];
                count++;
            }
        }
        return count;
    }

    public static int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (list.get(list.size() - 1) < nums[i]) {
                list.add(nums[i]);
            }
        }
        Arrays.fill(nums, 0);
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            nums[i] = list.get(i);
        }
        return listSize;
    }
}
