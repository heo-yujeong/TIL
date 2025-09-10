package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int min = N;
        int sum = 0;

        for (int i = M; i <= N; i++) {
            boolean isSosu = true;
            if (i == 1) {
                isSosu = false;
            }

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isSosu = false;
                    break;
                }
            }

            if (isSosu) {
                if (min > i) {
                    min = i;
                }
                sum += i;
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
