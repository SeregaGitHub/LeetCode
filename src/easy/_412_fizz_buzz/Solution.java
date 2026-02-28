package easy._412_fizz_buzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        System.out.println(fizzBuzz(3));
        System.out.println(fizzBuzz(5));
        System.out.println(fizzBuzz(15));

    }

    public static List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String str;

            if (i % 15 == 0) {
                str = "FizzBuzz";
            } else if (i % 3 == 0) {
                str = "Fizz";
            } else if (i % 5 == 0) {
                str = "Buzz";
            } else {
                str = String.valueOf(i);
            }

            result.add(str);
        }
        return result;
    }
}
