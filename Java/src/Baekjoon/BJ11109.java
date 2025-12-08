package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            int serial = n * s;
            int parallel = (n * p) + d;

            if (serial < parallel) {
                sb.append("do not parallelize").append("\n");
            } else if (serial == parallel) {
                sb.append("does not matter").append("\n");
            } else {
                sb.append("parallelize").append("\n");
            }
        }

        System.out.println(sb);
    }
}
