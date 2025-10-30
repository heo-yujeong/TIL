package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[41];
        dp[1] = 1;
        for (int i = 2; i <= 40; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                sb.append(1).append(" ").append(0).append("\n");
                continue;
            }

            sb.append(dp[N-1]).append(" ").append(dp[N]).append("\n");
        }

        System.out.println(sb);
    }
}
