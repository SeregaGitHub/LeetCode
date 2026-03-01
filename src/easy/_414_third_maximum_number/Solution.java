package easy._414_third_maximum_number;

public class Solution {
    public static void main(String[] args) {

        int[] array1 = {3, 2, 1};
        int[] array2 = {1, 2};
        int[] array3 = {2, 2, 3, 1};
        int[] array4 = {1, 2, -2147483648};

        System.out.println(thirdMax(array1));  // 1
        System.out.println(thirdMax(array2));  // 2
        System.out.println(thirdMax(array3));  // 1
        System.out.println(thirdMax(array4));  // -2147483648
    }

    public static int thirdMax(int[] nums) {

        Integer first = null;
        Integer second = null;
        Integer third = null;

        for (Integer check : nums) {

            if (!check.equals(first) && !check.equals(second) && !check.equals(third)) {

                if (third == null || check > third) third = check;

                if (second == null || third > second) {
                    int buffer = third;
                    third = second;
                    second = buffer;
                }

                if (first == null || second > first) {
                    int buffer = second;
                    second = first;
                    first = buffer;
                }
            }
        }

        return third != null ? third : first;
    }
}
