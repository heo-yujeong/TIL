package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[1001];
        // 0: 상근, 1: 창영
        dp[1] = true;
        dp[3] = true;

        for (int i = 5; i <= N; i++) {
            dp[i] = !dp[i - 1] && !dp[i - 3] && !dp[i - 4];
        }

        if (dp[N])
            System.out.println("CY");
        else
            System.out.println("SK");
        br.close();
    }
}
