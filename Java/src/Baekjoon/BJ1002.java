package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double dist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            if (dist == 0) {
                if (r1 == r2) {
                    sb.append(-1);
                } else {
                    sb.append(0);
                }
            } else {
                if (r1 + r2 == dist || Math.abs(r1 - r2) == dist) {
                    sb.append(1);
                } else if (Math.abs(r1 - r2) < dist && dist < r1 + r2) {
                    sb.append(2);
                } else {
                    sb.append(0);
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
