package easy._349_intersection_of_two_arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums1).forEach(set::add);

        Set<Integer> result = new HashSet<>();

        for (Integer i: nums2) {
            if (set.contains(i)) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(Number::intValue).toArray();
    }
}
