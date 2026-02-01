package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ31628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[][] board = new String[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = st.nextToken();
            }
        }

        boolean flag = false;
        for (int i = 0; i < 10; i++) {
            int cnt = 0;
            for (int j = 0; j < 10; j++) {
                if (board[i][0].equals(board[i][j])) {
                    cnt++;
                }
            }

            if (cnt == 10) {
                flag = true;
                break;
            }
        }

        for (int j = 0; j < 10; j++) {
            int cnt = 0;
            for (int i = 0; i < 10; i++) {
                if (board[0][j].equals(board[i][j])) {
                    cnt++;
                }
            }

            if (cnt == 10) {
                flag = true;
                break;
            }
        }

        System.out.println(flag ? 1 : 0);
    }
}
