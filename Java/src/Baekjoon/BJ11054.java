package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] l_dp = new int[N];
        int[] r_dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            r_dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && r_dp[i] < r_dp[j]+1) {
                    r_dp[i] = r_dp[j]+1;
                }
            }
        }

        for (int i = N-1; i >= 0; i--) {
            l_dp[i] = 1;

            for (int j = N-1; j > i; j--) {
                if (A[i] > A[j] && l_dp[i] < l_dp[j]+1) {
                    l_dp[i] = l_dp[j]+1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < r_dp[i] + l_dp[i]) {
                max = r_dp[i] + l_dp[i];
            }
        }

        System.out.println(max - 1);
    }
}
