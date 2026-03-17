package alg_tr_ya.first.theory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class H {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int a = Integer.parseInt(reader.readLine());
            int b = Integer.parseInt(reader.readLine());
            int c = Integer.parseInt(reader.readLine());

            //  a*x + b = c
            // -2*3 + 31 = 25
            int k = c * c;
            if (c < 0) {
                writer.write("NO SOLUTION");
            } else if (a == 0) {
                if (k == b) {
                    writer.write("MANY SOLUTIONS");
                } else {
                    writer.write("NO SOLUTION");
                }
            } else {
                int ax = k - b;
                if (ax % a == 0) {
                    int x = ax / a;
                    writer.write(String.valueOf(x));
                } else {
                    writer.write("NO SOLUTION");
                }
            }
        }
    }
}
