package easy._415_add_strings;

public class Solution {
    public static void main(String[] args) {
        String num1  ="11";
        String num2  ="123";

        String num11  ="11";
        String num22  ="22";

        String num111  ="0";
        String num222  ="0";

        String num1111  ="555";
        String num2222  ="555";

        String num11111  ="9";
        String num22222  ="99";

        System.out.println(addStrings(num1, num2));
        System.out.println(addStrings(num11, num22));
        System.out.println(addStrings(num111, num222));
        System.out.println(addStrings(num1111, num2222));
        System.out.println(addStrings(num11111, num22222));
    }

    public static String addStrings(String num1, String num2) {

        int num1Index = num1.length() - 1;
        int num2Index = num2.length() - 1;
        int count = Math.max(num1.length(), num2.length()) + 1;

        StringBuilder stringBuilder = new StringBuilder();
        int nextNumber = 0;

        while (count > 0) {
            int num1Current = 0;
            int num2Current = 0;

            if (num1Index >= 0) {
                num1Current = Integer.parseInt(String.valueOf(num1.charAt(num1Index)));
            }
            if (num2Index >= 0) {
                num2Current = Integer.parseInt(String.valueOf(num2.charAt(num2Index)));
            }

            int sum = num1Current + num2Current;
            int current = (sum % 10) + nextNumber;

            if (num1Index >= 0 || num2Index >= 0 || nextNumber == 1) {
                if (current == 10) {
                    current = 0;
                    nextNumber = 1;
                    stringBuilder.append(current);
                } else {
                    stringBuilder.append(current);
                    nextNumber = sum / 10;
                }
            }
            count--;
            num1Index--;
            num2Index--;
        }

        return stringBuilder.reverse().toString();
    }
}
