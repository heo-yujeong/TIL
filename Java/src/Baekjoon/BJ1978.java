package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean isSosu = true;

            if (num == 1) continue;

            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    isSosu = false;
                    break;
                }
            }

            if (isSosu) cnt++;
        }

        System.out.println(cnt);
    }
}
