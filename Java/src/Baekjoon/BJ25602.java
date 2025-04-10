package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ25602 {
    static int N, K;
    static int[] A;
    static int[][] R;
    static int[][] M;
    static int maxSatisfaction = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        R = new int[K][N];
        M = new int[K][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                R[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack(0, 0);
        System.out.println(maxSatisfaction);
    }

    private static void backtrack(int day, int satisfaction) {
        if (day == K) {
            maxSatisfaction = Math.max(maxSatisfaction, satisfaction);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (A[i] <= 0) {
                continue;
            }

            A[i]--;
            for (int j = 0; j < N; j++) {
                if (A[j] <= 0) {
                    continue;
                }

                A[j]--;
                backtrack(day+1, satisfaction+R[day][i]+M[day][j]);
                A[j]++;
            }
            A[i]++;
        }
    }
}
