package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1986 {
    static int n, m;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n+1][m+1];

        // 1: queen, 2: knight, 3: pawn
        st = new StringTokenizer(br.readLine());
        int queen = Integer.parseInt(st.nextToken());
        for (int i = 0; i < queen; i++) {
            int qi = Integer.parseInt(st.nextToken());
            int qj = Integer.parseInt(st.nextToken());
            board[qi][qj] = 1;
        }

        st = new StringTokenizer(br.readLine());
        int knight = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knight; i++) {
            int ki = Integer.parseInt(st.nextToken());
            int kj = Integer.parseInt(st.nextToken());
            board[ki][kj] = 2;
        }

        st = new StringTokenizer(br.readLine());
        int pawn = Integer.parseInt(st.nextToken());
        for (int i = 0; i < pawn; i++) {
            int pi = Integer.parseInt(st.nextToken());
            int pj = Integer.parseInt(st.nextToken());
            board[pi][pj] = 3;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] == 1) {
                    queenMove(i, j);
                } else if (board[i][j] == 2) {
                    knightMove(i, j);
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] == 0) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        br.close();
    }

    private static void queenMove(int y, int x) {
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

        for (int d = 0; d < 8; d++) {
            int nx = x;
            int ny = y;

            while (true) {
                nx += dx[d];
                ny += dy[d];

                if (1 <= nx && nx <= m && 1 <= ny && ny <= n && (board[ny][nx] == 0 || board[ny][nx] == -1)) {
                    board[ny][nx] = -1;
                } else
                    break;
            }
        }
    }

    private static void knightMove(int y, int x) {
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (1 <= nx && nx <= m && 1 <= ny && ny <= n && board[ny][nx] == 0) {
                board[ny][nx] = -1;
            }
        }
    }
}
