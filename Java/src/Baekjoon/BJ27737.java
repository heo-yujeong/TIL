package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ27737 {
    static int N;
    static int[][] board;
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0 && !visit[i][j]) {
                    int curCnt = dfs(i, j);
                    cnt += (curCnt+K-1) / K;
                }
            }
        }

        if (cnt == 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            if (cnt <= M) {
                System.out.println("POSSIBLE");
                System.out.println(M-cnt);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static int dfs(int y, int x) {
        visit[y][x] = true;
        int size = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < N && board[ny][nx] == 0 && !visit[ny][nx]) {
                size += dfs(ny, nx);
            }
        }

        return size;
    }
}
