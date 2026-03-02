package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int a = 1; a <= N/3; a++) {
            for (int b = a; b <= (N-a)/2; b++) {
                int c = N - a - b;

                if (a + b > c) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
