package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7569 {
    static int N, M, H;
    static int[][][] box;
    static int[][][] visit;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<int[]>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        visit = new int[H][N][M];

        int cnt = 0;
        int blank = 0;

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    box[h][i][j] = Integer.parseInt(st.nextToken());

                    if (box[h][i][j] == -1) {
                        blank++;
                    } else if (box[h][i][j] == 1) {
                        cnt++;
                        visit[h][i][j] = 1;
                        queue.add(new int[] {h, i, j});
                    }
                }
            }
        }

        if (cnt + blank == H * N * M) {
            System.out.println(0);
        } else {
            bfs();

            cnt = 0;
            int maxDay = 0;

            for (int h = 0; h < H; h++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (visit[h][i][j] != 0) {
                            cnt++;
                            maxDay = Math.max(maxDay, visit[h][i][j]-1);
                        }
                    }
                }
            }

            if (cnt + blank == H * N * M) {
                System.out.println(maxDay);
            } else {
                System.out.println(-1);
            }
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int h = now[0];
            int x = now[2];
            int y = now[1];

            for (int d = 0; d < 6; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                int nh = h + dz[d];

                if (nh >= 0 && nh < H && nx >= 0 && nx < M && ny >= 0 && ny < N && box[nh][ny][nx] != -1 && visit[nh][ny][nx] == 0) {
                    visit[nh][ny][nx] = visit[h][y][x] + 1;
                    queue.add(new int[]{nh, ny, nx});
                }
            }
        }
    }
}
