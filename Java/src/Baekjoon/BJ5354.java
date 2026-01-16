package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ5354 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringBuilder sb = new StringBuilder();
            int J = Integer.parseInt(br.readLine());

            for (int i = 0; i < J; i++) {
                for (int j = 0; j < J; j++) {
                    if (i == 0 || i == J - 1 || j == 0 || j == J - 1) {
                        sb.append("#");
                    } else {
                        sb.append('J');
                    }
                }
                sb.append('\n');
            }

            System.out.println(sb);
        }

        System.out.println('\n');
    }
}
