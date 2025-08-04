package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14889 {
    static int N;
    static int[][] S;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visit = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    private static void dfs(int idx, int cnt) {
        if (cnt == N/2) {
            calc();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i+1, cnt+1);
                visit[i] = false;
            }
        }
    }

    private static void calc() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if (visit[i] == true && visit[j] == true) {
                    start += S[i][j];
                    start += S[j][i];
                } else if (visit[i] == false && visit[j] == false) {
                    link += S[i][j];
                    link += S[j][i];
                }
            }
        }

        min = Math.min(min, Math.abs(start - link));
    }
}
