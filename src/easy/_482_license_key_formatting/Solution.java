package easy._482_license_key_formatting;

public class Solution {
    public static void main(String[] args) {

        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
        System.out.println(licenseKeyFormatting("2-4A0r7-4k", 4));
        System.out.println(licenseKeyFormatting("--a-a-a-a--", 2));
        System.out.println(licenseKeyFormatting("-", 1));
        System.out.println(licenseKeyFormatting("012", 1));
    }

    public static String licenseKeyFormatting(String s, int k) {

        StringBuilder builder = new StringBuilder();

        for (int i = s.length() - 1; i >= 0;) {
            int count = k;
            while (count > 0) {
                if (i == -1) break;
                char check = s.charAt(i);

                if (Character.isDigit(check)) {
                    builder.append(check);
                    count--;
                } else if (Character.isLetter(check)) {
                    builder.append(Character.toUpperCase(check));
                    count--;
                } else if (check == '-') {
                    i--;
                    continue;
                }
                i--;
            }
            if (i >= 0) {
                builder.append('-');
            }
        }


        if (builder.isEmpty()) {
            return builder.toString();
        } else {
            int builderLastIndex = builder.length() - 1;
            if (builder.charAt(builderLastIndex) == '-') {
                builder.delete(builderLastIndex, builder.length());
            }
        }

        return builder.reverse().toString();
    }
}
