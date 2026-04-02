package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ5987 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int Z = Integer.parseInt(br.readLine());
        for (int i = 0; i < Z; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            String cur = str;
            for (int j = 0; j < C; j++) {
                String suf = cur.substring(N);
                cur = suf + cur;
            }

            sb.append(cur).append("\n");
        }

        System.out.println(sb);
    }
}
