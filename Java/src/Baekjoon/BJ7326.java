package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ7326 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == y) {
                if (x % 2 == 0) {
                    sb.append(x * 2);
                } else {
                    sb.append(x * 2 - 1);
                }
            } else if (x == y + 2) {
                if (x % 2 == 0) {
                    sb.append(x * 2 - 2);
                } else {
                    sb.append(x * 2 - 3);
                }
            } else {
                sb.append("No Number");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
