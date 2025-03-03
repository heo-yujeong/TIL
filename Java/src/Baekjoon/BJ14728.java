package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] problem = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            problem[i][0] = Integer.parseInt(st.nextToken());
            problem[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][T+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= T; j++) {
                if (j >= problem[i][0]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-problem[i][0]]+problem[i][1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][T]);
        br.close();
    }
}
