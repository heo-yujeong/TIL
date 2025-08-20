package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2630 {
    static int white, blue;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void divide(int row, int col, int size) {
        if (check(row, col, size)) {
            if (board[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;
        divide(row, col, newSize);
        divide(row, col+newSize, newSize);
        divide(row+newSize, col, newSize);
        divide(row+newSize, col+newSize, newSize);
    }

    private static boolean check(int row, int col, int size) {
        int color = board[row][col];

        for (int i = row; i < row+size; i++) {
            for (int j = col; j < col+size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}
