package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] unit = {25, 10, 5, 1};


        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int C = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append(C / unit[i]).append(" ");
                C %= unit[i];
            }

            System.out.println(sb);
        }
    }
}
