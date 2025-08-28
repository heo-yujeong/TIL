package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7562 {
    static int l;
    static int[][] visit;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int goalX, goalY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            l = Integer.parseInt(br.readLine());
            visit = new int[l][l];

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            goalX = Integer.parseInt(st.nextToken());
            goalY = Integer.parseInt(st.nextToken());

            if (startX == goalX && startY == goalY) {
                System.out.println(0);
            } else {
                System.out.println(bfs(startY, startX));
            }
        }
    }

    private static int bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX});
        visit[startY][startX] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[1];
            int nowY = now[0];
            for (int d = 0; d < 8; d++) {
                int nextX = nowX + dx[d];
                int nextY = nowY + dy[d];
                if (nextX >= 0 && nextX < l && nextY >= 0 && nextY < l && visit[nextY][nextX] == 0) {
                    queue.add(new int[]{nextY, nextX});
                    visit[nextY][nextX] = visit[nowY][nowX] + 1;

                    if (nextX == goalX && nextY == goalY) {
                        return visit[nextY][nextX] - 1;
                    }
                }
            }
        }

        return -1;
    }
}
