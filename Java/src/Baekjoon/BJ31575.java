package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ31575 {
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int N, M;
    static int[][] city;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[M][N];
        visit = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (bfs())
            System.out.println("Yes");
        else
            System.out.println("No");
        br.close();
    }

    private static boolean bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 2; d++) {
                int nx = now[1] + dx[d];
                int ny = now[0] + dy[d];
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (city[ny][nx] == 1 && !visit[ny][nx]) {
                        visit[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
        return visit[M - 1][N - 1];
    }
}
