package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ15723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] prop = new boolean[26][26];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" is ");
            char a = str[0].charAt(0);
            char b = str[1].charAt(0);

            prop[a - 'a'][b - 'a'] = true;
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (prop[i][k] && prop[k][j]) {
                        prop[i][j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] str = br.readLine().split(" is ");
            char a = str[0].charAt(0);
            char b = str[1].charAt(0);

            sb.append(prop[a - 'a'][b - 'a'] ? "T\n" : "F\n");
        }

        System.out.println(sb);
        br.close();
    }
}
