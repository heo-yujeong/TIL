package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15661 {
    static int N;
    static int[][] S;
    static boolean[] visit;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack(0, 0);
        System.out.println(result);
        br.close();
    }

    static void backtrack(int depth, int idx) {
        if (depth == N) {
            int start = 0;
            int link = 0;
            int startCnt = 0;
            int linkCnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    if (visit[i] == visit[j]) {
                        if (visit[i]) {
                            start += S[i][j] + S[j][i];
                            startCnt++;
                        } else {
                            link += S[i][j] + S[j][i];
                            linkCnt++;
                        }
                    }
                }
            }

            if (startCnt == 0 || linkCnt == 0) {
                return;
            }

            if (result > Math.abs(start-link)) {
                result = Math.abs(start-link);
            }
            return;
        }

        visit[depth] = true;
        backtrack(depth+1, idx);
        visit[depth] = false;
        backtrack(depth+1, idx);
    }
}
