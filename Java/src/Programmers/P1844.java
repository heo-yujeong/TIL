package Programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class P1844 {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][m];
        queue.add(new int[] {0, 0, 1});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[1];
            int y = now[0];
            int dist = now[2];

            if (x == m-1 && y == n-1) {
                return dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (0 <= nx && nx < m && 0 <= ny && ny < n && maps[ny][nx] == 1 && !visit[ny][nx]) {
                    visit[ny][nx] = true;
                    queue.add(new int[] {ny, nx, dist+1});
                }
            }
        }
        return -1;
    }
}
