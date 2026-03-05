package easy._448_find_all_numbers_disappeared_in_an_array;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        int[] array = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findDisappearedNumbers(array);
        list.forEach(integer -> System.out.print(integer + " "));

        System.out.println();

        int[] array2 = {1, 1};
        List<Integer> list2 = findDisappearedNumbers(array2);
        list2.forEach(integer -> System.out.print(integer + " "));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>(nums.length);

        int currentIndex = 0;
        while (currentIndex < nums.length) {
            int check = nums[currentIndex];
            if (check != currentIndex + 1 && check != nums[check - 1]) {
                nums[currentIndex] = nums[check - 1];
                nums[check - 1] = check;
            } else {
                currentIndex++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }

        return list;
    }
}
