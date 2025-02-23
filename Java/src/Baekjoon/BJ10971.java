package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10971 {
    static int N;
    static int[][] W;
    static boolean[] visit;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        W = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            visit[i] = true;
            backtrack(i, i, 0, 0);
        }

        System.out.println(minValue);
        br.close();
    }

    private static void backtrack(int start, int now, int depth, int cost) {
        if (depth == N-1) {
            if (W[now][start] != 0) {
                cost += W[now][start];
                minValue = Math.min(minValue, cost);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i] && W[now][i] > 0) {
                visit[i] = true;
                backtrack(start, i, depth+1, cost+W[now][i]);
                visit[i] = false;
            }
        }
    }
}
