package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ6161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] R = new int[N];

        for (int i = 0; i < N; i++) {
            R[i] = Integer.parseInt(br.readLine());
        }

        for (int t = 0; t < T; t++) {
            int idx = 0;
            for (int i = 1; i < N; i++) {
                if (R[i] > R[idx]) {
                    idx = i;
                }
            }

            sb.append(idx + 1).append("\n");

            int rating = R[idx];
            R[idx] = 0;

            if (N == 1) continue;

            int share = rating / (N - 1);
            int extra = rating % (N - 1);

            for (int i = 0; i < N; i++) {
                if (i == idx) continue;
                R[i] += share;
            }

            for (int i = 0; i < N && extra > 0; i++) {
                if (i == idx) continue;
                R[i]++;
                extra--;
            }
        }

        System.out.println(sb);
    }
}
