package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ5751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            st = new StringTokenizer(br.readLine());
            int Mary = 0;
            int John = 0;

            for (int i = 0; i < N; i++) {
                int R = Integer.parseInt(st.nextToken());
                if (R == 0) {
                    Mary++;
                } else {
                    John++;
                }
            }

            System.out.println("Mary won " + Mary + " times and John won " + John + " times");
        }
    }
}
