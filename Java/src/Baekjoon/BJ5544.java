package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ5544 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] point = new int[N + 1];
        int total = N * (N - 1) / 2;

        for (int i = 0; i < total; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            if (C > D) {
                point[A] += 3;
            } else if (C < D) {
                point[B] += 3;
            } else {
                point[A] += 1;
                point[B] += 1;
            }
        }

        int[] rank = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int r = 1;
            for (int j = 1; j <= N; j++) {
                if (point[j] > point[i]) {
                    r++;
                }
            }

            rank[i] = r;
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(rank[i]);
        }
    }
}
