package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16174 {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        if (visit[N - 1][N - 1]) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    private static void dfs(int x, int y) {
        for (int d = 0; d < 2; d++) {
            int nx = x + dx[d] * map[y][x];
            int ny = y + dy[d] * map[y][x];

            if (0 <= nx && nx < N && 0 <= ny && ny < N && !visit[ny][nx]) {
                visit[ny][nx] = true;
                dfs(nx, ny);
            }
        }
    }
}
