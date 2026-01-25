package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ6751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Y = Integer.parseInt(br.readLine());

        while (true) {
            Y++;
            boolean[] num = new boolean[10];
            int tmp = Y;
            boolean isRepeat = false;

            while (tmp > 0) {
                int digit = tmp % 10;
                if (num[digit]) {
                    isRepeat = true;
                    break;
                }

                num[digit] = true;
                tmp /= 10;
            }

            if (!isRepeat) {
                System.out.println(Y);
                break;
            }
        }
    }
}
