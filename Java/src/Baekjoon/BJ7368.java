package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ7368 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int[] r = new int[n];
            int[] c = new int[n];
            int[] w = new int[n];
            int[] h = new int[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                r[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
                w[i] = Integer.parseInt(st.nextToken());
                h[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] overlap = new boolean[n];

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (r[i] + h[i] <= r[j] || r[j] + h[j] <= r[i] || c[i] + w[i] <= c[j] || c[j] + w[j] <= c[i]) {
                        continue;
                    }

                    overlap[i] = true;
                    overlap[j] = true;
                }
            }

            int cnt = 0;
            for (boolean b : overlap) {
                if (b) cnt++;
            }

            System.out.println(cnt);
        }
    }
}
