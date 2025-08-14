package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1463 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        System.out.println(calc(N));
    }

    private static int calc(int N) {
        if (N == 1) return 0;

        if (dp[N] == 0) {
            if (N % 6 == 0) {
                dp[N] = Math.min(calc(N-1), Math.min(calc(N/3), calc(N/2))) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(calc(N/3), calc(N-1)) + 1;
            } else if (N % 2 == 0) {
                dp[N] = Math.min(calc(N/2), calc(N-1)) + 1;
            } else {
                dp[N] = calc(N-1) + 1;
            }
        }

        return dp[N];
    }
}
