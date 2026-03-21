package alg_tr_ya.first.practic;

import java.io.*;

public class Three {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int count = Integer.parseInt(reader.readLine());
            //int count = 24;
            String str = reader.readLine();
            //String str = "ahahrunawayahahsofasthah";

            printResult(writer, count, str);
        }
    }

    private static void printResult(BufferedWriter writer, int count, String str) throws IOException {

        int result = 0;
        char next = 'h';

        for (int i = 0; i < count; i++) {
            char check = str.charAt(i);
            int newCount = 0;
            if (check == 'a' || check == 'h') {
                if (check == 'a') {
                    next = 'a';
                } else {
                    next = 'h';
                }

                for (int j = i; j < count; j++) {
                    if (str.charAt(j) == next) {
                        newCount++;
                        i++;
                        if (next == 'a') {
                            next = 'h';
                        } else if (next == 'h') {
                            next = 'a';
                        }
                    } else {
                        break;
                    }
                }
                i--;
                result = Math.max(newCount, result);
            }
        }

        writer.write(String.valueOf(result));
    }
}
