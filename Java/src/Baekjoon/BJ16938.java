package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16938 {
    static int N, L, R, X;
    static int[] A;
    static boolean[] visit;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        A = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= N; i++) {
            backtrack(0, i);
        }

        System.out.println(result);
    }

    private static void backtrack(int idx, int cnt) {
        if (cnt == 0) {
            int sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                if (visit[i]) {
                    sum += A[i];
                    min = Math.min(min, A[i]);
                    max = Math.max(max, A[i]);
                }
            }

            if (sum >= L && sum <= R && max-min >= X) {
                result++;
            }
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                backtrack(i+1, cnt-1);
                visit[i] = false;
            }
        }
    }
}
