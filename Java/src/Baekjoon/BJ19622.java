package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ19622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meeting = new int[N+1][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
            meeting[i][2] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[N+1];
        dp[0] = meeting[0][2];
        dp[1] = Math.max(dp[0], meeting[1][2]);

        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i-2] + meeting[i][2], dp[i-1]);
        }

        System.out.println(dp[N-1]);
        br.close();
    }
}
