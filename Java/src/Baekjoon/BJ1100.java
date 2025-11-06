package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0 && j % 2 == 0 && line.charAt(j) == 'F') {
                    cnt++;
                }

                if (i % 2 != 0 && j % 2 != 0 && line.charAt(j) == 'F') {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
