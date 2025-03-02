package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N][N];
        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = board[i][j];
                if (cnt == 0) break;
                if (i + cnt < N) {
                    dp[i+ cnt][j] += dp[i][j];
                }
                if (j + cnt < N) {
                    dp[i][j+ cnt] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N-1][N-1]);
        br.close();
    }
}
