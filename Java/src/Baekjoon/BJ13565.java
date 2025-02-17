package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ13565 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[][] fiber;
    static boolean[][] visit;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        fiber = new int[M][N];
        visit = new boolean[M][N];
        q = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                fiber[i][j] = line.charAt(j) - '0';
                if (i == 0 && fiber[i][j] == 0) {
                    q.add(new int[] {i, j});
                    visit[i][j] = true;
                }
            }
        }
        if (bfs())
            System.out.println("YES");
        else
            System.out.println("NO");
        br.close();
    }

    private static boolean bfs() {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = now[1] + dx[d];
                int ny = now[0] + dy[d];

                if (0 <= nx && nx < N && 0 <= ny && ny < M && fiber[ny][nx] == 0 && !visit[ny][nx]) {
                    if (ny == M-1)
                        return true;
                    visit[ny][nx] = true;
                    q.add(new int[] {ny, nx});
                }
            }
        }
        return false;
    }
}
