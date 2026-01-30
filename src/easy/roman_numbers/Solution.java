package easy.roman_numbers;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        System.out.println(romanToInt("MCMXCIV"));
        //                                MDCCCCLXXXXIIII
        /*

          - I can be placed before V (5) and X (10) to make 4 and 9.
          - X can be placed before L (50) and C (100) to make 40 and 90.
          - C can be placed before D (500) and M (1000) to make 400 and 900

         */
//        String s = "MCMXCIV";
//        System.out.println(s);
//        s=s.replace("IV","IIII");
//        s=s.replace("IX","VIIII");
//        s=s.replace("XL","XXXX");
//        s=s.replace("XC","LXXXX");
//        s=s.replace("CD","CCCC");
//        s=s.replace("CM","DCCCC");
//        System.out.println(s);
    }

    public static int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] array = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char check = s.charAt(i);
            if (i < s.length() - 1) {
                if (check == 'I') {
                    if (s.charAt(i + 1) == 'V') {
                        result += 4;
                        i++;
                    } else if (s.charAt(i + 1) == 'X') {
                        result += 9;
                        i++;
                    } else {
                        result += 1;
                    }
                } else if (check == 'X') {
                    if (s.charAt(i + 1) == 'L') {
                        result += 40;
                        i++;
                    } else if (s.charAt(i + 1) == 'C') {
                        result += 90;
                        i++;
                    } else {
                        result += 10;
                    }
                } else if (check == 'C') {
                    if (s.charAt(i + 1) == 'D') {
                        result += 400;
                        i++;
                    } else if (s.charAt(i + 1) == 'M') {
                        result += 900;
                        i++;
                    } else {
                        result += 100;
                    }
                } else {
                    result += map.get(check);
                }
            } else {
                result += map.get(check);
            }
        }
        return result;
    }
}
