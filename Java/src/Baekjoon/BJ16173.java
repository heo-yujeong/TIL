package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16173 {
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (map[now[0]][now[1]] == -1) {
                System.out.println("HaruHaru");
                System.exit(0);
            }

            int num = map[now[0]][now[1]];
            for (int d = 0; d < 2; d++) {
                int nextX = now[1] + dx[d] * num;
                int nextY = now[0] + dy[d] * num;

                if (nextX < N && nextY < N && !visit[nextY][nextX]) {
                    queue.add(new int[]{nextY, nextX});
                    visit[nextY][nextX] = true;
                }
            }
        }

        System.out.println("Hing");
    }
}
