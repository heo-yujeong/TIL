package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ26169 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] board = new int[5][5];
    static int start_r, start_c;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        start_r = Integer.parseInt(st.nextToken());
        start_c = Integer.parseInt(st.nextToken());

        backtrack(0, 0, start_r, start_c);
        System.out.println(result);
        br.close();
    }

    private static void backtrack(int nCnt, int aCnt, int r, int c) {
        if (board[r][c] == 1) {
            aCnt++;
        }

        if (aCnt >= 2) {
            result = 1;
            return;
        }

        if (nCnt == 3) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (0 <= nr && nr < 5 && 0 <= nc && nc < 5 && board[nr][nc] != -1) {
                board[r][c] = -1;
                backtrack(nCnt+1, aCnt, nr, nc);
                board[r][c] = 0;
            }
        }
    }
}
