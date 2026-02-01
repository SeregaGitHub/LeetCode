package easy._231_power_of_two;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n > 0) {
            return (n & (n - 1)) == 0;
        }
        return false;
    }
}
