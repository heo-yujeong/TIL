package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine()) != null) {
            long n = Long.parseLong(input);

            boolean[] num = new boolean[10];
            int cnt = 10;
            int k = 0;

            while (cnt > 0) {
                long value = n * ++k;

                while (value > 0) {
                    int digit = (int) (value % 10);
                    if (!num[digit]) {
                        num[digit] = true;
                        cnt--;
                    }

                    value /= 10;
                }
            }

            System.out.println(k);
        }
    }
}
