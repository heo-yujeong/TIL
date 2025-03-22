package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3085 {
    static int N;
    static char[][] board;
    static int result = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j+1 < N) {
                    swap(i, j, i, j+1);
                    checkCol(j);
                    checkCol(j+1);
                    checkRow(i);
                    swap(i, j, i, j+1);
                }
                if (i+1 < N) {
                    swap(i, j, i+1, j);
                    checkCol(j);
                    checkRow(i);
                    checkRow(i+1);
                    swap(i, j, i+1, j);
                }
            }
        }

        System.out.println(result);
        br.close();
    }

    private static void checkRow(int row) {
        int cur = 1;
        int max = 1;
        char value = board[row][0];

        for (int i = 1; i < N; i++) {
            if (board[row][i] == value) {
                cur++;
                max = Math.max(max, cur);
            } else {
                cur = 1;
                value = board[row][i];
            }
        }
        result = Math.max(result, max);
    }

    private static void checkCol(int col) {
        int cur = 1;
        int max = 1;
        char value = board[0][col];

        for (int i = 1; i < N; i++) {
            if (board[i][col] == value) {
                cur++;
                max = Math.max(max, cur);
            } else {
                cur = 1;
                value = board[i][col];
            }
        }
        result = Math.max(result, max);
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }
}
