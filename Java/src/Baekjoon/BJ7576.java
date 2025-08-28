package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576 {
    static int N, M;
    static int[][] box;
    static int[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        visit = new int[N][M];

        int cnt = 0;
        int blank = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                if (box[i][j] == -1) {
                    blank++;
                } else if (box[i][j] == 1) {
                    cnt++;
                    visit[i][j] = 1;
                    queue.add(new int[]{i, j});
                }
            }
        }

        if (cnt + blank == N * M) {
            System.out.println(0);
        } else {
            bfs();

            cnt = 0;
            int maxDay = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visit[i][j] != 0) {
                        cnt++;
                        maxDay = Math.max(maxDay, visit[i][j]-1);
                    }
                }
            }

            if (cnt + blank == N * M) {
                System.out.println(maxDay);
            } else {
                System.out.println(-1);
            }
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[1], y = now[0];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && box[ny][nx] != -1 && visit[ny][nx] == 0) {
                    queue.add(new int[]{ny, nx});
                    visit[ny][nx] = visit[y][x] + 1;
                }
            }
        }
    }
}
