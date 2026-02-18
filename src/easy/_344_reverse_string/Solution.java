package easy._344_reverse_string;

public class Solution {
    public static void main(String[] args) {
        char[] array = {'H', 'e', 'l', 'l', 'o'};

        for (Character c: array) {
            System.out.print(c + " ");
        }

        System.out.println();
        reverseString(array);

        for (Character c: array) {
            System.out.print(c + " ");
        }
    }

    public static void reverseString(char[] s) {

        for (int l = 0, r = s.length - 1; l < r; l++, r--) {
            swap(s, l, r);
        }
    }

    private static void swap(char[] s, int left, int right) {
        char buffer = s[left];
        s[left] = s[right];
        s[right] = buffer;
    }
}
