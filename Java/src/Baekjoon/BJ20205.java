package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < N; j++) {
                int pixel = Integer.parseInt(st.nextToken());
                for (int k = 0; k < K; k++) {
                    sb.append(pixel).append(" ");
                }
            }

            for (int k = 0; k < K; k++) {
                result.append(sb).append("\n");
            }
        }

        System.out.println(result);
    }
}
