package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ25956 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] l = new int[N];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            l[i] = Integer.parseInt(br.readLine());

            if (i == 0 && l[i] != 1) {
                System.out.println(-1);
                return;
            }

            if (i > 0 && l[i-1]+1 < l[i]) {
                System.out.println(-1);
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = i+1; j < N; j++) {
                if (l[j] == l[i] + 1) {
                    cnt++;
                }
                if (l[j] == l[i]) {
                    break;
                }
            }
            result[i] = cnt;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
