package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ14468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] pos1 = new int[26];
        int[] pos2 = new int[26];

        for (int i = 0; i < 52; i++) {
            int idx = input.charAt(i) - 'A';
            if (pos1[idx] == 0) {
                pos1[idx] = i+1;
            } else {
                pos2[idx] = i+1;
            }
        }

        int cnt = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (pos1[i] < pos1[j] && pos1[j] < pos2[i] && pos2[i] < pos2[j]) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
