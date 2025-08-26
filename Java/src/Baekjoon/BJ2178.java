package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178 {
    static int N, M;
    static int[][] miro;
    static int[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new int[N][M];
        visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visit[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[1], y = now[0];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N && miro[ny][nx] == 1 && visit[ny][nx] == 0) {
                    queue.add(new int[]{ny, nx});
                    visit[ny][nx] = visit[y][x] + 1;

                    if (nx == M - 1 && ny == N - 1) {
                        return visit[ny][nx];
                    }
                }
            }
        }

        return -1;
    }
}
