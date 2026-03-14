package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ4580 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            int prev = 0;

            for (int i = 0; i < k; i++) {
                int p = Integer.parseInt(st.nextToken());
                int cnt = p - prev;

                for (int j = 0; j < cnt; j++) {
                    sb.append(i + 1).append(" ");
                }

                prev = p;
            }

            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
