package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ6810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 9 * 1 + 7 * 3 + 8 * 1 + 0 * 3 + 9 * 1 + 2 * 3 + 1 * 1 + 4 * 3 + 1 * 1 + 8 * 3;

        for (int i = 11; i <= 13; i++) {
            int num = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                sum += num * 3;
            } else {
                sum += num;
            }
        }

        System.out.println("The 1-3-sum is " + sum);
    }
}
