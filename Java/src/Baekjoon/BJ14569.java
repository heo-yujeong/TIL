package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        long[] subject = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            long bitMask = 0;

            for (int j = 0; j < k; j++) {
                int t = Integer.parseInt(st.nextToken());
                bitMask |= 1L << t;
            }
            subject[i] = bitMask;
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            long freeTimeMask = 0;

            for (int j = 0; j < p; j++) {
                int q = Integer.parseInt(st.nextToken());
                freeTimeMask |= 1L << q;
            }

            int cnt = 0;
            for (long sub : subject) {
                if ((sub & freeTimeMask) == sub) {
                    cnt++;
                }
            }

            sb.append(cnt + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}
