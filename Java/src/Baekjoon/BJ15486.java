package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] counsel = new int[N+2][2];
        int[] dp = new int[N+2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            counsel[i][0] = T;
            counsel[i][1] = P;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N+1; i++) {
            max = Math.max(max, dp[i]);

            int next = i + counsel[i][0];
            if (next < N+2) {
                dp[next] = Math.max(dp[next], max + counsel[i][1]);
            }
        }

        System.out.println(dp[N+1]);
    }
}
