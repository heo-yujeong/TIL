package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            if (N == 1 || N == 2 || N == 3) System.out.println(1);
            else System.out.println(P(N));
        }
    }

    private static long P(int N) {
        long[] dp = new long[N + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        return dp[N];
    }
}
