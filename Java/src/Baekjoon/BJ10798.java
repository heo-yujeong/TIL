package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[5][15];
        int maxLen = 0;

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            if (str.length() > maxLen) {
                maxLen = str.length();
            }

            for (int j = 0; j < str.length(); j++) {
                board[i][j] = str.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[j][i] != '\0') {
                    sb.append(board[j][i]);
                }
            }
        }

        System.out.println(sb);
    }
}
