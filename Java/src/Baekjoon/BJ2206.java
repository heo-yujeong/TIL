package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2206 {
    static int N, M;
    static int[][] arr;
    static int[][][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        visit[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[1];
            int y = now[0];
            int broken = now[2];

            if (x == M - 1 && y == N - 1) {
                return visit[y][x][broken];
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (arr[ny][nx] == 1 && broken == 0) {
                        visit[ny][nx][1] = visit[y][x][0] + 1;
                        queue.add(new int[]{ny, nx, 1});
                    } else if (arr[ny][nx] == 0 && visit[ny][nx][broken] == 0) {
                        visit[ny][nx][broken] = visit[y][x][broken] + 1;
                        queue.add(new int[]{ny, nx, broken});
                    }
                }
            }
        }

        return -1;
    }
}
