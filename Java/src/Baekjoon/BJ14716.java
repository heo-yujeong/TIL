package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14716 {
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};
    static int N, M;
    static int[][] banner;
    static boolean[][] visit;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        banner = new int[M][N];
        visit = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                banner[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (banner[i][j] == 1 && !visit[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {y, x});
        visit[y][x] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 8; d++) {
                int nx = now[1] + dx[d];
                int ny = now[0] + dy[d];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (banner[ny][nx] == 1 && !visit[ny][nx]) {
                        visit[ny][nx] = true;
                        queue.add(new int[] {ny, nx});
                    }
                }
            }
        }
    }
}
