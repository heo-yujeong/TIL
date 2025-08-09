package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1012 {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visit = new boolean[N][M];
            count = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[Y][X] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void dfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visit[y][x] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[1] + dx[d];
                int ny = now[0] + dy[d];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[ny][nx] == 1 && !visit[ny][nx]) {
                    queue.offer(new int[]{ny, nx});
                    visit[ny][nx] = true;
                }
            }
        }
    }
}
