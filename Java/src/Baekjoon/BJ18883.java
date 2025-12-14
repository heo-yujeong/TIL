package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int num = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M-1; j++) {
                sb.append(num).append(" ");
                num++;
            }

            sb.append(num).append("\n");
            num++;
        }

        System.out.println(sb);
    }
}
