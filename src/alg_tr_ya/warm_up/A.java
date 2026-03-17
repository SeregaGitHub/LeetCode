package alg_tr_ya.warm_up;

import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String code = reader.readLine();
            StringBuilder builder = new StringBuilder();
            int x = 96;

            for (int i = code.length() - 1; i >= 0; i--) {
                char check = code.charAt(i);
                int currentInt;

                if (check == '#') {
                    currentInt = Integer.parseInt(code.substring(i - 2, i));
                    i -= 2;
                } else {
                    currentInt = Integer.parseInt(String.valueOf(code.charAt(i)));
                }

                char letter = (char) (x + currentInt);
                builder.append(letter);
            }

            String result = builder.reverse().toString();
            writer.write(result);
        }
    }
}
