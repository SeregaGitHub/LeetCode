package alg_tr_ya.first.theory_first;

import java.io.*;

public class I {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int blueShirt = Integer.parseInt(reader.readLine());
            int redShirt = Integer.parseInt(reader.readLine());
            int blueSocks = Integer.parseInt(reader.readLine());
            int redSocks = Integer.parseInt(reader.readLine());

//            int blueShirt = 1;
//            int redShirt = 0;
//            int blueSocks = 1;
//            int redSocks = 0;

            int bestShirt = Integer.MIN_VALUE;
            int bestSocks = Integer.MIN_VALUE;
            int bestSum = Integer.MAX_VALUE;

            // Вариант 1: все майки одного цвета (любого), носок один
            if (blueShirt > 0 && redShirt > 0) {
                int Shirt = Math.max(blueShirt, redShirt) + 1;
                int Socks = 1;
                    int sum = Shirt + Socks;
                    if (sum < bestSum) {
                        bestSum = sum;
                        bestShirt = Shirt;
                        bestSocks = Socks;
                    }
            }

            // Вариант 2: синие майки + синие носки (требуются красные майки и красные носки)
            if (redShirt > 0 && redSocks > 0) {
                int Shirt = blueShirt + 1;
                int Socks = blueSocks + 1;
                    int sum = Shirt + Socks;
                    if (sum < bestSum) {
                        bestSum = sum;
                        bestShirt = Shirt;
                        bestSocks = Socks;
                    }
            }

            // Вариант 3: красные майки + красные носки (требуются синие майки и синие носки)
            if (blueShirt > 0 && blueSocks > 0) {
                int Shirt = redShirt + 1;
                int Socks = redSocks + 1;
                    int sum = Shirt + Socks;
                    if (sum < bestSum) {
                        bestSum = sum;
                        bestShirt = Shirt;
                        bestSocks = Socks;
                    }
            }

            // Вариант 4: одна майка, все носки одного цвета
            if (blueSocks > 0 && redSocks > 0) {
                int Shirt = 1;
                int Socks = Math.max(blueSocks, redSocks) + 1;
                    int sum = Shirt + Socks;
                    if (sum < bestSum) {
                        bestSum = sum;
                        bestShirt = Shirt;
                        bestSocks = Socks;
                    }
            }

            writer.write(bestShirt + " " + bestSocks);

            // 6  6 0 0 0 2 4 4 6 2  1  2  3
            // 2  2 1 1 1 2 2 0 6 2  1  2  2
            // 7  3 0 0 2 2 2 2 1 3  1  1  1
            // 3  7 1 5 5 2 4 0 2 3  1  1  1
        }
    }
}
